package com.bridgelabz.content.exception.bankexample;

public class BankAccount {
    private int accountNumber;
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit Funds
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into account " + accountNumber);
    }

    // Withdraw Funds
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in account " + accountNumber);
        }
        balance -= amount;
        System.out.println("Withdrawn " + amount + " from account " + accountNumber);
    }

    // Transfer Funds
    public void transfer(BankAccount recipient, double amount) throws InsufficientFundsException {
        withdraw(amount);
        recipient.deposit(amount);
        System.out.println("Transferred " + amount + " from account " + accountNumber + " to account " + recipient.getAccountNumber());
    }

    // Getter for Account Number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Getter for Balance
    public double getBalance() {
        return balance;
    }
}
