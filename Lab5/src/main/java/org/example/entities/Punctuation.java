package org.example.entities;

/**
 * The Punctuation class represents a punctuation mark.
 */
public class Punctuation {
    /**
     * The character representing a punctuation mark.
     */
    private final char punctuation;

    /**
     * Constructs a Punctuation object with specified character.
     *
     * @param punctuation The character representing a punctuation mark.
     * @throws IllegalArgumentException If provided character do not match punctuation character.
     */
    public Punctuation(char punctuation) {
        if (!String.valueOf(punctuation).matches("\\p{Punct}")) {
            throw new IllegalArgumentException("Invalid punctuation character.");
        }

        this.punctuation = punctuation;
    }

    /**
     * Gets a character value.
     *
     * @return The character value of punctuation mark.
     */
    public char getPunctuation() {
        return punctuation;
    }
}
