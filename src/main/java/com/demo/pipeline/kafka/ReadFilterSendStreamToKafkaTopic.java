/*
 * 
 */
package com.demo.pipeline.kafka;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.kafka.KafkaIO;
import org.apache.beam.sdk.io.kafka.KafkaRecord;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.Filter;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.SerializableFunction;
import org.apache.beam.sdk.values.KV;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ReadFilterSendStreamToKafkaTopic.
 */
public class ReadFilterSendStreamToKafkaTopic {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadFilterSendStreamToKafkaTopic.class);

	/** The Constant MAX_VALUE. */
	private static final int MAX_VALUE = 100;

	/** The Constant BOOTSTRAP_SERVERS. */
	private static final String BOOTSTRAP_SERVERS = "localhost:9092";

	/** The Constant INPUT_TOPIC. */
	private static final String INPUT_TOPIC = "input-data";

	/** The Constant OUTPUT_TOPIC. */
	private static final String OUTPUT_TOPIC = "output-data";

	/**
	 * The Class FilterValues.
	 */
	public static class FilterValues implements SerializableFunction<String, Boolean> {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.apache.beam.sdk.transforms.SerializableFunction#apply(java.lang.
		 * Object)
		 */
		public Boolean apply(String input) {
			String[] split = input.split(",");
			if (split.length < 3) {
				return false;
			}
			Integer val1 = Integer.valueOf(split[1]);
			Integer val2 = Integer.valueOf(split[2]);
			return (val1 >= 0 && val1 < MAX_VALUE && val2 >= 0 && val2 < MAX_VALUE);
		}
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static final void main(String[] args) {
		final PipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation()
				.as(PipelineOptions.class);
		Pipeline pipeline = Pipeline.create(options);
		pipeline.apply("ReadFromKafka",
				KafkaIO.<Long, String>read().withBootstrapServers(BOOTSTRAP_SERVERS).withTopic(INPUT_TOPIC)
						.withKeyDeserializer(LongDeserializer.class).withValueDeserializer(StringDeserializer.class))
				.apply(ParDo.of(new DoFn<KafkaRecord<Long, String>, String>() {
					private static final long serialVersionUID = 1L;

					@ProcessElement
					public void processElement(ProcessContext processContext) {
						KafkaRecord<Long, String> record = processContext.element();
						LOGGER.debug("Reading the Record : {}", record.getKV().getValue());
						processContext.output(record.getKV().getValue());
					}
				})).apply("FilterValidRecords", Filter.by(new FilterValues()))
				.apply("ReadRecordsData", ParDo.of(new DoFn<String, KV<String, String>>() {
					private static final long serialVersionUID = 1L;

					@ProcessElement
					public void processElement(ProcessContext c) {
						LOGGER.debug("Filtered the Record : {}", c.element());
						c.output(KV.of("FilteredRecords", c.element()));
					}
				})).apply("WriteToKafka",
						KafkaIO.<String, String>write().withBootstrapServers(BOOTSTRAP_SERVERS).withTopic(OUTPUT_TOPIC)
								.withKeySerializer(org.apache.kafka.common.serialization.StringSerializer.class)
								.withValueSerializer(org.apache.kafka.common.serialization.StringSerializer.class));

		pipeline.run();
		LOGGER.debug("All done!!");
	}
}
