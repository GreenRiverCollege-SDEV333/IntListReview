import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/*
 *   Ryder Dettloff
 *   Tests for IntList Review; LinkedList methods
 */
class LinkedListTest {


    @Test
    void AddFront() {
        LinkedList myList = new LinkedList();
        myList.addFront(1);
        myList.addFront(5);
        myList.addFront(10);
        assertEquals(10, myList.get(0));
        assertEquals(5, myList.get(1));
        assertEquals(1, myList.get(2));
    }

    @Test
    void AddBack() {
        LinkedList myList = new LinkedList();
        myList.addBack(1);
        myList.addBack(5);
        myList.addBack(10);
        assertEquals(1, myList.get(0));
        assertEquals(5, myList.get(1));
        assertEquals(10, myList.get(2));
    }

    @Test
    void Add() {
        LinkedList myList = new LinkedList();
        myList.addFront(1);
        myList.addFront(5);
        myList.add(1, 10);
        assertEquals(5, myList.get(0));
        assertEquals(10, myList.get(1));
        assertEquals(1, myList.get(2));
    }

    @Test
    void RemoveFront() {
        LinkedList myList = new LinkedList();
        myList.addFront(1);
        myList.addFront(5);
        myList.removeFront();
        assertEquals(1, myList.get(0));
        assertEquals(0, myList.size());
    }

    @Test
    void RemoveBack() {
        LinkedList myList = new LinkedList();
        myList.addBack(1);
        myList.addBack(5);
        myList.addBack(10);
        myList.removeBack();
        assertEquals(1, myList.get(0));
        assertEquals(5, myList.get(1));
        assertEquals(2, myList.size());
    }

    @Test
    void Remove() {
        LinkedList mylist = new LinkedList();
        mylist.addBack(1);
        mylist.addBack(5);
        mylist.addBack(10);
        mylist.remove(1);
        assertEquals(1, mylist.get(0));
        assertEquals(10, mylist.get(1));
        assertEquals(2, mylist.size());
    }

    @Test
    void Get() {
        LinkedList myList = new LinkedList();
        myList.addFront(1);
        myList.addFront(5);
        myList.addFront(10);
        assertEquals(5, myList.get(1));
    }

    @Test
    void Contains() {
        LinkedList myList = new LinkedList();
        myList.addFront(1);
        myList.addFront(5);
        myList.addFront(10);
        assertTrue(myList.contains(5));
        assertFalse(myList.contains(6));
    }

    @Test
    void IndexOf() {
        LinkedList myList = new LinkedList();
        myList.addBack(1);
        myList.addBack(5);
        myList.addBack(10);
        assertEquals(1, myList.indexOf(5));
        assertEquals(-1, myList.indexOf(6));
    }

    @Test
    void IsEmpty() {
        LinkedList myList = new LinkedList();
        myList.addBack(1);
        assertFalse(myList.isEmpty());
        myList.clear();
        assertTrue(myList.isEmpty());
    }

    @Test
    void Size() {
        LinkedList myList = new LinkedList();
        assertEquals(0, myList.size());
        myList.addBack(1);
        myList.addBack(5);
        myList.addBack(10);
        assertEquals(3, myList.size());
    }

    @Test
    void Clear() {
        LinkedList myList = new LinkedList();
        assertEquals(0, myList.size());
        myList.addBack(1);
        myList.addBack(5);
        myList.clear();
        assertTrue(myList.isEmpty());
    }
}