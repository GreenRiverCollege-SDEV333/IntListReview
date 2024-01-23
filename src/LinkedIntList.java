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

    // Set up the size field
    private int size;

    // Add a constructor to initialize the fields
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
        Node theNewNode = new Node();
        theNewNode.data = value;
        Node placeHolder = head;
        if(size == 0) {
            // list is empty
            head = theNewNode;
        } else {
            // list isn't empty
            theNewNode.next = placeHolder;
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
        Node theNewNode = new Node();
        theNewNode.data = value;
        if(size == 0) {
            head = theNewNode;
        } else {
            // list isn't empty
            Node current = head;
            int counter = 0;
            while(current.next != null) {
                if(counter == (size - 1)) {
                    current.next = theNewNode;
                    break;
                }
                current = current.next;
                counter++;
            }
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
        if((size == 0 && index == 0) || (size == 1 && index == 0)) {
            addFront(value);
            size++;
        } else if(size > 0 && index < size && index >= 0) {
            Node current = head;
            Node newNode = new Node();
            newNode.data = value;
            int counter = 0;
            while(current.next != null) {
                if(counter == (index - 1)) {
                    newNode.next = current.next;
                    current.next = newNode;
                }
                current = current.next;
                counter++;
            }
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        Node placeHolder = head.next;
        if(size > 0) {
            // list isn't empty
            head = placeHolder;
            size--;
        }

    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if(size > 0) {
            // list isn't empty
            int counter = 0;
            Node current = head;
            while(current.next != null) {
                if(counter == (size - 2)) {
                    current.next = null;
                    break;
                }
                current = current.next;
                counter++;
            }
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
        if(size > 0 && index < (size - 1) && index > 0) {
            Node current = head;
            int counter = 0;
            while(current.next != null) {
                if(counter == (index - 1)) {
                    int removed = current.next.data;
                    current.next = current.next.next;
                    size--;
                    return removed;
                }
                current = current.next;
                counter++;
            }
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
    public int get(int index) {
        if(index > (size - 1) || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = head;
            int counter = 0;
            while(current != null) {
                if(counter == index) {
                    return current.data;
                }
                current = current.next;
                counter++;
            }
        }
        return -1;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        if(size > 0) {
            Node current = head;
            while(current != null) {
                if(current.data == value) {
                    return true;
                }
                current = current.next;
            }
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
        if(size > 0) {
            Node current = head;
            int counter = 0;
            while(current != null) {
                if(current.data == value) {
                    return counter;
                }
                current = current.next;
                counter++;
            }
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
        head = null;
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

        // Keeps track of node we're on
        private Node current;

        public SinglyLinkedIterator() {
            this.current = head;
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
