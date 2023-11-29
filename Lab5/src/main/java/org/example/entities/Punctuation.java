package org.example.entities;

public class Punctuation {
    private final char punctuation;

    public Punctuation(char punctuation) {
        if (!String.valueOf(punctuation).matches("[.,;:?!'()\"]")) {
            throw new IllegalArgumentException("Invalid punctuation character.");
        }

        this.punctuation = punctuation;
    }

    public char getPunctuation() {
        return punctuation;
    }
}
