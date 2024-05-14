package com.bridgelabz.content.exception;

public class BankAccountManagement {
    public static void main(String[] args) {
        try {
            // Create Bank Accounts
            BankAccount account1 = new BankAccount(123456, 1000);
            BankAccount account2 = new BankAccount(789012, 500);

            // Deposit Funds
            account1.deposit(200);
            account2.deposit(300);

            // Withdraw Funds
            account1.withdraw(150);
            account2.withdraw(200);

            // Transfer Funds
            account1.transfer(account2, 300);

        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
