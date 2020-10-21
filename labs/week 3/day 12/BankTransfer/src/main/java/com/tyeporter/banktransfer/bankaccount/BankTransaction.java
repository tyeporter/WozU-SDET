package com.tyeporter.banktransfer.bankaccount;

import java.util.HashMap;

public class BankTransaction {
    private String payer;
    private String payee;
    private double transactionAmount;

    // =========================================================
    // Constructors
    // =========================================================

    public BankTransaction(String payer, String payee, double transactionAmount) {
        this.payer = payer;
        this.payee = payee;
        this.transactionAmount = transactionAmount;
    }

    // =========================================================
    // Public
    // =========================================================

    public String getPayer() {
        return payer;
    }

    public String getPayee() {
        return payee;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }
    
    public HashMap<String, String> confirmTransaction() {
        HashMap<String, String> reciept = new HashMap<>();

        reciept.put("payer", this.payer);
        reciept.put("payee", this.payee);
        reciept.put("amount", String.valueOf(this.transactionAmount));

        return reciept;
    }
    
}
