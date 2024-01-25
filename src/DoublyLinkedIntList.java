import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedIntList implements IntList {

    // private fields
    private class Node {
        int data;
        Node next;                // address of the node "after" this one in line
        Node prev;                // address of the node "before" this one in line
    }

    public void Node() {
        post = null;
        pre = null;
    }

    private Node pre;
    private Node post;
    private int size;


    public DoublyLinkedIntList() {
        // an empty list has 2 sentitnal (dummy) nodes that serve as bookends
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
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
        Node newNode = new Node();
        newNode.data = value;
        newNode.prev = pre;
        newNode.next = pre.next;
        pre.next.prev = newNode;
        pre.next = newNode;
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        Node theLastOne = post.prev;

        // set up my new node and fill it out
        Node theNewOne = new Node();
        theNewOne.data = value;
        theNewOne.next = post;
        theNewOne.prev = pre;

        // go to the end of the lists's sentinal and update its prev.
        post.prev = theNewOne;

        // go to the node before the new one and update its next
        theLastOne.next = theNewOne;

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
            throw new IndexOutOfBoundsException("Index is out of range.");
        }

        if (index == size) {
            addBack(value);
        } else if (index == 0) {
            addFront(value);
        } else {
            Node newNode = new Node();
            newNode.data = value;

            Node current = pre.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
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
        if (size > 0) {
            Node firstNode = pre.next;
            pre.next = firstNode.next;
            firstNode.next.prev = pre;
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {

        if (size > 0) {
            // set up a temp variable for convenience;
            Node theOneToRemove = post.prev;

            theOneToRemove.prev.next = post;
            post.prev = theOneToRemove.prev;

            // optional clean up
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }

        Node current = pre.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;

        return current.data;
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }

        Node current = pre.next;
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
        Node current = pre.next;
        while (current != post) {
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
        Node current = pre.next;
        int index = 0;
        while (current != post) {
            if (current.data == value) {
                return index;
            }
            current = current.next;
            index++;
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
        pre.next = post;
        post.prev = pre;
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new DoublyLinkedIterator();
    }

    public class DoublyLinkedIterator implements Iterator<Integer> {

        private Node current = pre.next;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if (current == null) {
                return false;
            } else {
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
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no next one.");
            }

            int item = current.data;
            current = current.next;
            return item;
        }
    }
}
