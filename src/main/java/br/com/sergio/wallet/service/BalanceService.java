package br.com.sergio.wallet.service;

import br.com.sergio.wallet.*;
import br.com.sergio.wallet.dao.CurrenciesDAO;
import br.com.sergio.wallet.dao.UsersDAO;
import br.com.sergio.wallet.dao.WalletsDAO;
import br.com.sergio.wallet.model.Currencies;
import br.com.sergio.wallet.model.Users;
import br.com.sergio.wallet.model.Wallets;
import org.hibernate.Criteria;

import java.util.HashMap;
import java.util.List;

public class BalanceService implements IGenericService {

    private UsersDAO usersDAO;
    private CurrenciesDAO currenciesDAO;
    private WalletsDAO walletsDAO;
    private HashMap<String, Object> amounts;

    @Override
    public int doProcess(OperationInput request, BalanceInput balanceRequest, String process) {

        if (process.equals("balance")){
            initDAOs();
            return balance(balanceRequest);
        } else {
            return Response.UNRECOGNIZED.getNumber();
        }
    }

    private int balance(BalanceInput request){

        Users user = usersDAO.getById(request.getUserId());

        if(user != null){
            List<Wallets> wallets = walletsDAO.listByUser(user);

            initAmounts();
            for (Wallets w : wallets) {
                if (w.getCurrency().getCurrencyCode().equals(Currency.EUR.getValueDescriptor().getName())) {
                    amounts.put(Currency.EUR.getValueDescriptor().getName(),w.getAmount());
                }
                if (w.getCurrency().getCurrencyCode().equals(Currency.USD.getValueDescriptor().getName())) {
                    amounts.put(Currency.USD.getValueDescriptor().getName(),w.getAmount());
                }
                if (w.getCurrency().getCurrencyCode().equals(Currency.GBP.getValueDescriptor().getName())) {
                    amounts.put(Currency.GBP.getValueDescriptor().getName(),w.getAmount());
                }
            }
            closeSessions();
            return Response.OK_VALUE;
        } else {
            closeSessions();
            return Response.UNKNOWN_USER_VALUE;
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

    private void initAmounts(){
        amounts = new HashMap<String, Object>();
        List<Currencies> currencies = currenciesDAO.listAll();
        currencies.forEach(c -> amounts.put(c.getCurrencyCode(),0.00));
    }

    public HashMap<String, Object> getAmounts() {
        return amounts;
    }

    public void setAmounts(HashMap<String, Object> amounts) {
        this.amounts = amounts;
    }
}
