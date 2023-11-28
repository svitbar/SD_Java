package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void sortBySymbolCountOneWord() {
        String[] input = {"hello"};
        char c = 'l';

        String[] expectedResult = {"hello"};
        String[] actualResult = Main.sortBySymbolCount(input, c);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void sortBySymbolCountSeveralWords() {
        String[] input = {"hello", "lol", "good", "hi"};
        char c = 'o';

        String[] expectedResult = {"good", "hello", "lol", "hi"};
        String[] actualResult = Main.sortBySymbolCount(input, c);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void sortBySymbolCountRegister() {
        String[] input = {"hello", "Hi", "h", "hh"};
        char c = 'h';

        String[] expectedResult = {"hh", "hello", "h", "Hi"};
        String[] actualResult = Main.sortBySymbolCount(input, c);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void sortBySymbolCountNoChar() {
        String[] input = {"hello"};
        char c = 'a';

        String[] expectedResult = {"hello"};
        String[] actualResult = Main.sortBySymbolCount(input, c);

        assertArrayEquals(expectedResult, actualResult);
    }
}