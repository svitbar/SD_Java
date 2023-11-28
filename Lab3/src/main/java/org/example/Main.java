package org.example;

import java.security.PublicKey;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // C3 = 1202 % 3 = 2 => String
        // C17 = 1202 % 17 = 12 => sort words by specific symbol count

        run();
    }


    public static String[] sortBySymbolCount(String[] words, char c) {
        return Arrays.stream(words)
                .sorted((w1, w2) -> Integer.compare(getCount(w2, c), getCount(w1, c)))
                .toArray(String[]::new);
    }

    public static int getCount(String word, char c) {
        return (int) word.chars().filter(ch -> ch == c).count();
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
            String[] res = sortBySymbolCount(getTextToSort(), getChar());
            System.out.println(Arrays.toString(res));
        } catch (InputMismatchException ex) {
            throw new RuntimeException("Please try again: " + ex.getMessage());
        }
    }
}