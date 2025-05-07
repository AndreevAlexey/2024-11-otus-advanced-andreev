package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import shop.ProductUserGrpc;
import shop.ProductUserOuterClass;

import java.util.logging.Logger;

public class ProductUserClient {

    private static final Logger logger = Logger.getLogger(ProductUserClient.class.getName());


    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        ProductUserGrpc.ProductUserBlockingStub stub = ProductUserGrpc.newBlockingStub(channel);

        ProductUserOuterClass.NewUser newUser = ProductUserOuterClass.NewUser
                .newBuilder()
                .setUsername("otus")
                .setEmail("otus@mail.ru")
                .build();

        ProductUserOuterClass.UserID userID = stub.createUser(newUser);
        logger.info("User ID: " + userID.getValue() + " added successfully.");

        channel.shutdown();
    }
}
