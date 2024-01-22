import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
    }

    @org.junit.jupiter.api.Test
    void addBack() {
    }

    @org.junit.jupiter.api.Test
    void add() {
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
        ArrayIntList list = new ArrayIntList();
        assertTrue(list.isEmpty());

        ArrayIntList list2 = new ArrayIntList();
        list2.addBack(1);
        assertFalse(list2.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void Size() {
        //1st  test case
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        assertEquals(2, list.size());
        //2nd test case
        ArrayIntList list2 = new ArrayIntList();
        list2.addBack(1);
        list2.addBack(2);
        list2.remove(0);
        assertEquals(1, list2.size());
    }


    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }
}