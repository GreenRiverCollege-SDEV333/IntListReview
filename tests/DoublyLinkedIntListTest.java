import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedIntListTest {

    @Test
    void addFront() {
        LinkedIntList array = new LinkedIntList();
        for (int i = 0; i < 20; i++) {
            array.addFront(i);
            assertEquals(array.get(0), i);
        }

    }

    @Test
    void addBack() {
        LinkedIntList array = new LinkedIntList();

        for (int i = 0; i < 20; i++) {
            array.addBack(i);
            assertEquals(array.get(array.size()-1), i);
        }

    }

    @Test
    void add() {
        LinkedIntList array = new LinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> array.add(1, 8));

        for (int i = 0; i < 20; i++) {
            array.add(i, i+1);
            assertEquals(array.get(i), i+1);
        }

    }

    @Test
    void removeFront() {
        LinkedIntList array = new LinkedIntList();
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
        LinkedIntList array = new LinkedIntList();
        array.removeBack();
        assertEquals(array.size(), 0);

        array.addFront(6);
        array.removeBack();
        assertEquals(0, array.size());

        array.addFront(0);
        array.addFront(9);
        array.removeBack();
        assertEquals(1, array.size());

        array.addFront(0);
        array.addFront(9);
        array.removeBack();
        assertEquals(2, array.size());

    }

    @Test
    void remove() {
        LinkedIntList array = new LinkedIntList();
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
        LinkedIntList array = new LinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));

        for (int i = 0; i < 20; i++) {
            array.addFront(i);
            assertEquals(array.get(0), i);
        }
    }

    @Test
    void contains() {
        LinkedIntList array = new LinkedIntList();

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
        LinkedIntList array = new LinkedIntList();
        assertEquals(array.indexOf(5), -1);

        array.addBack(3);
        assertEquals(0, array.indexOf(3));


        array.addBack(8);
        assertEquals(-1, array.indexOf(5));
        assertEquals(1, array.indexOf(8));

        for (int i = 0; i < 4; i++) {
            array.addBack(i);
        }
        assertEquals(-1, array.indexOf(9));
        assertEquals(0, array.indexOf(3));


    }

    @Test
    void isEmpty() {
        LinkedIntList array = new LinkedIntList();
        assertTrue(array.isEmpty());

        for (int i = 0; i < 20; i++) {
            array.addBack(i);
            assertFalse(array.isEmpty());
        }
    }

    @Test
    void size() {
        LinkedIntList array = new LinkedIntList();
        assertEquals(array.size(), 0);

        for (int i = 1; i < 20; i++) {
            array.addBack(i);
            assertEquals(array.size(), i);
        }
    }

    @Test
    void clear() {
        LinkedIntList array = new LinkedIntList();
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
