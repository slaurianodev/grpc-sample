package br.com.sergio.wallet.service;

import br.com.sergio.wallet.BalanceInput;
import br.com.sergio.wallet.OperationInput;
import br.com.sergio.wallet.OperationOutput;
import br.com.sergio.wallet.Response;
import br.com.sergio.wallet.dao.CurrenciesDAO;
import br.com.sergio.wallet.dao.UsersDAO;
import br.com.sergio.wallet.dao.WalletsDAO;
import br.com.sergio.wallet.model.Currencies;
import br.com.sergio.wallet.model.Users;
import br.com.sergio.wallet.model.Wallets;

import java.util.HashMap;

public class WithdrawService implements IGenericService {

    private UsersDAO usersDAO;
    private CurrenciesDAO currenciesDAO;
    private WalletsDAO walletsDAO;


    @Override
    public int doProcess(OperationInput operationRequest, BalanceInput balanceRequest, String process) {

        if (process.equals("withdraw")){
            initDAOs();
            return withdraw(operationRequest);
        } else {
            return Response.UNRECOGNIZED.getNumber();
        }
    }

    private int withdraw(OperationInput request){

        Users user = usersDAO.getById(request.getUserId());
        if(user == null){
            closeSessions();
            return Response.UNKNOWN_USER_VALUE;
        }
        Currencies currency = currenciesDAO.getByCurrencyCode(request.getCurrency().getValueDescriptor().getName());
        if(currency == null){
            closeSessions();
            return Response.UNKNOWN_CURRENCY_VALUE;
        }
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("userId",user.getUserId());
        params.put("currencyId", currency.getCurrencyId());
        Wallets wallet = walletsDAO.getByUserAndCurrency(params);

        if(wallet != null){
            if(wallet.getAmount() < request.getAmount()){
                closeSessions();
                return Response.INSUFFICIENT_FUNDS_VALUE;
            } else {
                wallet.setAmount(wallet.getAmount() - request.getAmount());
                walletsDAO.saveOrUpdate(wallet);
                closeSessions();
                return Response.OK_VALUE;
            }
        } else {
            closeSessions();
            return Response.INSUFFICIENT_FUNDS_VALUE;
        }
    }

    @Override
    public void initDAOs() {
        usersDAO = new UsersDAO();
        usersDAO.initDAOSession();
        currenciesDAO = new CurrenciesDAO();
        currenciesDAO.initDAOSession();
        walletsDAO = new WalletsDAO();
        walletsDAO.initDAOSession();
    }

    @Override
    public void closeSessions() {
        usersDAO.closeSession();
        currenciesDAO.closeSession();
        walletsDAO.closeSession();
    }
}
