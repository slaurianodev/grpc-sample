package br.com.sergio.wallet.service;

import br.com.sergio.wallet.BalanceInput;
import br.com.sergio.wallet.BalanceOutput;
import br.com.sergio.wallet.OperationInput;

import java.io.Serializable;

public interface IGenericService <T extends Serializable>{
    public int doProcess(OperationInput operationRequest, BalanceInput balanceRequest, String process);
    public void initDAOs();
    public void closeSessions();
}
