package br.com.sergio.wallet;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.0)",
    comments = "Source: wallet.proto")
public final class OperationsGrpc {

  private OperationsGrpc() {}

  public static final String SERVICE_NAME = "wallet.Operations";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDepositMethod()} instead. 
  public static final io.grpc.MethodDescriptor<br.com.sergio.wallet.OperationInput,
      br.com.sergio.wallet.OperationOutput> METHOD_DEPOSIT = getDepositMethod();

  private static volatile io.grpc.MethodDescriptor<br.com.sergio.wallet.OperationInput,
      br.com.sergio.wallet.OperationOutput> getDepositMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<br.com.sergio.wallet.OperationInput,
      br.com.sergio.wallet.OperationOutput> getDepositMethod() {
    io.grpc.MethodDescriptor<br.com.sergio.wallet.OperationInput, br.com.sergio.wallet.OperationOutput> getDepositMethod;
    if ((getDepositMethod = OperationsGrpc.getDepositMethod) == null) {
      synchronized (OperationsGrpc.class) {
        if ((getDepositMethod = OperationsGrpc.getDepositMethod) == null) {
          OperationsGrpc.getDepositMethod = getDepositMethod = 
              io.grpc.MethodDescriptor.<br.com.sergio.wallet.OperationInput, br.com.sergio.wallet.OperationOutput>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "wallet.Operations", "Deposit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.sergio.wallet.OperationInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.sergio.wallet.OperationOutput.getDefaultInstance()))
                  .setSchemaDescriptor(new OperationsMethodDescriptorSupplier("Deposit"))
                  .build();
          }
        }
     }
     return getDepositMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getWithdrawMethod()} instead. 
  public static final io.grpc.MethodDescriptor<br.com.sergio.wallet.OperationInput,
      br.com.sergio.wallet.OperationOutput> METHOD_WITHDRAW = getWithdrawMethod();

  private static volatile io.grpc.MethodDescriptor<br.com.sergio.wallet.OperationInput,
      br.com.sergio.wallet.OperationOutput> getWithdrawMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<br.com.sergio.wallet.OperationInput,
      br.com.sergio.wallet.OperationOutput> getWithdrawMethod() {
    io.grpc.MethodDescriptor<br.com.sergio.wallet.OperationInput, br.com.sergio.wallet.OperationOutput> getWithdrawMethod;
    if ((getWithdrawMethod = OperationsGrpc.getWithdrawMethod) == null) {
      synchronized (OperationsGrpc.class) {
        if ((getWithdrawMethod = OperationsGrpc.getWithdrawMethod) == null) {
          OperationsGrpc.getWithdrawMethod = getWithdrawMethod = 
              io.grpc.MethodDescriptor.<br.com.sergio.wallet.OperationInput, br.com.sergio.wallet.OperationOutput>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "wallet.Operations", "Withdraw"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.sergio.wallet.OperationInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.sergio.wallet.OperationOutput.getDefaultInstance()))
                  .setSchemaDescriptor(new OperationsMethodDescriptorSupplier("Withdraw"))
                  .build();
          }
        }
     }
     return getWithdrawMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getBalanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<br.com.sergio.wallet.BalanceInput,
      br.com.sergio.wallet.BalanceOutput> METHOD_BALANCE = getBalanceMethod();

  private static volatile io.grpc.MethodDescriptor<br.com.sergio.wallet.BalanceInput,
      br.com.sergio.wallet.BalanceOutput> getBalanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<br.com.sergio.wallet.BalanceInput,
      br.com.sergio.wallet.BalanceOutput> getBalanceMethod() {
    io.grpc.MethodDescriptor<br.com.sergio.wallet.BalanceInput, br.com.sergio.wallet.BalanceOutput> getBalanceMethod;
    if ((getBalanceMethod = OperationsGrpc.getBalanceMethod) == null) {
      synchronized (OperationsGrpc.class) {
        if ((getBalanceMethod = OperationsGrpc.getBalanceMethod) == null) {
          OperationsGrpc.getBalanceMethod = getBalanceMethod = 
              io.grpc.MethodDescriptor.<br.com.sergio.wallet.BalanceInput, br.com.sergio.wallet.BalanceOutput>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "wallet.Operations", "Balance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.sergio.wallet.BalanceInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.sergio.wallet.BalanceOutput.getDefaultInstance()))
                  .setSchemaDescriptor(new OperationsMethodDescriptorSupplier("Balance"))
                  .build();
          }
        }
     }
     return getBalanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OperationsStub newStub(io.grpc.Channel channel) {
    return new OperationsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OperationsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OperationsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OperationsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OperationsFutureStub(channel);
  }

  /**
   */
  public static abstract class OperationsImplBase implements io.grpc.BindableService {

    /**
     */
    public void deposit(br.com.sergio.wallet.OperationInput request,
        io.grpc.stub.StreamObserver<br.com.sergio.wallet.OperationOutput> responseObserver) {
      asyncUnimplementedUnaryCall(getDepositMethod(), responseObserver);
    }

    /**
     */
    public void withdraw(br.com.sergio.wallet.OperationInput request,
        io.grpc.stub.StreamObserver<br.com.sergio.wallet.OperationOutput> responseObserver) {
      asyncUnimplementedUnaryCall(getWithdrawMethod(), responseObserver);
    }

    /**
     */
    public void balance(br.com.sergio.wallet.BalanceInput request,
        io.grpc.stub.StreamObserver<br.com.sergio.wallet.BalanceOutput> responseObserver) {
      asyncUnimplementedUnaryCall(getBalanceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDepositMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                br.com.sergio.wallet.OperationInput,
                br.com.sergio.wallet.OperationOutput>(
                  this, METHODID_DEPOSIT)))
          .addMethod(
            getWithdrawMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                br.com.sergio.wallet.OperationInput,
                br.com.sergio.wallet.OperationOutput>(
                  this, METHODID_WITHDRAW)))
          .addMethod(
            getBalanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                br.com.sergio.wallet.BalanceInput,
                br.com.sergio.wallet.BalanceOutput>(
                  this, METHODID_BALANCE)))
          .build();
    }
  }

  /**
   */
  public static final class OperationsStub extends io.grpc.stub.AbstractStub<OperationsStub> {
    private OperationsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OperationsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OperationsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OperationsStub(channel, callOptions);
    }

    /**
     */
    public void deposit(br.com.sergio.wallet.OperationInput request,
        io.grpc.stub.StreamObserver<br.com.sergio.wallet.OperationOutput> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDepositMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void withdraw(br.com.sergio.wallet.OperationInput request,
        io.grpc.stub.StreamObserver<br.com.sergio.wallet.OperationOutput> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getWithdrawMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void balance(br.com.sergio.wallet.BalanceInput request,
        io.grpc.stub.StreamObserver<br.com.sergio.wallet.BalanceOutput> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBalanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class OperationsBlockingStub extends io.grpc.stub.AbstractStub<OperationsBlockingStub> {
    private OperationsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OperationsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OperationsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OperationsBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.sergio.wallet.OperationOutput deposit(br.com.sergio.wallet.OperationInput request) {
      return blockingUnaryCall(
          getChannel(), getDepositMethod(), getCallOptions(), request);
    }

    /**
     */
    public br.com.sergio.wallet.OperationOutput withdraw(br.com.sergio.wallet.OperationInput request) {
      return blockingUnaryCall(
          getChannel(), getWithdrawMethod(), getCallOptions(), request);
    }

    /**
     */
    public br.com.sergio.wallet.BalanceOutput balance(br.com.sergio.wallet.BalanceInput request) {
      return blockingUnaryCall(
          getChannel(), getBalanceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class OperationsFutureStub extends io.grpc.stub.AbstractStub<OperationsFutureStub> {
    private OperationsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OperationsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OperationsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OperationsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.sergio.wallet.OperationOutput> deposit(
        br.com.sergio.wallet.OperationInput request) {
      return futureUnaryCall(
          getChannel().newCall(getDepositMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.sergio.wallet.OperationOutput> withdraw(
        br.com.sergio.wallet.OperationInput request) {
      return futureUnaryCall(
          getChannel().newCall(getWithdrawMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.sergio.wallet.BalanceOutput> balance(
        br.com.sergio.wallet.BalanceInput request) {
      return futureUnaryCall(
          getChannel().newCall(getBalanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DEPOSIT = 0;
  private static final int METHODID_WITHDRAW = 1;
  private static final int METHODID_BALANCE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OperationsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OperationsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DEPOSIT:
          serviceImpl.deposit((br.com.sergio.wallet.OperationInput) request,
              (io.grpc.stub.StreamObserver<br.com.sergio.wallet.OperationOutput>) responseObserver);
          break;
        case METHODID_WITHDRAW:
          serviceImpl.withdraw((br.com.sergio.wallet.OperationInput) request,
              (io.grpc.stub.StreamObserver<br.com.sergio.wallet.OperationOutput>) responseObserver);
          break;
        case METHODID_BALANCE:
          serviceImpl.balance((br.com.sergio.wallet.BalanceInput) request,
              (io.grpc.stub.StreamObserver<br.com.sergio.wallet.BalanceOutput>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class OperationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OperationsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.sergio.wallet.WalletProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Operations");
    }
  }

  private static final class OperationsFileDescriptorSupplier
      extends OperationsBaseDescriptorSupplier {
    OperationsFileDescriptorSupplier() {}
  }

  private static final class OperationsMethodDescriptorSupplier
      extends OperationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OperationsMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (OperationsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OperationsFileDescriptorSupplier())
              .addMethod(getDepositMethod())
              .addMethod(getWithdrawMethod())
              .addMethod(getBalanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
