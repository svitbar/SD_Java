package org.example.armor;

/**
 * The Armor class represents a piece of armor with a name, price, and weight.
 */
public class Armor {
    /**
     * The string that represents the name of the armor.
     */
    private final String name;
    /**
     * The int value that represents the price of the armor.
     */
    private final int price;
    /**
     * The int value that represents the weight of the armor.
     */
    private final double weight;

    /**
     * Constructs an Armor object with the specified name, price, and weight.
     *
     * @param name   the name of the armor.
     * @param price  the price of the armor (should be greater than zero).
     * @param weight the weight of the armor (should be greater than zero).
     * @throws IllegalArgumentException if the price or weight is not greater than zero.
     */
    public Armor(String name, int price, double weight) {
        this.name = name;

        if (price < 0) {
            throw new IllegalArgumentException("Price should be greater than zero.");
        }

        this.price = price;

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight should be greater than zero.");
        }

        this.weight = weight;
    }

    /**
     * Gets the name of the armor.
     *
     * @return the name of the armor.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the armor.
     *
     * @return the price of the armor.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the weight of the armor.
     *
     * @return the weight of the armor.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns a string representation of the armor.
     *
     * @return a string representation of the armor.
     */
    @Override
    public String toString() {
        return "Armor {" +
                "\nname: " + name +
                "\nprice: " + price +
                "\nweight: " + weight +
                "\n}";
    }
}

