package org.example;

public class Plane {
    private final int id;
    private final String name;
    private final String company;
    private final int capacity;
    private final String country;

    public Plane(int id, String name, String company, int capacity, String country) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.capacity = capacity;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", capacity=" + capacity +
                ", country='" + country + '\'' +
                '}';
    }
}
