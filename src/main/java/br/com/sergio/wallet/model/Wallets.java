package br.com.sergio.wallet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wallets")
public class Wallets {
    @Id
    @Column(name="wallet_id")
    private int walletId;
    @Column(name="user_id")
    private Users user;
    @Column(name="amount")
    private double amount;
    @Column(name="currency_id")
    private Currencies currency;

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public void setCurrency(Currencies currency) {
        this.currency = currency;
    }
}
