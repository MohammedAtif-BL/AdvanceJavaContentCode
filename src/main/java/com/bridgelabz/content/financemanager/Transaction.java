package com.bridgelabz.content.financemanager;

// Transaction Class
class Transaction {
    private String description;
    private double amount;
    private String category;
    private String date;

    // Constructor
    public Transaction(String description, double amount, String category, String date) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }
}
