package org.example.list;

import org.example.armor.Armor;
import org.example.armor.Helmet;
import org.example.armor.Shield;
import org.example.armor.Sword;
import org.example.exception.ArmorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmorListTest {
    private ArmorList armorList;
    private Helmet helmet;
    private Sword sword;
    private Shield shield;

    @BeforeEach
    void setUp() {
        armorList = new ArmorList();
        helmet = new Helmet("h", 250, 2.3);
        sword = new Sword("sw", 3005, 6.7);
        shield = new Shield("s", 4350, 5);
    }

    @Test
    void testSizeEmpty() {
        int expectedEmpty = 0;
        int actualEmpty = armorList.size();

        assertEquals(expectedEmpty, actualEmpty);
    }

    @Test
    void testSizeNotEmpty() {
        armorList.add(helmet);
        armorList.add(sword);

        int expectedNotEmpty = 2;
        int actualNotEmpty = armorList.size();

        assertEquals(expectedNotEmpty, actualNotEmpty);
    }

    @Test
    void testIsEmptyTrue() {
        assertTrue(armorList.isEmpty());
    }

    @Test
    void testIsEmptyFalse() {
        armorList.add(helmet);
        assertFalse(armorList.isEmpty());
    }

    @Test
    void testContainsNoElements() {
        assertFalse(armorList.contains(helmet));
        assertFalse(armorList.contains(shield));
    }

    @Test
    void testContainsElements() {
        armorList.add(helmet);
        assertTrue(armorList.contains(helmet));

        armorList.add(sword);
        assertTrue(armorList.contains(sword));
    }

    @Test
    void testIterator() {
        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(shield);

        Iterator<Armor> iterator = armorList.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(helmet, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(sword, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(shield, iterator.next());

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testToArrayEmpty() {
        Armor[] actualEmpty = armorList.toArray();
        Armor[] expectedEmpty = new Armor[0];

        assertArrayEquals(expectedEmpty, actualEmpty);
    }

    @Test
    void testToArrayNotEmpty() {
        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(shield);

        Armor[] actualNotEmpty = armorList.toArray();
        Armor[] expectedNotEmpty = {helmet, sword, shield};

        assertArrayEquals(expectedNotEmpty, actualNotEmpty);
    }

    @Test
    void testAddValid() {
        assertTrue(armorList.add(helmet));
        assertTrue(armorList.add(sword));
        assertEquals(2, armorList.size());
    }

    @Test
    void testAddNull() {
        String excMess = "Cannot be null!";

        ArmorException exc = assertThrows(ArmorException.class, () -> {
            armorList.add(null);
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testRemoveElementThatNotExist() {
        assertFalse(armorList.remove(helmet));
    }

    @Test
    void testRemoveValidElement() {
        armorList.add(helmet);
        assertTrue(armorList.remove(helmet));
        assertEquals(0, armorList.size());
        assertFalse(armorList.contains(helmet));

        armorList.add(shield);
        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(helmet);

        assertTrue(armorList.remove(sword));
        assertEquals(3, armorList.size());
        assertFalse(armorList.contains(sword));

        assertTrue(armorList.remove(helmet));
        assertEquals(2, armorList.size());
        assertTrue(armorList.contains(helmet));
    }

    @Test
    void testRemoveNullElement() {
        String excMess = "Cannot be null!";

        ArmorException exc = assertThrows(ArmorException.class, () -> {
            armorList.remove(null);
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testContainsAllEmptyCollection() {
        Collection<Object> c = new ArrayList<>();
        assertTrue(armorList.containsAll(c));
    }

    @Test
    void testContainsAllNullElement() {
        Collection<Object> c = new ArrayList<>();

        armorList.add(helmet);
        armorList.add(sword);

        c.add(helmet);
        c.add(null);

        assertFalse(armorList.containsAll(c));
    }

    @Test
    void testContainsAllNotArmorElement() {
        Collection<Object> c = new ArrayList<>();

        armorList.add(helmet);
        armorList.add(sword);

        c.add(helmet);
        c.add(2);

        assertFalse(armorList.containsAll(c));
    }

    @Test
    void testContainsAllValid() {
        Collection<Object> c = new ArrayList<>();

        armorList.add(helmet);
        armorList.add(sword);

        c.add(helmet);
        c.add(sword);
        assertTrue(armorList.containsAll(c));

        c.clear();
        c.add(helmet);
        c.add(sword);
        assertTrue(armorList.containsAll(c));

        c.add(shield);
        assertFalse(armorList.containsAll(c));
    }

    @Test
    void testAddAllValid() {
        Collection<Armor> c = new ArrayList<>();

        armorList.add(helmet);

        assertTrue(armorList.addAll(c));
        assertEquals(1, armorList.size());
        assertTrue(armorList.contains(helmet));

        c.add(sword);
        c.add(shield);

        assertTrue(armorList.addAll(c));
        assertEquals(3, armorList.size());
        assertEquals(armorList.get(0), helmet);
        assertEquals(armorList.get(1), sword);
        assertEquals(armorList.get(2), shield);
    }

    @Test
    void testAddAllContainNullElement() {
        Collection<Armor> c = new ArrayList<>();
        String excMess = "Cannot contain null!";
        c.add(null);

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            armorList.addAll(c);
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testAddAllAtIndexEmptyCollection() {
        Collection<Armor> c = new ArrayList<>();

        armorList.add(helmet);

        assertTrue(armorList.addAll(1, c));
        assertEquals(1, armorList.size());
        assertTrue(armorList.contains(helmet));
    }

    @Test
    void testAddAllAtIndexAtBeginning() {
        Helmet helmet1 = new Helmet("h1", 100, 1);
        Sword sword1 = new Sword("sw1", 123, 4.4);
        Shield shield1 = new Shield("s1", 200, 5.2);

        Collection<Armor> c = new ArrayList<>();

        armorList.add(sword);
        armorList.add(shield);

        c.add(helmet1);
        c.add(sword1);
        c.add(shield1);

        assertTrue(armorList.addAll(0, c));
        assertEquals(5, armorList.size());
        assertEquals(armorList.get(0), helmet1);
        assertEquals(armorList.get(1), sword1);
        assertEquals(armorList.get(2), shield1);
        assertEquals(armorList.get(3), sword);
        assertEquals(armorList.get(4), shield);
    }

    @Test
    void testAddAllAtIndexAtMiddle() {
        Helmet helmet1 = new Helmet("h1", 100, 1);
        Sword sword1 = new Sword("sw1", 123, 4.4);
        Shield shield1 = new Shield("s1", 200, 5.2);

        Collection<Armor> c = new ArrayList<>();

        c.add(helmet1);
        c.add(sword1);
        c.add(shield1);

        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(shield);

        assertTrue(armorList.addAll(1, c));
        assertEquals(6, armorList.size());
        assertEquals(armorList.get(0), helmet);
        assertEquals(armorList.get(1), helmet1);
        assertEquals(armorList.get(2), sword1);
        assertEquals(armorList.get(3), shield1);
        assertEquals(armorList.get(4), sword);
        assertEquals(armorList.get(5), shield);
    }

    @Test
    void testAddAllAtIndexAtEnd() {
        Helmet helmet1 = new Helmet("h1", 100, 1);
        Sword sword1 = new Sword("sw1", 123, 4.4);
        Shield shield1 = new Shield("s1", 200, 5.2);

        Collection<Armor> c = new ArrayList<>();

        c.add(helmet1);
        c.add(sword1);
        c.add(shield1);

        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(shield);

        assertTrue(armorList.addAll(3, c));
        assertEquals(6, armorList.size());
        assertEquals(armorList.get(0), helmet);
        assertEquals(armorList.get(1), sword);
        assertEquals(armorList.get(2), shield);
        assertEquals(armorList.get(3), helmet1);
        assertEquals(armorList.get(4), sword1);
        assertEquals(armorList.get(5), shield1);
    }

    @Test
    void testAddAllAtIndexOutOfRange() {
        Collection<Armor> c = new ArrayList<>();

        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(shield);

        String excMess1 = "Index should be in the range of size.";
        c.add(helmet);
        c.add(sword);

        IllegalArgumentException exc1 = assertThrows(IllegalArgumentException.class, () -> {
            armorList.addAll(8, c);
        });

        assertEquals(excMess1, exc1.getMessage());

        IllegalArgumentException exc2 = assertThrows(IllegalArgumentException.class, () -> {
            armorList.addAll(-8, c);
        });

        assertEquals(excMess1, exc2.getMessage());
    }

    @Test
    void testAddAllAtIndexContainNull() {
        Collection<Armor> c = new ArrayList<>();
        String excMess = "Cannot contain null!";
        c.add(null);

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            armorList.addAll(c);
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testRemoveAllEmptyCollection() {
        Collection<Object> c = new ArrayList<>();
        assertTrue(armorList.removeAll(c));
    }

    @Test
    void testRemoveAll() {
        Collection<Object> c = new ArrayList<>();

        c.add(helmet);
        c.add(sword);

        armorList.add(helmet);
        armorList.add(shield);
        armorList.add(sword);
        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(sword);

        assertTrue(armorList.removeAll(c));
        assertEquals(1, armorList.size());
        assertFalse(armorList.contains(helmet));
        assertFalse(armorList.contains(sword));
    }

    @Test
    void testRetainAllValid() {
        Collection<Object> c = new ArrayList<>();
        List<Armor> expected = new ArrayList<>();

        c.add(shield);
        c.add(sword);

        armorList.add(helmet);
        armorList.add(shield);
        armorList.add(sword);

        expected.add(shield);
        expected.add(sword);

        assertTrue(armorList.retainAll(c));
        assertArrayEquals(expected.toArray(), armorList.toArray());
    }

    @Test
    void testRetainAllNullElement() {
        Collection<Object> c = new ArrayList<>();
        String excMess = "Cannot contain null!";
        c.add(null);

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            armorList.retainAll(c);
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testClear() {
        armorList.add(helmet);
        armorList.add(sword);

        armorList.clear();

        assertEquals(0, armorList.size());
    }

    @Test
    void testGetValid() {
        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(shield);

        assertEquals(helmet, armorList.get(0));
        assertEquals(sword, armorList.get(1));
        assertEquals(shield, armorList.get(2));
    }

    @Test
    void testGetIndexOutOfRange() {
        String excMess1 = "Index should be in the range of size.";

        IllegalArgumentException exc1 = assertThrows(IllegalArgumentException.class, () -> {
            armorList.get(-3);
        });

        assertEquals(excMess1, exc1.getMessage());

        IllegalArgumentException exc2 = assertThrows(IllegalArgumentException.class, () -> {
            armorList.get(4);
        });

        assertEquals(excMess1, exc2.getMessage());
    }

    @Test
    void testSetAtTheBeginning() {
        List<Armor> expected = new ArrayList<>();

        expected.add(helmet);
        expected.add(shield);
        expected.add(helmet);

        armorList.add(sword);
        armorList.add(shield);
        armorList.add(helmet);

        assertEquals(sword, armorList.set(0, helmet));
        assertEquals(expected.size(), armorList.size());
        assertArrayEquals(expected.toArray(), armorList.toArray());
    }

    @Test
    void testSetInTheMiddle() {
        List<Armor> expected = new ArrayList<>();

        expected.add(sword);
        expected.add(helmet);
        expected.add(helmet);

        armorList.add(sword);
        armorList.add(shield);
        armorList.add(helmet);

        assertEquals(shield, armorList.set(1, helmet));
        assertEquals(expected.size(), armorList.size());
        assertArrayEquals(expected.toArray(), armorList.toArray());
    }

    @Test
    void testSetAtTheEnd() {
        List<Armor> expected = new ArrayList<>();

        expected.add(sword);
        expected.add(helmet);
        expected.add(helmet);

        armorList.add(sword);
        armorList.add(helmet);
        armorList.add(shield);

        assertEquals(shield, armorList.set(2, helmet));
        assertEquals(expected.size(), armorList.size());
        assertArrayEquals(expected.toArray(), armorList.toArray());
    }

    @Test
    void testSetIndexOutOfRange() {
        String excMess1 = "Index should be in the range of size.";

        IllegalArgumentException exc1 = assertThrows(IllegalArgumentException.class, () -> {
            armorList.set(-3, helmet);
        });

        assertEquals(excMess1, exc1.getMessage());

        IllegalArgumentException exc2 = assertThrows(IllegalArgumentException.class, () -> {
            armorList.set(4, helmet);
        });

        assertEquals(excMess1, exc2.getMessage());
    }

    @Test
    void testSetNullElement() {
        String excMess = "Cannot be null!";
        armorList.add(helmet);

        ArmorException exc = assertThrows(ArmorException.class, () -> {
            armorList.set(0, null);
        });

        assertEquals(excMess, exc.getMessage());
    }

    @Test
    void testAddAtIndexValidAtBeginning() {
        Helmet helmet1 = new Helmet("h1", 100, 1);

        armorList.add(0, helmet);

        assertEquals(1, armorList.size());
        assertEquals(armorList.get(0), helmet);

        armorList.add(sword);
        armorList.add(shield);

        armorList.add(0, helmet1);

        assertEquals(4, armorList.size());
        assertEquals(armorList.get(0), helmet1);
        assertEquals(armorList.get(1), helmet);
    }

    @Test
    void testAddAtIndexValidAtMiddle() {
        Helmet helmet1 = new Helmet("h1", 100, 1);
        Sword sword1 = new Sword("sw1", 123, 4.4);
        Shield shield1 = new Shield("s1", 200, 5.2);

        armorList.add(helmet1);
        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(sword1);

        armorList.add(2, shield1);

        assertEquals(5, armorList.size());
        assertEquals(armorList.get(1), helmet);
        assertEquals(armorList.get(2), shield1);
        assertEquals(armorList.get(3), sword);
    }

    @Test
    void testAddAtIndexOutRange() {
        String excMess1 = "Index should be in the range of size.";

        IllegalArgumentException exc1 = assertThrows(IllegalArgumentException.class, () -> {
            armorList.add(-2, helmet);
        });

        assertEquals(excMess1, exc1.getMessage());

        IllegalArgumentException exc2 = assertThrows(IllegalArgumentException.class, () -> {
            armorList.add(10, shield);
        });

        assertEquals(excMess1, exc2.getMessage());
    }

    @Test
    void testRemoveAtIndexAtBeginning() {
        List<Armor> expected = new ArrayList<>();

        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(shield);

        expected.add(sword);
        expected.add(shield);

        assertEquals(helmet, armorList.remove(0));
        assertArrayEquals(expected.toArray(), armorList.toArray());
    }

    @Test
    void testRemoveAtIndexAtMiddle() {
        List<Armor> expected = new ArrayList<>();

        expected.add(helmet);
        expected.add(shield);

        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(shield);

        assertEquals(sword, armorList.remove(1));
        assertArrayEquals(expected.toArray(), armorList.toArray());
    }

    @Test
    void testRemoveAtIndexAtEnd() {
        List<Armor> expected = new ArrayList<>();

        armorList.add(shield);
        armorList.add(helmet);
        armorList.add(sword);

        expected.add(shield);
        expected.add(helmet);

        assertEquals(sword, armorList.remove(2));
        assertArrayEquals(expected.toArray(), armorList.toArray());
    }

    @Test
    void testRemoveAtIndexOutOfRange() {
        String excMess1 = "Index should be in the range of size.";

        IndexOutOfBoundsException exc1 = assertThrows(IndexOutOfBoundsException.class, () -> {
            armorList.remove(-2);
        });

        assertEquals(excMess1, exc1.getMessage());

        IndexOutOfBoundsException exc2 = assertThrows(IndexOutOfBoundsException.class, () -> {
            armorList.remove(10);
        });

        assertEquals(excMess1, exc2.getMessage());
    }

    @Test
    void testIndexOf() {
        armorList.add(helmet);
        armorList.add(shield);
        armorList.add(helmet);

        assertEquals(0, armorList.indexOf(helmet));
        assertEquals(1, armorList.indexOf(shield));
        assertEquals(-1, armorList.indexOf(sword));
    }

    @Test
    void testLastIndexOf() {
        armorList.add(helmet);
        armorList.add(shield);
        armorList.add(shield);
        armorList.add(helmet);

        assertEquals(3, armorList.lastIndexOf(helmet));
        assertEquals(2, armorList.lastIndexOf(shield));
        assertEquals(-1, armorList.lastIndexOf(sword));
    }

    @Test
    void testSubListEmptyCollection() {
        List<Armor> expected = new ArrayList<>();
        List<Armor> actual;

        armorList.add(helmet);
        actual = armorList.subList(0, 0);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void testSubListInTheMiddle() {
        List<Armor> expected = new ArrayList<>();
        List<Armor> actual;

        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(sword);
        armorList.add(shield);
        armorList.add(helmet);

        expected.add(sword);
        expected.add(sword);
        expected.add(shield);

        actual = armorList.subList(1, 3);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void testSubListAtTheEnd() {
        List<Armor> expected = new ArrayList<>();
        List<Armor> actual;

        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(sword);
        armorList.add(shield);
        armorList.add(helmet);
        armorList.add(shield);
        armorList.add(helmet);

        expected.add(shield);
        expected.add(helmet);

        actual = armorList.subList(5, 6);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void testSubListSameIndex() {
        List<Armor> expected = new ArrayList<>();

        List<Armor> actual;
        armorList.add(helmet);
        armorList.add(sword);
        armorList.add(sword);
        armorList.add(shield);
        armorList.add(helmet);
        armorList.add(shield);
        armorList.add(helmet);

        actual = armorList.subList(3, 3);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}