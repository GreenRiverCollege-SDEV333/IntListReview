import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(10);
        list.addFront(20);
        list.addFront(30);
        list.addFront(100);

        //100, 30, 20, 10
        assertEquals(100, list.get(0));

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
        ArrayIntList list = new ArrayIntList();
        list.addFront(10);
        list.addFront(20);
        list.addFront(30);
        //30, 20, 10
        list.removeFront();
        //20, 10
        assertEquals(20, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(2, list.size());
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(10);
        list.addFront(20);
        list.addFront(30);
        //30, 20, 10
        list.removeBack();
        //30, 20
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void get() {
        ArrayIntList list = new ArrayIntList();
        list.add(0,0);
        list.add(1,1);
        list.add(2,2);
        list.add(3,3);
        // 0, 1, 2, 3

        //after add method, 10, 20, 100, 20, 40
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));


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