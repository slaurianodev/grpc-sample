// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wallet.proto

package br.com.sergio.wallet;

/**
 * Protobuf type {@code wallet.OperationInput}
 */
public  final class OperationInput extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:wallet.OperationInput)
    OperationInputOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OperationInput.newBuilder() to construct.
  private OperationInput(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OperationInput() {
    userId_ = 0;
    amount_ = 0D;
    currency_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private OperationInput(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            userId_ = input.readUInt32();
            break;
          }
          case 17: {

            amount_ = input.readDouble();
            break;
          }
          case 24: {
            int rawValue = input.readEnum();

            currency_ = rawValue;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return br.com.sergio.wallet.WalletProto.internal_static_wallet_OperationInput_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return br.com.sergio.wallet.WalletProto.internal_static_wallet_OperationInput_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            br.com.sergio.wallet.OperationInput.class, br.com.sergio.wallet.OperationInput.Builder.class);
  }

  public static final int USER_ID_FIELD_NUMBER = 1;
  private int userId_;
  /**
   * <code>uint32 user_id = 1;</code>
   */
  public int getUserId() {
    return userId_;
  }

  public static final int AMOUNT_FIELD_NUMBER = 2;
  private double amount_;
  /**
   * <code>double amount = 2;</code>
   */
  public double getAmount() {
    return amount_;
  }

  public static final int CURRENCY_FIELD_NUMBER = 3;
  private int currency_;
  /**
   * <code>.wallet.Currency currency = 3;</code>
   */
  public int getCurrencyValue() {
    return currency_;
  }
  /**
   * <code>.wallet.Currency currency = 3;</code>
   */
  public br.com.sergio.wallet.Currency getCurrency() {
    br.com.sergio.wallet.Currency result = br.com.sergio.wallet.Currency.valueOf(currency_);
    return result == null ? br.com.sergio.wallet.Currency.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (userId_ != 0) {
      output.writeUInt32(1, userId_);
    }
    if (amount_ != 0D) {
      output.writeDouble(2, amount_);
    }
    if (currency_ != br.com.sergio.wallet.Currency.EUR.getNumber()) {
      output.writeEnum(3, currency_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, userId_);
    }
    if (amount_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, amount_);
    }
    if (currency_ != br.com.sergio.wallet.Currency.EUR.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(3, currency_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof br.com.sergio.wallet.OperationInput)) {
      return super.equals(obj);
    }
    br.com.sergio.wallet.OperationInput other = (br.com.sergio.wallet.OperationInput) obj;

    boolean result = true;
    result = result && (getUserId()
        == other.getUserId());
    result = result && (
        java.lang.Double.doubleToLongBits(getAmount())
        == java.lang.Double.doubleToLongBits(
            other.getAmount()));
    result = result && currency_ == other.currency_;
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getUserId();
    hash = (37 * hash) + AMOUNT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getAmount()));
    hash = (37 * hash) + CURRENCY_FIELD_NUMBER;
    hash = (53 * hash) + currency_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static br.com.sergio.wallet.OperationInput parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.sergio.wallet.OperationInput parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.sergio.wallet.OperationInput parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.sergio.wallet.OperationInput parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.sergio.wallet.OperationInput parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.sergio.wallet.OperationInput parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.sergio.wallet.OperationInput parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.com.sergio.wallet.OperationInput parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.com.sergio.wallet.OperationInput parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static br.com.sergio.wallet.OperationInput parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.com.sergio.wallet.OperationInput parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.com.sergio.wallet.OperationInput parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(br.com.sergio.wallet.OperationInput prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code wallet.OperationInput}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:wallet.OperationInput)
      br.com.sergio.wallet.OperationInputOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return br.com.sergio.wallet.WalletProto.internal_static_wallet_OperationInput_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return br.com.sergio.wallet.WalletProto.internal_static_wallet_OperationInput_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              br.com.sergio.wallet.OperationInput.class, br.com.sergio.wallet.OperationInput.Builder.class);
    }

    // Construct using br.com.sergio.wallet.OperationInput.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      userId_ = 0;

      amount_ = 0D;

      currency_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return br.com.sergio.wallet.WalletProto.internal_static_wallet_OperationInput_descriptor;
    }

    public br.com.sergio.wallet.OperationInput getDefaultInstanceForType() {
      return br.com.sergio.wallet.OperationInput.getDefaultInstance();
    }

    public br.com.sergio.wallet.OperationInput build() {
      br.com.sergio.wallet.OperationInput result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public br.com.sergio.wallet.OperationInput buildPartial() {
      br.com.sergio.wallet.OperationInput result = new br.com.sergio.wallet.OperationInput(this);
      result.userId_ = userId_;
      result.amount_ = amount_;
      result.currency_ = currency_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof br.com.sergio.wallet.OperationInput) {
        return mergeFrom((br.com.sergio.wallet.OperationInput)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(br.com.sergio.wallet.OperationInput other) {
      if (other == br.com.sergio.wallet.OperationInput.getDefaultInstance()) return this;
      if (other.getUserId() != 0) {
        setUserId(other.getUserId());
      }
      if (other.getAmount() != 0D) {
        setAmount(other.getAmount());
      }
      if (other.currency_ != 0) {
        setCurrencyValue(other.getCurrencyValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      br.com.sergio.wallet.OperationInput parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (br.com.sergio.wallet.OperationInput) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int userId_ ;
    /**
     * <code>uint32 user_id = 1;</code>
     */
    public int getUserId() {
      return userId_;
    }
    /**
     * <code>uint32 user_id = 1;</code>
     */
    public Builder setUserId(int value) {
      
      userId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 user_id = 1;</code>
     */
    public Builder clearUserId() {
      
      userId_ = 0;
      onChanged();
      return this;
    }

    private double amount_ ;
    /**
     * <code>double amount = 2;</code>
     */
    public double getAmount() {
      return amount_;
    }
    /**
     * <code>double amount = 2;</code>
     */
    public Builder setAmount(double value) {
      
      amount_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double amount = 2;</code>
     */
    public Builder clearAmount() {
      
      amount_ = 0D;
      onChanged();
      return this;
    }

    private int currency_ = 0;
    /**
     * <code>.wallet.Currency currency = 3;</code>
     */
    public int getCurrencyValue() {
      return currency_;
    }
    /**
     * <code>.wallet.Currency currency = 3;</code>
     */
    public Builder setCurrencyValue(int value) {
      currency_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.wallet.Currency currency = 3;</code>
     */
    public br.com.sergio.wallet.Currency getCurrency() {
      br.com.sergio.wallet.Currency result = br.com.sergio.wallet.Currency.valueOf(currency_);
      return result == null ? br.com.sergio.wallet.Currency.UNRECOGNIZED : result;
    }
    /**
     * <code>.wallet.Currency currency = 3;</code>
     */
    public Builder setCurrency(br.com.sergio.wallet.Currency value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      currency_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.wallet.Currency currency = 3;</code>
     */
    public Builder clearCurrency() {
      
      currency_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:wallet.OperationInput)
  }

  // @@protoc_insertion_point(class_scope:wallet.OperationInput)
  private static final br.com.sergio.wallet.OperationInput DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new br.com.sergio.wallet.OperationInput();
  }

  public static br.com.sergio.wallet.OperationInput getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OperationInput>
      PARSER = new com.google.protobuf.AbstractParser<OperationInput>() {
    public OperationInput parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new OperationInput(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OperationInput> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OperationInput> getParserForType() {
    return PARSER;
  }

  public br.com.sergio.wallet.OperationInput getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

