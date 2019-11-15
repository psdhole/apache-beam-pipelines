/*
 *
 */
package com.demo.avro.model;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

import java.io.IOException;
import java.io.Serializable;

/** The Class Order. */
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Order extends org.apache.avro.specific.SpecificRecordBase
    implements org.apache.avro.specific.SpecificRecord, Serializable {

  /** The Constant SCHEMA$. */
  public static final org.apache.avro.Schema SCHEMA$ =
      new org.apache.avro.Schema.Parser()
          .parse(
              "{\"type\":\"record\",\"name\":\"Order\",\"namespace\":\"com.demo.avro.model\",\"fields\":[{\"name\":\"order_id\",\"type\":\"string\",\"doc\":\"Id of the order filed\"},{\"name\":\"customer_id\",\"type\":\"string\",\"doc\":\"Id of the customer\"},{\"name\":\"supplier_id\",\"type\":\"string\",\"doc\":\"Id of the supplier\"},{\"name\":\"cust_name\",\"type\":\"string\",\"doc\":\"First Name of Customer\"},{\"name\":\"item\",\"type\":\"int\",\"doc\":\"Total number of items in the order\"},{\"name\":\"price\",\"type\":\"float\",\"doc\":\"Total price of the order\"}],\"version\":\"1\"}");
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 5386090711224050901L;
  /** The MODE l$. */
  private static SpecificData MODEL$ = new SpecificData();
  /** The Constant ENCODER. */
  private static final BinaryMessageEncoder<Order> ENCODER =
      new BinaryMessageEncoder<Order>(MODEL$, SCHEMA$);
  /** The Constant DECODER. */
  private static final BinaryMessageDecoder<Order> DECODER =
      new BinaryMessageDecoder<Order>(MODEL$, SCHEMA$);
  /** The Constant WRITER$. */
  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Order> WRITER$ =
      (org.apache.avro.io.DatumWriter<Order>) MODEL$.createDatumWriter(SCHEMA$);
  /** The Constant READER$. */
  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Order> READER$ =
      (org.apache.avro.io.DatumReader<Order>) MODEL$.createDatumReader(SCHEMA$);
  /** The order id. */
  @Deprecated public java.lang.CharSequence order_id;
  /** The customer id. */
  @Deprecated public java.lang.CharSequence customer_id;
  /** The supplier id. */
  @Deprecated public java.lang.CharSequence supplier_id;
  /** The cust name. */
  @Deprecated public java.lang.CharSequence cust_name;
  /** The item. */
  @Deprecated public int item;
  /** The price. */
  @Deprecated public float price;

  /** Instantiates a new order. */
  public Order() {}

  /**
   * Instantiates a new order.
   *
   * @param order_id the order id
   * @param customer_id the customer id
   * @param supplier_id the supplier id
   * @param cust_name the cust name
   * @param item the item
   * @param price the price
   */
  public Order(
      java.lang.CharSequence order_id,
      java.lang.CharSequence customer_id,
      java.lang.CharSequence supplier_id,
      java.lang.CharSequence cust_name,
      java.lang.Integer item,
      java.lang.Float price) {
    this.order_id = order_id;
    this.customer_id = customer_id;
    this.supplier_id = supplier_id;
    this.cust_name = cust_name;
    this.item = item;
    this.price = price;
  }

  /**
   * Gets the class schema.
   *
   * @return the class schema
   */
  public static org.apache.avro.Schema getClassSchema() {
    return SCHEMA$;
  }

  /**
   * Gets the decoder.
   *
   * @return the decoder
   */
  public static BinaryMessageDecoder<Order> getDecoder() {
    return DECODER;
  }

  /**
   * Creates the decoder.
   *
   * @param resolver the resolver
   * @return the binary message decoder
   */
  public static BinaryMessageDecoder<Order> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Order>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * From byte buffer.
   *
   * @param b the b
   * @return the order
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public static Order fromByteBuffer(java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /**
   * New builder.
   *
   * @return the com.demo.avro.model. order. builder
   */
  public static com.demo.avro.model.Order.Builder newBuilder() {
    return new com.demo.avro.model.Order.Builder();
  }

  /**
   * New builder.
   *
   * @param other the other
   * @return the com.demo.avro.model. order. builder
   */
  public static com.demo.avro.model.Order.Builder newBuilder(
      com.demo.avro.model.Order.Builder other) {
    return new com.demo.avro.model.Order.Builder(other);
  }

  /**
   * New builder.
   *
   * @param other the other
   * @return the com.demo.avro.model. order. builder
   */
  public static com.demo.avro.model.Order.Builder newBuilder(com.demo.avro.model.Order other) {
    return new com.demo.avro.model.Order.Builder(other);
  }

  /**
   * To byte buffer.
   *
   * @return the java.nio. byte buffer
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /*
   * (non-Javadoc)
   *
   * @see org.apache.avro.specific.SpecificRecordBase#getSchema()
   */
  public org.apache.avro.Schema getSchema() {
    return SCHEMA$;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.apache.avro.specific.SpecificRecordBase#get(int)
   */
  // Used by DatumWriter. Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
      case 0:
        return order_id;
      case 1:
        return customer_id;
      case 2:
        return supplier_id;
      case 3:
        return cust_name;
      case 4:
        return item;
      case 5:
        return price;
      default:
        throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see org.apache.avro.specific.SpecificRecordBase#put(int,
   * java.lang.Object)
   */
  // Used by DatumReader. Applications should not call.
  @SuppressWarnings(value = "unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
      case 0:
        order_id = (java.lang.CharSequence) value$;
        break;
      case 1:
        customer_id = (java.lang.CharSequence) value$;
        break;
      case 2:
        supplier_id = (java.lang.CharSequence) value$;
        break;
      case 3:
        cust_name = (java.lang.CharSequence) value$;
        break;
      case 4:
        item = (java.lang.Integer) value$;
        break;
      case 5:
        price = (java.lang.Float) value$;
        break;
      default:
        throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the order id.
   *
   * @return the order id
   */
  public java.lang.CharSequence getOrderId() {
    return order_id;
  }

  /**
   * Sets the order id.
   *
   * @param value the new order id
   */
  public void setOrderId(java.lang.CharSequence value) {
    this.order_id = value;
  }

  /**
   * Gets the customer id.
   *
   * @return the customer id
   */
  public java.lang.CharSequence getCustomerId() {
    return customer_id;
  }

  /**
   * Sets the customer id.
   *
   * @param value the new customer id
   */
  public void setCustomerId(java.lang.CharSequence value) {
    this.customer_id = value;
  }

  /**
   * Gets the supplier id.
   *
   * @return the supplier id
   */
  public java.lang.CharSequence getSupplierId() {
    return supplier_id;
  }

  /**
   * Sets the supplier id.
   *
   * @param value the new supplier id
   */
  public void setSupplierId(java.lang.CharSequence value) {
    this.supplier_id = value;
  }

  /**
   * Gets the cust name.
   *
   * @return the cust name
   */
  public java.lang.CharSequence getCustName() {
    return cust_name;
  }

  /**
   * Sets the cust name.
   *
   * @param value the new cust name
   */
  public void setCustName(java.lang.CharSequence value) {
    this.cust_name = value;
  }

  /**
   * Gets the item.
   *
   * @return the item
   */
  public java.lang.Integer getItem() {
    return item;
  }

  /**
   * Sets the item.
   *
   * @param value the new item
   */
  public void setItem(java.lang.Integer value) {
    this.item = value;
  }

  /**
   * Gets the price.
   *
   * @return the price
   */
  public java.lang.Float getPrice() {
    return price;
  }

  /**
   * Sets the price.
   *
   * @param value the new price
   */
  public void setPrice(java.lang.Float value) {
    this.price = value;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.apache.avro.specific.SpecificRecordBase#writeExternal(java.io.
   * ObjectOutput)
   */
  @Override
  public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  /*
   * (non-Javadoc)
   *
   * @see org.apache.avro.specific.SpecificRecordBase#readExternal(java.io.
   * ObjectInput)
   */
  @Override
  public void readExternal(java.io.ObjectInput in) throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  /*
   * (non-Javadoc)
   *
   * @see org.apache.avro.specific.SpecificRecordBase#toString()
   */
  @Override
  public String toString() {
    return "Order [order_id="
        + order_id
        + ", customer_id="
        + customer_id
        + ", supplier_id="
        + supplier_id
        + ", cust_name="
        + cust_name
        + ", item="
        + item
        + ", price="
        + price
        + "]";
  }

  /** The Class Builder. */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Order>
      implements org.apache.avro.data.RecordBuilder<Order> {

    /** The order id. */
    private java.lang.CharSequence order_id;

    /** The customer id. */
    private java.lang.CharSequence customer_id;

    /** The supplier id. */
    private java.lang.CharSequence supplier_id;

    /** The cust name. */
    private java.lang.CharSequence cust_name;

    /** The item. */
    private int item;

    /** The price. */
    private float price;

    /** Instantiates a new builder. */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Instantiates a new builder.
     *
     * @param other the other
     */
    private Builder(com.demo.avro.model.Order.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.order_id)) {
        this.order_id = data().deepCopy(fields()[0].schema(), other.order_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.customer_id)) {
        this.customer_id = data().deepCopy(fields()[1].schema(), other.customer_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.supplier_id)) {
        this.supplier_id = data().deepCopy(fields()[2].schema(), other.supplier_id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.cust_name)) {
        this.cust_name = data().deepCopy(fields()[3].schema(), other.cust_name);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.item)) {
        this.item = data().deepCopy(fields()[4].schema(), other.item);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.price)) {
        this.price = data().deepCopy(fields()[5].schema(), other.price);
        fieldSetFlags()[5] = true;
      }
    }

    /**
     * Instantiates a new builder.
     *
     * @param other the other
     */
    private Builder(com.demo.avro.model.Order other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.order_id)) {
        this.order_id = data().deepCopy(fields()[0].schema(), other.order_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.customer_id)) {
        this.customer_id = data().deepCopy(fields()[1].schema(), other.customer_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.supplier_id)) {
        this.supplier_id = data().deepCopy(fields()[2].schema(), other.supplier_id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.cust_name)) {
        this.cust_name = data().deepCopy(fields()[3].schema(), other.cust_name);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.item)) {
        this.item = data().deepCopy(fields()[4].schema(), other.item);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.price)) {
        this.price = data().deepCopy(fields()[5].schema(), other.price);
        fieldSetFlags()[5] = true;
      }
    }

    /**
     * Gets the order id.
     *
     * @return the order id
     */
    public java.lang.CharSequence getOrderId() {
      return order_id;
    }

    /**
     * Sets the order id.
     *
     * @param value the value
     * @return the com.demo.avro.model. order. builder
     */
    public com.demo.avro.model.Order.Builder setOrderId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.order_id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
     * Checks for order id.
     *
     * @return true, if successful
     */
    public boolean hasOrderId() {
      return fieldSetFlags()[0];
    }

    /**
     * Clear order id.
     *
     * @return the com.demo.avro.model. order. builder
     */
    public com.demo.avro.model.Order.Builder clearOrderId() {
      order_id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
     * Gets the customer id.
     *
     * @return the customer id
     */
    public java.lang.CharSequence getCustomerId() {
      return customer_id;
    }

    /**
     * Sets the customer id.
     *
     * @param value the value
     * @return the com.demo.avro.model. order. builder
     */
    public com.demo.avro.model.Order.Builder setCustomerId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.customer_id = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
     * Checks for customer id.
     *
     * @return true, if successful
     */
    public boolean hasCustomerId() {
      return fieldSetFlags()[1];
    }

    /**
     * Clear customer id.
     *
     * @return the com.demo.avro.model. order. builder
     */
    public com.demo.avro.model.Order.Builder clearCustomerId() {
      customer_id = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
     * Gets the supplier id.
     *
     * @return the supplier id
     */
    public java.lang.CharSequence getSupplierId() {
      return supplier_id;
    }

    /**
     * Sets the supplier id.
     *
     * @param value the value
     * @return the com.demo.avro.model. order. builder
     */
    public com.demo.avro.model.Order.Builder setSupplierId(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.supplier_id = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
     * Checks for supplier id.
     *
     * @return true, if successful
     */
    public boolean hasSupplierId() {
      return fieldSetFlags()[2];
    }

    /**
     * Clear supplier id.
     *
     * @return the com.demo.avro.model. order. builder
     */
    public com.demo.avro.model.Order.Builder clearSupplierId() {
      supplier_id = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
     * Gets the cust name.
     *
     * @return the cust name
     */
    public java.lang.CharSequence getCustName() {
      return cust_name;
    }

    /**
     * Sets the cust name.
     *
     * @param value the value
     * @return the com.demo.avro.model. order. builder
     */
    public com.demo.avro.model.Order.Builder setCustName(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.cust_name = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
     * Checks for cust name.
     *
     * @return true, if successful
     */
    public boolean hasCustName() {
      return fieldSetFlags()[3];
    }

    /**
     * Clear cust name.
     *
     * @return the com.demo.avro.model. order. builder
     */
    public com.demo.avro.model.Order.Builder clearCustName() {
      cust_name = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
     * Gets the item.
     *
     * @return the item
     */
    public java.lang.Integer getItem() {
      return item;
    }

    /**
     * Sets the item.
     *
     * @param value the value
     * @return the com.demo.avro.model. order. builder
     */
    public com.demo.avro.model.Order.Builder setItem(int value) {
      validate(fields()[4], value);
      this.item = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
     * Checks for item.
     *
     * @return true, if successful
     */
    public boolean hasItem() {
      return fieldSetFlags()[4];
    }

    /**
     * Clear item.
     *
     * @return the com.demo.avro.model. order. builder
     */
    public com.demo.avro.model.Order.Builder clearItem() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public java.lang.Float getPrice() {
      return price;
    }

    /**
     * Sets the price.
     *
     * @param value the value
     * @return the com.demo.avro.model. order. builder
     */
    public com.demo.avro.model.Order.Builder setPrice(float value) {
      validate(fields()[5], value);
      this.price = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
     * Checks for price.
     *
     * @return true, if successful
     */
    public boolean hasPrice() {
      return fieldSetFlags()[5];
    }

    /**
     * Clear price.
     *
     * @return the com.demo.avro.model. order. builder
     */
    public com.demo.avro.model.Order.Builder clearPrice() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.apache.avro.data.RecordBuilder#build()
     */
    @SuppressWarnings("unchecked")
    public Order build() {
      try {
        Order record = new Order();
        record.order_id =
            fieldSetFlags()[0] ? this.order_id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.customer_id =
            fieldSetFlags()[1]
                ? this.customer_id
                : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.supplier_id =
            fieldSetFlags()[2]
                ? this.supplier_id
                : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.cust_name =
            fieldSetFlags()[3]
                ? this.cust_name
                : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.item =
            fieldSetFlags()[4] ? this.item : (java.lang.Integer) defaultValue(fields()[4]);
        record.price =
            fieldSetFlags()[5] ? this.price : (java.lang.Float) defaultValue(fields()[5]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
