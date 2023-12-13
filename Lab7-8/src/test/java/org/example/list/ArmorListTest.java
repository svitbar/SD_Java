package org.example.list;

import org.example.armor.Armor;
import org.example.armor.Helmet;
import org.example.armor.Shield;
import org.example.armor.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorListTest {
    private ArmorList armorList;
    private Helmet helmet;
    private Sword sword;
    private Shield shield;

    @BeforeEach
    void setUp() {
        armorList = new ArmorList();
        helmet = new Helmet("h1", 250, 2.3);
        sword = new Sword("sw1", 3005, 6.7);
        shield = new Shield("s1", 4350, 5);
    }

    @Test
    void testSize() {
        int expectedEmpty = 0;
        int actualEmpty = armorList.size();

        assertEquals(expectedEmpty, actualEmpty);

        armorList.add(helmet);
        armorList.add(sword);

        int expectedNotEmpty = 2;
        int actualNotEmpty = armorList.size();

        assertEquals(expectedNotEmpty, actualNotEmpty);
    }

    @Test
    void testIsEmpty() {
        assertTrue(armorList.isEmpty());

        armorList.add(helmet);
        assertFalse(armorList.isEmpty());
    }

    @Test
    void contains() {
        assertFalse(armorList.contains(helmet));

        armorList.add(helmet);
        assertTrue(armorList.contains(helmet));

        armorList.add(sword);
        armorList.add(shield);

        assertTrue(armorList.contains(sword));
        assertTrue(armorList.contains(shield));
    }

    @Test
    void iterator() {
    }

    @Test
    void toArray() {
    }

    @Test
    void testToArray() {
    }

    @Test
    void add() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void containsAll() {
    }

    @Test
    void addAll() {
    }

    @Test
    void testAddAll() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void retainAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void testRemove2() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void listIterator() {
    }

    @Test
    void testListIterator() {
    }

    @Test
    void subList() {
    }

    @Test
    void replaceAll() {
    }

    @Test
    void sort() {
    }

    @Test
    void spliterator() {
    }
}