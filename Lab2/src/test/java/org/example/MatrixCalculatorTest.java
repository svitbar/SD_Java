package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixCalculatorTest {
    char[][] a = {
            {'1', '3', '3'},
            {'3', '5', '5'},
            {'5', '4', '3'},
            {'1', '0', '0'},
    };

    char[][] b = {
            {'8', '5', '3'},
            {'7', '7', '5'},
            {'1', '4', '0'},
            {'1', '7', '0'},
    };

    char[][] c = {};

    int[][] d = {
            {9, 8, 6},
            {10, 12, 10},
            {6, 8, 3},
            {2, 7, 0},
    };

    int[][] e = {};

    @Test
    void testTwoMatrixSum() {
        assertArrayEquals(e, MatrixCalculator.twoMatrixSum(c, c));
        assertArrayEquals(d, MatrixCalculator.twoMatrixSum(a, b));
    }

    @Test
    void testMaxRowSum() {
        assertEquals(36, MatrixCalculator.maxRowSum(d));
    }

    @Test
    void testMaxRowSumEmpty() {
        String exMessage = "Cannot calculate a max row sum of an empty matrix.";

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            MatrixCalculator.maxRowSum(e);
        });

        assertEquals(exMessage, ex.getMessage());
    }
}