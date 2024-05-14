package com.bridgelabz.content.financemanager;

// Goal Class
class Goal {
    private String label;
    private double targetAmount;

    // Constructor
    public Goal(String label, double targetAmount) {
        this.label = label;
        this.targetAmount = targetAmount;
    }

    // Getter
    public double getTargetAmount() {
        return targetAmount;
    }
}
