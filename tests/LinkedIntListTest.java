import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest
{
    public LinkedIntList createList()
    {
        int sizeOfList = 5;
        LinkedIntList list = new LinkedIntList();
        list.addFront(1);

        for (int i = 2; i < sizeOfList; i++)
        {
            Random rand = new Random();
            int randomNum = rand.nextInt(100);
            list.add(i, randomNum);
        }
        return list;
    }

    @Test
    void addFront()
    {
       LinkedIntList linkedList = createList();
       linkedList.addFront(1);
       assertEquals(1, linkedList.get(0));
    }

    @Test
    void addBack()
    {
        LinkedIntList linkedIntList = createList();
        linkedIntList.addBack(2);
        assertEquals(2, linkedIntList.get(linkedIntList.size()));
    }

    @Test
    void add()
    {
        LinkedIntList linkedIntList = createList();
        linkedIntList.add(3, 5);
        assertEquals(5, linkedIntList.get(3));
    }

    @Test
    void removeFront()
    {
        LinkedIntList linkedIntList = createList();
        int newFront = linkedIntList.get(1);
        linkedIntList.removeFront();
        assertEquals(linkedIntList.get(0), newFront);
    }

    @Test
    void removeBack()
    {
        LinkedIntList linkedIntList = createList();
        int newLastNode = linkedIntList.get(linkedIntList.size() - 1);
        linkedIntList.removeBack();
        assertEquals(linkedIntList.get(linkedIntList.size() - 1), newLastNode);
    }

    @Test
    void remove()
    {
        LinkedIntList linkedIntList = createList();
        int removedNode = linkedIntList.get(2);
        assertEquals(removedNode, linkedIntList.remove(2));
    }

    @Test
    void get()
    {
        LinkedIntList linkedIntList = createList();
        int retrievedData = linkedIntList.get(3);
        assertEquals(retrievedData, linkedIntList.get(3));
    }

    @Test
    void contains()
    {
        LinkedIntList linkedIntList = createList();
        linkedIntList.add(linkedIntList.size(), 3);
        assertEquals(true, linkedIntList.contains(3));
    }

    @Test
    void indexOf()
    {
        LinkedIntList fixedList = new LinkedIntList();
        fixedList.add(0, 1);
        fixedList.add(1, 2);
        fixedList.add(2, 3);

        fixedList.addBack(6);
        assertEquals(fixedList.size() - 1, fixedList.indexOf(6));
    }

    @Test
    void isEmpty()
    {
        LinkedIntList emptyList = new LinkedIntList();
        assertEquals(true, emptyList.isEmpty());
    }

    @Test
    void size()
    {
        LinkedIntList linkedIntList = createList();
        assertEquals(4, linkedIntList.size());
    }

    @Test
    void clear()
    {
        LinkedIntList linkedIntList = createList();
        int size = linkedIntList.size();
        linkedIntList.clear();
        assertEquals(true, linkedIntList.isEmpty());
    }
}