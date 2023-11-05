package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // C5  = 1202 % 5  = 2 => C = A + B
        // C7  = 1202 % 7  = 5 => char
        // C11 = 1202 % 11 = 3 => Sum of rows' max

        char[][] A = {
                {'0', '2', '3', '9'},
                {'4', '2', '3', '4'},
                {'1', '7', '5', '4'},
        };

        char[][] B = {
                {'1', '2', '2', '4'},
                {'1', '0', '0', '4'},
                {'7', '2', '3', '9'},
        };

        char[][] a = {};
        char[][] b = {};

         // run(A, B);
         // run(a, b);

        runWithRandomMatrix();
    }

    public static void run(char[][] a, char[][] b) {
        try {
            ValidateMatrix.validateMatrix(a, b);

            System.out.println("Matrix A:");
            MatrixCalculator.showMatrix(a);

            System.out.println("Matrix B:");
            MatrixCalculator.showMatrix(b);

            System.out.println("Matrix A and B sum:");
            int[][] res = MatrixCalculator.twoMatrixSum(a, b);
            MatrixCalculator.showMatrix(res);

            int sum = MatrixCalculator.maxRowSum(res);
            System.out.println("Row's max sum = " + sum + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void runWithRandomMatrix() {
        Scanner sc = new Scanner(System.in);
        int n;
        int m;

        while (true) {
            try {
                System.out.println("Please input n: ");
                n = sc.nextInt();
                validateSizeParam(n);

                System.out.println("Please input m: ");
                m = sc.nextInt();
                validateSizeParam(m);

                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Input should be an integer.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

        char[][] A = MatrixCalculator.getRandomMatrix(n, m);
        char[][] B = MatrixCalculator.getRandomMatrix(n, m);

        run(A, B);
    }

    public static void validateSizeParam(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("Number should be positive.");
        }
    }
}