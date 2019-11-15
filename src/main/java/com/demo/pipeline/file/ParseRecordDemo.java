/*
 *
 */
package com.demo.pipeline.file;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** The Class ParseRecordDemo. */
public class ParseRecordDemo {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = LoggerFactory.getLogger(ParseRecordDemo.class);

  /** The Constant INPUT_FILE_NAME. */
  private static final String INPUT_FILE_NAME = "input/input.data";

  /** The Constant OUTPUT_FILE_NAME. */
  private static final String OUTPUT_FILE_NAME = "output/carBrandAndRelatedCount.data";

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    final PipelineOptions options = PipelineOptionsFactory.as(PipelineOptions.class);
    Pipeline pipeline = Pipeline.create(options);
    PCollection<String> input = pipeline.apply(TextIO.read().from(INPUT_FILE_NAME));
    PCollection<String> output =
        input.apply(
            "Read and extract the row",
            ParDo.of(
                new DoFn<String, String>() {
                  private static final long serialVersionUID = 1L;

                  @ProcessElement
                  public void processElement(ProcessContext context) {
                    String[] str = context.element().split(",");
                    String key = str[1].trim();
                    int value = Integer.parseInt(str[3].trim());
                    context.output(key + " : " + value);
                  }
                }));
    output.apply(TextIO.write().to(OUTPUT_FILE_NAME).withNumShards(2));
    pipeline.run().waitUntilFinish();
    LOGGER.debug("All done!!");
  }
}
