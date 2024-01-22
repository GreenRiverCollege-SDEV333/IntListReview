import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList {

    // define what a node is
    private class Node {
        int data;
        Node next;
    }

    // set up the head field
    private Node head;
    private Node current;

    // set up the size field
    private int size;

    //add a constructor to initialize
    public LinkedIntList()
    {
        head = null;
        size = 0;
        current = null;
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value)
    {
        // set up a new node
        Node theNewOne = new Node();

        if (head == null) {
            // the list is currently empty
            head = theNewOne;
            head.data = value;
            size++;
        }
        else {
            // the list currently has some nodes in it
            theNewOne.next = head;
            head = theNewOne;
            head.data = value;
            size++;
        }
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value)
    {
        //create a current to traverse list
        //create new node
        Node current = head;
        Node node = new Node();

        node.data = value;
        //if the next doesn't equals null,
        //continue

        //otherwise, assign the current.next to the new value
        if (current.next != null)
        {
            current = current.next;
        }
        else
        {
            current.next = node;
        }
    }

    /**
     * Inserts the specified value at the specified position in this list.
     * Shifts the value currently at that position (if any) and any subsequent
     * values to the right.
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value)
    {
        //keep track of current
        Node current = head;
        int currentIndex = 0;
        Node newNode = new Node();
        newNode.data = value;

        //invalid index
        if (index < 0)
        {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        //if head is null
        if (head == null)
        {
            head.data = value;
        }
        else
        {
            while (currentIndex != index)
            {
                current = current.next;
                currentIndex++;
            }
            current = newNode;
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()
    {
        if (head == null)
        {
            throw new NoSuchElementException("The list is empty");
        }
        head = head.next;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        Node current = head;
        while (current.next != null)
        {
            current = current.next;
        }
        current = null;
    }

    /**
     * Removes the value at the specified position in this list.
     * Shifts any subsequent values to the left. Returns the value
     * that was removed from the list.
     *
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int remove(int index)
    {
        int currentIndex = 0;
        Node current = head;
        Node previous = current;

        while (currentIndex != index)
        {
            previous = current;
            current = current.next;
        }
        previous = current.next;

    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index)
    {

    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value)
    {
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    @Override
    public int indexOf(int value)
    {
        return 0;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty()
    {
        return false;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size()
    {
        return 0;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear()
    {

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        SinglyLinkedIterator theIterator = new SinglyLinkedIterator();
        return theIterator;
//        return new SinglyLinkedIterator();
    }

    //helper class/type that defines how the iterator works
    private class SinglyLinkedIterator implements Iterator<Integer>{

        private Node current;

        public SinglyLinkedIterator() {
            current = head;
        }
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext()
        {
            //return current != null; <----- another way to write this
            if (current == null) {
                return false;
            }
            else {
                return true;
            }
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next()
        {
            if (current == null)
            {
                throw new NoSuchElementException("There is no next one to go to!!");
            }
            int item = current.data;
            current = current.next;
            return item;
        }
    }
}
