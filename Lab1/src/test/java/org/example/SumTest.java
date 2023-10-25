package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumTest {
    // a > n, b > m
    @Test
    void abGreaterThanMNTest() {
        assertEquals(0, Sum.calculateSum(2, 3, 4, 1));
        assertEquals(0, Sum.calculateSum(6, 3, 4, 1));
        assertEquals(0, Sum.calculateSum(6, 7, 4, 1));
    }
}