import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayIntListTest {

    @Test
    void addFront() {
        ArrayIntList array = new ArrayIntList();

        for (int i = 0; i < 20; i++) {
            array.addFront(i);
            assertEquals(array.get(0), i);
        }


    }

    @Test
    void addBack() {
        ArrayIntList array = new ArrayIntList();

        for (int i = 0; i < 20; i++) {
            array.addBack(i);
            assertEquals(array.get(array.size()-1), i);
        }

    }

    @Test
    void add() {
        ArrayIntList array = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> array.add(0, 8));

        for (int i = 1; i < 20; i++) {
            array.add(i, i+1);
            assertEquals(array.get(i), i+1);
        }

    }

    @Test
    void removeFront() {
        ArrayIntList array = new ArrayIntList();
        array.removeFront();
        assertEquals(array.size(), 0);

        array.addFront(6);
        array.removeFront();
        assertEquals(array.size(), 0);

        array.addFront(0);
        array.addFront(9);
        array.removeFront();
        assertEquals(array.size(), 1);

        array.addFront(0);
        array.addFront(9);
        array.removeFront();
        assertEquals(array.size(), 2);

    }

    @Test
    void removeBack() {
        ArrayIntList array = new ArrayIntList();
        array.removeBack();
        assertEquals(array.size(), 0);

        array.addFront(6);
        array.removeBack();
        assertEquals(array.size(), 0);

        array.addFront(0);
        array.addFront(9);
        array.removeBack();
        assertEquals(array.size(), 1);

        array.addFront(0);
        array.addFront(9);
        array.removeBack();
        assertEquals(array.size(), 2);

    }

    @Test
    void remove() {
        ArrayIntList array = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> array.remove(0));

        array.addFront(6);
        array.removeBack();
        assertEquals(array.size(), 0);

        array.addFront(0);
        array.addFront(9);
        array.removeBack();
        assertEquals(array.size(), 1);

        array.addFront(0);
        array.addFront(9);
        array.removeBack();
        assertEquals(array.size(), 2);
    }

    @Test
    void get() {
        ArrayIntList array = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));

        for (int i = 0; i < 20; i++) {
            array.addFront(i);
            assertEquals(array.get(0), i);
        }
    }

    @Test
    void contains() {
        ArrayIntList array = new ArrayIntList();

        assertFalse(array.contains(4));

        array.addFront(3);
        assertTrue(array.contains(3));
        assertFalse(array.contains(9));


        array.addFront(8);
        assertTrue(array.contains(3));
        assertFalse(array.contains(0));

        for (int i = 0; i < 4; i++) {
            array.addFront(i);
        }
        assertTrue(array.contains(2));
        assertFalse(array.contains(100));
    }

    @Test
    void indexOf() {
        ArrayIntList array = new ArrayIntList();
        assertEquals(array.indexOf(5), -1);

        array.addBack(3);
        assertEquals(array.indexOf(3), 0);


        array.addBack(8);
        assertEquals(array.indexOf(5), -1);
        assertEquals(array.indexOf(8), 1);


        for (int i = 0; i < 4; i++) {
            array.addBack(i);
        }
        assertEquals(array.indexOf(9), -1);
        assertEquals(array.indexOf(3), 0);

    }

    @Test
    void isEmpty() {
        ArrayIntList array = new ArrayIntList();
        assertTrue(array.isEmpty());

        for (int i = 0; i < 20; i++) {
            array.addBack(i);
            assertFalse(array.isEmpty());
        }
    }

    @Test
    void size() {
        ArrayIntList array = new ArrayIntList();
        assertEquals(array.size(), 0);

        for (int i = 1; i < 20; i++) {
            array.addBack(i);
            assertEquals(array.size(), i);
        }
    }

    @Test
    void clear() {
        ArrayIntList array = new ArrayIntList();
        array.clear();
        assertEquals(array.size(), 0);

        array.addFront(3);
        array.clear();
        assertEquals(array.size(), 0);

        array.addFront(34);
        array.addFront(6);
        array.clear();
        assertEquals(array.size(), 0);

        for (int i = 1; i < 20; i++) {
            array.addBack(i);
        }
        array.clear();
        assertEquals(array.size(), 0);


    }

}
