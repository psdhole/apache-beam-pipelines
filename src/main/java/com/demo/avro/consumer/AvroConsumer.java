/*
 * 
 */
package com.demo.avro.consumer;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.avro.model.Order;

/**
 * The Class AvroConsumer.
 */
public class AvroConsumer {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AvroConsumer.class);

	/** The consumer. */
	private final KafkaConsumer<String, Order> consumer;

	/** The input topic. */
	private final String inputTopic;

	/**
	 * Instantiates a new avro consumer.
	 *
	 * @param brokers
	 *            the brokers
	 * @param groupId
	 *            the group id
	 * @param inputTopic
	 *            the input topic
	 * @param url
	 *            the url
	 */
	public AvroConsumer(String brokers, String groupId, String inputTopic, String url) {
		this.consumer = new KafkaConsumer<String, Order>(createConsumerConfig(brokers, groupId, url));
		this.inputTopic = inputTopic;
	}

	/**
	 * Creates the consumer config.
	 *
	 * @param brokers
	 *            the brokers
	 * @param groupId
	 *            the group id
	 * @param url
	 *            the url
	 * @return the properties
	 */
	private Properties createConsumerConfig(String brokers, String groupId, String url) {
		Properties props = new Properties();
		props.put("bootstrap.servers", brokers);
		props.put("group.id", groupId);
		props.put("auto.commit.enable", "false");
		props.put("auto.offset.reset", "earliest");
		props.put("schema.registry.url", url);
		props.put("specific.avro.reader", true);
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		return props;
	}

	/**
	 * Run.
	 */
	private void run() {
		consumer.subscribe(Collections.singletonList(inputTopic));
		LOGGER.debug("Reading from topic : {}", inputTopic);
		while (true) {
			ConsumerRecords<String, Order> records = consumer.poll(100);
			for (ConsumerRecord<String, Order> record : records) {
				Order event = record.value();
				LOGGER.debug("Order processed : {}", event);
			}
			consumer.commitSync();
		}
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		String groupId = "avro-group";
		String inputTopic = "avro-input-topic-2";
		String url = "http://schema-registry:8081";
		String brokers = "localhost:9092";
		AvroConsumer consumer = new AvroConsumer(brokers, groupId, inputTopic, url);
		consumer.run();
	}
}
