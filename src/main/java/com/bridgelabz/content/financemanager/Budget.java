package com.bridgelabz.content.financemanager;

// Budget Class
class Budget {
    private String label;
    private double amount;

    // Constructor
    public Budget(String label, double amount) {
        this.label = label;
        this.amount = amount;
    }

    // Getter
    public double getAmount() {
        return amount;
    }
}