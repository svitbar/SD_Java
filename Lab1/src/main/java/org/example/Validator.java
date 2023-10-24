package org.example;

public class Validator {
    public static void validateArgs(int a, int b, int n, int m) {
        if (a < 0 || b < 0 || n < 0 || m < 0) {
            throw new IllegalArgumentException("Input should not be less than zero!");
        } else if (b == 0) {
            throw new IllegalArgumentException("Division by zero! \"b\" cannot be zero.");
        }
    }
}
