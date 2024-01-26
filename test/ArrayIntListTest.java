import org.junit.Assert;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {

    @org.junit.jupiter.api.Test
    void addFront() {
        ArrayIntList list = new ArrayIntList();
        list.add(0,1);
        list.addFront(0);
        list.addFront(-1);
        assertEquals(-1,list.get(0));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        ArrayIntList list = new ArrayIntList();
        list.add(0,1);
        list.addFront(0);
        list.addFront(-1);
        list.addBack(2);
        assertEquals(2,list.get(list.size()-1));
    }

    @org.junit.jupiter.api.Test
    void add() {
        ArrayIntList list = new ArrayIntList();
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
        list.add(11,11);//resizes

       // list.add(-1,0);  //this should throw IndexOutOfBoundsException with note on "Index cannot be negative")
        assertEquals(0,list.get(0));
        assertEquals(10,list.get(10));
        assertEquals(11,list.get(11));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        ArrayIntList list = new ArrayIntList();
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
        ArrayIntList list = new ArrayIntList();
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
        ArrayIntList list = new ArrayIntList();
        //list.remove(0);  // array is empty  should throw IndexOutOfBounds  Index is higher than size
        list.add(0,1);
        list.remove(0);
        assertEquals(0,list.size());
        list.add(0,0);
        list.add(1,1);
        list.add(2,2);
        list.remove(1);
        assertEquals(2,list.get(1));
        //list.remove(-1);  throws IndexOutOfBoundsException: Index cannot be negative

    }

    @org.junit.jupiter.api.Test
    void get() {
        ArrayIntList list = new ArrayIntList();
        //list.get(0);  array is empty  throws IndexOutOfBoundsException: Index is higher than size
        list.add(0,0);
        assertEquals(0, list.get(0));
        list.add(1,1);
        list.add(2,2);
        assertEquals(1,list.get(1));
        //list.get(-1); //throws IndexOutOfBoundsException: Index cannot be negative

    }

    @org.junit.jupiter.api.Test
    void contains() {
        ArrayIntList list = new ArrayIntList();
        assertFalse(list.contains(1));
        assertFalse(list.contains(-1));
        list.add(1,1);
        list.add(2,2);
        assertTrue( list.contains(1));
        assertTrue(list.contains(2));

    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        ArrayIntList list = new ArrayIntList();
        assertEquals(0,list.indexOf(0));
        assertEquals(-1, list.indexOf(1));
        list.add(1,20);
        list.add(2,40);
        assertEquals(2,list.indexOf(40));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertEquals(true,list.isEmpty());
        list.add(0,10);
        assertEquals(false, list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        ArrayIntList list = new ArrayIntList();
        assertEquals(0, list.size());
        list.add(0,10);
        assertEquals(1,list.size());
        list.add(2,10);
        assertEquals(2,list.size());
        list.removeFront();
        assertEquals(1,list.size());


    }

    @org.junit.jupiter.api.Test
    void clear() {
        ArrayIntList list = new ArrayIntList();
        list.clear();
        assertEquals(0,list.size());
        list.add(2,10);
        list.clear();
        assertEquals(0,list.size());

    }

    @org.junit.jupiter.api.Test
    void iterator() {
        ArrayIntList test = new ArrayIntList();

        Iterator<Integer> iterator = test.iterator();
        assertFalse(iterator.hasNext());
        assertEquals(0, iterator.next());
        test.addFront(1);
        test.addFront(4);
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());// [4,1,...]
        assertEquals(0, iterator.next());
        assertFalse(iterator.hasNext());



    }
}