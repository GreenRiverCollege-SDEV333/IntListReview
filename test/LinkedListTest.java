import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void addFront() {
        LinkedList empty = new LinkedList();
        //with an empty list
        empty.addFront(1);
        assertEquals(1,empty.get(0));

        //with a one element
        empty.addFront(4);
        assertEquals(4,empty.get(0));

        //with multiple elements
        empty.addFront(5);
        assertEquals(5,empty.get(0));
        assertEquals(1,empty.get(2));
    }

    @Test
    void addBack() {
        LinkedList empty = new LinkedList();
        //with an emptyList
        empty.addBack(2);
        assertEquals(2, empty.get(0));

        //with one element
        empty.addBack(10);
        assertEquals(10,empty.get(1));

        //with two elements
        empty.addBack(15);
        assertEquals(15,empty.get(2));

        //make sure the other elements are still there
        assertEquals(2, empty.get(0));
        assertEquals(10,empty.get(1));
    }

    @Test
    void add() {
        LinkedList empty = new LinkedList();

        //with an emptylist
        empty.add(4,20);
        assertEquals(20,empty.get(0));

        //with one element
        empty.add(1, 40);
        assertEquals(40,empty.get(1));

        //with two elements
        empty.add(1,4);
        assertEquals(4,empty.get(1));

        //with more elements
        empty.add(1,20);
        assertEquals(20,empty.get(1));

        //testing shifting
        assertEquals(4,empty.get(2));

        //testing when there are a lot of elements
        empty.add(3, 55);
        assertEquals(55,empty.get(3));
    }

    @Test
    void removeFront() {
        //with one element
        LinkedList empty = new LinkedList();
        empty.addBack(1);
        empty.addBack(2);
        //1,2
        empty.removeFront();
        //2
        assertEquals(2,empty.get(0));

        //multiple elements

        empty.addBack(3);
        empty.addBack(4);
        //2,3,4
        empty.removeFront();
        //3,4
        assertEquals(3,empty.get(0));
    }

    @Test
    void removeBack() {
    LinkedList empty = new LinkedList();

    //with one element
    empty.addBack(1);
    empty.addBack(2);
    //1, 2
    empty.removeBack();
    //1
    assertEquals(1, empty.get(0));

    //with multiple elements
    empty.addBack(3);
    empty.addBack(4);
    //1,3,4
    empty.removeBack();
    //1,3
    assertEquals(1,empty.get(0));
    assertEquals(3,empty.get(1));

    }

    @Test
    void remove() {
        //testing error throwing
        LinkedList empty = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.remove(100);} );
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.remove(-1);} );

        //removing at the start
        empty.addBack(1);
        empty.addBack(2);
        empty.addBack(3);
        empty.addBack(4);
        //1,2,3,4

        //2,3,4

        //testing return value
        assertEquals(1, empty.remove(0));

        //testing new index at the front
        assertEquals(2, empty.get(0));
        //2,3,4

        assertEquals(4, empty.remove(2));
        //2,3

        //testing newly formed list
        assertEquals(2,empty.get(0));
        assertEquals(3,empty.get(1));

        empty.addBack(4);
        empty.addBack(5);
        //2,3,4,5

        assertEquals(4,empty.remove(2));
        //2,3,5

        //testing new list
        assertEquals(2,empty.get(0));
        assertEquals(3,empty.get(1));
        assertEquals(5,empty.get(2));


    }

    @Test
    void get() {
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
    }

    @Test
    void clear() {
    }

    @Test
    void iterator() {
    }
}