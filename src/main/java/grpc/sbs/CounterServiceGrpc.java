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
    comments = "Source: occupancy.proto")
public final class CounterServiceGrpc {

  private CounterServiceGrpc() {}

  public static final String SERVICE_NAME = "occupancy.CounterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.sbs.OccupancyRequest,
      grpc.sbs.OccupancyResponse> getOccupancyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "occupancy",
      requestType = grpc.sbs.OccupancyRequest.class,
      responseType = grpc.sbs.OccupancyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.sbs.OccupancyRequest,
      grpc.sbs.OccupancyResponse> getOccupancyMethod() {
    io.grpc.MethodDescriptor<grpc.sbs.OccupancyRequest, grpc.sbs.OccupancyResponse> getOccupancyMethod;
    if ((getOccupancyMethod = CounterServiceGrpc.getOccupancyMethod) == null) {
      synchronized (CounterServiceGrpc.class) {
        if ((getOccupancyMethod = CounterServiceGrpc.getOccupancyMethod) == null) {
          CounterServiceGrpc.getOccupancyMethod = getOccupancyMethod = 
              io.grpc.MethodDescriptor.<grpc.sbs.OccupancyRequest, grpc.sbs.OccupancyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "occupancy.CounterService", "occupancy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.sbs.OccupancyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.sbs.OccupancyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CounterServiceMethodDescriptorSupplier("occupancy"))
                  .build();
          }
        }
     }
     return getOccupancyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CounterServiceStub newStub(io.grpc.Channel channel) {
    return new CounterServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CounterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CounterServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CounterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CounterServiceFutureStub(channel);
  }

  /**
   * <pre>
   * interface exported by the server
   * </pre>
   */
  public static abstract class CounterServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends occupancy request
     * </pre>
     */
    public void occupancy(grpc.sbs.OccupancyRequest request,
        io.grpc.stub.StreamObserver<grpc.sbs.OccupancyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOccupancyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOccupancyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.sbs.OccupancyRequest,
                grpc.sbs.OccupancyResponse>(
                  this, METHODID_OCCUPANCY)))
          .build();
    }
  }

  /**
   * <pre>
   * interface exported by the server
   * </pre>
   */
  public static final class CounterServiceStub extends io.grpc.stub.AbstractStub<CounterServiceStub> {
    private CounterServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CounterServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CounterServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CounterServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends occupancy request
     * </pre>
     */
    public void occupancy(grpc.sbs.OccupancyRequest request,
        io.grpc.stub.StreamObserver<grpc.sbs.OccupancyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOccupancyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * interface exported by the server
   * </pre>
   */
  public static final class CounterServiceBlockingStub extends io.grpc.stub.AbstractStub<CounterServiceBlockingStub> {
    private CounterServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CounterServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CounterServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CounterServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends occupancy request
     * </pre>
     */
    public grpc.sbs.OccupancyResponse occupancy(grpc.sbs.OccupancyRequest request) {
      return blockingUnaryCall(
          getChannel(), getOccupancyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * interface exported by the server
   * </pre>
   */
  public static final class CounterServiceFutureStub extends io.grpc.stub.AbstractStub<CounterServiceFutureStub> {
    private CounterServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CounterServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CounterServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CounterServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends occupancy request
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.sbs.OccupancyResponse> occupancy(
        grpc.sbs.OccupancyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getOccupancyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_OCCUPANCY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CounterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CounterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OCCUPANCY:
          serviceImpl.occupancy((grpc.sbs.OccupancyRequest) request,
              (io.grpc.stub.StreamObserver<grpc.sbs.OccupancyResponse>) responseObserver);
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

  private static abstract class CounterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CounterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.sbs.SBSOccupServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CounterService");
    }
  }

  private static final class CounterServiceFileDescriptorSupplier
      extends CounterServiceBaseDescriptorSupplier {
    CounterServiceFileDescriptorSupplier() {}
  }

  private static final class CounterServiceMethodDescriptorSupplier
      extends CounterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CounterServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CounterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CounterServiceFileDescriptorSupplier())
              .addMethod(getOccupancyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
