package com.tyeporter.banktransfer.bankaccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class BankAccount {
    private double balance;
    private String accountId;
    private ArrayList<HashMap<String, String>> transactions;

    // =========================================================
    // Constructors
    // =========================================================

    public BankAccount() {
        this.balance = 0.0;
        this.accountId = UUID.randomUUID().toString();
        this.transactions = new ArrayList<>();
    }

    public BankAccount(double balance) {
        this.balance = balance;
        this.accountId = UUID.randomUUID().toString();
        this.transactions = new ArrayList<>();
    }

    // =========================================================
    // Public
    // =========================================================

    public double getBalance() {
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public ArrayList<HashMap<String, String>> getTransactions() {
        return transactions;
    }

    public boolean deposit(double amount) throws Exception {
        if (amount < 0) { throw new InvalidAmountException(amount); }
        else if (amount == 0) { throw new ZeroAmountException(); }

        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) throws Exception {
        if (amount < 0) { throw new InvalidAmountException(amount); } 
        else if (amount == 0) { throw new ZeroAmountException(); }
        else if (amount > this.balance) { throw new AccountOverdraftException(this.balance, amount); }

        this.balance -= amount;
        return true;
    }

    public boolean pay(double amount, BankAccount toBankAccount) throws Exception {
        if (amount < 0) { throw new InvalidAmountException(amount); } 
        else if (amount == 0) { throw new ZeroAmountException(); }
        else if (amount > this.balance) { throw new AccountOverdraftException(this.balance, amount); }

        BankTransaction newTransaction = new BankTransaction(this.accountId, toBankAccount.accountId, amount);
        this.withdraw(amount);
        toBankAccount.deposit(amount);

        HashMap<String, String> receipt = newTransaction.confirmTransaction();

        this.transactions.add(receipt);
        toBankAccount.transactions.add(receipt);

        return true;
    }
    
}
