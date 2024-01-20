import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {
    ArrayIntList testList = new ArrayIntList();

    @org.junit.jupiter.api.Test
    void addFront() {
        testList.addFront(3);
        assertEquals(3, testList.get(0));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        testList.addBack(4);
        assertEquals(4, testList.get(testList.size() - 1));
    }

    @org.junit.jupiter.api.Test
    void add() {
        testList.add(1,7);
        assertEquals(7, testList.get(2));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }
}