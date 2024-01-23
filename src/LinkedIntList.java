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
    // set up the size field
    private int size;

    // add a constructor to initialize the fields
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
        // set up a new node
        Node newNode = new Node();

        if (head == null) {
            // the list is currently empty
            head = newNode;
            head.data = value;
            size++;
        }
        else {
            // the list currently has some nodes in it
            newNode.next = head;
            head = newNode;
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
    public void addBack(int value) {
        Node newNode = new Node();
        newNode.data = value;

        if (head == null) {
            // If the list is empty, addFront can be used
            addFront(value);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;
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
    public void add(int index, int value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bound.");
        }
        //create new node
        Node node = new Node();
        //set new value to new node
        node.data = value;
        Node current = head;
        // if index = 0 add the value to front
        if (index == 0) {
            this.addFront(value);
            //if value = to size, add the value to the end of the node
        } else if (index == size) {
            this.addBack(value);
        } else {

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
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
        //check whether the linklist is empty or not
        if (head == null) {
            return;
        }
        //set head to the next index and reduce size
        head = head.next;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        //check if the linklist is empty
        //if there is only 1 value in the linklist, set the value to null
        if (head == null || head.next == null) {
            head = null;
        } else {
            Node current = head;

            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--; // Decrement the size
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
    public int get(int index) {
        if (head == null) {
            throw new NoSuchElementException("The list is empty");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        int newIndex = 0;
        Node current = head;
        while (current != null) {
            if (newIndex == index) {
                return current.data;
            }
            current = current.next;
            newIndex++;
        }
        throw new IndexOutOfBoundsException("Index beyond size of list");
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
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
        return 0;
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

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        SinglyLinkedIterator theIterator = new SinglyLinkedIterator();
        return theIterator;
    }

    // helper class/type that defines how the iterator works
    private class SinglyLinkedIterator implements Iterator<Integer> {

        // private int i;       // the index of the item I am on in the arraylist
        private Node current;

        public SinglyLinkedIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (current == null) {
                throw new NoSuchElementException("There is no next one to go to!!");
            }

            int item = current.data;
            current = current.next;
            return item;
        }
    }

}
