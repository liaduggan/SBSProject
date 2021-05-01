package grpc.sbs;

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
 * <pre>
 * interface exported by the server
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: temperature.proto")
public final class TempServiceGrpc {

  private TempServiceGrpc() {}

  public static final String SERVICE_NAME = "temperature.TempService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.sbs.tempRequest,
      grpc.sbs.currentTemperature> getTempReadingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "tempReading",
      requestType = grpc.sbs.tempRequest.class,
      responseType = grpc.sbs.currentTemperature.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.sbs.tempRequest,
      grpc.sbs.currentTemperature> getTempReadingMethod() {
    io.grpc.MethodDescriptor<grpc.sbs.tempRequest, grpc.sbs.currentTemperature> getTempReadingMethod;
    if ((getTempReadingMethod = TempServiceGrpc.getTempReadingMethod) == null) {
      synchronized (TempServiceGrpc.class) {
        if ((getTempReadingMethod = TempServiceGrpc.getTempReadingMethod) == null) {
          TempServiceGrpc.getTempReadingMethod = getTempReadingMethod = 
              io.grpc.MethodDescriptor.<grpc.sbs.tempRequest, grpc.sbs.currentTemperature>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "temperature.TempService", "tempReading"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.sbs.tempRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.sbs.currentTemperature.getDefaultInstance()))
                  .setSchemaDescriptor(new TempServiceMethodDescriptorSupplier("tempReading"))
                  .build();
          }
        }
     }
     return getTempReadingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.sbs.tempSetRequest,
      grpc.sbs.tempSetResponse> getTempSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "tempSet",
      requestType = grpc.sbs.tempSetRequest.class,
      responseType = grpc.sbs.tempSetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.sbs.tempSetRequest,
      grpc.sbs.tempSetResponse> getTempSetMethod() {
    io.grpc.MethodDescriptor<grpc.sbs.tempSetRequest, grpc.sbs.tempSetResponse> getTempSetMethod;
    if ((getTempSetMethod = TempServiceGrpc.getTempSetMethod) == null) {
      synchronized (TempServiceGrpc.class) {
        if ((getTempSetMethod = TempServiceGrpc.getTempSetMethod) == null) {
          TempServiceGrpc.getTempSetMethod = getTempSetMethod = 
              io.grpc.MethodDescriptor.<grpc.sbs.tempSetRequest, grpc.sbs.tempSetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "temperature.TempService", "tempSet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.sbs.tempSetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.sbs.tempSetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TempServiceMethodDescriptorSupplier("tempSet"))
                  .build();
          }
        }
     }
     return getTempSetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TempServiceStub newStub(io.grpc.Channel channel) {
    return new TempServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TempServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TempServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TempServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TempServiceFutureStub(channel);
  }

  /**
   * <pre>
   * interface exported by the server
   * </pre>
   */
  public static abstract class TempServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends temperature reading request
     * </pre>
     */
    public void tempReading(grpc.sbs.tempRequest request,
        io.grpc.stub.StreamObserver<grpc.sbs.currentTemperature> responseObserver) {
      asyncUnimplementedUnaryCall(getTempReadingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sends change temperature setting request
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.sbs.tempSetRequest> tempSet(
        io.grpc.stub.StreamObserver<grpc.sbs.tempSetResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTempSetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTempReadingMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.sbs.tempRequest,
                grpc.sbs.currentTemperature>(
                  this, METHODID_TEMP_READING)))
          .addMethod(
            getTempSetMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.sbs.tempSetRequest,
                grpc.sbs.tempSetResponse>(
                  this, METHODID_TEMP_SET)))
          .build();
    }
  }

  /**
   * <pre>
   * interface exported by the server
   * </pre>
   */
  public static final class TempServiceStub extends io.grpc.stub.AbstractStub<TempServiceStub> {
    private TempServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TempServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TempServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TempServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends temperature reading request
     * </pre>
     */
    public void tempReading(grpc.sbs.tempRequest request,
        io.grpc.stub.StreamObserver<grpc.sbs.currentTemperature> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getTempReadingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sends change temperature setting request
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.sbs.tempSetRequest> tempSet(
        io.grpc.stub.StreamObserver<grpc.sbs.tempSetResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTempSetMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * interface exported by the server
   * </pre>
   */
  public static final class TempServiceBlockingStub extends io.grpc.stub.AbstractStub<TempServiceBlockingStub> {
    private TempServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TempServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TempServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TempServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends temperature reading request
     * </pre>
     */
    public java.util.Iterator<grpc.sbs.currentTemperature> tempReading(
        grpc.sbs.tempRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getTempReadingMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * interface exported by the server
   * </pre>
   */
  public static final class TempServiceFutureStub extends io.grpc.stub.AbstractStub<TempServiceFutureStub> {
    private TempServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TempServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TempServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TempServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_TEMP_READING = 0;
  private static final int METHODID_TEMP_SET = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TempServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TempServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TEMP_READING:
          serviceImpl.tempReading((grpc.sbs.tempRequest) request,
              (io.grpc.stub.StreamObserver<grpc.sbs.currentTemperature>) responseObserver);
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
        case METHODID_TEMP_SET:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.tempSet(
              (io.grpc.stub.StreamObserver<grpc.sbs.tempSetResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TempServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TempServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.sbs.SBSTempServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TempService");
    }
  }

  private static final class TempServiceFileDescriptorSupplier
      extends TempServiceBaseDescriptorSupplier {
    TempServiceFileDescriptorSupplier() {}
  }

  private static final class TempServiceMethodDescriptorSupplier
      extends TempServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TempServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TempServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TempServiceFileDescriptorSupplier())
              .addMethod(getTempReadingMethod())
              .addMethod(getTempSetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
