package org.example;

import org.example.armor.Armor;

import java.util.ArrayList;
import java.util.Comparator;

public class KnightArmor  {
    private final ArrayList<Armor> armor = new ArrayList<>();

    public ArrayList<Armor> getArmor() {
        return armor;
    }

    public void addArmor(Armor item) {
        armor.add(item);
    }

    public int calculateArmorPrice() {
        int price = 0;

        for (Armor item: armor) {
            price += item.getPrice();
        }

        return price;
    }

    public ArrayList<Armor> sortArmorByWeight() {
        ArrayList<Armor> sortedArray = new ArrayList<>(armor);
        sortedArray.sort(Comparator.comparing(Armor::getWeight));

        return sortedArray;
    }

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

    public void displayArmor(ArrayList<Armor> armorArray) {
        for (Armor item: armorArray) {
            System.out.println(item.toString());
        }
    }
}
