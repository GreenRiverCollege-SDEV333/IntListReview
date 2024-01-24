import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DoublyDoublyLinkedIntListTest
{
    private DoublyLinkedIntList emptyList;
    private DoublyLinkedIntList oneItemList;
    private DoublyLinkedIntList multiItemList;

    @BeforeEach
    void setUp()
    {
        emptyList = new DoublyLinkedIntList();

        oneItemList = new DoublyLinkedIntList();
        oneItemList.addFront(5);

        multiItemList = new DoublyLinkedIntList();
        multiItemList.addBack(10);
        multiItemList.addBack(20);
        multiItemList.addBack(30);
    }

    @Test
    void testAddFront()
    {
        //test on empty list
        emptyList.addFront(5);
        assertEquals(5, emptyList.get(0));

        //test on one item list
        oneItemList.addFront(15);
        assertEquals(15, oneItemList.get(0));
        assertEquals(5, oneItemList.get(1));

        //test on multi-item list
        multiItemList.addFront(5);
        assertEquals(5, multiItemList.get(0));
        assertEquals(10, multiItemList.get(1));
        assertEquals(20, multiItemList.get(2));
        assertEquals(30, multiItemList.get(3));
    }

    @Test
    void testAddBack()
    {
        //test on empty list
        emptyList.addBack(7);
        assertEquals(7, emptyList.get(0));

        //test on one item list
        oneItemList.addBack(18);
        assertEquals(5, oneItemList.get(0));
        assertEquals(18, oneItemList.get(1));

        //test on multi-item list
        multiItemList.addBack(40);
        assertEquals(10, multiItemList.get(0));
        assertEquals(20, multiItemList.get(1));
        assertEquals(30, multiItemList.get(2));
        assertEquals(40, multiItemList.get(3));
    }

    @Test
    void testAdd()
    {
        //test on empty list
        emptyList.add(0, 3);
        assertEquals(3, emptyList.get(0));

        //test on one item list
        oneItemList.add(1, 15);
        assertEquals(5, oneItemList.get(0));
        assertEquals(15, oneItemList.get(1));

        //test on multi-item list
        multiItemList.add(1, 25);
        assertEquals(10, multiItemList.get(0));
        assertEquals(25, multiItemList.get(1));
        assertEquals(20, multiItemList.get(2));
        assertEquals(30, multiItemList.get(3));
    }

    @Test
    void testRemoveFront()
    {
        //test on empty list
        assertTrue(emptyList.isEmpty());
        assertThrows(NoSuchElementException.class, () -> emptyList.removeFront());

        //test on one item list
        oneItemList.removeFront();
        assertTrue(oneItemList.isEmpty());

        //test on multi-item list
        multiItemList.removeFront();
        assertEquals(20, multiItemList.get(0));
        assertEquals(30, multiItemList.get(1));
    }

    @Test
    void testRemoveBack()
    {
        //test on empty list
        emptyList.removeBack();
        assertTrue(emptyList.isEmpty());

        //test on one item list
        oneItemList.removeBack();
        assertTrue(oneItemList.isEmpty());

        //test on multi-item list
        multiItemList.removeBack();
        assertEquals(10, multiItemList.get(0));
        assertEquals(20, multiItemList.get(1));
    }

    @Test
    void testRemove()
    {
        //test on empty list
        //https://junit.org/junit5/docs/5.8.2/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html
        //https://stackoverflow.com/questions/40268446/junit-5-how-to-assert-an-exception-is-thrown
        //took me some docs researching to figure out how to test an exception being thrown
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(0));

        //test on one item list
        assertEquals(5, oneItemList.remove(0));
        assertTrue(oneItemList.isEmpty());

        //test on multi-item list
        assertEquals(20, multiItemList.remove(1));
        assertEquals(10, multiItemList.get(0));
        assertEquals(30, multiItemList.get(1));
    }

    @Test
    void testGet()
    {
        //test on empty list
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(0));

        //test on one item list
        assertEquals(5, oneItemList.get(0));

        //test on multi-item list
        assertEquals(20, multiItemList.get(1));
    }

    @Test
    void testContains()
    {
        //test on empty list
        assertFalse(emptyList.contains(5));

        //test on one item list
        assertTrue(oneItemList.contains(5));
        assertFalse(oneItemList.contains(55));

        //test on multi-item list
        assertTrue(multiItemList.contains(20));
        assertFalse(multiItemList.contains(15));
    }

    @Test
    void testIndexOf()
    {
        //test on empty list
        assertEquals(-1, emptyList.indexOf(5));

        //test on one item list
        assertEquals(0, oneItemList.indexOf(5));
        assertEquals(-1, oneItemList.indexOf(55));

        //test on multi-item list
        assertEquals(1, multiItemList.indexOf(20));
        assertEquals(-1, multiItemList.indexOf(15));
    }

    @Test
    void testIsEmpty()
    {
        assertTrue(emptyList.isEmpty());
        assertFalse(oneItemList.isEmpty());
        assertFalse(multiItemList.isEmpty());
    }

    @Test
    void testSize()
    {
        assertEquals(0, emptyList.size());
        assertEquals(1, oneItemList.size());
        assertEquals(3, multiItemList.size());
    }

    @Test
    void testClear()
    {
        //test on empty list
        emptyList.clear();
        assertTrue(emptyList.isEmpty());

        //test on one item list
        oneItemList.clear();
        assertTrue(oneItemList.isEmpty());

        //test on multi-item list
        multiItemList.clear();
        assertTrue(multiItemList.isEmpty());
    }
}
