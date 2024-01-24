import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList {
    // Define what a node is
    private class Node {
        int data;
        Node next;
    }

    // Set up the head
    private Node head;

    // set up a size field
    private int size;

    // add a constructor to initialize
    public LinkedIntList() {
        head = null;
        size = 0;
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        //set up a new Node
        Node theNewOne = new Node();
        theNewOne.data = value;

        if (head == null) {
            // the list is currently empty
            head = theNewOne;
        }
        else {
            // the list currently has some nodes in it
            theNewOne.next = head;
            head = theNewOne;
        }

        size++;

    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value)
    {
        Node theNewOne = new Node();
        theNewOne.data = value;
        // set a marker
        Node current = head;
        if (head == null) {
            head = theNewOne;
        }
        else {
            // Move to the end
            while(current.next != null) {
                current = current.next;
            }
            current.next = theNewOne;
        }
        size++;

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
        if (index == 0)
        {
            head = new Node();
            head.data = value;

        }else
        {
            Node current = head;
            for (int i = 0; i < index - 1; i++)
            {
                current = current.next;
            }
            current.next = new Node();
            current.next.data = value;
            size++;
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
        if (!isEmpty())
        {
            head = head.next;
            size--;
        }

    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        Node beforeLast = head;
        while (beforeLast.next.next != null)
        {
            beforeLast = beforeLast.next;
        }
        beforeLast.next = null;
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
        if (index == 0)
        {
            head = head.next;
        }
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++)
            {
                current = current.next;

            }
            Node next = current.next.next;
            current.next = next;
            size--;
        }
        return 0;
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
        Node current = head;
        for (int i = 0; i < index; i++)
        {
            current = current.next;

        }
        return current.data;
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
        if (head == null)
        {
            return false;
        }
        else
        {
            Node current = head;

            while (current.next != null)
            {
                if (current.data == value)
                {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
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
        if (head == null)
        {
            return -1;
        }else
        {
            Node current = head;
            int index = 0;

            while (current != null)
            {
                if (current.data == value)
                {
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear()
    {
        size = 0;
        head = null;
    }

    /**
     * Prints out Linked List
     */
    public void printList()
    {
        Node current = head;
        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        return new SinglyLinkedIterator();
    }
    // helper class/type that defined how iterator works
    private class SinglyLinkedIterator implements Iterator<Integer>
    {
        // private fields
        private Node current;

        public SinglyLinkedIterator() {
            current = head;
        }

        @Override
        public boolean hasNext()
        {
            if (current != null) {
                return true;
            }
            else {
                return false;
            }
            //return current != null;
        }

        @Override
        public Integer next()
        {
            if (current == null) {
                throw new NoSuchElementException("There is no next one to go too!");
            }
            else {
                int item = current.data;
                current = current.next;
                return item;
            }
        }
    }
}
