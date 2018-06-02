package br.com.sergio.wallet;



import br.com.sergio.wallet.model.Currencies;
import br.com.sergio.wallet.model.Users;
import br.com.sergio.wallet.model.Wallets;
import br.com.sergio.wallet.service.GenericServiceImpl;
import br.com.sergio.wallet.service.IGenericService;
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
import java.util.Map;
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
            logger.info("Currency: " + request.getCurrency());
            int response = 0;
            Currency currency = request.getCurrency();

            if(currency.UNRECOGNIZED.equals(currency)){
                response = Response.UNRECOGNIZED.getNumber();
            }else {
                response = Response.OK_VALUE;
            }

            IGenericService<Users> userService = new GenericServiceImpl<Users>(Users.class,HibernateUtil.getSessionFactory());
            IGenericService<Currencies> currencyService = new GenericServiceImpl<Currencies>(Currencies.class,HibernateUtil.getSessionFactory());
            IGenericService<Wallets> walletService = new GenericServiceImpl<Wallets>(Wallets.class,HibernateUtil.getSessionFactory());

            Users user = userService.get(Users.class,request.getUserId());
            Currencies cur = currencyService.get(Currencies.class,request.getCurrency().getNumber());

            HashMap<String, Object> params = new HashMap<String,Object>();
            params.put("uId",user.getUserId());
            params.put("cId",cur.getCurrencyId());

            List<Wallets> wallet = walletService.query("select w from Wallets w inner join Users u on u.userId=w.userId " +
                    "inner join Currency c on c.currencyId=w.currencyId where u.userId = :uId and c.currencyId = :cId",params);


            logger.info(String.format("User: %s, Currency: %s, Amount: %s", wallet.get(0).getUser().getUserName(),
                    wallet.get(0).getCurrency().getCurrencyCode(), wallet.get(0).getAmount()));

            OperationOutput output = OperationOutput.newBuilder().setResponse(Response.forNumber(response)).build();
            logger.info("Output: "+output.toString());
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
