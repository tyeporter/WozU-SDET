package com.tyeporter.banktransfer.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTransactionTest {
    BankTransaction transaction;

    @BeforeEach
    public void setUp() {
        String sayeedsAccount = UUID.randomUUID().toString();
        String lionelsAccount = UUID.randomUUID().toString();

        this.transaction = new BankTransaction(sayeedsAccount, lionelsAccount, 25.0);
    }

    // =========================================================
    // Initialization
    // =========================================================

    @Test
    public void testInit_HasPayer() {
        String payer = this.transaction.getPayer();

        assertFalse(payer.isEmpty());
    }

    @Test
    public void testInit_HasPayee() {
        String payee = this.transaction.getPayee();

        assertFalse(payee.isEmpty());
    }

    @Test
    public void testInit_HasTransactionAmount() {
        double transactionAmount = this.transaction.getTransactionAmount();

        assertTrue(transactionAmount >= 0);
    }

    // =========================================================
    // Transaction Reciept
    // =========================================================

    @Test
    public void testConfirmTransaction_ReturnsHashMap() {
        Class expected = HashMap.class;
        Class actual = this.transaction.confirmTransaction().getClass();

        assertEquals(expected, actual);
    }

    @Test
    public void testConfirmTransaction_ReturnsHashMap_WithThreeMappings() {
        int expected = 3;
        int actual = this.transaction.confirmTransaction().size();

        assertEquals(expected, actual);
    }

    @Test
    public void testConfirmTransaction_ReturnsHashMap_WithPayerKey() {
        Set<String> keys = this.transaction.confirmTransaction().keySet();

        assertTrue(keys.contains("payer"));
    }

    @Test
    public void testConfirmTransaction_ReturnsHashMap_WithPayeeKey() {
        Set<String> keys = this.transaction.confirmTransaction().keySet();

        assertTrue(keys.contains("payee"));
    }
    
    @Test
    public void testConfirmTransaction_ReturnsHashMap_WithAmountKey() {
        Set<String> keys = this.transaction.confirmTransaction().keySet();

        assertTrue(keys.contains("amount"));
    }

    @Test
    public void testConfirmTransaction_ReturnsHashMap_WithPayerValue() {
        assertFalse(this.transaction.confirmTransaction().get("payer").isEmpty());
    }

    @Test
    public void testConfirmTransaction_ReturnsHashMap_WithPayeeValue() {
        assertFalse(this.transaction.confirmTransaction().get("payee").isEmpty());
    }
    
    @Test
    public void testConfirmTransaction_ReturnsHashMap_WithAmountValue() {
        assertFalse(this.transaction.confirmTransaction().get("amount").isEmpty());
    }

    
}
