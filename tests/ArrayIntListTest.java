import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    // ArrayIntList for testing
    ArrayIntList testEmpty = new ArrayIntList();
    ArrayIntList testSingle = fillArray(1);

    ArrayIntList testPartial= fillArray(5);
    ArrayIntList testFull = fillArray(10);

    // used to fill array with values for testing
    public ArrayIntList fillArray(int numValues) {
        ArrayIntList arr = new ArrayIntList();
        for(int i = numValues; i > 0; i--) {
            arr.addFront(i);
        }

        return arr;
    }

    @org.junit.jupiter.api.Test
    void addFront() {
        // tests empty
        testEmpty.addFront(3);
        int resultOfTest1 = testEmpty.get(0);
        assertEquals(3, resultOfTest1);

        // tests one item
        testSingle.addFront(2);
        int resultOfTest2 = testSingle.get(0);
        assertEquals(2, resultOfTest2);

        // test partially full
        testPartial.addFront(7);
        int resultOfTest3 = testPartial.get(0);
        assertEquals(1, resultOfTest3);

        // tests full
        testFull.addFront(11);
        int resultOfTest4 = testFull.get(0);
        assertEquals(11, resultOfTest4);
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        // tests empty
        testEmpty.addBack(12);
        int resultOfTest1 = testEmpty.get(testEmpty.size() - 1);
        assertEquals(12, resultOfTest1);

        // tests one item
        testSingle.addBack(1);
        int resultOfTest2 = testSingle.get(testSingle.size() - 1);
        assertEquals(1, resultOfTest2);

        // test partially full
        testPartial.addBack(35);
        int resultOfTest3 = testPartial.get(testPartial.size() - 1);
        assertEquals(35, resultOfTest3);

        // tests full
        testFull.addBack(11);
        int resultOfTest4 = testFull.get(testFull.size() - 1);
        assertEquals(11, resultOfTest4);
    }

    @org.junit.jupiter.api.Test
    void add() {
        // tests empty
        testEmpty.add(3,12);
        int resultOfTest1 = testEmpty.get(3);
        assertEquals(12, resultOfTest1);

        // tests one item
        testSingle.add(8, 1);
        int resultOfTest2 = testSingle.get(8);
        assertEquals(1, resultOfTest2);

        // test partially full
        testPartial.add(7, 35);
        int resultOfTest3 = testPartial.get(7);
        assertEquals(35, resultOfTest3);

        // tests full
        testFull.add(2, 11);
        int resultOfTest4 = testFull.get(2);
        assertEquals(11, resultOfTest4);
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        // tests empty
        int resultOfTest1 = testEmpty.get(0);
        testEmpty.removeFront();
        assertEquals(0, resultOfTest1);

        // tests one item
        int resultOfTest2 = testSingle.get(0);
        testSingle.removeFront();
        assertEquals(1, resultOfTest2);
        assertEquals(0, testSingle.size());

        // test partially full
        int resultOfTest3 = testPartial.get(0);
        testPartial.removeFront();
        assertEquals(1, resultOfTest3);
        assertEquals(4, testPartial.size());

        // tests full
        int resultOfTest4 = testFull.get(0);
        testFull.removeFront();
        assertEquals(1, resultOfTest4);
        assertEquals(9, testFull.size());
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        // tests empty
        int resultOfTest1 = testEmpty.get(testEmpty.size() - 1);
        testEmpty.removeBack();
        assertEquals(0, resultOfTest1);
        assertEquals(0, testEmpty.size());

        // tests one item
        int resultOfTest2 = testSingle.get(0);
        testSingle.removeBack();
        assertEquals(1, resultOfTest2);
        assertEquals(0, testSingle.size());

        // test partially full
        int resultOfTest3 = testPartial.get(testPartial.size() - 1);
        testPartial.removeBack();
        assertEquals(5, resultOfTest3);
        assertEquals(4, testPartial.size());

        // tests full
        int resultOfTest4 = testFull.get(testFull.size() - 1);
        testFull.removeFront();
        assertEquals(10, resultOfTest4);
        assertEquals(9, testFull.size());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        // tests empty
        int resultOfTest1 = testEmpty.get(testEmpty.size() - 1);
        testEmpty.remove(3);
        assertEquals(0, resultOfTest1);
        assertEquals(0, testEmpty.size());

        // tests one item
        int resultOfTest2 = testSingle.get(0);
        testSingle.remove(0);
        assertEquals(1, resultOfTest2);
        assertEquals(0, testSingle.size());

        // test partially full
        int resultOfTest3 = testPartial.get(2);
        testPartial.remove(2);
        assertEquals(3, resultOfTest3);
        assertEquals(4, testPartial.size());

        // tests full
        int resultOfTest4 = testFull.get(4);
        testFull.remove(4);
        assertEquals(5, resultOfTest4);
        assertEquals(9, testFull.size());
    }

    @org.junit.jupiter.api.Test
    void get() {
        // tests empty
        assertEquals(0, testEmpty.get(5));

        // tests one item
        assertEquals(1, testSingle.get(0));

        // test partially full
        assertEquals(4, testPartial.get(3));

        // tests full
        assertEquals(9, testFull.get(8));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        // tests empty
        assertFalse(testEmpty.contains(3));

        // tests one item
        assertTrue(testSingle.contains(1));
        assertFalse(testSingle.contains(2));

        // test partially full
        assertTrue(testPartial.contains(5));
        assertFalse(testPartial.contains(6));

        // tests full
        assertTrue(testFull.contains(10));
        assertFalse(testFull.contains(11));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        // tests empty
        assertEquals(-1, testEmpty.indexOf(5));

        // tests one item
        assertEquals(0, testSingle.indexOf(1));
        assertEquals(-1, testSingle.indexOf(2));

        // test partially full
        assertEquals(2, testPartial.indexOf(3));
        assertEquals(-1, testPartial.indexOf(6));

        // tests full
        assertEquals(7, testFull.indexOf(8));
        assertEquals(-1, testFull.indexOf(11));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        // tests empty
        assertTrue(testEmpty.isEmpty());

        // tests one item
        assertFalse(testSingle.isEmpty());

        // test partially full
        assertFalse(testPartial.isEmpty());

        // tests full
        assertFalse(testFull.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        // tests empty
        assertEquals(0, testEmpty.size());

        // tests one item
        assertEquals(1, testSingle.size());

        // test partially full
        assertEquals(5, testPartial.size());

        // tests full
        assertEquals(10, testFull.size());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        // tests empty
        testEmpty.clear();
        assertEquals(0, testEmpty.size());

        // tests one item
        assertFalse(testSingle.isEmpty());
        testSingle.clear();
        assertEquals(0, testSingle.size());

        // test partially full
        assertFalse(testPartial.isEmpty());
        testPartial.clear();
        assertEquals(0, testPartial.size());

        // tests full
        assertFalse(testFull.isEmpty());
        testFull.clear();
        assertEquals(0, testFull.size());
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        // tests empty
        assertFalse(testEmpty.iterator().hasNext());

        // tests partial
        assertTrue(testPartial.iterator().hasNext());
    }
}