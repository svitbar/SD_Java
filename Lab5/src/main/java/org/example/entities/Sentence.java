package org.example.entities;

import java.util.ArrayList;

/**
 * A Sentence class represents the sentence created from words and punctuation marks.
 */
public class Sentence {
    /**
     * An array of objects representing the sentence, where each object is either a Word or Punctuation.
     */
    private final Object[] sentence;

    /**
     * Constructs a Sentence object with specified array of objects.
     *
     * @param sentence An array representing a sentence.
     * @throws IllegalArgumentException If provided array contains objects other than Punctuation and Word.
     */
    public Sentence(Object[] sentence) {
        for (Object o: sentence) {
            if (!(o instanceof Punctuation || o instanceof Word)) {
                throw new IllegalArgumentException("Sentence should contain only words and punctuation.");
            }
        }

        this.sentence = sentence;
    }

    /**
     * Constructs a Sentence object with specified string.
     *
     * @param text A string representing a sentence.
     * @throws IllegalArgumentException If provided string is empty.
     */
    public Sentence(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Sentence should not be empty.");
        }

        String[] partsArray = text.split("(?<=\\s)|(?=\\s)|(?<=\\p{Punct})|(?=\\p{Punct})");
        ArrayList<Object> parts = new ArrayList<>();

        for (String p: partsArray) {
            if (p.matches("\\w+")) {
                parts.add(new Word(p));
            } else if (p.matches("\\p{Punct}")) {
                parts.add(new Punctuation(p.charAt(0)));
            }
        }

        this.sentence = parts.toArray();
    }

    /**
     * Gets an array of objects representing a sentence.
     *
     * @return An array of objects representing the sentence where each object is either a Word or Punctuation.
     */
    public Object[] getSentence() {
        return sentence;
    }
}
