package org.example;

public class ValidateMatrix {

    public static void validateMatrix(char[][] a, char[][] b) {
        validateMatrixSize(a);
        validateMatrixElements(a);
        validateMatrixSize(b);
        validateMatrixElements(b);

        compareMatrixSize(a, b);
    }

    public static void validateMatrixSize(char[][] matrix) {
        int n = matrix.length;

        if (matrix.length == 0) {
            return;
        }

        for (int i = 1; i < n; i++) {
            if (matrix[0].length != matrix[i].length) {
                throw new IllegalArgumentException("Row lengths are not equal!");
            }
        }
    }

    public static void compareMatrixSize(char[][] first, char[][] second) {
        if (first.length != second.length || first[0].length != second[0].length) {
            throw new IllegalArgumentException("Matrix size should be equal!");
        }
    }

    public static void validateMatrixElements(char[][] matrix) {
        for (char[] row: matrix) {
            for (char el: row) {
                if (!Character.isDigit(el)) {
                    throw new IllegalArgumentException("Matrix should contain only numbers.");
                }
            }
        }
    }
}
