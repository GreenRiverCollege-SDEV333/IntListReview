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
    }

    @Test
    void removeFront() {
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
    }

    @Test
    void indexOf() {
    }

    @Test
    void isEmpty() {
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
    }

    @Test
    void iterator() {
    }
}