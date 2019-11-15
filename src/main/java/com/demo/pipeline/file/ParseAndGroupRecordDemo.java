/*
 *
 */
package com.demo.pipeline.file;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** The Class ParseAndGroupRecordDemo. */
public class ParseAndGroupRecordDemo {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = LoggerFactory.getLogger(ParseAndGroupRecordDemo.class);

  /** The Constant INPUT_FILE_NAME. */
  private static final String INPUT_FILE_NAME = "input/input.data";

  /** The Constant OUTPUT_FILE_NAME. */
  private static final String OUTPUT_FILE_NAME = "output/carCountGroupByBrand";

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    Pipeline pipeline = Pipeline.create();
    PCollection<String> input = pipeline.apply(TextIO.read().from(INPUT_FILE_NAME));
    PCollection<KV<String, Integer>> parseAndConvertToKV =
        input.apply(
            "Read file and map to key value pair",
            MapElements.via(
                new InferableFunction<String, KV<String, Integer>>() {
                  private static final long serialVersionUID = 1L;

                  @Override
                  public KV<String, Integer> apply(String input) {
                    String[] split = input.split(",");
                    if (split.length < 4) {
                      return null;
                    }
                    String key = split[1];
                    Integer value = Integer.valueOf(split[3]);
                    return KV.of(key, value);
                  }
                }));
    // group the input key-pair (brand and its orderCount) by brand name
    PCollection<KV<String, Iterable<Integer>>> kvpCollection =
        parseAndConvertToKV.apply(GroupByKey.<String, Integer>create());
    // sum orderCount for each brand
    PCollection<String> sumUpValuesByKey =
        kvpCollection.apply(
            "Calculate car orderCount group by brand name",
            ParDo.of(
                new DoFn<KV<String, Iterable<Integer>>, String>() {
                  private static final long serialVersionUID = -2934226755283652150L;

                  @ProcessElement
                  public void processElement(ProcessContext context) {
                    Integer totalSells = 0;
                    String brand = context.element().getKey();
                    for (Integer amount : context.element().getValue()) {
                      totalSells += amount;
                    }
                    context.output(brand + " : " + totalSells);
                  }
                }));
    sumUpValuesByKey.apply(TextIO.write().to(OUTPUT_FILE_NAME).withoutSharding());
    pipeline.run().waitUntilFinish();
    LOGGER.debug("All Done!!");
  }
}
