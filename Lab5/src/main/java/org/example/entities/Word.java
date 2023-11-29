package org.example.entities;

public class Word {
    private final Letter[] word;

    public Word(Letter[] word) {
        if (word.length == 0) {
            throw new IllegalArgumentException("Word should not be empty.");
        }

        this.word = word;
    }

    public Word(String word) {
        if (word.isEmpty()) {
            throw new IllegalArgumentException("Word should not be empty.");
        }

        Letter[] wArr = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wArr[i] = new Letter(word.charAt(i));
        }

        this.word = wArr;
    }

    public Letter[] getWord() {
        return word;
    }

    @Override
    public String toString() {
        StringBuilder wordToDisplay = new StringBuilder();

        for (Letter letter: word) {
            wordToDisplay.append(letter.getSymbol());
        }

        return wordToDisplay.toString();
    }
}
