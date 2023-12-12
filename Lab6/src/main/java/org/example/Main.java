package org.example;

import org.example.armor.Armor;
import org.example.armor.Helmet;
import org.example.armor.Shield;
import org.example.armor.Sword;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // C13 = 1202 % 6 = 13 => knight

        perform();
    }

    public static void perform() {
        try {
            KnightArmor knight = knightArmor();

            System.out.println("List of armors:");
            knight.displayArmor(knight.getArmor());

            int totalPrice = knight.calculateArmorPrice();
            System.out.println("\nTotal price: " + totalPrice);

            ArrayList<Armor> sorted = knight.sortArmorByWeight();
            System.out.println("\nSorted armor list:");
            knight.displayArmor(sorted);

            int min = 34;
            int max = 567;
            ArrayList<Armor> byPrice = knight.findArmorByPrice(min, max);
            System.out.println("\nAll armor which price is in the range from " + min + " to " + max + ".");
            knight.displayArmor(byPrice);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static KnightArmor knightArmor() {
        KnightArmor knight = new KnightArmor();

        Helmet helmet = new Helmet("h11", 245, 12.4);
        Shield shield = new Shield("s11", 100, 1782.3);
        Sword sword = new Sword("sw11", 12, 9.1);
        Helmet helmet1 = new Helmet("h12", 1678, 156);
        Shield shield1 = new Shield("s12", 43, 873.1);
        Sword sword1 = new Sword("sw12", 928, 3.2);

        knight.addArmor(helmet);
        knight.addArmor(shield);
        knight.addArmor(sword);
        knight.addArmor(helmet1);
        knight.addArmor(shield1);
        knight.addArmor(sword1);

        return knight;
    }
}