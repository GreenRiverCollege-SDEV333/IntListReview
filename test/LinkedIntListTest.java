import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {

    @Test
    void addFront() {
        LinkedIntList list = new LinkedIntList();

        list.addFront(10);
        list.addFront(20);
        //20, 10
        assertEquals(20, list.get(0));
        assertEquals(10, list.get(1));
    }

    @Test
    void addBack() {
        LinkedIntList list = new LinkedIntList();

        list.addFront(20);
        list.addFront(10);
        list.addBack(30);
        list.addBack(40);
        //10 20 30 40
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(40, list.get(3));

    }

    @Test
    void add() {
        LinkedIntList list = new LinkedIntList();

        list.addFront(20);
        list.addFront(10);
        //10 30
        list.add(0,0);
        //0 10 30
        assertEquals(0, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(20, list.get(2));

        list.add(1,100);
        // 0 10 20 100
        assertEquals(100, list.get(3));


    }

    @Test
    void removeFront() {
    }

    @Test
    void removeBack() {
    }

    @Test
    void remove() {
    }

    @Test
    void get() {
        LinkedIntList list = new LinkedIntList();

        list.addBack(10);
        list.addFront(5);
        //5 10
        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));

    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }

    @Test
    void iterator() {
    }
}