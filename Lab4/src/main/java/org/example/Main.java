package org.example;

import java.util.Arrays;
import java.util.Comparator;

/***
 * The main class represents an entry point of the program.
 */
public class Main {
    /***
     * An entry point of the program. It creates an array of Plane objects,
     * sorts them, and display sorted array.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // C11 = 1202 % 11 = 3 => plane

        Plane[] planes = {
                new Plane(5, "C", "a", 100, "ua"),
                new Plane(2, "B", "b", 101, "ua"),
                new Plane(2, "A", "c", 102, "pl"),
                new Plane(4, "F", "d", 103, "ua"),
                new Plane(1, "D", "f", 104, "uk"),
        };

        displayArray(sort(planes));
    }

    /***
     * Sorts an array of Plane objects depending on their id and name.
     *
     * @param planes The array of Plane objects.
     * @return The sorted array of plane objects.
     */
    public static Plane[] sort(Plane[] planes) {
        Comparator<Plane> byId = Comparator.comparing(Plane::getId);
        Comparator<Plane> byName = Comparator.comparing(Plane::getName).reversed();
        Arrays.sort(planes, byId.thenComparing(byName));

        return planes;
    }

    /***
     * Displays an array of Plane objects.
     *
     * @param planes The array of Plane objects.
     */
    public static void displayArray(Plane[] planes) {
        for (Plane plane: planes) {
            System.out.println(plane.toString());
        }
    }
}