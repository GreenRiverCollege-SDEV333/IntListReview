import org.junit.jupiter.api.Test;

import java.util.Optional;

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
        //10 20
        list.add(0,0);
        //0 10 20
        list.add(1,30);
        //0 30 10 20
        assertEquals(0, list.get(0));
        assertEquals(30, list.get(1));
        assertEquals(10, list.get(2));
        assertEquals(20, list.get(3));

    }

    @Test
    void removeFront() {
        LinkedIntList list = new LinkedIntList();

        list.addFront(10);
        list.addFront(20);
        list.addFront(30);
        // 30 20 10
        list.removeFront();
        assertEquals(20, list.get(0));
        // 20 10
        list.removeFront();
        //10
        assertEquals(10, list.get(0));

    }

    @Test
    void removeBack() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(10);
        list.addFront(20);
        list.addFront(30);
        // 30 20 10
        list.removeBack();
        //30 20
        assertEquals(30, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(2,list.size());


    }

    @Test
    void remove() {
        LinkedIntList list = new LinkedIntList();
        list.addFront(10);
        list.addFront(20);
        list.addFront(30);
        // 30 20 10
        list.remove(1);
        assertEquals(2, list.size());


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
        LinkedIntList list = new LinkedIntList();
        list.addBack(20);
        list.addFront(5);
        //5 20
        assertTrue(list.contains(5));
        assertEquals(2, list.size());
        assertTrue(list.contains(20));
        assertFalse(list.contains(15));

    }

    @Test
    void indexOf() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(20);
        list.addFront(5);
        assertEquals(1, list.indexOf(20));
        assertEquals(0, list.indexOf(5));

    }

    @Test
    void isEmpty() {
        LinkedIntList list = new LinkedIntList();
        list.addBack(10);
        list.removeBack();
        assertTrue(list.isEmpty());
        list.addBack(10);
        assertFalse(list.isEmpty());


    }

    @Test
    void size() {
        LinkedIntList list = new LinkedIntList();

        list.addFront(10);
        list.addFront(20);
        assertEquals(2,list.size());
        list.addFront(10);
        assertEquals(3,list.size());


    }

    @Test
    void clear() {
    }

    @Test
    void iterator() {
    }
}