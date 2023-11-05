package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // C5  = 1202 % 5  = 2 => C = A + B
        // C7  = 1202 % 7  = 5 => char
        // C11 = 1202 % 11 = 3 => Sum of rows' max

/*        char[][] A = {
                {'0', '2', '3', '9'},
                {'4', '2', '3', '4'},
                {'1', '7', '5', '4'},
        };

        char[][] B = {
                {'1', '2', '2', '4'},
                {'1', '0', '0', '4'},
                {'7', '2', '3', '9'},
        };

        run(A, B);*/

/*        char[][] a = {};
        char[][] b = {};

        run(a, b);*/

        int n = getMatrixSize();
        int m = getMatrixSize();

        char[][] aMatrix = MatrixCalculator.getRandomMatrix(n, m);
        char[][] bMatrix = MatrixCalculator.getRandomMatrix(n, m);

        run(aMatrix, bMatrix);
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
            System.out.println("Rows' max sum = " + sum + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getMatrixSize() {
        Scanner sc = new Scanner(System.in);
        int num;

        while (true) {
            try {
                System.out.println("Please enter a number: ");
                num = sc.nextInt();
                validateSizeParam(num);

                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Number should be an integer.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

        return num;
    }

    public static void validateSizeParam(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("Number should be positive.");
        }
    }
}