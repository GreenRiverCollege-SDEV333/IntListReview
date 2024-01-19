import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList {

    //define what a Node is
    private class Node {
        int data;
        Node next;
    }

    private Node head;
    private int size;

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
        //set up a new node
        Node theNewOne = new Node();
        theNewOne.data = value;

        if (head == null) {
            // the list is currently empty
            head = theNewOne;
        }
        else {
            //the list currently has some nodes in it
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
    public void addBack(int value) {
        Node theNewOne = new Node();
        theNewOne.data = value;
        Node current = head;

        if (head == null) {
            head = theNewOne;
        }
        else {
            while (current.next != null) {
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
    public void add(int index, int value) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {
            Node theNewOne = new Node();
            theNewOne.data = value;
            Node current = head;

            while (index != 0) {
                current = current.next;
                index--;
            }
            if (current.next == null) {
                addBack(value);
            }
            else {
                theNewOne.next = current.next;
                current.next = theNewOne;
            }
            size++;
        }

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        head = head.next;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        Node current = head;

        if (head != null) {
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
            size--;
        }

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
        Node current = head;

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        else {

            while (index != 0) {
                if (index != 1) {
                    current = current.next;
                }
                index--;
            }

            int value = current.next.data;

            if (current.next.next != null) {
                //if the node to remove is not the last in the list
                current.next = current.next.next;
            }
            else {
                //if the node to remove is the last in the list
                current.next = null;
            }

            size--;
            return value;
        }

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
        Node current = head;

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        else {
            while (index != 0) {
                current = current.next;
                index--;
            }
            return current.data;
        }
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

        while (current.next != null) {
            if (current.data == value) {
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
        int counter = 0;

        while (current.next != null) {
            if (current.data == value) {
                return counter;
            }
            current = current.next;
            counter++;

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
        return head == null;
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
        head.data = 0;
        head.next = null;



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
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            int item = current.data;
            current = current.next;
            return item;
        }
    }
}
