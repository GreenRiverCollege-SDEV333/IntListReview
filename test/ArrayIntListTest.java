import java.util.Arrays;

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

        //testing with a full array
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
        ArrayIntList empty = new ArrayIntList();
        empty.addBack(1);
        empty.addBack(2);

        assertEquals(2,empty.get(1));
    }

    @org.junit.jupiter.api.Test
    void add() {
        ArrayIntList empty = new ArrayIntList();
        empty.addFront(1);
        empty.addFront(2);
        empty.addFront(3);

        // [3,2,1]

        empty.add(1,10);
        //[3,10,2,1]
        assertEquals(10,empty.get(1));

        //[3,9,10,2,1]
        empty.add(1, 9);
        assertEquals(9,empty.get(1));
        assertEquals(1,empty.get(4));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }
}