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
        try{
            OperationInput input = OperationInput.newBuilder().setUserId(userId).setAmount(value).setCurrency(currency).build();
            OperationOutput output = blockingStub.deposit(input);
            logger.info("Response: " + output.getResponseValue());
        }catch(RuntimeException e){
            logger.log(Level.WARNING,"Request to grpc server failed",e);
        }

    }

    public void withdraw(int userId, double value, Currency currency){
        try{
            OperationInput input = OperationInput.newBuilder().setUserId(userId).setAmount(value).setCurrency(currency).build();
            OperationOutput output = blockingStub.withdraw(input);
            logger.info("Response: " + output.getResponseValue());
        }catch(RuntimeException e){
            logger.log(Level.WARNING,"Request to grpc server failed",e);
        }

    }

    public void balance (int userId){
        try{
            BalanceInput input = BalanceInput.newBuilder().setUserId(userId).build();
            BalanceOutput output = blockingStub.balance(input);
            logger.info(String.format("Response: %s EUR: %10.2f USD: %10.2f GBP: %10.2f" ,  output.getResponseValue(), output.getEur() , output.getUsd() , output.getGbp()));
        }catch(RuntimeException e){
            logger.log(Level.WARNING,"Request to grpc server failed",e);
        }
    }

    public static void main(String[] args) throws Exception{
        WalletClient client = new WalletClient("localhost",4242);

        try{
            int op = Integer.parseInt(args[0]);
            String checkOperation = operation(op);
            if(checkOperation.equals("deposit")){
                int userId = Integer.parseInt(args[1]);
                double value = Double.parseDouble(args[2]);
                Currency currency =  Currency.forNumber(Integer.parseInt(args[3])) != null ? Currency.forNumber(Integer.parseInt(args[3])) : Currency.UNRECOGNIZED;
                client.deposit(userId,value,currency);
            } else if(checkOperation.equals("withdraw")){
                int userId = Integer.parseInt(args[1]);
                double value = Double.parseDouble(args[2]);
                Currency currency =  Currency.forNumber(Integer.parseInt(args[3])) != null ? Currency.forNumber(Integer.parseInt(args[3])) : Currency.UNRECOGNIZED;
                client.withdraw(userId,value,currency);
            } else if(checkOperation.equals("balance")){
                int userId = Integer.parseInt(args[1]);
                client.balance(userId);
            }

        }finally {
            client.shutdown();
        }

    }

    private static String operation(int op){
        String operation = "";
        switch (op){
            case 1:
                operation = "deposit";
                break;
            case 2:
                operation = "withdraw";
                break;
            case 3:
                operation = "balance";
                break;
        }
        return operation;
    }

}
