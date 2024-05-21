package com.bridgelabz.content.calculatorapp;

public class Calculator {

    // Define lambda expressions for basic arithmetic operations
    private final Operation add = (num1, num2) -> num1 + num2;
    private final Operation subtract = (num1, num2) -> num1 - num2;
    private final Operation multiply = (num1, num2) -> num1 * num2;
    private final Operation divide = (num1, num2) -> {
        if (num2 == 0) throw new ArithmeticException("Division by zero is not allowed.");
        return num1 / num2;
    };

    // Optional: Define lambda expressions for advanced operations
    private final Operation exponentiate = (num1, num2) -> (int) Math.pow(num1, num2);
    private final Operation squareRoot = (num1, num2) -> (int) Math.sqrt(num1);

    public int performOperation(String operation, int num1, int num2) {
        return switch (operation.toLowerCase()) {
            case "add" -> add.calculate(num1, num2);
            case "subtract" -> subtract.calculate(num1, num2);
            case "multiply" -> multiply.calculate(num1, num2);
            case "divide" -> divide.calculate(num1, num2);
            case "exponentiate" -> exponentiate.calculate(num1, num2);
            case "squareroot" -> squareRoot.calculate(num1, num2);
            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        };
    }
}

