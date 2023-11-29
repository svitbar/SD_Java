package org.example;

import org.example.entities.*;
import org.example.sorter.TextSorter;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static String getTextToSort() {
        System.out.println("Please enter a string:");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static char getChar() {
        System.out.println("Please enter a character:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input.length() != 1) {
            throw new InputMismatchException("Should be a character!");
        }

        return input.charAt(0);
    }

    public static void run() {
        try {
            Text text = new Text(getTextToSort());
            Letter c = new Letter(getChar());

            Word[] res = TextSorter.getWordArray(text, c);
            System.out.println(Arrays.toString(res));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}