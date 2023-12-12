package org.example;

import org.example.armor.Armor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The KnightArmor class represents a collection of armor for a knight.
 */
public class KnightArmor  {
    private final ArrayList<Armor> armor = new ArrayList<>();

    /**
     * Gets the armor collection.
     *
     * @return the armor collection.
     */
    public ArrayList<Armor> getArmor() {
        return armor;
    }

    /**
     * Adds armor to the collection.
     *
     * @param item the armor to add.
     */
    public void addArmor(Armor item) {
        armor.add(item);
    }

    /**
     * Calculates the total price of all armor pieces.
     *
     * @return the total price of all armor pieces.
     */
    public int calculateArmorPrice() {
        int price = 0;

        for (Armor item: armor) {
            price += item.getPrice();
        }

        return price;
    }

    /**
     * Sorts the armor collection by weight.
     *
     * @return a sorted list of armor by weight.
     */
    public ArrayList<Armor> sortArmorByWeight() {
        ArrayList<Armor> sortedArray = new ArrayList<>(armor);
        sortedArray.sort(Comparator.comparing(Armor::getWeight));

        return sortedArray;
    }

    /**
     * Finds armor within a specified price range.
     *
     * @param min the minimum price.
     * @param max the maximum price.
     * @return a list of armor within the specified price range.
     * @throws IllegalArgumentException if min or max is less than zero, or if min is greater than max.
     */
    public ArrayList<Armor> findArmorByPrice(int min, int max) {
        if (min < 0 || max < 0) {
            throw new IllegalArgumentException("Min and max value should be greater than zero");
        } else if (min > max) {
            throw new IllegalArgumentException("Minimum should be less than maximum.");
        }

        ArrayList<Armor> armorPrice = new ArrayList<>();

        for (Armor item: armor) {
            if (item.getPrice() >= min && item.getPrice() <= max) {
                armorPrice.add(item);
            }
        }

        return armorPrice;
    }

    /**
     * Displays armor pieces.
     *
     * @param armorList the list of armor to display.
     */
    public void displayArmor(ArrayList<Armor> armorList) {
        for (Armor item: armorList) {
            System.out.println(item.toString());
        }
    }
}
