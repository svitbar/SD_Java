package org.example.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {
    @Test
    public void testValidWordFromArray() {
        Letter[] input = {new Letter('H'), new Letter('e'), new Letter('l'), new Letter('l'), new Letter('o')};
        Word word = new Word(input);
        assertArrayEquals(input, word.getWord());
    }

    @Test
    public void testInvalidWordFromArray() {
        String excMess = "Word should not be empty.";
        Letter[] input = {};

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            new Word(input);
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    public void testEmptyWordFromString() {
        String excMess = "Word should not be empty.";

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            new Word("");
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    public void testWordToString() {
        Letter[] input = {new Letter('H'), new Letter('e'), new Letter('l'), new Letter('l'), new Letter('o')};
        Word word = new Word(input);
        assertEquals("Hello", word.toString());
    }
}