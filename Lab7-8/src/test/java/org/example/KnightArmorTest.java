package org.example;

import org.example.armor.Armor;
import org.example.armor.Helmet;
import org.example.armor.Shield;
import org.example.armor.Sword;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KnightArmorTest {
    KnightArmor knightArmor = new KnightArmor();

    Helmet helmet = new Helmet("h1", 250, 2.3);
    Sword sword = new Sword("sw1", 3005, 6.7);
    Shield shield = new Shield("s1", 4350, 5);

    @Test
    void testAddArmor() {
        knightArmor.addArmor(helmet);
        knightArmor.addArmor(sword);
        knightArmor.addArmor(shield);

        assertEquals(3, knightArmor.getArmor().size());

        assertEquals(helmet, knightArmor.getArmor().get(0));
        assertEquals(sword, knightArmor.getArmor().get(1));
        assertEquals(shield, knightArmor.getArmor().get(2));
    }

    @Test
    void testCalculateArmorPrice() {
        knightArmor.addArmor(helmet);
        knightArmor.addArmor(sword);
        knightArmor.addArmor(shield);

        int actualPrice = knightArmor.calculateArmorPrice();
        int expectedPrice = 7605;

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void testSortArmorByWeight() {
        knightArmor.addArmor(helmet);
        knightArmor.addArmor(sword);
        knightArmor.addArmor(shield);

        List<Armor> expected = new ArrayList<>();
        expected.add(helmet);
        expected.add(shield);
        expected.add(sword);

        List<Armor> actual = knightArmor.sortArmorByWeight();

        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(1), actual.get(1));
        assertEquals(expected.get(2), actual.get(2));
    }

    @Test
    void testFindArmorByPriceValid() {
        knightArmor.addArmor(helmet);
        knightArmor.addArmor(sword);
        knightArmor.addArmor(shield);

        int min = 200;
        int max = 3500;
        List<Armor> actual = knightArmor.findArmorByPrice(min, max);

        ArrayList<Armor> expected = new ArrayList<>();
        expected.add(helmet);
        expected.add(sword);

        assertEquals(2, actual.size());
        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(1), actual.get(1));
    }

    @Test
    void testFindArmorByPriceMinOrMaxLessThanZero() {
        String excMess = "Min and max value should be greater than zero";

        IllegalArgumentException exc1 = assertThrows(IllegalArgumentException.class, () -> {
            knightArmor.findArmorByPrice(-10, 356);
        });

        assertEquals(excMess, exc1.getMessage());

        IllegalArgumentException exc2 = assertThrows(IllegalArgumentException.class, () -> {
            knightArmor.findArmorByPrice(89, -6);
        });

        assertEquals(excMess, exc2.getMessage());

        IllegalArgumentException exc3 = assertThrows(IllegalArgumentException.class, () -> {
            knightArmor.findArmorByPrice(-3, -1);
        });

        assertEquals(excMess, exc3.getMessage());
    }

    @Test
    void testFindArmorByPriceMinGreaterThanMax() {
        String excMess = "Minimum should be less than maximum.";

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            knightArmor.findArmorByPrice(145, 9);
        });

        assertEquals(excMess, exc.getMessage());
    }
}