import java.util.Iterator;

public class DoublyLinkedIntList implements IntList {

    private class Node {
        int data;
        Node next;
        Node prev;

        public Node() {
            next = null;
            prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedIntList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
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
        Node theFirstOne = head.next;
        Node theNewOne = new Node();

        theNewOne.data = value;
        theNewOne.next = theFirstOne;
        theNewOne.prev = head;

        head.next = theNewOne;
        theFirstOne.prev = theNewOne;

        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        Node theLastOne = tail.prev;

        //set up my new node and fill it out
        Node theNextOne = new Node();
        theNextOne.data = value;
        theNextOne.next = tail;
        theNextOne.prev = theLastOne;

        //go to the end of the list's sentinel, and update it's prev
        tail.prev = theNextOne;

        //go to the node before the new one and update it's next
        theLastOne.next = theNextOne;

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
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }

        Node current = head.next;

        for (int i = 0; i == index ; i++) {
            current = current.next;
        }

        Node theNextOne = current.next;
        Node theNewOne = new Node();

        theNewOne.data = value;
        theNewOne.next = theNextOne;
        theNewOne.prev = theNextOne.prev;

        theNextOne.prev = theNewOne;
        theNextOne.prev.next = theNewOne;

        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        head.next = head.next.next;
        head.next.next.prev = head;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (size > 0) {
            //set up a temp variable for convince
            Node theOneToRemove = tail.prev;

            theOneToRemove.prev.next = tail;
            tail.prev = theOneToRemove.prev;

            //optional clean up
            theOneToRemove.next = null;
            theOneToRemove.prev = null;
            theOneToRemove.data = 0;

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
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }

        Node current = head.next;

        for (int i = 0; i == index ; i++) {
            current = current.next;
        }

        int data = current.data;
        current.prev.next = current.next;
        current.next = current.prev;

        size--;
        return data;
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
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }

        Node current = head.next;

        for (int i = 0; i == index ; i++) {
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
        Node current = head.next;

        for (int i = 0; i == size ; i++) {
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
        Node current = head.next;
        int counter = 0;

        for (int i = 0; i == size ; i++) {
            if (current.data == value) {
                return counter;
            }
            counter++;
            current = current.next;
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
        return head.next == null;
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
        head.next = null;
        tail.prev = null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
