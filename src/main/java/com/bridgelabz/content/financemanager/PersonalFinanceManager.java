package com.bridgelabz.content.financemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Personal Finance Manager Class
public class PersonalFinanceManager {
    private List<Transaction> transactions;
    private List<Category> categories;
    private List<Budget> budgets;
    private List<Goal> goals;

    // Constructor
    public PersonalFinanceManager() {
        transactions = new ArrayList<>();
        categories = new ArrayList<>();
        budgets = new ArrayList<>();
        goals = new ArrayList<>();
    }

    // Add Transaction
    public void addTransaction(Transaction transaction) throws InvalidTransactionException {
        // Validate transaction
        if (transaction.getAmount() <= 0) {
            throw new InvalidTransactionException("Transaction amount must be greater than zero.");
        }
        // Add transaction
        transactions.add(transaction);
    }

    // Add Budget
    public void addBudget(Budget budget) {
        budgets.add(budget);
    }

    // Add Goal
    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    // Calculate Total Expenses by Category
    public double getTotalExpensesByCategory(String category) {
        return transactions.stream()
                .filter(t -> t.getCategory().equals(category))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    // Calculate Total Expenses by Month
    public double getTotalExpensesByMonth(String month) {
        return transactions.stream()
                .filter(t -> t.getDate().startsWith(month))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    // Main Method
    public static void main(String[] args) {
        // Initialize PersonalFinanceManager
        PersonalFinanceManager manager = new PersonalFinanceManager();
        // Add initial data (categories, budgets, goals)
        manager.categories.add(new Category("Food"));
        manager.categories.add(new Category("Transportation"));
        manager.categories.add(new Category("Utilities"));

        manager.budgets.add(new Budget("Food", 500));
        manager.budgets.add(new Budget("Transportation", 200));
        manager.budgets.add(new Budget("Utilities", 300));

        manager.goals.add(new Goal("Savings", 1000));

        // Implement menu navigation and user input handling
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nPersonal Finance Manager Menu:");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Total Expenses by Category");
            System.out.println("3. View Total Expenses by Month");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter description: ");
                        String description = scanner.next();
                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();
                        System.out.print("Enter category: ");
                        String category = scanner.next();
                        System.out.print("Enter date (MM/YYYY): ");
                        String date = scanner.next();
                        Transaction transaction = new Transaction(description, amount, category, date);
                        manager.addTransaction(transaction);
                        System.out.println("Transaction added successfully.");
                    } catch (InvalidTransactionException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter category: ");
                    String category = scanner.next();
                    double totalExpensesByCategory = manager.getTotalExpensesByCategory(category);
                    System.out.println("Total expenses for category " + category + ": $" + totalExpensesByCategory);
                    break;
                case 3:
                    System.out.print("Enter month (MM/YYYY): ");
                    String month = scanner.next();
                    double totalExpensesByMonth = manager.getTotalExpensesByMonth(month);
                    System.out.println("Total expenses for month " + month + ": $" + totalExpensesByMonth);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Personal Finance Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        scanner.close();
    }
}
