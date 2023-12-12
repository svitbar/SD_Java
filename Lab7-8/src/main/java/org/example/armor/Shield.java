package org.example.armor;

/**
 * The Shield class represents a specific type of armor, which is a shield.
 * It extends the {@link Armor} class and inherits its properties and methods.
 */
public class Shield extends Armor {
    /**
     * Constructs a Shield object with the specified name, price, and weight.
     *
     * @param name   the name of the shield.
     * @param price  the price of the shield (should be greater than zero).
     * @param weight the weight of the shield (should be greater than zero).
     * @throws IllegalArgumentException if the price or weight is not greater than zero.
     */
    public Shield(String name, int price, double weight) {
        super(name, price, weight);
    }
}
