package org.example.entities;

public class Letter {
    private final char symbol;

    public Letter(char symbol) {
        if (!Character.isLetter(symbol)) {
            throw new IllegalArgumentException("Character should be a letter.");
        }

        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
