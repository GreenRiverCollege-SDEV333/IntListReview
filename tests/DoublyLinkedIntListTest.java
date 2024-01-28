import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedIntListTest {

    @Test
    void addFront() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        assertEquals(0, list.size()); // test by checking size and indices
        list.addFront(12);
        assertEquals(12, list.get(0));
        list.addFront(45);
        assertEquals(45, list.get(0));
        assertEquals(2, list.size());
    }

    @Test
    void addBack() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        assertEquals(0, list.size()); // test by checking size and indices
        list.addBack(12);
        assertEquals(12, list.get(list.size()-1));
        list.addBack(45);
        assertEquals(45, list.get(list.size()-1));
        assertEquals(2, list.size());
    }

    @Test
    void add() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        assertEquals(0, list.size()); // test by checking size and indices
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
        list.addBack(12);
        assertEquals(1, list.size()); // test by checking size and indices
        list.removeFront();
        list.addBack(44);
        list.addBack(32);
        list.addBack(19);
        list.addBack(87);
        assertEquals(4, list.size());
        assertEquals(44, list.get(0));
        list.removeFront();
        assertEquals(3, list.size());
        assertEquals(32, list.get(0));
        list.removeFront();
        assertEquals(2, list.size());
        assertEquals(19, list.get(0));
        list.removeFront();
        assertEquals(1, list.size());
        assertEquals(87, list.get(0));
        list.removeFront();
        assertEquals(0, list.size());
    }

    @Test
    void removeBack() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        list.addBack(12);
        assertEquals(1, list.size()); // test by checking size and indices
        list.removeBack();
        assertEquals(0, list.size());
        list.addBack(14);
        list.addBack(19);
        list.addBack(44);
        list.addBack(31);
        assertEquals(4, list.size());
        assertEquals(31, list.get(list.size()-1));
        list.removeBack();
        assertEquals(3, list.size());
        assertEquals(44, list.get(list.size()-1));
        list.removeBack();
        assertEquals(2, list.size());
        assertEquals(19, list.get(list.size()-1));
        list.removeBack();
        assertEquals(1, list.size());
        assertEquals(14, list.get(list.size()-1));
        list.removeBack();
        assertEquals(0, list.size());
    }

    @Test
    void remove() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        list.addBack(12);
        assertEquals(1, list.size()); // test by checking size and indices
        list.remove(0);
        assertEquals(0, list.size());
        list.addBack(22);
        list.addBack(16);
        list.addBack(4);
        list.addBack(99);
        list.addBack(28);
        assertEquals(5, list.size());
        assertEquals(16, list.get(1));
        list.remove(1);
        assertEquals(4, list.get(1));
        assertEquals(4, list.size());
        list.remove(0);
        assertEquals(4, list.get(0));
        assertEquals(3, list.size());
    }

    @Test
    void get() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        list.addBack(22); // test by adding values
        assertEquals(22, list.get(0));
        list.addBack(45);
        list.addBack(45);
        list.addBack(20);
        list.addBack(19);
        list.addBack(33);
        list.addBack(16);
        assertEquals(45, list.get(1));
        assertEquals(45, list.get(2));
        assertEquals(19, list.get(4));
        assertEquals(16, list.get(list.size()-1));
    }

    @Test
    void contains() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        list.addBack(22); // test by adding values
        list.addBack(10);
        list.addBack(3);
        list.addBack(65);
        list.addBack(9);
        assertEquals(true, list.contains(3));
        assertEquals(false, list.contains(44));
        assertEquals(true, list.contains(9));
        assertEquals(false, list.contains(900));
        assertEquals(false, list.contains(101));
        assertEquals(true, list.contains(10));
        assertEquals(true, list.contains(22));
    }

    @Test
    void indexOf() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        list.addBack(22); // test by adding values
        list.addBack(44);
        list.addBack(68);
        list.addBack(31);
        list.addBack(11);
        list.addBack(22);
        assertEquals(0, list.indexOf(22));
        assertEquals(-1, list.indexOf(20));
        assertEquals(3, list.indexOf(31));
        assertEquals(4, list.indexOf(11));
        assertEquals(-1, list.indexOf(2298473));
    }

    @Test
    void isEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        assertEquals(true, list.isEmpty());
        list.addFront(12); // test by adding values and clearing the list
        assertEquals(false, list.isEmpty());
        list.addFront(14);
        list.addFront(16);
        list.addFront(19);
        assertEquals(false, list.isEmpty());
        list.clear();
        assertEquals(true, list.isEmpty());
    }

    @Test
    void size() {
        DoublyLinkedIntList list = new DoublyLinkedIntList(); // empty list for testing
        assertEquals(0, list.size());
        list.addFront(12); // test by adding and removing values
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
        list.addFront(12);
        assertEquals(1, list.size()); // test size for clear()
        list.clear();
        assertEquals(0, list.size());
        list.addFront(14);
        list.addFront(33);
        list.addFront(98);
        list.addFront(22);
        assertEquals(4, list.size());
        list.clear();
        assertEquals(0, list.size());
    }
}