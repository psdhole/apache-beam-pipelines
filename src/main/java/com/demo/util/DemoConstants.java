/*
 *
 */
package com.demo.util;

/** The Class DemoConstants. */
public class DemoConstants {

  /** The Constant DB_SECRET. */
  public static final String DB_SECRET = "";
  /** The Constant DB_USER_NAME. */
  public static final String DB_USER_NAME = "sa";
  /** The Constant SELECT_QUERY. */
  public static final String SELECT_QUERY = "select id,name from emp where id < ?";
  /** The Constant INSERT_QUERY. */
  public static final String INSERT_QUERY = "insert into emp2 values(?, ?)";
  /** The Constant DB_DRIVER_CLASS. */
  public static final String DB_DRIVER_CLASS = "org.h2.Driver";
  /** The Constant DB_CONN_URL. */
  public static final String DB_CONN_URL = "jdbc:h2:~/test";
  /** The Constant DEST_DB_USER_NAME. */
  public static final String DEST_DB_USER_NAME = "root";
  /** The Constant DEST_DB_SECRET. */
  public static final String DEST_DB_SECRET = "root";
  /** The Constant DEST_DB_DRIVER_CLASS. */
  public static final String DEST_DB_DRIVER_CLASS = "org.postgresql.Driver";
  /** The Constant DEST_DB_CONN_URL. */
  public static final String DEST_DB_CONN_URL = "jdbc:postgresql://localhost:5432/testdb";
  /** The Constant DEST_INSERT_QUERY. */
  public static final String DEST_INSERT_QUERY = "call test.add_user(?,?,?)";

  /** Instantiates a new demo constants. */
  private DemoConstants() {
    super();
  }
}
