import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {

    @Test
    void addFront() {
        LinkedIntList list = new LinkedIntList(); // new list for testing
        // add values to front, check if size has increased by 1 and the value in index 0 is correct
        list.addFront(6);
        assertEquals(1, list.size());
        assertEquals(6, list.get(0));
        list.addFront(15);
        assertEquals(2, list.size());
        assertEquals(15, list.get(0));
        list.addFront(22);
        assertEquals(3, list.size());
        assertEquals(22, list.get(0));
    }

    @Test
    void addBack() {
        LinkedIntList list = new LinkedIntList(); // new list for testing
        // add values to back, check if size has increased by 1 and the value in index size()-1 is correct
        list.addBack(6);
        assertEquals(1, list.size());
        assertEquals(6, list.get(list.size()-1));
        list.addBack(11);
        assertEquals(2, list.size());
        assertEquals(11, list.get(list.size()-1));
        list.addBack(43);
        assertEquals(3, list.size());
        assertEquals(43, list.get(list.size()-1));
    }

    @Test
    void add() {
        LinkedIntList list = new LinkedIntList(); // new list for testing
        // add index 0, check size incremented and value was added
        list.add(0, 4);
        assertEquals(1, list.size());
        assertEquals(4, list.get(0));
        // add index 1, check size incremented and value was added
        list.add(1, 29);
        assertEquals(2, list.size());
        assertEquals(29, list.get(1));
        // add NEW index 1, check size incremented and value was added
        list.add(1, 12);
        assertEquals(3, list.size());
        assertEquals(12, list.get(1));
        // check that our old index 1 was shifted to index 2
        assertEquals(29, list.get(2));
        // add index 3 at end of list, check size incremented and value was added
        list.add(3, 67);
        assertEquals(4, list.size());
        assertEquals(67, list.get(3));
        // add to index 0, check that everything got shifted over properly
        list.add(0, 99);
        assertEquals(5, list.size());
        assertEquals(99, list.get(0));
        assertEquals(4, list.get(1));
        assertEquals(12, list.get(2));
        assertEquals(29, list.get(3));
        assertEquals(67, list.get(4));
    }

    @Test
    void removeFront() {
        LinkedIntList list = new LinkedIntList(); // new list for testing
        // add values for testing
        list.addBack(12);
        list.addBack(9);
        list.addBack(44);
        list.addBack(56);
        list.addBack(20);
        list.addBack(88);
        // test size = 6
        assertEquals(6, list.size());
        // test get(0) = 12
        assertEquals(12, list.get(0));
        // remove front
        list.removeFront();
        // test size = 5
        assertEquals(5, list.size());
        // test all values shifted over
        assertEquals(9, list.get(0));
        assertEquals(44, list.get(1));
        assertEquals(56, list.get(2));
        assertEquals(20, list.get(3));
        assertEquals(88, list.get(4));
        // remove front
        list.removeFront();
        // test size = 4 (decremented)
        assertEquals(4, list.size());
        // test values shifted over
        assertEquals(44, list.get(0));
        assertEquals(56, list.get(1));
        assertEquals(20, list.get(2));
        assertEquals(88, list.get(3));
    }

    @Test
    void removeBack() {
        LinkedIntList list = new LinkedIntList(); // new list for testing
        // add 1 item
        list.addBack(12);
        // test size = 1
        assertEquals(1, list.size());
        // remove back item
        list.removeBack();
        // test size = 0
        assertEquals(0, list.size());
        list.addBack(19);
        list.addBack(44);
        list.addBack(99);
        list.addBack(10);
        list.addBack(5);
        assertEquals(5, list.size());
        assertEquals(5, list.get(list.size()-1));
        list.removeBack();
        assertEquals(4, list.size());
        assertEquals(10, list.get(list.size()-1));
        list.removeBack();
        assertEquals(3, list.size());
        assertEquals(99, list.get(list.size()-1));
        list.removeBack();
        assertEquals(2, list.size());
        assertEquals(44, list.get(list.size()-1));
        list.removeBack();
        assertEquals(1, list.size());
        assertEquals(19, list.get(list.size()-1));
        list.removeBack();
        assertEquals(0, list.size());
    }

    @Test
    void remove() {
        LinkedIntList list = new LinkedIntList(); // new list for testing
        // add 1 item
        list.addBack(12);
        // test size = 1
        assertEquals(1, list.size());
        // remove our only item
        list.remove(0);
        // test size = 0
        assertEquals(0, list.size());
        // add 4 items
        list.addBack(87);
        list.addBack(41);
        list.addBack(22);
        list.addBack(76);
        // test size = 0
        assertEquals(4, list.size());
        assertEquals(41, list.get(1));
        // remove index 1
        list.remove(1);
        // test size was decremented
        assertEquals(3, list.size());
        // test all values were shifted over
        assertEquals(87, list.get(0));
        assertEquals(22, list.get(1));
        assertEquals(76, list.get(2));

    }

    @Test
    void get() {
        LinkedIntList list = new LinkedIntList(); // new list for testing
        // add values to test get()
        list.addBack(77);
        list.addBack(21);
        list.addBack(33);
        list.addBack(10);
        list.addBack(8);
        list.addBack(68);
        list.addBack(93);
        // check that get() returns the correct values
        assertEquals(33, list.get(2));
        assertEquals(8, list.get(4));
        assertEquals(21, list.get(1));
        assertEquals(77, list.get(0));
        assertEquals(68, list.get(5));
    }

    @Test
    void contains() {
        LinkedIntList list = new LinkedIntList(); // new list for testing
        // add values to test contains()
        list.addBack(6);
        list.addBack(13);
        list.addBack(40);
        list.addBack(78);
        list.addBack(120);
        list.addBack(36);
        // check for values within the list using contains()
        assertEquals(true, list.contains(6));
        assertEquals(false, list.contains(7));
        assertEquals(true, list.contains(13));
        assertEquals(true, list.contains(36));
        assertEquals(true, list.contains(120));
        assertEquals(true, list.contains(40));
        assertEquals(false, list.contains(600));
        assertEquals(false, list.contains(18928475));
        assertEquals(false, list.contains(1));
    }

    @Test
    void indexOf() {
        LinkedIntList list = new LinkedIntList(); // new list for testing
        // add values
        list.addBack(1);
        list.addBack(100);
        list.addBack(24);
        list.addBack(81);
        list.addBack(33);
        // test for values that exist and don't exist
        assertEquals(0, list.indexOf(1));
        assertEquals(-1, list.indexOf(19));
        assertEquals(-1, list.indexOf(44));
        assertEquals(3, list.indexOf(81));
        assertEquals(4, list.indexOf(33));
        assertEquals(-1, list.indexOf(99));
        assertEquals(1, list.indexOf(100));
        assertEquals(2, list.indexOf(24));
    }

    @Test
    void isEmpty() {
        LinkedIntList list = new LinkedIntList(); // new list for testing
        // test empty list is empty
        assertEquals(true, list.isEmpty());
        list.addFront(12);
        // test list with 1 item is not empty
        assertEquals(false, list.isEmpty());
        list.removeFront();
        // test now empty list is empty
        assertEquals(true, list.isEmpty());
        list.addFront(12);
        list.addFront(12);
        list.addFront(12);
        list.addFront(12);
        // test list with 4 items is not empty
        assertEquals(false, list.isEmpty());
    }

    @Test
    void size() {
        LinkedIntList list = new LinkedIntList(); // new list for testing
        // test size = 0
        assertEquals(0, list.size());
        list.addFront(12);
        // test size = 1
        assertEquals(1, list.size());
        list.addFront(12);
        list.addFront(12);
        list.addFront(12);
        list.addFront(12);
        list.addFront(12);
        // test size = 6
        assertEquals(6, list.size());
        list.removeFront();
        list.removeFront();
        list.removeFront();
        list.removeFront();
        // test size = 2
        assertEquals(2, list.size());
    }

    @Test
    void clear() {
        LinkedIntList list = new LinkedIntList(); // new list for testing
        // add 1 item, test clear
        list.addFront(12);
        assertEquals(1, list.size());
        list.clear();
        assertEquals(0, list.size());
        // add 3 items, test clear
        list.addFront(12);
        list.addFront(12);
        list.addFront(12);
        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());
    }
}