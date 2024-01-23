import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList testLink = new LinkedList();
    
    @Test
    void addFront() {
        //catches empty array when a get is used to verify it returns the correct error.
        try {
            testLink.get(0);
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        testLink.addFront(3);
        assertEquals(3, testLink.get(0));
        testLink.addFront(5);
        assertEquals(5, testLink.get(0));
    }

    @Test
    void addBack() {
        testLink.addBack(4);
        testLink.addBack(7);
        assertEquals(7, testLink.get(testLink.size() - 1));
    }

    @Test
    void add() {

        //catches an attempt to add a value outside the size of the array
        try {
            testLink.add(77,1);
            fail();
        } catch (Exception e) {
            final String expected = "Index out of bounds";
            assertEquals(expected, e.getMessage());
        }

        testLink.addFront(3);
        for(int i = 0; i < 7; i++) {
            testLink.add(i, (i+1)*2);
        }
        assertEquals(2, testLink.get(0));
        testLink.add(7,66);
        assertEquals(66, testLink.get(7));
    }

    @Test
    void removeFront() {
        //catches empty array when an attempt to remove the value from the front of an empty array is made
        try {
            testLink.removeFront();
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        testLink.addFront(3);
        testLink.addFront(4);
        testLink.removeFront();
        assertEquals(3, testLink.get(0));
    }

    @Test
    void removeBack() {
        //catches empty array when an attempt to remove the value from the back of an empty array is made
        try {
            testLink.removeBack();
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        testLink.addFront(11);
        testLink.addBack(12);
        testLink.removeBack();
        assertEquals(11, testLink.get(testLink.size() - 1));
    }

    @Test
    void remove() {
        //catches empty array when an attempt to remove an element from an empty array is made
        try {
            testLink.remove(7);
            fail();
        } catch (Exception e) {
            final String expected = "Index out of bounds";
            assertEquals(expected, e.getMessage());
        }
        testLink.addFront(99);
        testLink.remove(0);
        assertEquals(0, testLink.size());

        for(int i = 0; i < 5; i++){
            testLink.addFront(i);
        }
        testLink.remove(1);
        assertEquals(4, testLink.get(0));
        assertEquals(2, testLink.get(1));
        assertEquals(1, testLink.get(2));
        assertEquals(0, testLink.get(3));
    }

    @Test
    void get() {
        //catches empty array when a get is used to verify it returns the correct error.
        try {
            testLink.get(0);
            fail();
        } catch (Exception e) {
            final String expected = "The list is empty";
            assertEquals(expected, e.getMessage());
        }
        for(int i = 0; i < 5; i++){
            testLink.addFront(i);
        }
        assertEquals(4, testLink.get(0));
        assertEquals(3, testLink.get(1));
        assertEquals(2, testLink.get(2));
        assertEquals(1, testLink.get(3));
        assertEquals(0, testLink.get(4));
    }

    @Test
    void contains() {
        assertFalse(testLink.contains(2));
        for(int i = 5; i < 10; i++){
            testLink.addFront(i);
        }
        assertTrue(testLink.contains(6));
        assertTrue(testLink.contains(8));
        assertFalse(testLink.contains(10));
        assertFalse(testLink.contains(-10));
    }

    @Test
    void indexOf() {
        for(int i = 5; i < 10; i++){
            testLink.addFront(i);
        }
        assertEquals(-1, testLink.indexOf(4));
        assertEquals(-1, testLink.indexOf(-4));
        assertEquals(1, testLink.indexOf(8));
        assertEquals(2, testLink.indexOf(7));
    }

    @Test
    void isEmpty() {
        assertTrue(testLink.isEmpty());
        testLink.addFront(2);
        assertFalse(testLink.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, testLink.size());
        testLink.addFront(1);
        assertEquals(1, testLink.size());
        for(int i = 0; i < 5; i++){
            testLink.addFront(i);
        }
        assertEquals(6, testLink.size());
    }

    @Test
    void clear() {
        testLink.addFront(1);
        testLink.clear();
        assertEquals(0, testLink.size());
    }
}