package com.bridgelabz.content.financemanager;

// Custom Exception for Invalid Transactions
class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}
