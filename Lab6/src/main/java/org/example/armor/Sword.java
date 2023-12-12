package org.example.armor;

/**
 * The Sword class represents a specific type of armor, which is a sword.
 * It extends the {@link Armor} class and inherits its properties and methods.
 */
public class Sword extends Armor {
    /**
     * Constructs a Sword object with the specified name, price, and weight.
     *
     * @param name   the name of the sword.
     * @param price  the price of the sword (should be greater than zero).
     * @param weight the weight of the sword (should be greater than zero).
     * @throws IllegalArgumentException if the price or weight is not greater than zero.
     */
    public Sword(String name, int price, double weight) {
        super(name, price, weight);
    }
}
