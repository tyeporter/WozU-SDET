package com.tyeporter.banktransfer.bankaccount;

public class AccountOverdraftException extends Exception {

    public AccountOverdraftException(double accountBalance, double amount) {
        super("Overdraft protection not supported. Account holder tried to withdraw " + amount + " with a balance of " + accountBalance);
    }
    
}
