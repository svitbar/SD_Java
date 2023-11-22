package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // C3 = 1202 % 3 = 2 => String
        // C17 = 1202 % 17 = 12 => sort words by specific symbol count

        run();
    }


    public static void sortBySymbolCount(String[] words, char c) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word: words) {
            int count = 0;

            for (char symbol: word.toCharArray()) {
                if (symbol == c) count++;
            }

            wordCount.put(word, count);
        }

/*        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
        sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/
        wordCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry -> System.out.println(entry.getValue() + ": " + entry.getKey()));
    }

    public static String[] getTextToSort() {
        System.out.println("Please enter a string:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] wordsAndOther = str.split("\\W+");
        ArrayList<String> words = new ArrayList<>();

        for (String w: wordsAndOther) {
            boolean isWord = w.chars().allMatch(Character::isLetter);
            if (isWord) words.add(w);
        }

        if (words.isEmpty()) {
            throw new InputMismatchException("String should contain words!");
        }

        return words.toArray(new String[0]);
    }

    public static char getChar() {
        System.out.println("Please enter a character:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            throw new InputMismatchException("Should be a character!");
        }

        return input.charAt(0);
    }

    public static void run() {
        try {
            sortBySymbolCount(getTextToSort(), getChar());
        } catch (InputMismatchException ex) {
            throw new RuntimeException("Please try again: " + ex.getMessage());
        }
    }
}