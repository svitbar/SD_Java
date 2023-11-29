package org.example.sorter;

import org.example.entities.Letter;
import org.example.entities.Sentence;
import org.example.entities.Text;
import org.example.entities.Word;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A TextSorter provides method for sorting words in a text based on count of a specific letter.
 */
public class TextSorter {
    /**
     * Sorts words in provided text based on count of specific letter in each word.
     *
     * @param text The Text object representing the text to sort.
     * @param c The Letter object representing the letter to count.
     * @return An array of Word objects sorted in descending order based on count of specific letter in each word.
     */
    public static Word[] sortText(Text text, Letter c) {
        Sentence[] sentences = text.getSentences();
        ArrayList<Word> wordsList = new ArrayList<>();

        for (Sentence sentence : sentences) {
            Arrays.stream(sentence.getSentence())
                    .filter(p -> p instanceof Word)
                    .map(p -> (Word) p)
                    .forEach(wordsList::add);
        }

        return sortBySymbolCount(wordsList.toArray(new Word[0]), c);
    }

    /**
     * Sorts an array of words based on the count of a specific letter in each word.
     *
     * @param words The array of Word objects to be sorted.
     * @param c The Letter object representing the letter to count.
     * @return An array of Word objects sorted in descending order based on count of specific letter in each word.
     */
    public static Word[] sortBySymbolCount(Word[] words, Letter c) {
        return Arrays.stream(words)
                .sorted((w1, w2) -> Integer.compare(getCount(w2, c), getCount(w1, c)))
                .toArray(Word[]::new);
    }

    /**
     * Gets the count of a specific letter in a word.
     *
     * @param word The Word object to count the letter in.
     * @param c The Letter object representing the letter to count.
     * @return The count of the specified letter in the word.
     */
    public static int getCount(Word word, Letter c) {
        return (int) Arrays.stream(word.getWord())
                .filter(ch -> ch.getSymbol() == c.getSymbol())
                .count();
    }
}
