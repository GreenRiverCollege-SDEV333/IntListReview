import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedIntListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.add(0,1);
        list.addFront(0);
        list.addFront(-1);
        assertEquals(-1,list.get(0));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.add(0,1);
        list.addFront(0);//-1,0,1,2
        list.addFront(-1);
        list.addBack(2);
        assertEquals(2,list.get(3));
    }

    @org.junit.jupiter.api.Test
    void add() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.add(0,0);
        list.add(1,1);
        list.add(2,2);
        list.add(3,3);
        list.add(4,4);
        list.add(5,5);
        list.add(6,6);
        list.add(7,7);
        list.add(8,8);
        list.add(9,9);
        list.add(10,10);
        list.add(11,11);

       //  list.add(-1,0);  //this should throw IndexOutOfBoundsException with note on "Index cannot be negative")
        assertEquals(0,list.get(0));
        assertEquals(10,list.get(10));
        assertEquals(11,list.get(11));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        // list.removeFront();   //array is empty, should throw IndexOutOfBoundsException("Array is empty, nothing to remove");
        list.add(0,0);
        list.removeFront();
        //test the removal of front from array with only 1 value, deletion makes array empty
        assertEquals(0,list.size());
        list.add(0,0);
        list.add(1,1);
        list.add(2,2);
        list.removeFront();
        assertEquals(2,list.get(list.size()-1));
    }


    @org.junit.jupiter.api.Test
    void removeBack() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        //list.removeBack();   //array is empty, should throw IndexOutOfBoundsException("Array is empty, nothing to remove");
        list.add(0,0);
        list.removeBack();// remove only value in array, should have a size of 0 now.
        assertEquals(0,list.size());
        list.add(0,0);
        list.add(1,1);
        list.add(2,2);
        list.removeBack();
        assertEquals(1, list.get(list.size()-1));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        //list.remove(0);  // list is empty  should throw IndexOutOfBounds  Index is higher than size
        list.add(0,1);
        list.remove(0);
        assertEquals(0,list.size());
        list.add(0,0);
        list.add(1,1);
        list.add(2,2);
        list.remove(1);
        assertEquals(2,list.get(1));
        //list.remove(-1); // throws IndexOutOfBoundsException: Index cannot be negative

    }

    @org.junit.jupiter.api.Test
    void get() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        //list.get(0);  //list is empty  throws IndexOutOfBoundsException: Index is higher than size
        list.add(0,0);
        assertEquals(0, list.get(0));
        list.add(1,1);
        list.add(2,2);
        assertEquals(1,list.get(1));
        //list.get(-1); //throws IndexOutOfBoundsException: Index cannot be negative

    }

    @org.junit.jupiter.api.Test
    void contains() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        assertFalse(list.contains(1));
        assertFalse(list.contains(-1));
        list.add(0,1);
        list.add(1,2);
        assertTrue( list.contains(1));
        assertTrue(list.contains(2));

    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
       // assertEquals(0,list.indexOf(0)); //list is empty
        assertEquals(-1, list.indexOf(1));
        list.add(0,20);
        list.add(1,40);
        assertEquals(1,list.indexOf(40));
        assertEquals(0,list.indexOf(20));
        list.add(2,20);
        assertEquals(0,list.indexOf(20));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        assertEquals(true,list.isEmpty());
        list.add(0,10);
        assertEquals(false, list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        assertEquals(0, list.size());
        list.add(0,10);
        assertEquals(1,list.size());
        list.add(0,20);
        assertEquals(2,list.size());
        list.removeFront();
        assertEquals(1,list.size());


    }

    @org.junit.jupiter.api.Test
    void clear() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
       // list.clear(); //nothing to clear  list is empty
        assertEquals(0,list.size());
        list.add(0,10);
        list.clear();
        assertEquals(0,list.size());

    }

    @org.junit.jupiter.api.Test
    void iterator() {
        DoublyLinkedIntList test = new DoublyLinkedIntList();
        test.addFront(1);
        test.addFront(4);
        Iterator<Integer> iterator = test.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());// [4,1,...]
        assertEquals(0, iterator.next());
        assertFalse(iterator.hasNext());



    }
}