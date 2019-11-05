/*
 * 
 */
package com.demo.avro.model;

import java.io.IOException;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

/**
 * The Class Data.
 */
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Data extends org.apache.avro.specific.SpecificRecordBase
		implements org.apache.avro.specific.SpecificRecord {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4405851890358733830L;

	/** The Constant SCHEMA$. */
	public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse(
			"{\"type\":\"record\",\"name\":\"Data\",\"namespace\":\"com.demo.avro.model\",\"fields\":[{\"name\":\"InvoiceNo\",\"type\":\"string\"},{\"name\":\"StockCode\",\"type\":\"string\"},{\"name\":\"Description\",\"type\":\"string\"},{\"name\":\"Quantity\",\"type\":\"string\"},{\"name\":\"InvoiceDate\",\"type\":\"string\"},{\"name\":\"UnitPrice\",\"type\":\"string\"},{\"name\":\"CustomerID\",\"type\":\"string\"},{\"name\":\"Country\",\"type\":\"string\"}]}");

	/**
	 * Gets the class schema.
	 *
	 * @return the class schema
	 */
	public static org.apache.avro.Schema getClassSchema() {
		return SCHEMA$;
	}

	/** The MODE l$. */
	private static SpecificData MODEL$ = new SpecificData();

	/** The Constant ENCODER. */
	private static final BinaryMessageEncoder<Data> ENCODER = new BinaryMessageEncoder<Data>(MODEL$, SCHEMA$);

	/** The Constant DECODER. */
	private static final BinaryMessageDecoder<Data> DECODER = new BinaryMessageDecoder<Data>(MODEL$, SCHEMA$);

	/**
	 * Gets the decoder.
	 *
	 * @return the decoder
	 */
	public static BinaryMessageDecoder<Data> getDecoder() {
		return DECODER;
	}

	/**
	 * Creates the decoder.
	 *
	 * @param resolver
	 *            the resolver
	 * @return the binary message decoder
	 */
	public static BinaryMessageDecoder<Data> createDecoder(SchemaStore resolver) {
		return new BinaryMessageDecoder<Data>(MODEL$, SCHEMA$, resolver);
	}

	/**
	 * To byte buffer.
	 *
	 * @return the java.nio. byte buffer
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
		return ENCODER.encode(this);
	}

	/**
	 * From byte buffer.
	 *
	 * @param b
	 *            the b
	 * @return the data
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static Data fromByteBuffer(java.nio.ByteBuffer b) throws java.io.IOException {
		return DECODER.decode(b);
	}

	/** The Invoice no. */
	@Deprecated
	public java.lang.CharSequence InvoiceNo;

	/** The Stock code. */
	@Deprecated
	public java.lang.CharSequence StockCode;

	/** The Description. */
	@Deprecated
	public java.lang.CharSequence Description;

	/** The Quantity. */
	@Deprecated
	public java.lang.CharSequence Quantity;

	/** The Invoice date. */
	@Deprecated
	public java.lang.CharSequence InvoiceDate;

	/** The Unit price. */
	@Deprecated
	public java.lang.CharSequence UnitPrice;

	/** The Customer ID. */
	@Deprecated
	public java.lang.CharSequence CustomerID;

	/** The Country. */
	@Deprecated
	public java.lang.CharSequence Country;

	/**
	 * Instantiates a new data.
	 */
	public Data() {
	}

	/**
	 * Instantiates a new data.
	 *
	 * @param InvoiceNo
	 *            the invoice no
	 * @param StockCode
	 *            the stock code
	 * @param Description
	 *            the description
	 * @param Quantity
	 *            the quantity
	 * @param InvoiceDate
	 *            the invoice date
	 * @param UnitPrice
	 *            the unit price
	 * @param CustomerID
	 *            the customer ID
	 * @param Country
	 *            the country
	 */
	public Data(java.lang.CharSequence InvoiceNo, java.lang.CharSequence StockCode, java.lang.CharSequence Description,
			java.lang.CharSequence Quantity, java.lang.CharSequence InvoiceDate, java.lang.CharSequence UnitPrice,
			java.lang.CharSequence CustomerID, java.lang.CharSequence Country) {
		this.InvoiceNo = InvoiceNo;
		this.StockCode = StockCode;
		this.Description = Description;
		this.Quantity = Quantity;
		this.InvoiceDate = InvoiceDate;
		this.UnitPrice = UnitPrice;
		this.CustomerID = CustomerID;
		this.Country = Country;
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
			return InvoiceNo;
		case 1:
			return StockCode;
		case 2:
			return Description;
		case 3:
			return Quantity;
		case 4:
			return InvoiceDate;
		case 5:
			return UnitPrice;
		case 6:
			return CustomerID;
		case 7:
			return Country;
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
			InvoiceNo = (java.lang.CharSequence) value$;
			break;
		case 1:
			StockCode = (java.lang.CharSequence) value$;
			break;
		case 2:
			Description = (java.lang.CharSequence) value$;
			break;
		case 3:
			Quantity = (java.lang.CharSequence) value$;
			break;
		case 4:
			InvoiceDate = (java.lang.CharSequence) value$;
			break;
		case 5:
			UnitPrice = (java.lang.CharSequence) value$;
			break;
		case 6:
			CustomerID = (java.lang.CharSequence) value$;
			break;
		case 7:
			Country = (java.lang.CharSequence) value$;
			break;
		default:
			throw new org.apache.avro.AvroRuntimeException("Bad index");
		}
	}

	/**
	 * Gets the invoice no.
	 *
	 * @return the invoice no
	 */
	public java.lang.CharSequence getInvoiceNo() {
		return InvoiceNo;
	}

	/**
	 * Sets the invoice no.
	 *
	 * @param value
	 *            the new invoice no
	 */
	public void setInvoiceNo(java.lang.CharSequence value) {
		this.InvoiceNo = value;
	}

	/**
	 * Gets the stock code.
	 *
	 * @return the stock code
	 */
	public java.lang.CharSequence getStockCode() {
		return StockCode;
	}

	/**
	 * Sets the stock code.
	 *
	 * @param value
	 *            the new stock code
	 */
	public void setStockCode(java.lang.CharSequence value) {
		this.StockCode = value;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public java.lang.CharSequence getDescription() {
		return Description;
	}

	/**
	 * Sets the description.
	 *
	 * @param value
	 *            the new description
	 */
	public void setDescription(java.lang.CharSequence value) {
		this.Description = value;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public java.lang.CharSequence getQuantity() {
		return Quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param value
	 *            the new quantity
	 */
	public void setQuantity(java.lang.CharSequence value) {
		this.Quantity = value;
	}

	/**
	 * Gets the invoice date.
	 *
	 * @return the invoice date
	 */
	public java.lang.CharSequence getInvoiceDate() {
		return InvoiceDate;
	}

	/**
	 * Sets the invoice date.
	 *
	 * @param value
	 *            the new invoice date
	 */
	public void setInvoiceDate(java.lang.CharSequence value) {
		this.InvoiceDate = value;
	}

	/**
	 * Gets the unit price.
	 *
	 * @return the unit price
	 */
	public java.lang.CharSequence getUnitPrice() {
		return UnitPrice;
	}

	/**
	 * Sets the unit price.
	 *
	 * @param value
	 *            the new unit price
	 */
	public void setUnitPrice(java.lang.CharSequence value) {
		this.UnitPrice = value;
	}

	/**
	 * Gets the customer ID.
	 *
	 * @return the customer ID
	 */
	public java.lang.CharSequence getCustomerID() {
		return CustomerID;
	}

	/**
	 * Sets the customer ID.
	 *
	 * @param value
	 *            the new customer ID
	 */
	public void setCustomerID(java.lang.CharSequence value) {
		this.CustomerID = value;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public java.lang.CharSequence getCountry() {
		return Country;
	}

	/**
	 * Sets the country.
	 *
	 * @param value
	 *            the new country
	 */
	public void setCountry(java.lang.CharSequence value) {
		this.Country = value;
	}

	/**
	 * New builder.
	 *
	 * @return the com.demo.avro.model. data. builder
	 */
	public static com.demo.avro.model.Data.Builder newBuilder() {
		return new com.demo.avro.model.Data.Builder();
	}

	/**
	 * New builder.
	 *
	 * @param other
	 *            the other
	 * @return the com.demo.avro.model. data. builder
	 */
	public static com.demo.avro.model.Data.Builder newBuilder(com.demo.avro.model.Data.Builder other) {
		return new com.demo.avro.model.Data.Builder(other);
	}

	/**
	 * New builder.
	 *
	 * @param other
	 *            the other
	 * @return the com.demo.avro.model. data. builder
	 */
	public static com.demo.avro.model.Data.Builder newBuilder(com.demo.avro.model.Data other) {
		return new com.demo.avro.model.Data.Builder(other);
	}

	/**
	 * The Class Builder.
	 */
	public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Data>
			implements org.apache.avro.data.RecordBuilder<Data> {

		/** The Invoice no. */
		private java.lang.CharSequence InvoiceNo;

		/** The Stock code. */
		private java.lang.CharSequence StockCode;

		/** The Description. */
		private java.lang.CharSequence Description;

		/** The Quantity. */
		private java.lang.CharSequence Quantity;

		/** The Invoice date. */
		private java.lang.CharSequence InvoiceDate;

		/** The Unit price. */
		private java.lang.CharSequence UnitPrice;

		/** The Customer ID. */
		private java.lang.CharSequence CustomerID;

		/** The Country. */
		private java.lang.CharSequence Country;

		/**
		 * Instantiates a new builder.
		 */
		private Builder() {
			super(SCHEMA$);
		}

		/**
		 * Instantiates a new builder.
		 *
		 * @param other
		 *            the other
		 */
		private Builder(com.demo.avro.model.Data.Builder other) {
			super(other);
			if (isValidValue(fields()[0], other.InvoiceNo)) {
				this.InvoiceNo = data().deepCopy(fields()[0].schema(), other.InvoiceNo);
				fieldSetFlags()[0] = true;
			}
			if (isValidValue(fields()[1], other.StockCode)) {
				this.StockCode = data().deepCopy(fields()[1].schema(), other.StockCode);
				fieldSetFlags()[1] = true;
			}
			if (isValidValue(fields()[2], other.Description)) {
				this.Description = data().deepCopy(fields()[2].schema(), other.Description);
				fieldSetFlags()[2] = true;
			}
			if (isValidValue(fields()[3], other.Quantity)) {
				this.Quantity = data().deepCopy(fields()[3].schema(), other.Quantity);
				fieldSetFlags()[3] = true;
			}
			if (isValidValue(fields()[4], other.InvoiceDate)) {
				this.InvoiceDate = data().deepCopy(fields()[4].schema(), other.InvoiceDate);
				fieldSetFlags()[4] = true;
			}
			if (isValidValue(fields()[5], other.UnitPrice)) {
				this.UnitPrice = data().deepCopy(fields()[5].schema(), other.UnitPrice);
				fieldSetFlags()[5] = true;
			}
			if (isValidValue(fields()[6], other.CustomerID)) {
				this.CustomerID = data().deepCopy(fields()[6].schema(), other.CustomerID);
				fieldSetFlags()[6] = true;
			}
			if (isValidValue(fields()[7], other.Country)) {
				this.Country = data().deepCopy(fields()[7].schema(), other.Country);
				fieldSetFlags()[7] = true;
			}
		}

		/**
		 * Instantiates a new builder.
		 *
		 * @param other
		 *            the other
		 */
		private Builder(com.demo.avro.model.Data other) {
			super(SCHEMA$);
			if (isValidValue(fields()[0], other.InvoiceNo)) {
				this.InvoiceNo = data().deepCopy(fields()[0].schema(), other.InvoiceNo);
				fieldSetFlags()[0] = true;
			}
			if (isValidValue(fields()[1], other.StockCode)) {
				this.StockCode = data().deepCopy(fields()[1].schema(), other.StockCode);
				fieldSetFlags()[1] = true;
			}
			if (isValidValue(fields()[2], other.Description)) {
				this.Description = data().deepCopy(fields()[2].schema(), other.Description);
				fieldSetFlags()[2] = true;
			}
			if (isValidValue(fields()[3], other.Quantity)) {
				this.Quantity = data().deepCopy(fields()[3].schema(), other.Quantity);
				fieldSetFlags()[3] = true;
			}
			if (isValidValue(fields()[4], other.InvoiceDate)) {
				this.InvoiceDate = data().deepCopy(fields()[4].schema(), other.InvoiceDate);
				fieldSetFlags()[4] = true;
			}
			if (isValidValue(fields()[5], other.UnitPrice)) {
				this.UnitPrice = data().deepCopy(fields()[5].schema(), other.UnitPrice);
				fieldSetFlags()[5] = true;
			}
			if (isValidValue(fields()[6], other.CustomerID)) {
				this.CustomerID = data().deepCopy(fields()[6].schema(), other.CustomerID);
				fieldSetFlags()[6] = true;
			}
			if (isValidValue(fields()[7], other.Country)) {
				this.Country = data().deepCopy(fields()[7].schema(), other.Country);
				fieldSetFlags()[7] = true;
			}
		}

		/**
		 * Gets the invoice no.
		 *
		 * @return the invoice no
		 */
		public java.lang.CharSequence getInvoiceNo() {
			return InvoiceNo;
		}

		/**
		 * Sets the invoice no.
		 *
		 * @param value
		 *            the value
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder setInvoiceNo(java.lang.CharSequence value) {
			validate(fields()[0], value);
			this.InvoiceNo = value;
			fieldSetFlags()[0] = true;
			return this;
		}

		/**
		 * Checks for invoice no.
		 *
		 * @return true, if successful
		 */
		public boolean hasInvoiceNo() {
			return fieldSetFlags()[0];
		}

		/**
		 * Clear invoice no.
		 *
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder clearInvoiceNo() {
			InvoiceNo = null;
			fieldSetFlags()[0] = false;
			return this;
		}

		/**
		 * Gets the stock code.
		 *
		 * @return the stock code
		 */
		public java.lang.CharSequence getStockCode() {
			return StockCode;
		}

		/**
		 * Sets the stock code.
		 *
		 * @param value
		 *            the value
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder setStockCode(java.lang.CharSequence value) {
			validate(fields()[1], value);
			this.StockCode = value;
			fieldSetFlags()[1] = true;
			return this;
		}

		/**
		 * Checks for stock code.
		 *
		 * @return true, if successful
		 */
		public boolean hasStockCode() {
			return fieldSetFlags()[1];
		}

		/**
		 * Clear stock code.
		 *
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder clearStockCode() {
			StockCode = null;
			fieldSetFlags()[1] = false;
			return this;
		}

		/**
		 * Gets the description.
		 *
		 * @return the description
		 */
		public java.lang.CharSequence getDescription() {
			return Description;
		}

		/**
		 * Sets the description.
		 *
		 * @param value
		 *            the value
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder setDescription(java.lang.CharSequence value) {
			validate(fields()[2], value);
			this.Description = value;
			fieldSetFlags()[2] = true;
			return this;
		}

		/**
		 * Checks for description.
		 *
		 * @return true, if successful
		 */
		public boolean hasDescription() {
			return fieldSetFlags()[2];
		}

		/**
		 * Clear description.
		 *
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder clearDescription() {
			Description = null;
			fieldSetFlags()[2] = false;
			return this;
		}

		/**
		 * Gets the quantity.
		 *
		 * @return the quantity
		 */
		public java.lang.CharSequence getQuantity() {
			return Quantity;
		}

		/**
		 * Sets the quantity.
		 *
		 * @param value
		 *            the value
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder setQuantity(java.lang.CharSequence value) {
			validate(fields()[3], value);
			this.Quantity = value;
			fieldSetFlags()[3] = true;
			return this;
		}

		/**
		 * Checks for quantity.
		 *
		 * @return true, if successful
		 */
		public boolean hasQuantity() {
			return fieldSetFlags()[3];
		}

		/**
		 * Clear quantity.
		 *
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder clearQuantity() {
			Quantity = null;
			fieldSetFlags()[3] = false;
			return this;
		}

		/**
		 * Gets the invoice date.
		 *
		 * @return the invoice date
		 */
		public java.lang.CharSequence getInvoiceDate() {
			return InvoiceDate;
		}

		/**
		 * Sets the invoice date.
		 *
		 * @param value
		 *            the value
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder setInvoiceDate(java.lang.CharSequence value) {
			validate(fields()[4], value);
			this.InvoiceDate = value;
			fieldSetFlags()[4] = true;
			return this;
		}

		/**
		 * Checks for invoice date.
		 *
		 * @return true, if successful
		 */
		public boolean hasInvoiceDate() {
			return fieldSetFlags()[4];
		}

		/**
		 * Clear invoice date.
		 *
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder clearInvoiceDate() {
			InvoiceDate = null;
			fieldSetFlags()[4] = false;
			return this;
		}

		/**
		 * Gets the unit price.
		 *
		 * @return the unit price
		 */
		public java.lang.CharSequence getUnitPrice() {
			return UnitPrice;
		}

		/**
		 * Sets the unit price.
		 *
		 * @param value
		 *            the value
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder setUnitPrice(java.lang.CharSequence value) {
			validate(fields()[5], value);
			this.UnitPrice = value;
			fieldSetFlags()[5] = true;
			return this;
		}

		/**
		 * Checks for unit price.
		 *
		 * @return true, if successful
		 */
		public boolean hasUnitPrice() {
			return fieldSetFlags()[5];
		}

		/**
		 * Clear unit price.
		 *
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder clearUnitPrice() {
			UnitPrice = null;
			fieldSetFlags()[5] = false;
			return this;
		}

		/**
		 * Gets the customer ID.
		 *
		 * @return the customer ID
		 */
		public java.lang.CharSequence getCustomerID() {
			return CustomerID;
		}

		/**
		 * Sets the customer ID.
		 *
		 * @param value
		 *            the value
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder setCustomerID(java.lang.CharSequence value) {
			validate(fields()[6], value);
			this.CustomerID = value;
			fieldSetFlags()[6] = true;
			return this;
		}

		/**
		 * Checks for customer ID.
		 *
		 * @return true, if successful
		 */
		public boolean hasCustomerID() {
			return fieldSetFlags()[6];
		}

		/**
		 * Clear customer ID.
		 *
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder clearCustomerID() {
			CustomerID = null;
			fieldSetFlags()[6] = false;
			return this;
		}

		/**
		 * Gets the country.
		 *
		 * @return the country
		 */
		public java.lang.CharSequence getCountry() {
			return Country;
		}

		/**
		 * Sets the country.
		 *
		 * @param value
		 *            the value
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder setCountry(java.lang.CharSequence value) {
			validate(fields()[7], value);
			this.Country = value;
			fieldSetFlags()[7] = true;
			return this;
		}

		/**
		 * Checks for country.
		 *
		 * @return true, if successful
		 */
		public boolean hasCountry() {
			return fieldSetFlags()[7];
		}

		/**
		 * Clear country.
		 *
		 * @return the com.demo.avro.model. data. builder
		 */
		public com.demo.avro.model.Data.Builder clearCountry() {
			Country = null;
			fieldSetFlags()[7] = false;
			return this;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.apache.avro.data.RecordBuilder#build()
		 */
		@SuppressWarnings("unchecked")
		public Data build() {
			try {
				Data record = new Data();
				record.InvoiceNo = fieldSetFlags()[0] ? this.InvoiceNo
						: (java.lang.CharSequence) defaultValue(fields()[0]);
				record.StockCode = fieldSetFlags()[1] ? this.StockCode
						: (java.lang.CharSequence) defaultValue(fields()[1]);
				record.Description = fieldSetFlags()[2] ? this.Description
						: (java.lang.CharSequence) defaultValue(fields()[2]);
				record.Quantity = fieldSetFlags()[3] ? this.Quantity
						: (java.lang.CharSequence) defaultValue(fields()[3]);
				record.InvoiceDate = fieldSetFlags()[4] ? this.InvoiceDate
						: (java.lang.CharSequence) defaultValue(fields()[4]);
				record.UnitPrice = fieldSetFlags()[5] ? this.UnitPrice
						: (java.lang.CharSequence) defaultValue(fields()[5]);
				record.CustomerID = fieldSetFlags()[6] ? this.CustomerID
						: (java.lang.CharSequence) defaultValue(fields()[6]);
				record.Country = fieldSetFlags()[7] ? this.Country : (java.lang.CharSequence) defaultValue(fields()[7]);
				return record;
			} catch (java.lang.Exception e) {
				throw new org.apache.avro.AvroRuntimeException(e);
			}
		}
	}

	/** The Constant WRITER$. */
	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumWriter<Data> WRITER$ = (org.apache.avro.io.DatumWriter<Data>) MODEL$
			.createDatumWriter(SCHEMA$);

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

	/** The Constant READER$. */
	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumReader<Data> READER$ = (org.apache.avro.io.DatumReader<Data>) MODEL$
			.createDatumReader(SCHEMA$);

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
		return "Data [InvoiceNo=" + InvoiceNo + ", StockCode=" + StockCode + ", Description=" + Description
				+ ", Quantity=" + Quantity + ", InvoiceDate=" + InvoiceDate + ", UnitPrice=" + UnitPrice
				+ ", CustomerID=" + CustomerID + ", Country=" + Country + "]";
	}

}
