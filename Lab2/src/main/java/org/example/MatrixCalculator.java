package org.example;

public class MatrixCalculator {
    public static int[][] twoMatrixSum(char[][] A, char[][] B) {
        if (A.length == 0 || B.length == 0) return new int[0][0];

        int rows = A.length;
        int col = A[0].length;
        int [][] C = new int[rows][col];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                int a = Character.digit(A[i][j], 10);
                int b = Character.digit(B[i][j], 10);
                C[i][j] = a+ b;
            }
        }

        return C;
    }

    public static int maxRowSum(int[][] C) {
        if (C.length == 0) return 0;

        int res = 0;
        int m = C[0].length;

        for (int[] ints : C) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                if (ints[j] > max) max = ints[j];
            }
            res += max;
        }

        return res;
    }

    public static void showMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int el: row) {
                System.out.print(el + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void showMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char el: row) {
                System.out.print(el + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
