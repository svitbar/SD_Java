package org.example.armor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
    @Test
    public void testArmorConstructorValid() {
        Helmet helmet = new Helmet("h1", 123, 23.4);
        Sword sword = new Sword("sw1", 0, 5.3);
        Shield shield = new Shield("s1", 3000, 10);

        Armor armor = new Armor("a1", 200, 2);
/*        Armor helmet1 = new Helmet("h2", 456, 1.2);
        Armor sword1 = new Sword("sw2", 671, 3.0);
        Armor shield1 = new Shield("s2", 1, 1);*/

        assertEquals("h1", helmet.getName());
        assertEquals(123, helmet.getPrice());
        assertEquals(23.4, helmet.getWeight());

        assertEquals("sw1", sword.getName());
        assertEquals(0, sword.getPrice());
        assertEquals(5.3, sword.getWeight());

        assertEquals("s1", shield.getName());
        assertEquals(3000, shield.getPrice());
        assertEquals(10, shield.getWeight());

        assertEquals("a1", armor.getName());
        assertEquals(200, armor.getPrice());
        assertEquals(2, armor.getWeight());
    }

    @Test
    public void testArmorConstructorInvalidPrice() {
        String excMess = "Price should be greater than zero.";

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            new Armor("a", -2, 123);
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    public void testArmorConstructorInvalidWeight() {
        String excMess = "Weight should be greater than zero.";

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            new Armor("a", 2, 0);
        });

        assertEquals(excMess, exc.getMessage());

        IllegalArgumentException exc1 = assertThrows(IllegalArgumentException.class, () -> {
            new Armor("a", 2, -10.2);
        });

        assertEquals(excMess, exc1.getMessage());
    }
}