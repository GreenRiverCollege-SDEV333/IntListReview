import org.junit.jupiter.api.Test;

import java.util.Iterator;

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
        LinkedList empty = new LinkedList();
        empty.addBack(1);
        empty.addBack(2);
        empty.addBack(3);
        empty.addBack(4);
        empty.addBack(5);
        empty.addBack(6);

        //1,2,3,4,5,6
        //test at the front of list
        assertEquals(1,empty.get(0));

        //test at the middle of list
        assertEquals(4,empty.get(3));

        //test at the end of list
        assertEquals(6,empty.get(5));

        //error throwing test
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.get(7);} );
        assertThrows(IndexOutOfBoundsException.class, () -> {empty.get(-1);} );
    }

    @Test
    void contains() {
        LinkedList empty = new LinkedList();

        //test with an empty list
        assertEquals(false,empty.contains(5));

        //test with one element list
        empty.addBack(1);
        //1
        assertEquals(true,empty.contains(1));
        assertEquals(false,empty.contains(100));

        //test with two elements on the list (last on list)
        empty.addBack(4);

        //1,4
        assertEquals(true,empty.contains(4));
        assertEquals(false, empty.contains(199));

        empty.addBack(99);
        assertEquals(false, empty.contains(100));
        assertEquals(true,empty.contains(4));

    }

    @Test
    void indexOf() {
        LinkedList empty = new LinkedList();

        //empty list
        assertEquals(-1, empty.indexOf(100));

        //with one element
        empty.addBack(1);

        //1
        assertEquals(0, empty.indexOf(1));
        assertEquals(-1, empty.indexOf(50));

        //with two elements
        empty.addBack(6);
        //1,6
        assertEquals(0, empty.indexOf(1));
        assertEquals(1,empty.indexOf(6));

        //with many elements
        empty.addBack(8);
        empty.addBack(3);
        empty.addBack(19);

        //1,6,8,3,19
        //the last element
        assertEquals(4,empty.indexOf(19));

        //middle element
        assertEquals(2,empty.indexOf(8));

        //front element
        assertEquals(0,empty.indexOf(1));

        //not on the list
        assertEquals(-1,empty.indexOf(22));
    }


    @Test
    void isEmpty() {
        LinkedList empty = new LinkedList();

        //an empty list
        assertTrue(empty.isEmpty());

        empty.addBack(10);
        //non-empty list
        assertFalse(empty.isEmpty());
    }

    @Test
    void size() {
        LinkedList empty = new LinkedList();

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
        LinkedList empty = new LinkedList();
        empty.addBack(1);

        //testing clear
        empty.clear();
        assertTrue(empty.isEmpty());
    }

    @Test
    void iterator() {
        LinkedList empty = new LinkedList();

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