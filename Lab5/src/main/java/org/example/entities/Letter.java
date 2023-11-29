package org.example.entities;

public class Letter {
    private final char symbol;

    public Letter(char symbol) {
        if (Character.isLetter(symbol)) {
            this.symbol = symbol;
        } else {
            throw new IllegalArgumentException("Character should be a letter.");
        }
    }

    public char getSymbol() {
        return symbol;
    }
}
