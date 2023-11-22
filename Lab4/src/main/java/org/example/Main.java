package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
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

    public static Plane[] sort(Plane[] planes) {
        Comparator<Plane> byId = Comparator.comparing(Plane::getId);
        Comparator<Plane> byName = Comparator.comparing(Plane::getName).reversed();
        Arrays.sort(planes, byId.thenComparing(byName));

        return planes;
    }

    public static void displayArray(Plane[] planes) {
        for (Plane plane: planes) {
            System.out.println(plane.toString());
        }
    }
}