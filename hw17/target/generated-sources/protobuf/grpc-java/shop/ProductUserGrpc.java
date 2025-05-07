package shop;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: product_user.proto")
public final class ProductUserGrpc {

  private ProductUserGrpc() {}

  public static final String SERVICE_NAME = "shop.ProductUser";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<shop.ProductUserOuterClass.NewUser,
      shop.ProductUserOuterClass.UserID> METHOD_CREATE_USER =
      io.grpc.MethodDescriptor.<shop.ProductUserOuterClass.NewUser, shop.ProductUserOuterClass.UserID>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "shop.ProductUser", "createUser"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              shop.ProductUserOuterClass.NewUser.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              shop.ProductUserOuterClass.UserID.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<shop.ProductUserOuterClass.UpdateUserMail,
      shop.ProductUserOuterClass.Empty> METHOD_CHANGE_USER_EMAIL =
      io.grpc.MethodDescriptor.<shop.ProductUserOuterClass.UpdateUserMail, shop.ProductUserOuterClass.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "shop.ProductUser", "changeUserEmail"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              shop.ProductUserOuterClass.UpdateUserMail.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              shop.ProductUserOuterClass.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<shop.ProductUserOuterClass.UpdateUserName,
      shop.ProductUserOuterClass.Empty> METHOD_CHANGE_USER_NAME =
      io.grpc.MethodDescriptor.<shop.ProductUserOuterClass.UpdateUserName, shop.ProductUserOuterClass.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "shop.ProductUser", "changeUserName"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              shop.ProductUserOuterClass.UpdateUserName.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              shop.ProductUserOuterClass.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<shop.ProductUserOuterClass.ProductName,
      shop.ProductUserOuterClass.ProductID> METHOD_CREATE_PRODUCT =
      io.grpc.MethodDescriptor.<shop.ProductUserOuterClass.ProductName, shop.ProductUserOuterClass.ProductID>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "shop.ProductUser", "createProduct"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              shop.ProductUserOuterClass.ProductName.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              shop.ProductUserOuterClass.ProductID.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<shop.ProductUserOuterClass.UserProduct,
      shop.ProductUserOuterClass.Empty> METHOD_ADD_PRODUCT_TO_CART =
      io.grpc.MethodDescriptor.<shop.ProductUserOuterClass.UserProduct, shop.ProductUserOuterClass.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "shop.ProductUser", "addProductToCart"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              shop.ProductUserOuterClass.UserProduct.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              shop.ProductUserOuterClass.Empty.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductUserStub newStub(io.grpc.Channel channel) {
    return new ProductUserStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductUserBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProductUserBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductUserFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProductUserFutureStub(channel);
  }

  /**
   */
  public static abstract class ProductUserImplBase implements io.grpc.BindableService {

    /**
     */
    public void createUser(shop.ProductUserOuterClass.NewUser request,
        io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.UserID> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_USER, responseObserver);
    }

    /**
     */
    public void changeUserEmail(shop.ProductUserOuterClass.UpdateUserMail request,
        io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_USER_EMAIL, responseObserver);
    }

    /**
     */
    public void changeUserName(shop.ProductUserOuterClass.UpdateUserName request,
        io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHANGE_USER_NAME, responseObserver);
    }

    /**
     */
    public void createProduct(shop.ProductUserOuterClass.ProductName request,
        io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.ProductID> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_PRODUCT, responseObserver);
    }

    /**
     */
    public void addProductToCart(shop.ProductUserOuterClass.UserProduct request,
        io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_PRODUCT_TO_CART, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_USER,
            asyncUnaryCall(
              new MethodHandlers<
                shop.ProductUserOuterClass.NewUser,
                shop.ProductUserOuterClass.UserID>(
                  this, METHODID_CREATE_USER)))
          .addMethod(
            METHOD_CHANGE_USER_EMAIL,
            asyncUnaryCall(
              new MethodHandlers<
                shop.ProductUserOuterClass.UpdateUserMail,
                shop.ProductUserOuterClass.Empty>(
                  this, METHODID_CHANGE_USER_EMAIL)))
          .addMethod(
            METHOD_CHANGE_USER_NAME,
            asyncUnaryCall(
              new MethodHandlers<
                shop.ProductUserOuterClass.UpdateUserName,
                shop.ProductUserOuterClass.Empty>(
                  this, METHODID_CHANGE_USER_NAME)))
          .addMethod(
            METHOD_CREATE_PRODUCT,
            asyncUnaryCall(
              new MethodHandlers<
                shop.ProductUserOuterClass.ProductName,
                shop.ProductUserOuterClass.ProductID>(
                  this, METHODID_CREATE_PRODUCT)))
          .addMethod(
            METHOD_ADD_PRODUCT_TO_CART,
            asyncUnaryCall(
              new MethodHandlers<
                shop.ProductUserOuterClass.UserProduct,
                shop.ProductUserOuterClass.Empty>(
                  this, METHODID_ADD_PRODUCT_TO_CART)))
          .build();
    }
  }

  /**
   */
  public static final class ProductUserStub extends io.grpc.stub.AbstractStub<ProductUserStub> {
    private ProductUserStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductUserStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductUserStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductUserStub(channel, callOptions);
    }

    /**
     */
    public void createUser(shop.ProductUserOuterClass.NewUser request,
        io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.UserID> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_USER, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeUserEmail(shop.ProductUserOuterClass.UpdateUserMail request,
        io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_USER_EMAIL, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changeUserName(shop.ProductUserOuterClass.UpdateUserName request,
        io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHANGE_USER_NAME, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createProduct(shop.ProductUserOuterClass.ProductName request,
        io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.ProductID> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_PRODUCT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addProductToCart(shop.ProductUserOuterClass.UserProduct request,
        io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_PRODUCT_TO_CART, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductUserBlockingStub extends io.grpc.stub.AbstractStub<ProductUserBlockingStub> {
    private ProductUserBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductUserBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductUserBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductUserBlockingStub(channel, callOptions);
    }

    /**
     */
    public shop.ProductUserOuterClass.UserID createUser(shop.ProductUserOuterClass.NewUser request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_USER, getCallOptions(), request);
    }

    /**
     */
    public shop.ProductUserOuterClass.Empty changeUserEmail(shop.ProductUserOuterClass.UpdateUserMail request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHANGE_USER_EMAIL, getCallOptions(), request);
    }

    /**
     */
    public shop.ProductUserOuterClass.Empty changeUserName(shop.ProductUserOuterClass.UpdateUserName request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHANGE_USER_NAME, getCallOptions(), request);
    }

    /**
     */
    public shop.ProductUserOuterClass.ProductID createProduct(shop.ProductUserOuterClass.ProductName request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_PRODUCT, getCallOptions(), request);
    }

    /**
     */
    public shop.ProductUserOuterClass.Empty addProductToCart(shop.ProductUserOuterClass.UserProduct request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_PRODUCT_TO_CART, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductUserFutureStub extends io.grpc.stub.AbstractStub<ProductUserFutureStub> {
    private ProductUserFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductUserFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductUserFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductUserFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<shop.ProductUserOuterClass.UserID> createUser(
        shop.ProductUserOuterClass.NewUser request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_USER, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<shop.ProductUserOuterClass.Empty> changeUserEmail(
        shop.ProductUserOuterClass.UpdateUserMail request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_USER_EMAIL, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<shop.ProductUserOuterClass.Empty> changeUserName(
        shop.ProductUserOuterClass.UpdateUserName request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHANGE_USER_NAME, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<shop.ProductUserOuterClass.ProductID> createProduct(
        shop.ProductUserOuterClass.ProductName request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_PRODUCT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<shop.ProductUserOuterClass.Empty> addProductToCart(
        shop.ProductUserOuterClass.UserProduct request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_PRODUCT_TO_CART, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_CHANGE_USER_EMAIL = 1;
  private static final int METHODID_CHANGE_USER_NAME = 2;
  private static final int METHODID_CREATE_PRODUCT = 3;
  private static final int METHODID_ADD_PRODUCT_TO_CART = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductUserImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductUserImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_USER:
          serviceImpl.createUser((shop.ProductUserOuterClass.NewUser) request,
              (io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.UserID>) responseObserver);
          break;
        case METHODID_CHANGE_USER_EMAIL:
          serviceImpl.changeUserEmail((shop.ProductUserOuterClass.UpdateUserMail) request,
              (io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.Empty>) responseObserver);
          break;
        case METHODID_CHANGE_USER_NAME:
          serviceImpl.changeUserName((shop.ProductUserOuterClass.UpdateUserName) request,
              (io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.Empty>) responseObserver);
          break;
        case METHODID_CREATE_PRODUCT:
          serviceImpl.createProduct((shop.ProductUserOuterClass.ProductName) request,
              (io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.ProductID>) responseObserver);
          break;
        case METHODID_ADD_PRODUCT_TO_CART:
          serviceImpl.addProductToCart((shop.ProductUserOuterClass.UserProduct) request,
              (io.grpc.stub.StreamObserver<shop.ProductUserOuterClass.Empty>) responseObserver);
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

  private static final class ProductUserDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return shop.ProductUserOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProductUserGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductUserDescriptorSupplier())
              .addMethod(METHOD_CREATE_USER)
              .addMethod(METHOD_CHANGE_USER_EMAIL)
              .addMethod(METHOD_CHANGE_USER_NAME)
              .addMethod(METHOD_CREATE_PRODUCT)
              .addMethod(METHOD_ADD_PRODUCT_TO_CART)
              .build();
        }
      }
    }
    return result;
  }
}
