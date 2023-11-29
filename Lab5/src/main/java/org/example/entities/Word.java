package org.example.entities;

public class Word {
    private final Letter[] word;

    public Word(Letter[] word) {
        this.word = word;
    }

    public Letter[] getWord() {
        return word;
    }
}
