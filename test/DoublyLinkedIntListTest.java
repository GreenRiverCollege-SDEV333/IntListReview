import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedIntListTest {
    @Test
    void addFront() {
        DoublyLinkedIntList empty = new DoublyLinkedIntList();

        //empty list with no elements
        empty.addFront(1);

        //1
        assertEquals(1, empty.get(0));

        //list with two elements
        empty.addFront(2);
        //2, 1
        assertEquals(2,empty.get(0));
        assertEquals(1,empty.get(1));

        //with many elements
        empty.addFront(3);
        empty.addFront(4);
        empty.addFront(5);

        //5,4,3,2,1
        assertEquals(3,empty.get(2));
        assertEquals(1,empty.get(4));
        assertEquals(5,empty.get(0));
    }

    @Test
    void addBack() {
        DoublyLinkedIntList empty = new DoublyLinkedIntList();

        //empty list with no element
        empty.addBack(1);

        //1
        assertEquals(1,empty.get(0));

        //list with two elements
        //1,2
        empty.addBack(2);
        assertEquals(1,empty.get(0));
        assertEquals(2,empty.get(1));

        //with many elements
        empty.addBack(3);
        empty.addBack(4);
        empty.addBack(5);

        //1,2,3,4,5
        assertEquals(1,empty.get(0));
        assertEquals(3,empty.get(2));
        assertEquals(5,empty.get(4));

    }

    @Test
    void add() {
        DoublyLinkedIntList empty = new DoublyLinkedIntList();

        //testing errors
        assertThrows(IndexOutOfBoundsException.class, ()-> empty.add(-1, 100));
        assertThrows(IndexOutOfBoundsException.class, ()-> empty.add(1, 100));

        //testing adding in an emptyList
        empty.add(0,21);
        //21
        assertEquals(21,empty.get(0));
        empty.add(0,10);

        //10,21
        assertEquals(10,empty.get(0));
        assertEquals(21,empty.get(1));

        //testing adding at the end
        empty.add(2,30);
        //10,21,30
        assertEquals(30,empty.get(2));
        assertEquals(21, empty.get(1));

        //testing adding in the middle
        empty.add(1,99);
        //10,99,21,30
        assertEquals(99,empty.get(1));

        //testing placements of shifted nodes
        assertEquals(21,empty.get(2));
        assertEquals(30,empty.get(3));

    }

    @Test
    void removeFront() {
        DoublyLinkedIntList empty = new DoublyLinkedIntList();

        //empty list
        empty.removeFront();
        assertEquals(true, empty.isEmpty());

        //with one element
        empty.addBack(1);
        empty.removeFront();
        assertEquals(true,empty.isEmpty());

        //with two elements
        empty.addBack(1);
        empty.addBack(2);
        empty.removeFront();
        //2
        assertEquals(2,empty.get(0));

        //with multiple elements
        empty.addBack(3);
        empty.addBack(4);
        empty.addBack(5);
        empty.addBack(6);
        empty.addBack(7);
        //2,3,4,5,6,7

        empty.removeFront();
        //3,4,5,6,7
        assertEquals(5,empty.get(2));

        empty.removeFront();
        //4,5,6,7
        assertEquals(4,empty.get(0));
        assertEquals(7,empty.get(3));
    }

    @Test
    void removeBack() {
        DoublyLinkedIntList empty = new DoublyLinkedIntList();

        //empty list error test
        assertThrows(IllegalStateException.class, ()-> empty.removeBack());

        //with one element
        empty.addBack(1);
        empty.removeBack();
        assertTrue(empty.isEmpty());

        //with two elements
        empty.addBack(1);
        empty.addBack(2);
        //1,2
        empty.removeBack();

        //1
        assertEquals(1,empty.get(0));

        //with many elements
        empty.addBack(2);
        empty.addBack(3);
        empty.addBack(4);
        //1,2,3,4

        empty.removeBack();
        //1,2,3
        assertEquals(1,empty.get(0));
        assertEquals(2,empty.get(1));
        assertEquals(3,empty.get(2));
    }

    @Test
    void remove() {

    }

    @Test
    void get() {
        //testing for errors on an empty list
        DoublyLinkedIntList empty = new DoublyLinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, ()-> empty.get(1));
        assertThrows(IndexOutOfBoundsException.class, ()-> empty.get(-20));

        //with one element in list
        empty.addBack(1);
        assertEquals(1,empty.get(0));

        //with two elements
        empty.addBack(2);
        assertEquals(2,empty.get(1));

        //with multiple elements in list
        empty.addBack(3);
        empty.addBack(4);
        empty.addBack(5);
        //1,2,3,4,5

        assertEquals(1,empty.get(0));
        assertEquals(3,empty.get(2));
        assertEquals(5,empty.get(4));
    }

    @Test
    void contains() {

    }

    @Test
    void indexOf() {

    }

    @Test
    void isEmpty() {
        DoublyLinkedIntList empty = new DoublyLinkedIntList();
        assertTrue(empty.isEmpty());

        empty.addBack(1);

        assertFalse(empty.isEmpty());

    }

    @Test
    void size() {
        DoublyLinkedIntList empty = new DoublyLinkedIntList();

        //empty list
        assertEquals(0,empty.size());

        //one element
        empty.addBack(1);
        assertEquals(1, empty.size());

        //two elements
        empty.addBack(2);
        assertEquals(2,empty.size());

        //many elements
        empty.addBack(3);
        empty.addBack(4);
        empty.addBack(5);
        assertEquals(5,empty.size());

    }

    @Test
    void clear() {
        DoublyLinkedIntList empty = new DoublyLinkedIntList();
        empty.addBack(1);

        //testing clear
        empty.clear();
        assertTrue(empty.isEmpty());
    }

    @Test
    void iterator() {
        DoublyLinkedIntList empty = new DoublyLinkedIntList();

        //adding into the array numbers
        for (int i = 0; i < 10; i++) {
            empty.addBack(i);
        }

        //testing iterator
        Iterator<Integer> test = empty.iterator();
        assertEquals(0,test.next());
        assertEquals(1,test.next());

        assertTrue(test.hasNext());

        //testing hasNext
        if(test.hasNext()){
            int curr = 2;
            int testInt = test.next();
            assertEquals(curr, testInt);
        }

    }
}