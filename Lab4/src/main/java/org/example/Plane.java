package org.example;

/**
 *  The Plane class represents the plane objects.
 */
public class Plane {
    private final int id;
    private final String name;
    private final String company;
    private final int capacity;
    private final String country;

    /***
     * Constructor for creating an object of Plane.
     *
     * @param id    The id of the plane.
     * @param name  The name of the plane.
     * @param company   A company that manufactures plane.
     * @param capacity  The capacity of the plane.
     * @param country   The country which owns the company of the plane.
     */
    public Plane(int id, String name, String company, int capacity, String country) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.capacity = capacity;
        this.country = country;
    }

    // getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /***
     * Return a string of all parameters of plane object.
     *
     * @return A string that include all plane fields.
     */
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
