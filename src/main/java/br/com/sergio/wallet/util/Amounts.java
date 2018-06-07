package br.com.sergio.wallet.util;

import br.com.sergio.wallet.Currency;
import br.com.sergio.wallet.model.Wallets;

import java.util.List;

public class Amounts {

    public double setAmount(Wallets w, String filter){
        double amount = 0.00;

        if (w.getCurrency().getCurrencyCode().equals(filter)) {
            amount =  w.getAmount();
        }
        return amount;
    }
}
