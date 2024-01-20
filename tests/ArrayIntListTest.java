import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {
    ArrayIntList testList = new ArrayIntList();

    @org.junit.jupiter.api.Test
    void addFront() {
        testList.addFront(3);
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
        testList.addFront(3);
        testList.addFront(4);
        testList.removeFront();
        assertEquals(3, testList.get(0));
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        testList.addFront(11);
        testList.addBack(12);
        testList.removeBack();
        assertEquals(11, testList.get(testList.size() - 1));
    }

    @org.junit.jupiter.api.Test
    void remove() {
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