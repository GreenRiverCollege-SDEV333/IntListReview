import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedList testDouble = new DoublyLinkedList();

    @Test
    void addFront() {
        //catches empty array when a get is used to verify it returns the correct error.
        try {
            testDouble.get(0);
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        testDouble.addFront(3);
        assertEquals(3, testDouble.get(0));
        testDouble.addFront(5);
        assertEquals(5, testDouble.get(0));
    }

    @Test
    void addBack() {
        testDouble.addBack(4);
        testDouble.addBack(7);
        assertEquals(7, testDouble.get(testDouble.size() - 1));
    }

    @Test
    void add() {

        //catches an attempt to add a value outside the size of the array
        try {
            testDouble.add(77, 1);
            fail();
        } catch (Exception e) {
            final String expected = "Index out of bounds";
            assertEquals(expected, e.getMessage());
        }

        testDouble.addFront(3);
        for (int i = 0; i < 7; i++) {
            testDouble.add(i, (i + 1) * 2);
        }
        assertEquals(2, testDouble.get(0));
        testDouble.add(7, 66);
        assertEquals(66, testDouble.get(7));
    }

    @Test
    void removeFront() {
        //catches empty array when an attempt to remove the value from the front of an empty array is made
        try {
            testDouble.removeFront();
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        testDouble.addFront(3);
        testDouble.addFront(4);
        testDouble.removeFront();
        assertEquals(3, testDouble.get(0));
    }

    @Test
    void removeBack() {
        //catches empty array when an attempt to remove the value from the back of an empty array is made
        try {
            testDouble.removeBack();
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        testDouble.addFront(11);
        testDouble.addBack(12);
        testDouble.removeBack();
        assertEquals(11, testDouble.get(testDouble.size() - 1));
    }

    @Test
    void remove() {
        //catches empty array when an attempt to remove an element from an empty array is made
        try {
            testDouble.remove(7);
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        for (int i = 0; i < 5; i++) {
            testDouble.addFront(i);
        }
        testDouble.remove(2);
        assertEquals(4, testDouble.get(0));
        assertEquals(3, testDouble.get(1));
        assertEquals(1, testDouble.get(2));
        assertEquals(0, testDouble.get(3));
    }

    @Test
    void get() {
        //catches empty array when a get is used to verify it returns the correct error.
        try {
            testDouble.get(0);
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        for (int i = 0; i < 5; i++) {
            testDouble.addFront(i);
        }
        assertEquals(4, testDouble.get(0));
        assertEquals(3, testDouble.get(1));
        assertEquals(2, testDouble.get(2));
        assertEquals(1, testDouble.get(3));
        assertEquals(0, testDouble.get(4));
    }

    @Test
    void contains() {
        for (int i = 5; i < 10; i++) {
            testDouble.addFront(i);
        }
        assertTrue(testDouble.contains(6));
        assertTrue(testDouble.contains(8));
        assertFalse(testDouble.contains(10));
        assertFalse(testDouble.contains(-10));
    }

    @Test
    void indexOf() {
        for (int i = 5; i < 10; i++) {
            testDouble.addFront(i);
        }
        assertEquals(-1, testDouble.indexOf(4));
        assertEquals(-1, testDouble.indexOf(-4));
        assertEquals(1, testDouble.indexOf(8));
        assertEquals(2, testDouble.indexOf(7));
    }

    @Test
    void isEmpty() {
        assertTrue(testDouble.isEmpty());
        testDouble.addFront(2);
        assertFalse(testDouble.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, testDouble.size());
        testDouble.addFront(1);
        assertEquals(1, testDouble.size());
        for (int i = 0; i < 5; i++) {
            testDouble.addFront(i);
        }
        assertEquals(6, testDouble.size());
    }

    @Test
    void clear() {
        testDouble.addFront(1);
        testDouble.clear();
        assertEquals(0, testDouble.size());
    }
}