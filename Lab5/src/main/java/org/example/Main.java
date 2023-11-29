package org.example;

import org.example.entities.*;
import org.example.sorter.TextSorter;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Main class provides a simple user-interactive interface.
 */
public class Main {
    /**
     * The main method that initiates the execution of the program.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        run();
    }

    /**
     * Prompts the user to enter a string.
     *
     * @return The string entered by the user.
     */
    public static String getTextToSort() {
        System.out.println("Please enter a string:");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Prompts the user to enter a character.
     *
     * @return The character entered by the user.
     * @throws InputMismatchException If the input is not a single character.
     */
    public static char getChar() {
        System.out.println("Please enter a character:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input.length() != 1) {
            throw new InputMismatchException("Should be a character!");
        }

        return input.charAt(0);
    }

    /**
     * Executes the main functionality of the program:
     * - Asks the user to input a text and a character.
     * - Uses the TextSorter to sort the words in the text based on the count of the specified character.
     * - Prints the sorted words.
     */
    public static void run() {
        try {
            Text text = new Text(getTextToSort());
            Letter c = new Letter(getChar());

            Word[] res = TextSorter.sortText(text, c);
            System.out.println(Arrays.toString(res));
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}