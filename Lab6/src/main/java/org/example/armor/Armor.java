package org.example.armor;

public class Armor {
    private final int price;
    private final double weight;
    private final String name;

    public Armor(String name, int price, double weight) {
        this.name = name;

        if (price < 0) {
            throw new IllegalArgumentException("Cost should be more than zero.");
        }

        this.price = price;

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight should be more than zero.");
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
        return "Armor{" +
                "price=" + price +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
