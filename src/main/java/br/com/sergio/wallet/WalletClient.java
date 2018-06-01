package br.com.sergio.wallet;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WalletClient {
    private static final Logger logger = Logger.getLogger(WalletClient.class.getName());

    private final ManagedChannel channel;
    private OperationsGrpc.OperationsBlockingStub blockingStub;

    public WalletClient(String hostname, int port){
        channel = ManagedChannelBuilder.forAddress(hostname,port)
                .usePlaintext(true)
                .build();
        blockingStub = OperationsGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException{
        channel.shutdown().awaitTermination(5,TimeUnit.SECONDS);
    }

    public void deposit(double value, Currency currency){
        logger.info("Trying to deposit" + value);
        try{
            OperationInput input = OperationInput.newBuilder().setAmount(value).setCurrency(currency).build();
            OperationOutput output = blockingStub.deposit(input);
            logger.info("Response: " + output.getResponseValue());
        }catch(RuntimeException e){
            logger.log(Level.WARNING,"Request to grpc server failed",e);
        }

    }

    public static void main(String[] args) throws Exception{
        WalletClient client = new WalletClient("localhost",4242);
        double value = args.length > 0 ? Double.parseDouble(args[0]) : 100.00;
        Currency currency = args.length > 0 ? Currency.valueOf(args[1]) : Currency.EUR;

        try{
            client.deposit(value,currency);
        }finally {
            client.shutdown();
        }

    }

}
