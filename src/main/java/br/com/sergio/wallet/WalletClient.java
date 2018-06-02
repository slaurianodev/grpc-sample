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
        int userId = 1;
        double value = 100.00;
        Currency currency = Currency.UNRECOGNIZED;

        for(int i=0; i < args.length; i++){
            if(Integer.parseInt(args[i]) == 0 ){
                userId = Integer.parseInt(args[0]);
            }
            if(args[1] != null){
                value = Double.parseDouble(args[1]);
            }
            if(args[2] != null){
                currency = Currency.forNumber(Integer.parseInt(args[2]));
            }
        }

        if(args.length > 0 && args.length <=3){


        }
        try{
            client.deposit(userId,value,currency);
        }finally {
            client.shutdown();
        }

    }

}
