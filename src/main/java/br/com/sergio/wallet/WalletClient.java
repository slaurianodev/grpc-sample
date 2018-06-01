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

    public void deposit(int userId, double value, Currency currency){
        logger.info("Trying to deposit " + value + " on currency " + currency.getValueDescriptor());
        try{
            OperationInput input = OperationInput.newBuilder().setUserId(userId).setAmount(value).setCurrency(currency).build();
            OperationOutput output = blockingStub.deposit(input);
            logger.info("Response: " + output.getResponseValue());
        }catch(RuntimeException e){
            logger.log(Level.WARNING,"Request to grpc server failed",e);
        }

    }

    public static void main(String[] args) throws Exception{
        WalletClient client = new WalletClient("localhost",4242);
        logger.info(String.format("args passed: %s %s %s", args[0],args[1],args[2] ));
        int userId = args.length > 0 ? Integer.parseInt(args[0]) : 1;
        double value = args.length > 0 ? Double.parseDouble(args[1]) : 100.00;

        Currency currency = args.length > 0 ? Currency.forNumber(Integer.parseInt(args[2])) : Currency.UNRECOGNIZED;

        try{
            client.deposit(userId,value,currency);
        }finally {
            client.shutdown();
        }

    }

}
