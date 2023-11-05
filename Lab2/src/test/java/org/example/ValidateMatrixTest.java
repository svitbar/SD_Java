package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateMatrixTest {
    char[][] a = {
            {'0', '2', '3', '9'},
            {'4', '2', '3', '4'},
            {'1', '7', '5', '4'},
    };

    char[][] b = {
            {'0', '2', '3', '9'},
            {'4', '4'},
    };

    char[][] c = {};

    char[][] d = {
            {'a', '1', '2', '3'},
    };

    char[][] e = {
            {'0', '-', '2'},
            {'3', '4', '6'},
    };

    char[][] f = {
            {'3', '1', ' '},
    };

    @Test
    void testValidateMatrixSizeValidMatrix() {
        ValidateMatrix.validateMatrixSize(a);
        ValidateMatrix.validateMatrixSize(c);
    }

    @Test
    void testValidateMatrixSizeInvalidMatrix() {
        String exMessage = "Row lengths are not equal!";

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.validateMatrixSize(b);
        });

        assertEquals(exMessage, ex.getMessage());
    }

    @Test
    void testCompareMatrixSizeEqual() {
        ValidateMatrix.compareMatrixSize(a, a);
        ValidateMatrix.compareMatrixSize(c, c);
    }

    @Test
    void testCompareMatrixSizeNotEqual() {
        String exMessage = "Matrix size should be equal!";

        // 4x3 || 0
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.compareMatrixSize(a, c);
        });

        assertEquals(exMessage, ex1.getMessage());

        // 0 || 4x3
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.compareMatrixSize(c, a);
        });

        assertEquals(exMessage, ex2.getMessage());

        // 4x2 || 4x1
        Exception ex3 = assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.compareMatrixSize(a, d);
        });

        assertEquals(exMessage, ex3.getMessage());

        // 4x1 || 4x2
        Exception ex4 = assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.compareMatrixSize(d, a);
        });

        assertEquals(exMessage, ex4.getMessage());

        // 3x2 || 4x1
        Exception ex5 = assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.compareMatrixSize(e, d);
        });

        assertEquals(exMessage, ex5.getMessage());

        // 4x1 || 3x2
        Exception ex6 = assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.compareMatrixSize(d, e);
        });

        assertEquals(exMessage, ex6.getMessage());
    }

    @Test
    void testValidateMatrixElementsValid() {
        ValidateMatrix.validateMatrixElements(a);
        ValidateMatrix.validateMatrixElements(c);
    }

    @Test
    void testValidateMatrixElementsInValid() {
        String exMessage = "Matrix should contain only numbers.";

        // el = 'a'
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.validateMatrixElements(d);
        });

        assertEquals(exMessage, ex1.getMessage());

        // el = '-'
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.validateMatrixElements(e);
        });

        assertEquals(exMessage, ex2.getMessage());

        // el = ' '
        Exception ex3 = assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.validateMatrixElements(f);
        });

        assertEquals(exMessage, ex3.getMessage());
    }

    @Test
    void testValidateMatrixValid() {
        ValidateMatrix.validateMatrix(a, a);
        ValidateMatrix.validateMatrix(c, c);
    }

    @Test
    void testValidateMatrixInValid() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.validateMatrix(a, c);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.validateMatrix(c, a);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.validateMatrix(a, d);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.validateMatrix(a, e);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.validateMatrix(a, b);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ValidateMatrix.validateMatrix(e, b);
        });
    }
}