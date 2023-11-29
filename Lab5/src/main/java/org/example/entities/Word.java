package org.example.entities;

/**
 * The Word class represents the word created of letters array.
 */
public class Word {
    /**
     * An Array of Letter objects that represents a word.
     */
    private final Letter[] word;

    /**
     * Constructs a Word object with specified array of letters.
     *
     * @param word An array of {@code Letter} objects.
     * @throws IllegalArgumentException If provided array is empty.
     */
    public Word(Letter[] word) {
        if (word.length == 0) {
            throw new IllegalArgumentException("Word should not be empty.");
        }

        this.word = word;
    }

    /**
     * Constructs a Word object with the specified string.
     *
     * @param word A string that represents a word.
     * @throws IllegalArgumentException If provided string is empty or contains non-letter characters.
     */
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

    /**
     * Gets an array of letters representing word.
     *
     * @return An array of Letter objects.
     */
    public Letter[] getWord() {
        return word;
    }

    /**
     * Returns a string representing a word.
     *
     * @return A string which is an array of letters.
     */
    @Override
    public String toString() {
        StringBuilder wordToDisplay = new StringBuilder();

        for (Letter letter: word) {
            wordToDisplay.append(letter.getSymbol());
        }

        return wordToDisplay.toString();
    }
}
