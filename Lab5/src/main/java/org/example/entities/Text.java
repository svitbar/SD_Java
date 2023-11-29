package org.example.entities;

/**
 * A Text class represents a text created from sentences.
 */
public class Text {
    /**
     * An array of Sentence objects representing text.
     */
    private final Sentence[] sentences;

    /**
     * Constructs a Text object with specified array of sentences.
     *
     * @param sentences An array of Sentence objects.
     */
    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    /**
     * Constructs a Text object with specified string.
     *
     * @param text A string representing a text.
     * @throws IllegalArgumentException If provided string is empty.
     */
    public Text(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text should not be empty.");
        }

        String[] sentArray = text.split("(?<=[.!?])\\s*");
        Sentence[] result = new Sentence[sentArray.length];

        for (int i = 0; i < sentArray.length; i++) {
            result[i] = new Sentence(sentArray[i]);
        }

        this.sentences = result;
    }

    /**
     * Gets the array of Sentence objects representing a text.
     *
     * @return An array of Sentence objects.
     */
    public Sentence[] getSentences() {
        return sentences;
    }
}
