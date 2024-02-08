import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedIntListTest {
    DoublyLinkedIntList list = new DoublyLinkedIntList();
    @Test
    void addFront() {
        list.addFront(10);
        list.addFront(20);
        list.addFront(30);

        // Verify the size of the list
        assertEquals(3, list.size());

        // Verify the elements and their order in the list
        assertEquals(30, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(10, list.get(2));
    }

    @Test
    void addBack() {
        list.addBack(10);
        list.addBack(10);
        list.addBack(10);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(10, list.get(2));
    }

    @Test
    void add() {
        list.addBack(10);
        list.addBack(20);
        list.addBack(30);
        //10 20 30
        list.add(1,5);
        //10 5 20 30
        assertEquals(4,list.size());
        assertEquals(10, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(20, list.get(2));
        assertEquals(30, list.get(3));


    }

    @Test
    void removeFront() {
        list.addBack(10);
        list.addBack(20);
        list.addBack(30);
        //10 20 30
        list.removeFront();
        //20 30
        assertEquals(2,list.size());
        assertEquals(20, list.get(0));
        assertEquals(30, list.get(1));

    }

    @Test
    void removeBack() {
        list.addBack(10);
        list.addBack(20);
        list.addBack(30);
        list.removeBack();
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        list.removeBack();
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void remove() {
        list.addFront(10);
        list.addBack(20);
        list.addBack(30);
        //10 20 30
        list.remove(1);
        assertEquals(2,list.size());
        assertEquals(10,list.get(0));
        assertEquals(30,list.get(1));


    }

    @Test
    void get() {
        list.addFront(10);
        list.addBack(20);
        list.addBack(30);
        //10 20 30
        assertEquals(10,list.get(0));
        assertEquals(20,list.get(1));
        assertEquals(30,list.get(2));



    }

    @Test
    void contains() {
        list.addBack(10);
        list.addBack(20);
        list.addBack(30);
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertTrue(list.contains(30));
        assertFalse(list.contains(40));
    }

    @Test
    void indexOf() {
        list.addBack(10);
        list.addBack(20);
        list.addBack(30);
        //10 20 30
        assertEquals(1,list.indexOf(20));
        assertEquals(0,list.indexOf(10));
        assertEquals(2,list.indexOf(30));

    }

    @Test
    void isEmpty() {
        list.addBack(10);
        list.addBack(20);
        list.addBack(30);
        assertFalse(list.isEmpty());
        list.removeBack();
        list.removeBack();
        list.removeBack();
        assertTrue(list.isEmpty());
    }

    @Test
    void size() {
        list.addFront(10);
        list.addFront(10);
        list.addFront(10);

        assertEquals(3, list.size());
        list.addFront(10);
        list.addFront(10);
        list.addFront(10);
        assertEquals(6, list.size());


    }

    @Test
    void clear() {
        list.addFront(10);
        list.addFront(10);
        list.addFront(10);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void iterator() {
    }
}