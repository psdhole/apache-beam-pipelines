/*
 * 
 */
package com.demo.pipeline.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.BigEndianIntegerCoder;
import org.apache.beam.sdk.coders.KvCoder;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.io.jdbc.JdbcIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.util.DemoConstants;

/**
 * The Class ReadFromDBWriteToFile.
 */
public class ReadFromDBWriteToFile {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadFromDBWriteToFile.class);

	/** The Constant OUTPUT_FILE_NAME. */
	private static final String OUTPUT_FILE_NAME = "output/outputFromDB.data";

	/**
	 * Read and write data.
	 */
	public static void readAndWriteData() {
		final PipelineOptions options = PipelineOptionsFactory.fromArgs().withValidation().as(PipelineOptions.class);
		Pipeline pipeline = Pipeline.create(options);
		pipeline.apply(
				JdbcIO.<KV<Integer, String>>read()
						.withDataSourceConfiguration(JdbcIO.DataSourceConfiguration
								.create(DemoConstants.DB_DRIVER_CLASS, DemoConstants.DB_CONN_URL)
								.withUsername(DemoConstants.DB_USER_NAME).withPassword(DemoConstants.DB_SECRET))
						.withQuery(DemoConstants.SELECT_QUERY)
						.withCoder(KvCoder.of(BigEndianIntegerCoder.of(), StringUtf8Coder.of()))
						.withStatementPreparator(new JdbcIO.StatementPreparator() {
							private static final long serialVersionUID = 1L;

							public void setParameters(PreparedStatement preparedStatement) throws Exception {
								preparedStatement.setInt(1, 10);
							}
						}).withRowMapper(new JdbcIO.RowMapper<KV<Integer, String>>() {
							private static final long serialVersionUID = 1L;

							public KV<Integer, String> mapRow(ResultSet resultSet) throws Exception {
								return KV.of(resultSet.getInt(1), resultSet.getString(2));
							}
						}))
				.apply("Print the data", ParDo.of(new DoFn<KV<Integer, String>, String>() {
					private static final long serialVersionUID = -2934226755283652150L;

					@ProcessElement
					public void processElement(ProcessContext context) {
						Integer eid = context.element().getKey();
						String ename = context.element().getValue();
						context.output(eid + " : " + ename);
					}
				})).apply(TextIO.write().to(OUTPUT_FILE_NAME).withoutSharding());
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
		readAndWriteData();
	}
}
