package com.bridgelabz.content.exception.example;

import java.io.IOException;

public class ExceptionHandlingShowcase {
    public static void main(String[] args) {
        try {
            // ArithmeticException
            int result = 10 / 0; // Divide by zero
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException occurred: " + e.getMessage());
        }

        try {
            // NullPointerException
            String str = null;
            int length = str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException occurred: " + e.getMessage());
        }

        try {
            // ArrayIndexOutOfBoundsException
            int[] arr = new int[5];
            int value = arr[10]; // Index out of bounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occurred: " + e.getMessage());
        }

        try {
            // NumberFormatException
            String str = "abc";
            int number = Integer.parseInt(str); // Cannot parse "abc" to int
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred: " + e.getMessage());
        }

        try {
            // IOException
            throw new IOException("IO error occurred");
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }

        try {
            // Catching multiple exceptions
            int[] arr = new int[5];
            int value = arr[10] / 0; // This line will throw both ArrayIndexOutOfBoundsException and ArithmeticException
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("Multiple exceptions caught: " + e.getMessage());
        }

        try {
            // Finally block
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException occurred: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }

        try {
            // Custom Exception
            int age = -10;
            if (age < 0) {
                throw new InvalidAgeException("Age cannot be negative");
            }
        } catch (InvalidAgeException e) {
            System.out.println("Custom exception caught: " + e.getMessage());
        }
    }
}
