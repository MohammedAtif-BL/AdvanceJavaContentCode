package com.bridgelabz.content.financemanager;

// Custom Exception for Budget Exceeded
class BudgetExceededException extends Exception {
    public BudgetExceededException(String message) {
        super(message);
    }
}
