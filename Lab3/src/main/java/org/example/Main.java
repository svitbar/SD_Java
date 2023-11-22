package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // C3 = 1202 % 3 = 2 => String
        // C17 = 1202 % 17 = 12 => sort words by specific symbol count

        String text = "hello! how are you?";

        sortBySymbolCount(text, 'o');
    }


    public static void sortBySymbolCount(String text, char c) {
        String[] words = text.split("\\W+");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word: words) {
            int count = 0;

            for (char symbol: word.toCharArray()) {
                if (symbol == c) count++;
            }

            wordCount.put(word, count);
        }

        wordCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry -> System.out.println(entry.getValue() + ": " + entry.getKey()));
    }
}