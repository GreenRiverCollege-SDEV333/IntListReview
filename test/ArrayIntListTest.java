import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
        //testing with an empty array
        ArrayIntList empty = new ArrayIntList();

        //[1]
        empty.addFront(1);
        assertEquals(1, empty.get(0));

        //testing one element in the array already
        //[2,1]
        empty.addFront(2);
        assertEquals(2, empty.get(0));

        //testing with multiple items in teh array
        //[3,2,1]
        empty.addFront(3);
        assertEquals(3, empty.get(0));

        //testing with a full array and resizing
        //[4,4,4,4,4,4,4,4,4,3,2,1]
        empty.addFront(4);
        empty.addFront(4);
        empty.addFront(4);
        empty.addFront(4);
        empty.addFront(4);
        empty.addFront(4);
        empty.addFront(4);
        empty.addFront(4);
        empty.addFront(4);

        assertEquals(1,empty.get(11));

    }

    @org.junit.jupiter.api.Test
    void addBack() {
        //testing with an empty array
        ArrayIntList empty = new ArrayIntList();

        //[1]
        empty.addBack(1);
        assertEquals(1, empty.get(0));

        //testing with one element
        //[1,2]
        empty.addBack(2);
        assertEquals(2,empty.get(1));

        //testing with two elements
        //[1,2,3]
        empty.addBack(3);
        assertEquals(3,empty.get(2));

        //testing with a full array and resizing
        //[1,2,3,4,4,4,4,4,4,4,4,4,5]
        empty.addBack(4);
        empty.addBack(4);
        empty.addBack(4);
        empty.addBack(4);
        empty.addBack(4);
        empty.addBack(4);
        empty.addBack(4);
        empty.addBack(4);
        empty.addBack(5);

        assertEquals(5,empty.get(11));


    }

    @org.junit.jupiter.api.Test
    void add() {
        ArrayIntList empty = new ArrayIntList();

        //adding with an empty array
        //[0,0,0,0,0,10,0,0,0,0]
        empty.add(5,10);
        assertEquals(10,empty.get(5));
        assertEquals(0,empty.get(6));

        //adding with one element
        //[0,0,0,0,0,10,0,0,0,30]
        empty.add(9,30);
        assertEquals(30,empty.get(9));

        //adding with two element
        //[0,25,0,0,0,10,0,0,0,30]
        empty.add(1,25);
        assertEquals(25,empty.get(1));

        //testing error handling for out of bounds
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.add(-1,100);} );
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.add(10000,100);} );
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        ArrayIntList empty = new ArrayIntList();

        //testing error with an empty array
        assertThrows(NoSuchElementException.class, () -> {empty.removeFront();} );

        empty.addFront(1);
        empty.addFront(2);
        empty.addFront(3);
        //[3,2,1]
        empty.removeFront();
        assertEquals(2, empty.get(0));

    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        ArrayIntList empty = new ArrayIntList();

        //testing error with an empty array
        assertThrows(NoSuchElementException.class, () -> {empty.removeBack();} );

        //testing remove method
        empty.addFront(1);
        empty.addFront(2);
        empty.addFront(3);
        //[1, 2, 3]
        empty.removeBack();
        assertEquals(0, empty.get(3));

    }

    @org.junit.jupiter.api.Test
    void remove() {
        ArrayIntList empty = new ArrayIntList();

        //testing error with an empty array
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.remove(100);} );
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.remove(-1);} );

        //testing method array with some elements
        //[1,2,3,4,5]
        empty.addBack(1);
        empty.addBack(2);
        empty.addBack(3);
        empty.addBack(4);
        empty.addBack(5);

        //[1,2,4,5]
        empty.remove(2);
        assertEquals(4, empty.get(2));
    }

    @org.junit.jupiter.api.Test
    void get() {
        ArrayIntList empty = new ArrayIntList();

        //testing errors with index positions
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.get(100);} );
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.get(-2);} );

        empty.addBack(1);
        empty.addBack(2);
        empty.addBack(3);

        //[1,2,3]
        assertEquals(3,empty.get(2));

        //two element testing
        empty.add(8,20);
        assertEquals(20, empty.get(8));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        ArrayIntList empty = new ArrayIntList();
        //empty array test
        assertTrue(empty.contains(0));
        assertFalse(empty.contains(4));

        //test with some elements
        empty.addBack(1);
        empty.addBack(5);
        empty.addBack(1);
        empty.addBack(2);
        empty.addBack(1);
        empty.addBack(1);
        empty.add(3,500);

        assertTrue(empty.contains(500));
        assertFalse(empty.contains(3));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        //empty array test
        ArrayIntList empty = new ArrayIntList();
        assertEquals(0, empty.indexOf(0));
        assertEquals(-1, empty.indexOf(7));

        //test with one element
        empty.add(3,9);
        assertEquals(3,empty.indexOf(9));

        //test with two element
        empty.addBack(100);
        assertEquals(1,empty.indexOf(100));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        //empty array
        ArrayIntList empty = new ArrayIntList();
        assertTrue(empty.isEmpty());

        //one element in array
        empty.addBack(1);
        assertFalse(empty.isEmpty());

        //two elements
        empty.addBack(2);
        assertFalse(empty.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        ArrayIntList empty = new ArrayIntList();

        //testing with empty array
        assertEquals(0, empty.size());

        //testing with one element
        empty.addFront(2);
        assertEquals(1, empty.size());

        //testing with two element
        empty.add(8,10);
        assertEquals(2, empty.size());

        //testing with last add method
        empty.addBack(21);
        assertEquals(3, empty.size());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        ArrayIntList empty = new ArrayIntList();

        //testing on already empty array
        empty.clear();
        assertTrue(empty.isEmpty());

        for (int i = 0; i < 31; i++) {
            empty.addFront(i);
        }

        //testing clear
        empty.clear();
        assertTrue(empty.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        ArrayIntList empty = new ArrayIntList();

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