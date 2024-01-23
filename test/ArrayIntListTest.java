import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(10);
        list.addBack(20);
        //current array list: 10, 20
        assertEquals(20, list.get(1));
        list.addBack(100);
        list.addBack(40);
        //current array list: 10, 20, 100, 40

        assertEquals(40, list.get(3));


    }

    @org.junit.jupiter.api.Test
    void add() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(10);
        list.addBack(20);
        list.addBack(100);
        list.addBack(40);
        // 10, 20, 100, 40
        list.add(3, 20);
        //after add method, 10, 20, 100, 20, 40
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(100, list.get(2));
        assertEquals(20, list.get(3));
        assertEquals(40, list.get(4));

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