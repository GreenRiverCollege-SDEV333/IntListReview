import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedIntListTest
{
    private DoublyLinkedIntList emptyList;
    private DoublyLinkedIntList fullList;
    private DoublyLinkedIntList oneItemList;
    private DoublyLinkedIntList twoItemList;

    public void createLists()
    {
        //empty list
        emptyList = new DoublyLinkedIntList();

        //full list
        fullList = new DoublyLinkedIntList();
        fullList.addFront(5);
        fullList.add(1, 10);
        fullList.add(2, 15);
        fullList.add(3, 20);
        fullList.addBack(25);

        //one item list
        oneItemList = new DoublyLinkedIntList();
        oneItemList.addFront(5);

        //two items
        twoItemList = new DoublyLinkedIntList();
        twoItemList.addFront(5);
        twoItemList.addBack(25);
    }

    @Test
    void addFront()
    {
        createLists();
        emptyList.addFront(7);
        fullList.addFront(7);
        oneItemList.addFront(7);
        twoItemList.addFront(7);

        assertEquals(7, emptyList.get(0));
        assertEquals(7, fullList.get(0));
        assertEquals(7, oneItemList.get(0));
        assertEquals(7, twoItemList.get(0));
//        DoublyLinkedIntList list = createList();
//        list.addFront(50);
//        assertEquals(50, list.get(0));
    }

    @Test
    void addBack()
    {
        createLists();
        emptyList.addBack(1);
        fullList.addBack(1);
        oneItemList.addBack(1);
        twoItemList.addBack(1);

        assertEquals(1, emptyList.get(emptyList.size));
        assertEquals(1, fullList.get(fullList.size));
        assertEquals(1, oneItemList.get(oneItemList.size));
        assertEquals(1, twoItemList.get(twoItemList.size));

//        DoublyLinkedIntList list = createList();
//        list.addBack(30);
//        assertEquals(30, list.get(list.size));
    }

    @Test
    void add()
    {
        createLists();

//        emptyList.add(1, 3); -> throws IndexOutOfBoundException
        fullList.add(1, 3);
        oneItemList.add(1, 3);
        twoItemList.add(1, 3);

        assertEquals(3, fullList.get(1));
        assertEquals(3, oneItemList.get(1));
        assertEquals(3, twoItemList.get(1));

//        DoublyLinkedIntList list = createList();
//        list.add(5, 21);
//        assertEquals(21, list.get(5));
    }

    @Test
    void removeFront()
    {
        createLists();

        int removedElementOne = fullList.get(0);
        int removedElementTwo = oneItemList.get(0);
        int removedElementThree = twoItemList.get(0);
        int removedElement = 5;

//        assertEquals(emptyList); -> Throws exception
        fullList.removeFront();
        oneItemList.removeFront();
        twoItemList.removeFront();

        assertEquals(removedElement, removedElementOne);
        assertEquals(removedElement, removedElementTwo);
        assertEquals(removedElement, removedElementThree);

//        DoublyLinkedIntList list = createList();
//        int newHead = list.get(1);
//        list.removeFront();
//        assertEquals(newHead, list.get(0));
    }

    @Test
    void removeBack()
    {
        createLists();

//        emptyList.removeFront();
        fullList.removeBack();
        oneItemList.removeBack();
        twoItemList.removeBack();

//        assertEquals();
//        DoublyLinkedIntList list = createList();
//        int newTail = list.get(list.size - 1);
//        list.removeBack();
//        assertEquals(newTail, list.get(list.size));
    }

    @Test
    void remove()
    {
        createLists();

        assertEquals(5, fullList.remove(0));
        assertEquals(5, oneItemList.remove(0));
        assertEquals(5, twoItemList.remove(0));
//        DoublyLinkedIntList list = createList();
//        assertEquals(list.get(2), list.remove(2));
    }

    @Test
    void get()
    {
        createLists();

//        assertEquals(5, fullList.indexOf(0));
        assertEquals(5, fullList.get(0));
        assertEquals(5, oneItemList.get(0));
        assertEquals(5, twoItemList.get(0));
    }
//
    @Test
    void contains()
    {
        createLists();

        assertEquals(true, fullList.contains(5));
        assertEquals(true, oneItemList.contains(5));
        assertEquals(true, twoItemList.contains(5));


//        DoublyLinkedIntList list = createList();
//        assertEquals(true, list.contains(20));
    }

    @Test
    void indexOf()
    {
        createLists();

//        assertEquals(1, emptyList);
        assertEquals(0, fullList.indexOf(0));
        assertEquals(0, oneItemList.indexOf(0));
        assertEquals(0, twoItemList.indexOf(0));

//        DoublyLinkedIntList list = createList();
//        assertEquals(4, list.indexOf(25));
    }

    @Test
    void isEmpty()
    {
        createLists();

        assertEquals(true, emptyList);
        assertEquals(false, fullList);
        assertEquals(false, oneItemList);
        assertEquals(false, twoItemList);
//        DoublyLinkedIntList list = createList();
//        assertEquals(false, list.isEmpty());
    }

    @Test
    void size()
    {
        createLists();

        assertEquals(0, emptyList.size());
        assertEquals(5, fullList.size());
        assertEquals(1, oneItemList.size());
        assertEquals(2, twoItemList.size());
//        DoublyLinkedIntList list = createList();
//        assertEquals(5, list.size());
    }

    @Test
    void clear()
    {
        createLists();

        emptyList.clear();
        fullList.clear();
        oneItemList.clear();
        twoItemList.clear();

        assertEquals(true, emptyList.isEmpty());
        assertEquals(true, emptyList.isEmpty());
        assertEquals(true, emptyList.isEmpty());
        assertEquals(true, emptyList.isEmpty());

    }
}