package com.tyeporter.banktransfer.bankaccount;

public class InvalidAmountException extends Exception {

    public InvalidAmountException(double amount) {
        super("Tried to make transaction with invalid amount: " + amount);
    }
    
}
