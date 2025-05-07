package server;

import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import shop.ProductUserGrpc;
import shop.ProductUserOuterClass;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductUserImpl extends ProductUserGrpc.ProductUserImplBase {

    private final Map<Integer, ProductUserOuterClass.User> userMap = new HashMap<>();

    private final Map<Integer, ProductUserOuterClass.Product> productMap = new HashMap<>();

    private final Map<Integer, List<Integer>> userCart = new HashMap<>();


    @Override
    public void createUser(
            ProductUserOuterClass.NewUser request,
            StreamObserver<ProductUserOuterClass.UserID> responseObserver
    ) {
        int newId = userMap.size() + 1;
        ProductUserOuterClass.User user = ProductUserOuterClass.User
                .newBuilder()
                .setId(newId)
                .setEmail(request.getEmail())
                .setUsername(request.getUsername())
                .build();
        userMap.put(newId, user);

        ProductUserOuterClass.UserID userID = ProductUserOuterClass.UserID
                .newBuilder()
                .setValue(newId)
                .build();

        responseObserver.onNext(userID);
        responseObserver.onCompleted();
    }

    @Override
    public void changeUserEmail(
            ProductUserOuterClass.UpdateUserMail request,
            StreamObserver<ProductUserOuterClass.Empty> responseObserver
    ) {
        if (userMap.containsKey(request.getId())) {
            userMap.get(request.getId()).toBuilder().setEmail(request.getEmail()).build();
            responseObserver.onNext(ProductUserOuterClass.Empty.getDefaultInstance());
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }
    }

    @Override
    public void changeUserName(
            ProductUserOuterClass.UpdateUserName request,
            StreamObserver<ProductUserOuterClass.Empty> responseObserver
    ) {
        if (userMap.containsKey(request.getId())) {
            userMap.get(request.getId()).toBuilder().setEmail(request.getName()).build();
            responseObserver.onNext(ProductUserOuterClass.Empty.getDefaultInstance());
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }
    }

    @Override
    public void createProduct(
            ProductUserOuterClass.ProductName request,
            StreamObserver<ProductUserOuterClass.ProductID> responseObserver
    ) {
        int newId = productMap.size() + 1;
        ProductUserOuterClass.Product newProduct = ProductUserOuterClass.Product
                .newBuilder()
                .setId(newId)
                .setName(request.getValue())
                .build();
        productMap.put(newId, newProduct);

        ProductUserOuterClass.ProductID productID = ProductUserOuterClass.ProductID
                .newBuilder()
                .setValue(newId)
                .build();

        responseObserver.onNext(productID);
        responseObserver.onCompleted();

    }

    @Override
    public void addProductToCart(
            ProductUserOuterClass.UserProduct request,
            StreamObserver<ProductUserOuterClass.Empty> responseObserver
    ) {
        int userId = request.getUserId();
        int productId = request.getProductId();
        if (userMap.containsKey(userId) && productMap.containsKey(productId)) {
            if (!userCart.containsKey(userId)) {
                userCart.put(userId, Collections.emptyList());
            }
            userCart.get(userId).add(productId);
            responseObserver.onNext(ProductUserOuterClass.Empty.getDefaultInstance());
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }
    }
}
