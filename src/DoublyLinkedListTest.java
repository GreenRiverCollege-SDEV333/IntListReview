import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
/*
 *   Ryder Dettloff
 *   Tests for IntList Review; DoublyLinkedList methods
 * I have work to do to get this to work )):
 */
class DoublyLinkedListTest {


    @Test
    void AddFront() {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.addFront(1);
        myList.addFront(5);
        myList.addFront(10);
        assertEquals(10, myList.get(0));
        assertEquals(5, myList.get(1));
        assertEquals(1, myList.get(2));
    }

    @Test
    void AddBack() {
        // Create a new instance of DoublyLinkedList
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.addBack(1);
        myList.addBack(5);
        myList.addBack(10);
        assertEquals(1, myList.get(0));
        assertEquals(5, myList.get(1));
        assertEquals(10, myList.get(2));
    }

    @Test
    void Add() {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.addFront(1);
        myList.addFront(5);
        myList.add(1, 10);
        assertEquals(5, myList.get(0));
        assertEquals(10, myList.get(1));
        assertEquals(1, myList.get(2));
    }

    @Test
    void RemoveFront() {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.addFront(1);
        myList.addFront(5);
        myList.removeFront();
        assertEquals(1, myList.get(0));
        assertEquals(0, myList.size());
    }

    @Test
    void RemoveBack() {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.addBack(1);
        myList.addBack(5);
        myList.addBack(10);
        myList.removeBack();
        assertEquals(5, myList.get(myList.size() - 1));
        assertEquals(2, myList.size());
    }

    @Test
    void Remove() {
        DoublyLinkedList mylist = new DoublyLinkedList();
        mylist.addFront(1);
        mylist.addFront(5);
        mylist.addFront(10);
        mylist.remove(1);
        assertEquals(10, mylist.get(0));
        assertEquals(1, mylist.get(1));
        assertEquals(2, mylist.size());
    }

    @Test
    void Get() {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.addFront(1);
        myList.addFront(5);
        myList.addFront(10);
        assertEquals(5, myList.get(1));
    }

    @Test
    void Contains() {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.addFront(1);
        myList.addFront(5);
        myList.addFront(10);
        assertTrue(myList.contains(5));
        assertFalse(myList.contains(6));
    }

    @Test
    void IndexOf() {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.addBack(1);
        myList.addBack(5);
        myList.addBack(10);
        assertEquals(1, myList.indexOf(5));
        assertEquals(-1, myList.indexOf(6));
    }

    @Test
    void IsEmpty() {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.addBack(1);
        assertFalse(myList.isEmpty());
        myList.clear();
        assertTrue(myList.isEmpty());
    }

    @Test
    void Size() {
        DoublyLinkedList myList = new DoublyLinkedList();
        assertEquals(0, myList.size());
        myList.addBack(1);
        myList.addBack(5);
        myList.addBack(10);
        assertEquals(3, myList.size());
    }

    @Test
    void Clear() {
        DoublyLinkedList myList = new DoublyLinkedList();
        assertEquals(0, myList.size());
        myList.addBack(1);
        myList.addBack(5);
        myList.clear();
        assertTrue(myList.isEmpty());
    }

    /*
    I had trouble with this test but finally got it working
    it tests the itertators and its methods (hasNext) and next
     */
    @Test
    public void testIterator() {
        DoublyLinkedList mylist = new DoublyLinkedList();
        mylist.addFront(1);
        mylist.addFront(5);
        mylist.addFront(10);

        Iterator<Integer> iterator = mylist.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }
}