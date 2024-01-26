import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList{

    // define what a node is
    private class Node {
        int data;
        Node next;
    }


    // set up the head
    private Node head;

    //set up the size field
    private int size;

    // add a constructor to initialize the fields
    private LinkedIntList(){
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
        Node newOne = new Node();
        newOne.data = value;
        if(head == null)
        {
            // the list is currently empty
            newOne.next = null;
            head = newOne;
            size++;
            return;
        }
        // the list currently has some nodes in it
        newOne.next = head;
        head = newOne;
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        Node newOne = new Node();
        newOne.data = value;
        if(head == null)
        {
            // the list is currently empty
            newOne.next = null;
            head = newOne;
            size++;
            return;
        }
        // the list currently has some nodes in it
        Node current = head;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = newOne;
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
    public void add(int index, int value) {
        // throw exception if index given is out of bounds
        if(index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index given!");
        }
        // current Node to keep track of index
        Node current = head;
        // create a new Node
        Node theNewOne = new Node();
        // set the new Nodes value
        theNewOne.data = value;
        // check if index is at the end of the LinkedList
        if(index == size()-1)
        {
            // loop to end of the list
            while(current.next != null)
            {
                current = current.next;
            }
            // add the new Node
            current.next = theNewOne;
            size++;
            return;
        }
        // else, for loop that stops one before new indexed Node
        for (int i = 0; i < index-1; i++) {
            current = current.next;
        }
        // save the old Node from that index so we can move it forward one space
        Node nodeAfterAdded = current.next;
        // put the new Node in current.next position
        current.next = theNewOne;
        // move current forward one
        current = current.next;
        // set the previous index Node forward one index position (e.g. index 3 Node would now become index 4)
        current.next = nodeAfterAdded;
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if(size() > 0)
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
    public void removeBack() {
        if(size() <= 1)
        {
            head = null;
        }
        Node current = head;
        for (int i = 0; i < size()-2; i++) {
            current = current.next;
        }
        current.next = null;
        size--;
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
    public int remove(int index) {
        // check if index is invalid
        if(index >= size() || index < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index given!");
        }
        // current Node to iterate through LinkedList
        Node current = head;
        // loop until one Node before our index
        for (int i = 0; i < index-1; i++) {
            current = current.next;
        }
        // save our value that will be removed
        int dataToBeRemoved = current.next.data;
        // check if there are two Nodes ahead for easy shifting
        if(size()-index > 1)
        {
            // move current.next an additional space forward
            current.next = current.next.next;
            return dataToBeRemoved;
        }
        // else, remove the next Node (there are no Nodes ahead of our index
        current.next = null;
        return dataToBeRemoved;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        if(index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index given!");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
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
    public boolean contains(int value) {
        Node current = head;
        while(current != null)
        {
            if(current.data == value)
            {
                return true;
            }
            current = current.next;
        }
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
    public int indexOf(int value) {
        Node current = head;
        int nodeCounter = 0;
        while(current != null)
        {
            if(current.data == value)
            {
                return nodeCounter;
            }
            current = current.next;
            nodeCounter++;
        }
        return -1;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        head = new Node();
        head.data = 0;
        head.next = null;
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new SinglyLinkedIterator();
    }

    // helper class/type that defines how the iterator works
    private class SinglyLinkedIterator implements Iterator<Integer> {
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
        public boolean hasNext() {
            if(current != null)
            {
                return true;
            }
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            if(current == null)
            {
                throw new NoSuchElementException("There is no next element!");
            }
            int item = current.data;
            current = current.next;
            return item;
        }
    }
}
