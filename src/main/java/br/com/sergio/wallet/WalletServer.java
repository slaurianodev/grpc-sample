package br.com.sergio.wallet;



import br.com.sergio.wallet.dao.CurrenciesDAO;
import br.com.sergio.wallet.dao.UsersDAO;
import br.com.sergio.wallet.dao.WalletsDAO;
import br.com.sergio.wallet.model.Currencies;
import br.com.sergio.wallet.model.Users;
import br.com.sergio.wallet.model.Wallets;
import br.com.sergio.wallet.service.BalanceService;
import br.com.sergio.wallet.service.DepositService;
import br.com.sergio.wallet.service.WithdrawService;
import br.com.sergio.wallet.util.Amounts;
import br.com.sergio.wallet.util.HibernateUtil;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
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
            DepositService depositService = new DepositService();
            int result = depositService.doProcess(request,null,"deposit");

            OperationOutput output = OperationOutput.newBuilder().setResponse(Response.forNumber(result)).build();
            responseObserver.onNext(output);
            responseObserver.onCompleted();
        }

        @Override
        public void withdraw(OperationInput request, StreamObserver<OperationOutput> responseObserver) {
            WithdrawService withdrawService = new WithdrawService();
            int result = withdrawService.doProcess(request,null,"withdraw");

            OperationOutput output = OperationOutput.newBuilder().setResponse(Response.forNumber(result)).build();
            responseObserver.onNext(output);
            responseObserver.onCompleted();
        }

        @Override
        public void balance(BalanceInput request,StreamObserver<BalanceOutput> responseObserver) {
            BalanceService balanceService = new BalanceService();
            int result = balanceService.doProcess(null,request,"balance");
            double amountEur = (double) balanceService.getAmounts().get(Currency.EUR.getValueDescriptor().getName());
            double amountUsd =(double) balanceService.getAmounts().get(Currency.USD.getValueDescriptor().getName());
            double amountGbp =(double) balanceService.getAmounts().get(Currency.GBP.getValueDescriptor().getName());

            BalanceOutput output = BalanceOutput.newBuilder().setResponseValue(result).setEur(amountEur).setUsd(amountUsd).setGbp(amountGbp).build();
            responseObserver.onNext(output);
            responseObserver.onCompleted();
        }

    }

}
