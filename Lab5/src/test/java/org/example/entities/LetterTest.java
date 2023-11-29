package org.example.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterTest {

    @Test
    public void testIsValidLetterValid() {
        Letter letter = new Letter('c');
        assertEquals('c', letter.getSymbol());
    }

    @Test
    public void testValidLetterInvalid() {
        String excMess = "Character should be a letter.";

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            new Letter('%');
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    public void testValidLetterEmpty() {
        String excMess = "Character should be a letter.";

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            new Letter(' ');
        });

        assertEquals(excMess, exc.getMessage());
    }
}