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
    comments = "Source: lighting.proto")
public final class LightingServiceGrpc {

  private LightingServiceGrpc() {}

  public static final String SERVICE_NAME = "lighting.LightingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.sbs.FloorsRequest,
      grpc.sbs.CompletedActionsResponse> getLightSwitchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lightSwitch",
      requestType = grpc.sbs.FloorsRequest.class,
      responseType = grpc.sbs.CompletedActionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.sbs.FloorsRequest,
      grpc.sbs.CompletedActionsResponse> getLightSwitchMethod() {
    io.grpc.MethodDescriptor<grpc.sbs.FloorsRequest, grpc.sbs.CompletedActionsResponse> getLightSwitchMethod;
    if ((getLightSwitchMethod = LightingServiceGrpc.getLightSwitchMethod) == null) {
      synchronized (LightingServiceGrpc.class) {
        if ((getLightSwitchMethod = LightingServiceGrpc.getLightSwitchMethod) == null) {
          LightingServiceGrpc.getLightSwitchMethod = getLightSwitchMethod = 
              io.grpc.MethodDescriptor.<grpc.sbs.FloorsRequest, grpc.sbs.CompletedActionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lighting.LightingService", "lightSwitch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.sbs.FloorsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.sbs.CompletedActionsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightingServiceMethodDescriptorSupplier("lightSwitch"))
                  .build();
          }
        }
     }
     return getLightSwitchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightingServiceStub newStub(io.grpc.Channel channel) {
    return new LightingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightingServiceFutureStub(channel);
  }

  /**
   * <pre>
   * interface exported by the server
   * </pre>
   */
  public static abstract class LightingServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends light switch on/off requests
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.sbs.FloorsRequest> lightSwitch(
        io.grpc.stub.StreamObserver<grpc.sbs.CompletedActionsResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getLightSwitchMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLightSwitchMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.sbs.FloorsRequest,
                grpc.sbs.CompletedActionsResponse>(
                  this, METHODID_LIGHT_SWITCH)))
          .build();
    }
  }

  /**
   * <pre>
   * interface exported by the server
   * </pre>
   */
  public static final class LightingServiceStub extends io.grpc.stub.AbstractStub<LightingServiceStub> {
    private LightingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends light switch on/off requests
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.sbs.FloorsRequest> lightSwitch(
        io.grpc.stub.StreamObserver<grpc.sbs.CompletedActionsResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getLightSwitchMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * interface exported by the server
   * </pre>
   */
  public static final class LightingServiceBlockingStub extends io.grpc.stub.AbstractStub<LightingServiceBlockingStub> {
    private LightingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * interface exported by the server
   * </pre>
   */
  public static final class LightingServiceFutureStub extends io.grpc.stub.AbstractStub<LightingServiceFutureStub> {
    private LightingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_LIGHT_SWITCH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIGHT_SWITCH:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.lightSwitch(
              (io.grpc.stub.StreamObserver<grpc.sbs.CompletedActionsResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.sbs.SBSLighServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightingService");
    }
  }

  private static final class LightingServiceFileDescriptorSupplier
      extends LightingServiceBaseDescriptorSupplier {
    LightingServiceFileDescriptorSupplier() {}
  }

  private static final class LightingServiceMethodDescriptorSupplier
      extends LightingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightingServiceFileDescriptorSupplier())
              .addMethod(getLightSwitchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
