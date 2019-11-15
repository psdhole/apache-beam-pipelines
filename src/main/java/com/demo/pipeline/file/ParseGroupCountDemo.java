/*
 *
 */
package com.demo.pipeline.file;

import com.demo.avro.model.LogMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.io.FileIO;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptors;
/** The Class ParseAndGroupRecordDemo. */
@Slf4j
public class ParseGroupCountDemo {

  /** The Constant INPUT_FILE_NAME. */
  private static final String INPUT_FILE_NAME = "input/input.json";

  /** The Constant OUTPUT_FILE_NAME. */
  private static final String OUTPUT_FILE_NAME = "output";

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    Pipeline pipeline = Pipeline.create();

    PCollection<String> input = pipeline.apply(TextIO.read().from(INPUT_FILE_NAME));

    PCollection<KV<String, String>> parseAndConvertToKV = convertJsonToKV(input);

    // Calculate count for each of the log type.
    PCollection<KV<String, Long>> countLogByType = parseAndConvertToKV.apply(Count.perKey());

    wrtieKVToFile(countLogByType);

    pipeline.run().waitUntilFinish();
    log.debug("All Done!!");
  }

  public static PCollection<KV<String, String>> convertJsonToKV(PCollection<String> inputJSONS) {
    return inputJSONS.apply(
        "Read file and map to key value pair",
        MapElements.via(
            new InferableFunction<String, KV<String, String>>() {
              private static final long serialVersionUID = 1L;

              @Override
              public KV<String, String> apply(String inputJSON) {
                LogMessage logMessage = new LogMessage();
                try {
                  logMessage = new ObjectMapper().readValue(inputJSON, LogMessage.class);
                } catch (Exception e) {
                  log.debug("Error while parsing JSON :", e);
                }
                return KV.of(logMessage.getLogType(), inputJSON);
              }
            }));
  }
  // Convert key pair to csv row
  public static PCollection<String> convertKVToCSVRows(
      PCollection<KV<String, Long>> countLogByType) {
    return countLogByType.apply(
        "Convert key pair to sinle line",
        ParDo.of(
            new DoFn<KV<String, Long>, String>() {
              private static final long serialVersionUID = -2934226755283652150L;

              @ProcessElement
              public void processElement(ProcessContext context) {
                context.output(context.element().getKey() + "," + context.element().getValue());
              }
            }));
  }

  public static void writeLinesToCSVFile(PCollection<String> writeLogTypeAndCount) {
    writeLogTypeAndCount.apply(
        TextIO.write().withHeader("LogType,Count").to(OUTPUT_FILE_NAME).withoutSharding());
  }

  public static void wrtieKVToFile(PCollection<KV<String, Long>> countLogByType) {
    countLogByType
        .apply(
            MapElements.into(
                    TypeDescriptors.kvs(TypeDescriptors.strings(), TypeDescriptors.strings()))
                .via(
                    tableRow ->
                        KV.of((String) tableRow.getKey(), String.valueOf(tableRow.getValue()))))
        .apply(
            FileIO.<String, KV<String, String>>writeDynamic()
                .by(KV::getKey)
                .withDestinationCoder(StringUtf8Coder.of())
                .via(Contextful.fn(KV::getValue), TextIO.sink())
                .to(OUTPUT_FILE_NAME)
                .withNaming(key -> FileIO.Write.defaultNaming("file-" + key, ".txt")));
  }
}
