/*
 *
 */
package com.demo.pipeline.kafkatodb;

import com.demo.avro.model.Data;
import com.demo.util.DemoConstants;
import com.google.common.collect.ImmutableMap;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.reflect.ReflectDatumReader;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.jdbc.JdbcIO;
import org.apache.beam.sdk.io.kafka.KafkaIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.transforms.windowing.FixedWindows;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** The Class AvroReadFromKafkaWriteToDB. */
public class AvroReadFromKafkaWriteToDB {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = LoggerFactory.getLogger(AvroReadFromKafkaWriteToDB.class);
  /** The Constant BOOT_STRAP_SERVER. */
  private static final String BOOT_STRAP_SERVER = "10.9.43.185:9092";
  /** The Constant TOPIC_NAME. */
  private static final String TOPIC_NAME = "OrderDetailsTopic";
  /** The Constant ORDER_INSERT_QUERY. */
  private static final String ORDER_INSERT_QUERY =
      "insert into ORDER_DETAILS  values(?, ?,?,?,?,?,?,?)";
  /** The order count. */
  private static long orderCount = 0;

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    Pipeline p = Pipeline.create(PipelineOptionsFactory.fromArgs(args).withValidation().create());
    PCollection<Data> output =
        p.apply(
                KafkaIO.<String, byte[]>read()
                    .withBootstrapServers(BOOT_STRAP_SERVER)
                    .withTopic(TOPIC_NAME)
                    .withKeyDeserializer(StringDeserializer.class)
                    .withValueDeserializer(ByteArrayDeserializer.class)
                    .updateConsumerProperties(
                        ImmutableMap.of("auto.offset.reset", (Object) "earliest"))
                    // .withMaxReadTime(Duration.millis()).
                    .withoutMetadata())
            .apply(
                "Apply Fixed window: ",
                Window.<KV<String, byte[]>>into(FixedWindows.of(Duration.standardSeconds(5))))
            .apply(
                MapElements.via(
                    new SimpleFunction<KV<String, byte[]>, Data>() {
                      private static final long serialVersionUID = 1L;

                      @Override
                      public Data apply(KV<String, byte[]> word) {
                        Data dataRead = new Data();
                        DatumReader<Data> reader = new ReflectDatumReader<Data>(Data.SCHEMA$);
                        BinaryDecoder binaryDecoder =
                            DecoderFactory.get().binaryDecoder(word.getValue(), null);
                        try {
                          reader.read(dataRead, binaryDecoder);
                          LOGGER.debug("Reading from kafka order : {}", dataRead);
                        } catch (IOException e) {
                          LOGGER.error("Error while reading from kafka : {}", e);
                        }
                        return dataRead;
                      }
                    }));
    output.apply(
        JdbcIO.<Data>write()
            .withDataSourceConfiguration(
                JdbcIO.DataSourceConfiguration.create(
                        DemoConstants.DB_DRIVER_CLASS, DemoConstants.DB_CONN_URL)
                    .withUsername(DemoConstants.DB_USER_NAME)
                    .withPassword(DemoConstants.DB_SECRET))
            .withStatement(ORDER_INSERT_QUERY)
            .withPreparedStatementSetter(
                new JdbcIO.PreparedStatementSetter<Data>() {
                  private static final long serialVersionUID = 1L;

                  public void setParameters(Data row, PreparedStatement query) throws SQLException {
                    LOGGER.debug("Order rows insterting into DB : {}", ++orderCount);
                    query.setString(1, String.valueOf(row.getInvoiceNo()));
                    query.setString(2, String.valueOf(row.getStockCode()));
                    query.setString(3, String.valueOf(row.getDescription()));
                    query.setString(4, String.valueOf(row.getQuantity()));
                    query.setString(5, String.valueOf(row.getInvoiceDate()));
                    query.setString(6, String.valueOf(row.getUnitPrice()));
                    query.setString(7, String.valueOf(row.getCustomerID()));
                    query.setString(8, String.valueOf(row.getCountry()));
                  }
                }));

    p.run().waitUntilFinish();
    LOGGER.debug("All done!!");
  }
}
