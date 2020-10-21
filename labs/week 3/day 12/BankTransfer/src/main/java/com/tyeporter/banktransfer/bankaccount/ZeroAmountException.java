package com.tyeporter.banktransfer.bankaccount;

public class ZeroAmountException extends Exception {

    public ZeroAmountException() {
        super("Please put in an amount over zero.");
    }
    
}
