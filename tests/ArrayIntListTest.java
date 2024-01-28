import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {
    @org.junit.jupiter.api.Test
    void addFront() {
        ArrayIntList list = new ArrayIntList(); // new list
        list.addFront(6); // add 6 to front of empty list
        assertEquals(6, list.get(0));
        list.addFront(10); // add 10 to front of list with only 1 item
        assertEquals(10, list.get(0));
        list.addFront(20); // add 20 to front of list with more than 1 item
        assertEquals(20, list.get(0));
        for (int i = 0; i < 7; i++) {
            list.addFront(1); // fill up our buffer
        }
        list.addFront(9); // add 9 to front of full list, testing resize works
        assertEquals(9, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        ArrayIntList list = new ArrayIntList(); // new list
        list.addBack(6); // add 6 to back of empty list
        assertEquals(6, list.get(list.size()-1));
        list.addBack(10); // add 10 to back of list with only 1 item
        assertEquals(10, list.get(list.size()-1));
        list.addBack(20); // add 20 to back of list with more than 1 item
        assertEquals(20, list.get(list.size()-1));
        for (int i = 0; i < 7; i++) {
            list.addBack(1); // fill up our buffer
        }
        list.addBack(9); // add 9 to back of full list, testing resize works
        assertEquals(9, list.get(list.size()-1));
    }

    @org.junit.jupiter.api.Test
    void add() {
        ArrayIntList list = new ArrayIntList(); // new list
        list.add(0, 6); // add 6 at index 0
        assertEquals(6, list.get(0));
        list.add(1, 10); // add 10 at index 1
        assertEquals(10, list.get(1));
        list.add(2, 2); // add 2 at index 2
        assertEquals(2, list.get(2));
        list.add(1, 5); // add 5 at index 1 (moving our previous index 1 over)
        assertEquals(5, list.get(1));
        assertEquals(10, list.get(2)); // test index 2 has shifted over value previously in index 1
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        ArrayIntList list = new ArrayIntList(); // new list
        list.addBack(12); // Add first value
        assertEquals(1, list.size()); // check size = 1
        list.removeFront(); // remove our only item from the front
        assertEquals(0, list.size()); // check size = 0
        list.addBack(17);
        list.addBack(21);
        list.addBack(33); // add 3 values
        assertEquals(17, list.get(0)); // check front value is 17
        list.removeFront(); // remove 17 from front
        assertEquals(21, list.get(0)); // check new front value is 21
        list.removeFront(); // remove 21 from front
        assertEquals(33, list.get(0)); // check new front value is 33
        list.removeFront(); // remove 33 from front
        assertEquals(0, list.size()); // check size = 0
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        ArrayIntList list = new ArrayIntList(); // new list
        list.addFront(12);
        assertEquals(1, list.size()); // check size = 1
        list.removeBack(); // remove our only item from the back
        assertEquals(0, list.size()); // check size = 0
        list.addFront(88);
        list.addFront(77);
        list.addFront(66);
        assertEquals(88, list.get(list.size()-1)); // check front value is 17
        list.removeBack(); // remove 17 from front
        assertEquals(77, list.get(list.size()-1)); // check new front value is 21
        list.removeBack(); // remove 21 from front
        assertEquals(66, list.get(list.size()-1)); // check new front value is 33
        list.removeBack(); // remove 33 from front
        assertEquals(0, list.size()); // check size = 0
    }

    @org.junit.jupiter.api.Test
    void remove() {
        ArrayIntList list = new ArrayIntList(); // new list
        // add test values
        list.add(0, 12);
        list.add(1, 100);
        list.add(2, 55);
        list.add(3, 19);
        list.add(4, 5);

        assertEquals(12, list.remove(0)); // remove index 0 (12)
        assertEquals(100, list.get(0)); // get new index 0 (100)
        assertEquals(19, list.remove(2)); // remove index 2 (now 19)
        assertEquals(5, list.get(2)); // get new index 2 (5)
        assertEquals(55, list.remove(1)); // remove index 1 (now 55)
        assertEquals(100, list.get(0)); // get new index 0 (100)
        assertEquals(100, list.remove(0)); // remove index 0 (100)
        assertEquals(5, list.get(0)); // get new index 0 (5)
        assertEquals(5, list.remove(0)); // remove index 0 (5)
    }

    @org.junit.jupiter.api.Test
    void get() {
        ArrayIntList list = new ArrayIntList(); // new list
        list.addFront(5);
        list.addFront(9);
        list.addFront(23);
        list.addFront(11);
        list.addFront(16); // add values to front
        assertEquals(16, list.get(0)); // test getting index 0
        assertEquals(5, list.get(4)); // test getting index 4
        assertEquals(23, list.get(2)); // test getting index 2
    }

    @org.junit.jupiter.api.Test
    void contains() {
        ArrayIntList list = new ArrayIntList(); // new list
        assertEquals(false, list.contains(0)); // check if empty list contains 0
        list.addFront(7);
        list.addFront(15);
        list.addFront(33);
        list.addFront(45); // add values to front
        assertEquals(true, list.contains(7)); // check if list contains 7
        assertEquals(false, list.contains(13)); // check if list contains 13
        assertEquals(true, list.contains(45)); // check if list contains 45
        assertEquals(false, list.contains(22)); // check if list contains 22
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        ArrayIntList list = new ArrayIntList(); // new list
        list.addFront(3);
        assertEquals(0, list.indexOf(3)); // check for index of 3
        assertEquals(-1, list.indexOf(5)); // check for index of 5 (doesn't exist)
        for (int i = 0; i < 9; i++) {
            list.addBack(8);
        }
        assertEquals(1, list.indexOf(8)); // check for first index of 8
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        ArrayIntList list = new ArrayIntList(); // new list
        assertEquals(true, list.isEmpty()); // testing isEmpty() on empty list
        list.addFront(5);
        assertEquals(false, list.isEmpty()); // testing isEmpty() on list with 1 item
        for (int i = 0; i < 9; i++) {
            list.addFront(10);
        }
        assertEquals(false, list.isEmpty()); // testing isEmpty() on list with 10 items
    }

    @org.junit.jupiter.api.Test
    void size() {
        ArrayIntList list = new ArrayIntList(); // new list
        assertEquals(0, list.size()); // testing for 0 items
        list.addFront(10);
        assertEquals(1, list.size()); // testing for 1 item
        for (int i = 0; i < 9; i++) {
            list.addFront(1);
        }
        assertEquals(10, list.size()); // testing for 10 items (full buffer)
    }

    @org.junit.jupiter.api.Test
    void clear() {
        ArrayIntList list = new ArrayIntList(); // new list
        list.addFront(3);
        list.clear(); // clear list
        assertEquals(0, list.size()); // check size after clear
        for (int i = 0; i < 10; i++) {
            list.addFront(5);
        }
        list.clear(); // clear list
        assertEquals(0, list.size()); // check size after clear
    }
}