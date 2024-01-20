import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {
    ArrayIntList testList = new ArrayIntList();

    @org.junit.jupiter.api.Test
    void addFront() {
        //catches empty array when a get is used to verify it returns the correct error.
        try {
            testList.get(0);
            fail();
        } catch (Exception e) {
            final String expected = "Index cannot be outside the size of the array.";
            assertEquals(expected, e.getMessage());
        }
        testList.addFront(3);
        assertEquals(3, testList.get(0));
        testList.addFront(5);
        assertEquals(5, testList.get(0));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        testList.addBack(4);
        testList.addBack(7);
        assertEquals(7, testList.get(testList.size() - 1));
    }

    @org.junit.jupiter.api.Test
    void add() {

        //catches an attempt to add a value outside the size of the array
        try {
            testList.add(77,1);
            fail();
        } catch (Exception e) {
            final String expected = "Index ouf of bounds. NOPE!";
            assertEquals(expected, e.getMessage());
        }

        testList.addFront(3);
        for(int i = 0; i < 7; i++) {
            testList.add(i, (i+1)*2);
        }
        assertEquals(2, testList.get(0));
        testList.add(7,66);
        assertEquals(66, testList.get(7));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        //catches empty array when an attempt to remove the value from the front of an empty array is made
        try {
            testList.removeFront();
            fail();
        } catch (Exception e) {
            final String expected = "Cannot remove element from empty array";
            assertEquals(expected, e.getMessage());
        }
        testList.addFront(3);
        testList.addFront(4);
        testList.removeFront();
        assertEquals(3, testList.get(0));
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        //catches empty array when an attempt to remove the value from the back of an empty array is made
        try {
            testList.removeBack();
            fail();
        } catch (Exception e) {
            final String expected = "Cannot remove element from empty array";
            assertEquals(expected, e.getMessage());
        }
        testList.addFront(11);
        testList.addBack(12);
        testList.removeBack();
        assertEquals(11, testList.get(testList.size() - 1));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        //catches empty array when an attempt to remove an element from an empty array is made
        try {
            testList.remove(7);
            fail();
        } catch (Exception e) {
            final String expected = "Index cannot be greater than array length";
            assertEquals(expected, e.getMessage());
        }
        for(int i = 0; i < 5; i++){
            testList.addFront(i);
        }
        testList.remove(2);
        assertEquals(4, testList.get(0));
        assertEquals(3, testList.get(1));
        assertEquals(1, testList.get(2));
        assertEquals(0, testList.get(3));
    }

    @org.junit.jupiter.api.Test
    void get() {
        //catches empty array when a get is used to verify it returns the correct error.
        try {
            testList.get(0);
            fail();
        } catch (Exception e) {
            final String expected = "Index cannot be outside the size of the array.";
            assertEquals(expected, e.getMessage());
        }
        for(int i = 0; i < 5; i++){
            testList.addFront(i);
        }
        assertEquals(4, testList.get(0));
        assertEquals(3, testList.get(1));
        assertEquals(2, testList.get(2));
        assertEquals(1, testList.get(3));
        assertEquals(0, testList.get(4));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        for(int i = 5; i < 10; i++){
            testList.addFront(i);
        }
        assertTrue(testList.contains(6));
        assertTrue(testList.contains(8));
        assertFalse(testList.contains(10));
        assertFalse(testList.contains(-10));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        for(int i = 5; i < 10; i++){
            testList.addFront(i);
        }
        assertEquals(-1, testList.indexOf(4));
        assertEquals(-1, testList.indexOf(-4));
        assertEquals(1, testList.indexOf(8));
        assertEquals(2, testList.indexOf(7));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(testList.isEmpty());
        testList.addFront(2);
        assertFalse(testList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(0, testList.size());
        testList.addFront(1);
        assertEquals(1, testList.size());
        for(int i = 0; i < 5; i++){
            testList.addFront(i);
        }
        assertEquals(6, testList.size());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        testList.addFront(1);
        testList.clear();
        assertEquals(0, testList.size());
    }
}