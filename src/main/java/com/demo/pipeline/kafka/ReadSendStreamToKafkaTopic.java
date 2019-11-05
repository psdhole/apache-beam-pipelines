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
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ReadSendStreamToKafkaTopic.
 */
public class ReadSendStreamToKafkaTopic {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadSendStreamToKafkaTopic.class);

	/** The Constant BOOTSTRAP_SERVERS. */
	private static final String BOOTSTRAP_SERVERS = "localhost:9092";

	/** The Constant INPUT_TOPIC. */
	private static final String INPUT_TOPIC = "sample-topic";

	/** The Constant OUTPUT_TOPIC. */
	private static final String OUTPUT_TOPIC = "output-topic";

	/**
	 * Recieve and send data.
	 */
	public static void recieveAndSendData() {
		final PipelineOptions options = PipelineOptionsFactory.fromArgs().withValidation().as(PipelineOptions.class);
		Pipeline pipeline = Pipeline.create(options);
		pipeline.apply(KafkaIO.<Long, String>read().withBootstrapServers(BOOTSTRAP_SERVERS).withTopic(INPUT_TOPIC)
				.withKeyDeserializer(LongDeserializer.class).withValueDeserializer(StringDeserializer.class))
				.apply(ParDo.of(new DoFn<KafkaRecord<Long, String>, String>() {
					private static final long serialVersionUID = 1L;

					@ProcessElement
					public void processElement(ProcessContext processContext) {
						KafkaRecord<Long, String> record = processContext.element();
						LOGGER.debug("Reading the Record : {}", record.getKV().getValue());
						processContext.output(record.getKV().getValue());
					}
				})).apply("ExtractPayload", ParDo.of(new DoFn<String, KV<String, String>>() {
					private static final long serialVersionUID = 1L;

					@ProcessElement
					public void processElement(ProcessContext c) {
						LOGGER.debug("Filtering the Record : {}", c.element());
						c.output(KV.of("FilteredRecord", c.element()));
					}
				})).apply("WriteToKafka",
						KafkaIO.<String, String>write().withBootstrapServers(BOOTSTRAP_SERVERS).withTopic(OUTPUT_TOPIC)
								.withKeySerializer(org.apache.kafka.common.serialization.StringSerializer.class)
								.withValueSerializer(org.apache.kafka.common.serialization.StringSerializer.class));

		pipeline.run();
		LOGGER.debug("Pipeline started..!!");
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		recieveAndSendData();
	}
}
