package org.example.sorter;

import org.example.entities.Letter;
import org.example.entities.Sentence;
import org.example.entities.Text;
import org.example.entities.Word;

import java.util.ArrayList;
import java.util.Arrays;

public class TextSorter {
    public static Word[] getWordArray(Text text, Letter c) {
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

    public static Word[] sortBySymbolCount(Word[] words, Letter c) {
        return Arrays.stream(words)
                .sorted((w1, w2) -> Integer.compare(getCount(w2, c), getCount(w1, c)))
                .toArray(Word[]::new);
    }

    public static int getCount(Word word, Letter c) {
        return (int) Arrays.stream(word.getWord())
                .filter(ch -> ch.getSymbol() == c.getSymbol())
                .count();
    }
}
