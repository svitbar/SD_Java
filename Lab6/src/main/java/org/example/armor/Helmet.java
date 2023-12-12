package org.example.armor;

/**
 * The Helmet class represents a specific type of armor, which is a helmet.
 * It extends the {@link Armor} class and inherits its properties and methods.
 */
public class Helmet extends Armor {
    /**
     * Constructs a Helmet object with the specified name, price, and weight.
     *
     * @param name   the name of the helmet.
     * @param price  the price of the helmet (should be greater than zero).
     * @param weight the weight of the helmet (should be greater than zero).
     * @throws IllegalArgumentException if the price or weight is not greater than zero.
     */
    public Helmet(String name, int price, double weight) {
        super(name, price, weight);
    }
}
