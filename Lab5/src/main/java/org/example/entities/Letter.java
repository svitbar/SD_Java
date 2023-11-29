package org.example.entities;

/**
 * The Letter class represents a single letter in the alphabet.
 */
public class Letter {
    /**
     * The character that represents the letter.
     */
    private final char symbol;

    /**
     * Constructs a Letter object with specified character.
     *
     * @param symbol The character that represents the letter.
     * @throws IllegalArgumentException If the provided character is not a letter.
     */
    public Letter(char symbol) {
        if (!Character.isLetter(symbol)) {
            throw new IllegalArgumentException("Character should be a letter.");
        }

        this.symbol = symbol;
    }

    /**
     * Gets the character value.
     *
     * @return The character value of the letter.
     */
    public char getSymbol() {
        return symbol;
    }
}
