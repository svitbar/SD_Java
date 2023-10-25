package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    // a, b, n, m < 0
    @Test
    void lessThanZero() {
        String error = "Input should not be less than zero!";

        Exception aLessThanZero = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateArgs(-1, 2, 3, 4);
        });

        assertEquals(error, aLessThanZero.getMessage());

        Exception bLessThanZero = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateArgs(1, -2, 3, 4);
        });

        assertEquals(error, bLessThanZero.getMessage());

        Exception nLessThanZero = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateArgs(1, 2, -3, 4);
        });

        assertEquals(error, nLessThanZero.getMessage());

        Exception mLessThanZero = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateArgs(1, 2, 3, -4);
        });

        assertEquals(error, mLessThanZero.getMessage());

        Exception allLessThanZero = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateArgs(-1, -2, -3, -4);
        });

        assertEquals(error, aLessThanZero.getMessage());
    }

    // b = 0 => division by zero
    @Test
    void divisionByZero() {
        String error = "Division by zero! \"b\" cannot be zero.";

        Exception zero = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateArgs(1, 0, 3, 4);
        });

        assertEquals(error, zero.getMessage());
    }
}