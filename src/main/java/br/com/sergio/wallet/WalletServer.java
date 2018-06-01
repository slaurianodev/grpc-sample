package br.com.sergio.wallet;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.logging.Logger;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

public class WalletServer {
    private static final Logger logger = Logger.getLogger(WalletServer.class.getName());

    private int port = 4242;

    private Server server;

    private void start() throws Exception {
        logger.info("Starting the grpc server");

        server = ServerBuilder.forPort(port)
                .addService(new OperationsGrpcImpl())
                .build()
                .start();

        logger.info("Server started. Listening on port: " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** JVM is shutting down. Turning off grpc server as well ***");
            WalletServer.this.stop();
            System.err.println("*** shutdown complete ***");
        }));
    }

    private void stop(){
        if(server != null){
            server.shutdown();
        }
    }

    public static void main(String[] args) throws Exception {
        logger.info("Server startup. Args = " + Arrays.toString(args));
        final WalletServer walletServer = new WalletServer();

        walletServer.start();
        walletServer.blockUntilShutdown();
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private class OperationsGrpcImpl extends OperationsGrpc.OperationsImplBase {
        @Override
        public void deposit(OperationInput request,StreamObserver<OperationOutput> responseObserver) {
            OperationOutput output = OperationOutput.newBuilder().setResponse(Response.valueOf(request.getCurrency().getNumber())).build();
            responseObserver.onNext(output);
            responseObserver.onCompleted();
        }

        @Override
        public void withdraw(OperationInput request, StreamObserver<OperationOutput> responseObserver) {
            asyncUnimplementedUnaryCall(OperationsGrpc.getWithdrawMethod(), responseObserver);
        }

        @Override
        public void balance(BalanceInput request,StreamObserver<BalanceOutput> responseObserver) {
            asyncUnimplementedUnaryCall(OperationsGrpc.getBalanceMethod(), responseObserver);
        }

    }

}
