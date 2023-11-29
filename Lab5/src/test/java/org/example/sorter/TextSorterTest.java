package org.example.sorter;

import org.example.entities.Letter;
import org.example.entities.Text;
import org.example.entities.Word;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextSorterTest {

    @Test
    void testSortTextOneWord() {
        Text input = new Text("Hello");
        Letter c = new Letter('l');

        String expectedResult = "Hello ";
        Word[] words = TextSorter.sortText(input, c);
        StringBuilder actualResult = new StringBuilder();

        for (Word w: words) {
            actualResult.append(w.toString()).append(" ");
        }

        assertEquals(expectedResult, actualResult.toString());
    }

    @Test
    void testSortTextSeveralWords() {
        Text input = new Text("hello lol, good hi");
        Letter c = new Letter('o');

        String expectedResult = "good hello lol hi ";
        Word[] words = TextSorter.sortText(input, c);
        StringBuilder actualResult = new StringBuilder();

        for (Word w: words) {
            actualResult.append(w.toString()).append(" ");
        }

        assertEquals(expectedResult, actualResult.toString());
    }

    @Test
    void testSortTextRegister() {
        Text input = new Text("hello, Hi, hh h");
        Letter c = new Letter('h');

        String expectedResult = "hh hello h Hi ";
        Word[] words = TextSorter.sortText(input, c);
        StringBuilder actualResult = new StringBuilder();

        for (Word w: words) {
            actualResult.append(w.toString()).append(" ");
        }

        assertEquals(expectedResult, actualResult.toString());
    }

    @Test
    void testSortTextNoChar() {
        Text input = new Text("hello!");
        Letter c = new Letter('a');

        String expectedResult = "hello ";
        Word[] words = TextSorter.sortText(input, c);
        StringBuilder actualResult = new StringBuilder();

        for (Word w: words) {
            actualResult.append(w.toString()).append(" ");
        }

        assertEquals(expectedResult, actualResult.toString());
    }

    @Test
    void testGetCountSimpleWord() {
        Word word = new Word("hello");
        Letter c = new Letter('l');

        int count = TextSorter.getCount(word, c);

        assertEquals(2, count);
    }

    @Test
    void testGetCountDifferentCase() {
        Word word = new Word("Text");
        Letter c = new Letter('t');

        int count = TextSorter.getCount(word, c);

        assertEquals(1, count);
    }

    @Test
    void testGetCountNoSymbol() {
        Word word = new Word("hi");
        Letter c = new Letter('l');

        int count = TextSorter.getCount(word, c);

        assertEquals(0, count);
    }
}