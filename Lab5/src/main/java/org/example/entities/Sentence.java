package org.example.entities;

public class Sentence {
    private final Object[] sentence;

    public Sentence(Object[] sentence) {
        this.sentence = sentence;
    }

    public Object[] getSentence() {
        return sentence;
    }
}
