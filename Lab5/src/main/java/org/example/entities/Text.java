package org.example.entities;

import java.util.Arrays;

public class Text {
    private final Sentence[] sentences;

    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public Text(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text should not be empty.");
        }

        String[] sentArray = text.split("(?<=[.!?])\\s*");
        System.out.println(Arrays.toString(sentArray));
        Sentence[] result = new Sentence[sentArray.length];

        for (int i = 0; i < sentArray.length; i++) {
            result[i] = new Sentence(sentArray[i]);
        }

        this.sentences = result;
    }

    public Sentence[] getSentences() {
        return sentences;
    }
}
