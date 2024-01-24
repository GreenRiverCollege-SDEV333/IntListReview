package lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//Does the method work when the data structure is empty?
//Does the method work when the data structure has one item (almost empty, but not empty)?
//Does the method work when the data structure has 2 or more items (not empty)?
//Does the method work when the data structure is "full" (if "full" is a possibility)?
//Does the method handle invalid parameter values? (and throws exceptions as appropriate)

class DoublyLinkedListTest
{

    @Test
    void addFront()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFront(0);
        assertEquals("[ 0 ]", doublyLinkedList.toString());
        doublyLinkedList.addFront(1);
        assertEquals("[ 1, 0 ]", doublyLinkedList.toString());
        doublyLinkedList.addFront(2);
        assertEquals("[ 2, 1, 0 ]", doublyLinkedList.toString());
        doublyLinkedList.addFront(3);
        assertEquals("[ 3, 2, 1, 0 ]", doublyLinkedList.toString());
    }

    @Test
    void addBack()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addBack(0);
        assertEquals("[ 0 ]", doublyLinkedList.toString());
        doublyLinkedList.addBack(1);
        assertEquals("[ 0, 1 ]", doublyLinkedList.toString());
        doublyLinkedList.addBack(2);
        assertEquals("[ 0, 1, 2 ]", doublyLinkedList.toString());
        doublyLinkedList.addBack(3);
        assertEquals("[ 0, 1, 2, 3 ]", doublyLinkedList.toString());
    }

    @Test
    void add()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(0,0);
        assertEquals("[ 0 ]", doublyLinkedList.toString());
        doublyLinkedList.add(1,1);
        assertEquals("[ 0, 1 ]", doublyLinkedList.toString());
        doublyLinkedList.add(2,3);
        assertEquals("[ 0, 1, 2 ]", doublyLinkedList.toString());
        doublyLinkedList.add(30,4);
        assertEquals("[ 0, 1, 2, 3 ]", doublyLinkedList.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedList.add(-20,5));
    }

    @Test
    void removeFront()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.removeFront();
        assertEquals("[ ]", doublyLinkedList.toString());
        for (int i = 0; i < 3; i++)
        {
            doublyLinkedList.addBack(i);
        }
        doublyLinkedList.removeFront();
        assertEquals("[ 1, 2 ]", doublyLinkedList.toString());
        doublyLinkedList.removeFront();
        assertEquals("[ 2 ]", doublyLinkedList.toString());
    }

    @Test
    void removeBack()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.removeBack();
        assertEquals("[ ]", doublyLinkedList.toString());
        for (int i = 0; i < 3; i++)
        {
            doublyLinkedList.addBack(i);
        }
        doublyLinkedList.removeBack();
        assertEquals("[ 0, 1 ]", doublyLinkedList.toString());
        doublyLinkedList.removeBack();
        assertEquals("[ 0 ]", doublyLinkedList.toString());
    }

    @Test
    void remove()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.remove(4);
        assertEquals("[ ]", doublyLinkedList.toString());
        for (int i = 0; i < 10; i++)
        {
            doublyLinkedList.addBack(i);
        }
        assertEquals(3, doublyLinkedList.remove(3));
        assertEquals(7, doublyLinkedList.remove(6));

    }

    @Test
    void get()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        assertEquals(-99, doublyLinkedList.get(4));
        for (int i = 0; i < 10; i++)
        {
            doublyLinkedList.addBack(i);
        }
        assertEquals(3, doublyLinkedList.get(3));
    }

    @Test
    void contains()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        assertEquals(false, doublyLinkedList.contains(4));
        for (int i = 0; i < 10; i++)
        {
            doublyLinkedList.addBack(i);
        }
        assertEquals(true, doublyLinkedList.contains(3));
    }

    @Test
    void indexOf()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        assertEquals(-99, doublyLinkedList.indexOf(4));
        for (int i = 0; i < 10; i++)
        {
            doublyLinkedList.addBack(i);
        }
        assertEquals(3, doublyLinkedList.indexOf(3));
    }

    @Test
    void isEmpty()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        assertEquals(true, doublyLinkedList.isEmpty());
        for (int i = 0; i < 10; i++)
        {
            doublyLinkedList.addBack(i);
        }
        assertEquals(false, doublyLinkedList.isEmpty());
    }

    @Test
    void size()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        assertEquals(0, doublyLinkedList.size());
        for (int i = 0; i < 10; i++)
        {
            doublyLinkedList.addBack(i);
        }
        assertEquals(10, doublyLinkedList.size());
    }

    @Test
    void clear()
    {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.clear();
        assertEquals(new DoublyLinkedList(), doublyLinkedList);
        for (int i = 0; i < 10; i++)
        {
            doublyLinkedList.addBack(i);
        }
        doublyLinkedList.clear();
        assertEquals(new DoublyLinkedList(), doublyLinkedList);
    }
}