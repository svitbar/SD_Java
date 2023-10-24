package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getInput();
    }

    // c2   +
    // c3   2
    // c    2
    // c5   %
    // c7   float

    // n, m should be int
    // a < i, b < j, nm = 0  => S == 0 => a < n, b < m
    // i == a == -2 => /0 => error
    // j = b = 0 => /0 => error
    // a, b, n, m < 0 => error?

    public static void getInput() {
        int a;
        int b;
        int n;
        int m;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter a: ");
            a = sc.nextInt();

            System.out.println("Enter b: ");
            b = sc.nextInt();

            System.out.println("Enter n: ");
            n = sc.nextInt();

            System.out.println("Enter m: ");
            m = sc.nextInt();

            if (validate(a, b, n, m)) {
                System.out.println("Sum = " + calculateSum(a, b, n, m));
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer.");
        }
    }

    public static Boolean validate(int a, int b, int n, int m) {
        try {
            validateArgs(a, b, n, m);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void validateArgs(int a, int b, int n, int m) {
        if (a < 0 || b < 0 || n < 0 || m < 0) {
            throw new IllegalArgumentException("Input should not be less than zero!");
        } else if (b == 0) {
            throw new IllegalArgumentException("Error! Division by zero!");
        }
    }

    public static double calculateSum(int a, int b, int n, int m) {
        double S = 0;

        if (a > n || b > m) {
            return S;
        }

        for (float i = a; i <= n; i++) {
            for (float j = b; j <= m; j++) {
                S += (double) (i % j) / (i + 2);
            }
        }

        return S;
    }
}