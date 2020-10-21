package com.tyeporter.banktransfer.bankaccount;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        this.bankAccount = new BankAccount();
    }

    // =========================================================
    // Initialization
    // =========================================================

    @Test
    public void testInit_HasZeroBalance() {
        double expected = 0.0;
        double actual = this.bankAccount.getBalance();

        assertEquals(expected, actual);
    }

    @Test
    public void testInit_HasAccountId() {
        assertFalse(this.bankAccount.getAccountId().isEmpty());
    }

    @Test
    public void testInit_HasNoTransactions() {
        int expected = 0;
        int actual = this.bankAccount.getTransactions().size();

        assertEquals(expected, actual);
    }

    @Test
    public void testInit_GivenBalance_HasBalance() {
        BankAccount newBankAccount = new BankAccount(500.0);

        double expected = 500.0;
        double actual = newBankAccount.getBalance();

        assertEquals(expected, actual);
    }

    // =========================================================
    // Depositing
    // =========================================================

    @Test
    public void testDeposit_GivenNegativeAmount_ThrowsException() {
        assertThrows(InvalidAmountException.class, () -> this.bankAccount.deposit(-5));
    }

    @Test
    public void testDeposit_GivenZero_ThrowsException() {
        assertThrows(ZeroAmountException.class, () -> this.bankAccount.deposit(0));
    }

    @Test
    public void testDeposit_GivenValidAmount_ReturnsTrue() throws Exception {
        assertTrue(this.bankAccount.deposit(25));
    }

    @Test
    public void testDeposit_GivenValidAmount_UpdatesBalance() throws Exception {
        double balanceBefore = this.bankAccount.getBalance();

        this.bankAccount.deposit(25);
        double balanceAfter = this.bankAccount.getBalance();

        assertNotEquals(balanceBefore, balanceAfter);
    }

    // =========================================================
    // Withdrawing
    // =========================================================

    @Test
    public void testWithdraw_GivenNegativeNumber_ThrowsException() {
        assertThrows(InvalidAmountException.class, () -> this.bankAccount.withdraw(-25));
    }

    @Test
    public void testWithdraw_GivenZero_ThrowsException() {
        assertThrows(ZeroAmountException.class, () -> this.bankAccount.withdraw(0));
    }

    @Test
    public void testWithdraw_GivenAmountGreaterThanBalance_ThrowsException() throws Exception {
        this.bankAccount.deposit(500.0);
        assertThrows(AccountOverdraftException.class, () -> this.bankAccount.withdraw(501));
    }

    @Test
    public void testWithdraw_GivenValidAmount_ReturnsTrue() throws Exception {
        this.bankAccount.deposit(500.0);
        assertTrue(this.bankAccount.withdraw(25));
    }

    @Test
    public void testWithdraw_GivenValidAmount_UpdatesBalance() throws Exception {
        this.bankAccount.deposit(500.0);
        double balanceBefore = this.bankAccount.getBalance();

        this.bankAccount.withdraw(25);
        double balanceAfter = this.bankAccount.getBalance();

        assertNotEquals(balanceBefore, balanceAfter);
    }


    // =========================================================
    // Paying
    // =========================================================

    @Test
    public void testPay_GivenNegativeNumber_ThrowsException() {
        BankAccount toBankAccount = new BankAccount();
        assertThrows(InvalidAmountException.class, () -> this.bankAccount.pay(-25, toBankAccount));
    }

    @Test
    public void testPay_GivenZero_ThrowsException() {
        BankAccount toBankAccount = new BankAccount();
        assertThrows(ZeroAmountException.class, () -> this.bankAccount.pay(0, toBankAccount));
    }

    @Test
    public void testPay_GivenAmountGreaterThanBalance_ThrowsException() throws Exception {
        BankAccount toBankAccount = new BankAccount();
        this.bankAccount.deposit(500.0);
        assertThrows(AccountOverdraftException.class, () -> this.bankAccount.pay(501, toBankAccount));
    }

    @Test
    public void testPay_GivenValidAmount_ReturnsTrue() throws Exception {
        BankAccount toBankAccount = new BankAccount();
        this.bankAccount.deposit(500.0);
        assertTrue(this.bankAccount.pay(25, toBankAccount));
    }

    @Test
    public void testPay_GivenValidAmount_UpdatesPayerBalance() throws Exception {
        BankAccount toBankAccount = new BankAccount();
        this.bankAccount.deposit(500.0);
        double balanceBefore = this.bankAccount.getBalance();

        this.bankAccount.pay(25, toBankAccount);
        double balanceAfter = this.bankAccount.getBalance();

        assertNotEquals(balanceBefore, balanceAfter);
    }

    @Test
    public void testPay_GivenValidAmount_UpdatesPayeeBalance() throws Exception {
        BankAccount toBankAccount = new BankAccount();
        this.bankAccount.deposit(500.0);
        double balanceBefore = toBankAccount.getBalance();

        this.bankAccount.pay(25, toBankAccount);
        double balanceAfter = toBankAccount.getBalance();

        assertNotEquals(balanceBefore, balanceAfter);
    }

    @Test
    public void testPay_GivenValidAmount_UpdatesPayerTransactionsCount() throws Exception {
        int transactionsBefore = this.bankAccount.getTransactions().size();

        BankAccount toBankAccount = new BankAccount();
        this.bankAccount.deposit(500.0);
        this.bankAccount.pay(25, toBankAccount);

        int transactionsAfter = this.bankAccount.getTransactions().size();

        assertNotEquals(transactionsBefore, transactionsAfter);
    }

    @Test
    public void testPay_GivenValidAmount_UpdatesPayeeTransactionsCount() throws Exception {
        BankAccount toBankAccount = new BankAccount();

        int transactionsBefore = toBankAccount.getTransactions().size();
        
        this.bankAccount.deposit(500.0);
        this.bankAccount.pay(25, toBankAccount);

        int transactionsAfter = toBankAccount.getTransactions().size();

        assertNotEquals(transactionsBefore, transactionsAfter);
    }
    
}
