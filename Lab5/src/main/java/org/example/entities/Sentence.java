package org.example.entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Sentence {
    private final Object[] sentence;

    public Sentence(Object[] sentence) {
        for (Object o: sentence) {
            if (!(o instanceof Punctuation || o instanceof Word)) {
                throw new IllegalArgumentException("Sentence should contain only words and punctuation.");
            }
        }

        this.sentence = sentence;
    }

    public Sentence(String text) {
        String[] partsArray = text.split("(?<=\\s)|(?=\\s)|(?<=\\p{Punct})|(?=\\p{Punct})");
        ArrayList<Object> parts = new ArrayList<>();

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Sentence should not be empty.");
        }

        for (String p: partsArray) {
            if (p.matches("\\w+")) {
                parts.add(new Word(p));
            } else if (p.matches("\\p{Punct}")) {
                parts.add(new Punctuation(p.charAt(0)));
            }
        }

        this.sentence = parts.toArray();
    }

    public Object[] getSentence() {
        return sentence;
    }
}
