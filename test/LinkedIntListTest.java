import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {
    @org.junit.jupiter.api.Test
    void addFront() {
        LinkedIntList list = new LinkedIntList();
        list.add(0,1);
        list.addFront(0);
        list.addFront(-1);
        assertEquals(-1,list.get(0));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        LinkedIntList list = new LinkedIntList();
        list.add(0,1);
        list.addFront(0);
        list.addFront(-1);
        list.addBack(2);
        assertEquals(2,list.get(list.size()-1));
    }

    @org.junit.jupiter.api.Test
    void add() {
        LinkedIntList list = new LinkedIntList();
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

        //list.add(-1,0);  //this should throw IndexOutOfBoundsException with note on "Index cannot be negative")
        assertEquals(0,list.get(0));
        assertEquals(10,list.get(10));
        assertEquals(11,list.get(11));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        LinkedIntList list = new LinkedIntList();
        // list.removeFront();   //array is empty, should throw IndexOutOfBoundsException("Array is empty, nothing to remove");
        list.add(0,1);
        list.removeFront();
        //test the removal of front from list with only 1 values, deletion makes array empty
        assertEquals(0,list.size());
        list.add(0,1);
        list.add(1,2);
        list.add(2,2);
        list.removeFront();
        assertEquals(2,list.get(list.size()-1));
    }


    @org.junit.jupiter.api.Test
    void removeBack() {
        LinkedIntList list = new LinkedIntList();
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
        LinkedIntList list = new LinkedIntList();
        //list.remove(0);  // array is empty  should throw IndexOutOfBounds  Index is higher than size
        list.add(0,1);
        list.remove(0);
        assertEquals(0,list.size());
        list.add(0,3);
        list.add(1,1);
        list.add(2,2);
        list.remove(1);
        assertEquals(2,list.get(1));
        //list.remove(-1); // throws IndexOutOfBoundsException: Index cannot be negative

    }

    @org.junit.jupiter.api.Test
    void get() {
        LinkedIntList list = new LinkedIntList();
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
        LinkedIntList list = new LinkedIntList();
     //   assertFalse(list.contains(1));// list is empty

        list.add(0,1);
        list.add(1,2);
        assertTrue( list.contains(1));
        assertTrue(list.contains(2));
        assertFalse(list.contains(-1));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        LinkedIntList list = new LinkedIntList();
        //assertEquals(0,list.indexOf(0));//list is empty
        list.add(0,20);
        list.add(1,20);
        list.add(2,40);
        assertEquals(2,list.indexOf(40));
        assertEquals(-1, list.indexOf(1));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        LinkedIntList list = new LinkedIntList();
        assertEquals(true,list.isEmpty());
        list.add(0,10);
        assertEquals(false, list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        LinkedIntList list = new LinkedIntList();
        assertEquals(0, list.size());
        list.add(0,10);
        assertEquals(1,list.size());
        list.add(1,10);
        assertEquals(2,list.size());
        list.removeFront();
        assertEquals(1,list.size());


    }

    @org.junit.jupiter.api.Test
    void clear() {
        LinkedIntList list = new LinkedIntList();
        list.clear();
        assertEquals(0,list.size());
        list.add(0,10);
        list.clear();
        assertEquals(0,list.size());

    }

    @org.junit.jupiter.api.Test
    void iterator() {
        LinkedIntList test = new LinkedIntList();
        test.addFront(1);
        test.addFront(4);
        Iterator<Integer> iterator = test.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());// [4,1,...]
       // assertEquals(0, iterator.next());//no more data, current.next is null
        assertFalse(iterator.hasNext());



    }
}