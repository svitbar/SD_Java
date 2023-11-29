package org.example.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PunctuationTest {
    @Test
    public void testValidPunctuation() {
        Punctuation punctuation = new Punctuation(',');
        assertEquals(',', punctuation.getPunctuation());
    }

    @Test
    public void testInvalidPunctuation() {
        String excMess = "Invalid punctuation character.";

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            new Punctuation('a');
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    public void testValidPunctuationEmpty() {
        String excMess = "Invalid punctuation character.";

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            new Punctuation(' ');
        });

        assertEquals(excMess, exc.getMessage());
    }
}