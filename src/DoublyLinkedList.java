import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList implements IntList {
    //define node
    private static class Node {
        int data;
        Node nextNode;
        Node previousNode;

        Node(int data) {
            this.data = data;
            this.nextNode = null;
            this.previousNode = null;
        }
    }
//set up size field
    //set up head and tail nodes
    private Node head;

    private Node tail;
    private int size;

//constructor
    public DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
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
        Node theNewNode = new Node(value);
        if (head != null) { //if list isn't empty, add node head and shift
            theNewNode.nextNode = head;
            head.previousNode = theNewNode;
            head = theNewNode;
        } else {
            head = theNewNode;
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
        Node theNewNode = new Node(value);
        if (head != null) {
            tail.nextNode = theNewNode;
            theNewNode.previousNode = tail;
            tail = theNewNode;
        } else {
            head = theNewNode; // Assign head when the list is empty
            tail = theNewNode;
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
        if (index != 0 && index != size - 1) { //if added node isn't the head or tail index
            Node newNode = new Node(value); // replace the node and shift to where previous node points
            Node currentNode = head;
            for (int filter = 0; filter < index; filter++) {
                currentNode = currentNode.nextNode;
            }
            newNode.previousNode = currentNode.previousNode;
            newNode.nextNode = currentNode;
            currentNode.previousNode.nextNode = newNode;
            currentNode.previousNode = newNode;
        } else if (index == 0) {
            addFront(value);
        } else {
            addBack(value);
        }
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if (head != null) { //if list isn't assign next node to head and set
            head = head.nextNode; // the node to null
            head.previousNode = null;
        } else {
            tail = null;
        }
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (tail != null) {
            if (tail.previousNode != null) {
                tail = tail.previousNode;
                tail.nextNode = null;
            } else {
                // If tail is the only node in the list
                tail = null;
                head = null;
            }
        }
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
        int removedData; //works similar to add method
        if (index != 0 && index != size - 1) { // if it isn't head or tail, remove the data
            Node currentNode = head; //and point the previous node to the next node of that node
            for (int filter = 0; filter < index; filter++) {
                currentNode = currentNode.nextNode;
            }
            removedData = currentNode.data;
            currentNode.previousNode.nextNode = currentNode.nextNode;
            currentNode.nextNode.previousNode = currentNode.previousNode;
        } else if (index == 0) {
            removedData = head.data;
            removeFront();
        } else {
            removedData = tail.data;
            removeBack();

        }
        size--;
        return removedData;
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
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node currentNode = head;
        for (int filter = 0; filter < index; filter++) {
            currentNode = currentNode.nextNode;
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
        while (currentNode != null) {
            if (currentNode.data == value) {
                return true;
            }
            currentNode = currentNode.nextNode;
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
        Node currentNode = head;
        for (int filter = 0; filter < size; filter++) { //filter counts the index
            if (currentNode.data == value) {
                return filter; //when data is found, it returns the index
            }
            currentNode = currentNode.nextNode;
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
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public void resize(int newSize) {

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new doublyLinkedIterator();
    }

    private class doublyLinkedIterator implements Iterator<Integer> {
        private Node current;

        public doublyLinkedIterator() {
            current = head;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
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
            if (current == null) {
                throw new NoSuchElementException("No next element available");
            }
            int thisNode = current.data;
            current = current.nextNode;
            return thisNode;
        }
    }
}
