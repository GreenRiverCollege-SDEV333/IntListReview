import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedIntListTest {

    @Test
    void addFront() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        assertEquals(0, list.size());
        list.addFront(12);
        assertEquals(12, list.get(0));
        list.addFront(45);
        assertEquals(45, list.get(0));
        assertEquals(2, list.size());
    }

    @Test
    void addBack() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        assertEquals(0, list.size());
        list.addBack(12);
        assertEquals(12, list.get(list.size()-1));
        list.addBack(45);
        assertEquals(45, list.get(list.size()-1));
        assertEquals(2, list.size());
    }

    @Test
    void add() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        assertEquals(0, list.size());
        list.add(0, 12);
        assertEquals(12, list.get(0));
        list.add(1, 45);
        assertEquals(45, list.get(1));
        assertEquals(2, list.size());
        list.add(1, 24);
        assertEquals(24, list.get(1));
        assertEquals(45, list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void removeFront() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
    }

    @Test
    void removeBack() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
    }

    @Test
    void remove() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
    }

    @Test
    void get() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
    }

    @Test
    void contains() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
    }

    @Test
    void indexOf() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
    }

    @Test
    void isEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
    }

    @Test
    void size() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        assertEquals(0, list.size());
        list.addFront(12);
        assertEquals(1, list.size());
        list.addBack(55);
        assertEquals(2, list.size());
        list.add(1, 68);
        assertEquals(3, list.size());
        list.remove(1);
        assertEquals(2, list.size());
        list.removeBack();
        assertEquals(1, list.size());
        list.removeFront();
        assertEquals(0, list.size());
    }

    @Test
    void clear() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
    }
}