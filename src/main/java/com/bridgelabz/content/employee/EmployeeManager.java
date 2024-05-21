package com.bridgelabz.content.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

    public void processEmployees(EmployeeProcessor processor) {
        for (Employee employee : employees) {
            processor.process(employee);
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void sortEmployees(Comparator<Employee> comparator) {
        employees.sort(comparator);
    }
}

