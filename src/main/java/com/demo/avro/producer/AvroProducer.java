/*
 *
 */
package com.demo.avro.producer;

import com.demo.avro.model.Order;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/** The Class AvroProducer. */
public class AvroProducer {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = LoggerFactory.getLogger(AvroProducer.class);

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    String topic = "avro-input-topic-2";
    Properties props = new Properties();
    props.put("bootstrap.servers", "broker:9092");
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
    props.put("schema.registry.url", "http://schema-registry:8081");

    Producer<String, Order> producer = new KafkaProducer<String, Order>(props);
    try {
      for (long i = 0; i < 2; i++) {
        Order order =
            new Order("order_id" + i, "customer_id", "supplier_id", "cust_name", 10, (float) 100);
        ProducerRecord<String, Order> record =
            new ProducerRecord<String, Order>(topic, (String) order.getOrderId(), order);

        Thread.sleep(5000);
        LOGGER.debug("Sending : {}", order);
        producer.send(record).get();
      }
    } catch (Exception e) {
      LOGGER.error("Error ", e);
    } finally {
      producer.close();
    }
  }
}
