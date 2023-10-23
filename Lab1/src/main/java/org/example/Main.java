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

        System.out.println("Enter a: ");
        a = sc.nextInt();

        System.out.println("Enter b: ");
        b = sc.nextInt();

        System.out.println("Enter n: ");
        n = sc.nextInt();

        System.out.println("Enter m: ");
        m = sc.nextInt();

        System.out.println("Sum = " + calculateSum(a, b, n, m));
    }

    public static double calculateSum(int a, int b, int n, int m) {
        double S = 0;

        for (float i = a; i <= n; i++) {
            for (float j = b; j <= m; j++) {
                S += (double) (i % j) / (i + 2);
            }
        }

        return S;
    }
}