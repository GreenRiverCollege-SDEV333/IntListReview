import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedIntListTest
{
    public DoublyLinkedIntList createList()
    {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addFront(5);
        list.add(1, 10);
        list.add(2, 15);
        list.add(3, 20);
        list.addBack(25);

        return list;
    }

    @Test
    void addFront()
    {
        DoublyLinkedIntList list = createList();
        list.addFront(50);
        assertEquals(50, list.get(0));
    }

    @Test
    void addBack()
    {
        DoublyLinkedIntList list = createList();
        list.addBack(30);
        assertEquals(30, list.get(list.size));
    }

    @Test
    void add()
    {
        DoublyLinkedIntList list = createList();
        list.add(5, 21);
        assertEquals(21, list.get(5));
    }

    @Test
    void removeFront()
    {
        DoublyLinkedIntList list = createList();
        int newHead = list.get(1);
        list.removeFront();
        assertEquals(newHead, list.get(0));
    }

    @Test
    void removeBack()
    {
        DoublyLinkedIntList list = createList();
        int newTail = list.get(list.size - 1);
        list.removeBack();
        assertEquals(newTail, list.get(list.size));
    }

    @Test
    void remove()
    {
        DoublyLinkedIntList list = createList();
        assertEquals(list.get(2), list.remove(2));
    }

    @Test
    void get()
    {
        DoublyLinkedIntList list = createList();
        assertEquals(20, list.get(3));
    }

    @Test
    void contains()
    {
        DoublyLinkedIntList list = createList();
        assertEquals(true, list.contains(20));
    }

    @Test
    void indexOf()
    {
        DoublyLinkedIntList list = createList();
        assertEquals(4, list.indexOf(25));
    }

    @Test
    void isEmpty()
    {
        DoublyLinkedIntList list = createList();
        assertEquals(false, list.isEmpty());
    }

    @Test
    void size()
    {
        DoublyLinkedIntList list = createList();
        assertEquals(5, list.size());
    }

    @Test
    void clear()
    {
        DoublyLinkedIntList list = createList();
        list.clear();
        assertEquals(true, list.isEmpty());
    }
}