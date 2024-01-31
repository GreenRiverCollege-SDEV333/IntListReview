import java.util.Iterator;

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

    // adda constructor to initialize the fields
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
        Node theNewOne = new Node();

        if (head == null) {
            // the list is currently empty
            head = theNewOne;

            size++;
        }
        else {
            // the list currently has some nodes in it
            theNewOne.next = head;
            head = theNewOne;

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
        Node theNewOne = new Node();
        Node currentNode = head;

        // For each size, we will move the currentNode next until we reach the size so that we can set the currenNode.next to theNewOne which means that we added a new node in the back
        for (int i = 0; i < size; i++) {
            currentNode = currentNode.next;
        }

        currentNode.next = theNewOne;
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
        Node currentNode = head;
        int lastData;

        // If the index is less than or equal to size since it won't makes sense to work if it's bigger than the size
        if (index <= size) {
            for (int i = 0; i < size - index; i++) {
                currentNode = currentNode.next;
            }

            // First time
            lastData = currentNode.next.data; // Grabs the next data so it won't be lost
            currentNode.next = currentNode; // The next node is equal to the current node
            currentNode.data = value; // Replaces the current data to the value since we are adding the index here
            currentNode = currentNode.next; // Then we move to the next node

            // The rest of the time
            for (int i = size + 1; i > index; i--) {
                currentNode.data = lastData;
                lastData = currentNode.next.data; // Grabs the next data so it won't be lost
                currentNode.next = currentNode; // The next node is equal to the current node
                currentNode = currentNode.next; // Then we move to the next node
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
        Node currentNode = head;

        for (int i = 0; i < size - 1; i++) {
            currentNode.data = currentNode.next.data;
            currentNode = currentNode.next;
        }

        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        Node currentNode = head;

        for (int i = 0; i < size; i++) {
            currentNode = currentNode.next;
        }

        currentNode.data = 0;
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
        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
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
        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        Node currentNode = head;
        boolean containValue = false;

        for (int i = 0; i < size; i++) {
            if (currentNode.data == value) {
                containValue = true;
            }

            currentNode = currentNode.next;
        }

        return containValue;
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
        Node currentNode = head;
        int indexOfValue = -1;

        for (int i = 0; i < size; i++) {
            if (currentNode.data == value) {
                indexOfValue = i;
            }

            currentNode = currentNode.next;
        }

        return indexOfValue;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        }
        else {
            return true;
        }
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
        Node currentNode = head;

        for (int i = 0; i < size; i++) {
            currentNode.data = 0;
            currentNode = currentNode.next;
        }

        size = 0;
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
