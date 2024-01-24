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
    }

    @Test
    void add()
    {
    }

    @Test
    void removeFront()
    {
    }

    @Test
    void removeBack()
    {
    }

    @Test
    void remove()
    {
    }

    @Test
    void get()
    {
    }

    @Test
    void contains()
    {
    }

    @Test
    void indexOf()
    {
    }

    @Test
    void isEmpty()
    {
    }

    @Test
    void size()
    {
    }

    @Test
    void clear()
    {
    }
}