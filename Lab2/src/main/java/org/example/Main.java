package org.example;

public class Main {
    public static void main(String[] args) {
        // C5  = 1202 % 5  = 2 => C = A + B
        // C7  = 1202 % 7  = 5 => char
        // C11 = 1202 % 11 = 3 => Sum of row's max

        char[][] A = {
                {'1', '2', '3', '4'},
                {'1', '2', '3', '4'},
                {'1', '2', '3', '4'},
        };

        char[][] B = {
                {'1', '2', '3', '4'},
                {'1', '2', '3', '4'},
                {'1', '2', '3', '4'},
        };

        char[][] a = {};
        char[][] b = {};

         run(A, B);
         run(a, b);
    }

    public static void run(char[][] a, char[][] b) {
        try {
            ValidateMatrix.validateMatrix(a, b);

            int[][] res = MatrixCalculator.twoMatrixSum(a, b);
            MatrixCalculator.showMatrix(res);
            int sum = MatrixCalculator.maxRowSum(res);
            System.out.println("Row's max sum = " + sum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}