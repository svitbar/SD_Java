package org.example.armor;

public class Armor {
    private final String name;
    private final int price;
    private final double weight;

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

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Armor {" +
                "\nname: " + name +
                "\nprice: " + price +
                "\nweight: " + weight +
                "\n}";
    }
}
