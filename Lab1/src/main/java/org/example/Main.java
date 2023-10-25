package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a;
        int b;
        int n;
        int m;
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter a: ");
                a = sc.nextInt();

                System.out.println("Enter b: ");
                b = sc.nextInt();

                System.out.println("Enter n: ");
                n = sc.nextInt();

                System.out.println("Enter m: ");
                m = sc.nextInt();

                Validator.validateArgs(a, b, n, m);

                System.out.println("Sum = " + Sum.calculateSum(a, b, n, m));

                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}