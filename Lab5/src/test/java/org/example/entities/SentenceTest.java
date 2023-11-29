package org.example.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SentenceTest {
    @Test
    public void testValidSentenceFromArray() {
        Object[] input = {new Word("Hello"), new Punctuation(','), new Word("world")};
        Sentence sentence = new Sentence(input);

        assertArrayEquals(input, sentence.getSentence());
    }

    @Test
    public void testInvalidSentenceFromArray() {
        String excMess = "Sentence should contain only words and punctuation.";
        Object[] input = {new Word("Hello"), new Letter('p')};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Sentence(input);
        });

        assertEquals(excMess, exception.getMessage());
    }

    @Test
    public void testEmptySentenceFromString() {
        String excMess = "Sentence should not be empty.";

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            new Sentence("");
        });

        assertEquals(excMess, exc.getMessage());
    }
}