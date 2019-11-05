/*
 * 
 */
package com.demo.pipeline.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.BigEndianIntegerCoder;
import org.apache.beam.sdk.coders.KvCoder;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.io.jdbc.JdbcIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.values.KV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.util.DemoConstants;

/**
 * The Class ReadFromDBWriteToDB.
 */
public class ReadFromDBWriteToDB {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadFromDBWriteToDB.class);

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
								int eid = resultSet.getInt(1);
								String ename = resultSet.getString(2);
								return KV.of(eid + 100, "Mr." + ename);
							}
						}))
				.apply(JdbcIO.<KV<Integer, String>>write()
						.withDataSourceConfiguration(JdbcIO.DataSourceConfiguration
								.create(DemoConstants.DB_DRIVER_CLASS, DemoConstants.DB_CONN_URL)
								.withUsername(DemoConstants.DB_USER_NAME).withPassword(DemoConstants.DB_SECRET))
						.withStatement(DemoConstants.INSERT_QUERY)
						.withPreparedStatementSetter(new JdbcIO.PreparedStatementSetter<KV<Integer, String>>() {
							private static final long serialVersionUID = 1L;

							public void setParameters(KV<Integer, String> row, PreparedStatement query)
									throws SQLException {
								query.setInt(1, row.getKey());
								query.setString(2, row.getValue());
							}
						}));

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
