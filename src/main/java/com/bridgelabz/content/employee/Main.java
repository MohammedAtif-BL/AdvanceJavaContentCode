package com.bridgelabz.content.employee;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        Employee e1 = new Employee(1, "Alice", "HR", 50000);
        Employee e2 = new Employee(2, "Bob", "IT", 60000);
        Employee e3 = new Employee(3, "Charlie", "Finance", 55000);

        manager.addEmployee(e1);
        manager.addEmployee(e2);
        manager.addEmployee(e3);

        // Calculate bonus
        EmployeeProcessor bonusProcessor = emp -> emp.setSalary(emp.getSalary() * 1.10);
        manager.processEmployees(bonusProcessor);

        // Print employee details
        EmployeeProcessor printProcessor = System.out::println;
        manager.processEmployees(printProcessor);

        // Increase salary
        EmployeeProcessor increaseSalaryProcessor = emp -> emp.setSalary(emp.getSalary() + 5000);
        manager.processEmployees(increaseSalaryProcessor);
        manager.processEmployees(printProcessor);

        // Sort by salary
        manager.sortEmployees(Comparator.comparing(Employee::getSalary));
        System.out.println("Sorted by salary:");
        manager.processEmployees(printProcessor);
    }
}
