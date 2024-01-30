import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Getting practice with implementing a LinkedList type class
 * @author Zalman I.
 */
public class LinkedIntList implements IntList {
    /**
     * A storage container which contains a connection to another Node
     */
    private static class Node {
        /**
         * The number stored within the Node
         */
        int data;

        /**
         * The node this Node is pointing to
         */
        Node next;
    }

    /**
     * The first Node of the current LinkedIntList
     */
    private Node head;

    /**
     * The number of Nodes contained within this LinkedIntList
     */
    private int size;

    /**
     * Constructs an empty LinkedIntList
     */
    public LinkedIntList() {
        // the LinkedIntList is empty
        head = null;

        // there are no values contained within this LinkedIntList
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
        // construct a new Node to hold given value
        Node newNode = new Node();
        newNode.data = value;

        // if the LinkedIntList is not empty
        if(head != null) {
            // point the newly created Node at head
            newNode.next = head;
        }

        // override head with newly created node (making it the first element in LinkedIntList)
        head = newNode;

        // a new element has been added, increment size
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        // if the LinkedIntList is empty
        if(head == null) {
            // add current value as head
            addFront(value);
        }

        else {
            // construct a new Node to hold given value
            Node newNode = new Node();
            newNode.data = value;

            // setup pointer
            Node pointer = head;

            // run through LinkedIntList, up to the last Node
            while(pointer.next != null) {
                pointer = pointer.next;
            }

            // point the last Node at the newly created Node
            pointer.next = newNode;

            // a new element has been added, increment size
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
        // if index out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // if the given index is 0 or list is empty, add value at front of list
        if(index == 0) {
            addFront(value);
        }

        // if the given index is size, add value at back of list
        else if(index == size) {
            addBack(value);
        }

        // otherwise insert it somewhere in the middle
        else {
            // construct a new Node to hold given value
            Node newNode = new Node();
            newNode.data = value;

            // setup current index tracker
            int currIndex = 0;

            // setup pointers
            Node previous = null;
            Node pointer = head;

            // run through LinkedIntList, up to specified index
            while (pointer != null && currIndex != index) {
                // update pointers
                previous = pointer;
                pointer = pointer.next;

                // update tracker
                currIndex++;
            }

            // update Nodes around index to account for newly created Node
            previous.next = newNode;
            newNode.next = pointer;

            // a new element has been added, increment size
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
        // if the list is empty
        if(head == null) {
            throw new NoSuchElementException("Cannot remove values from empty LinkedIntList");
        }

        // otherwise, replace current head with the Node its pointing to
        head = head.next;

        // account for element removal
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        // if the list is empty
        if (head == null) {
            throw new NoSuchElementException("Cannot remove values from empty LinkedIntList");
        }

        // setup pointer
        Node pointer = head;

        // run through LinkedIntList, up to the second to last Node
        while (pointer.next.next != null) {
            pointer = pointer.next;
        }

        // point the Node before last Node at null, thereby overriding it
        pointer.next = null;

        // account for element removal
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
        // if index out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // if the list is empty
        if (head == null) {
            throw new NoSuchElementException("Cannot remove values from empty LinkedIntList");
        }

        // setup tracker
        int requestedValue = 0;

        // if the given index is 0, return and remove value at front of list
        if(index == 0) {
            requestedValue = head.data;
            removeFront();
            return requestedValue;
        }

        // setup current index tracker
        int currIndex = 0;

        // setup pointers
        Node previous = null;
        Node pointer = head;

        // run through LinkedIntList, up to specified index
        while (pointer != null && currIndex != index) {
            // update pointers
            previous = pointer;
            pointer = pointer.next;

            // update tracker
            currIndex++;
        }

        // get value in Node at current index
        requestedValue = pointer.data;

        // update Nodes around index to remove specified node
        previous.next = pointer.next;

        // account for element removal
        size--;

        // return the requested value
        return requestedValue;
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
        // if index out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // if list contains no values
        if(size == 0) {
            throw new NoSuchElementException("Cannot remove values from empty LinkedIntList");
        }

        // setup current index tracker
        int currIndex = 0;

        // setup pointer
        Node pointer = head;

        // run through LinkedIntList, up to specified index
        while (pointer != null && currIndex != index) {
            // move onto next Node
            pointer = pointer.next;

            // update tracker
            currIndex++;
        }

        // return data stored within Node at specified index
        return pointer.data;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        //    // if the LinkedIntList is not empty
        //    if(head != null) {
        //        // setup pointer
        //        Node pointer = head;
        //
        //        // run through LinkedIntList
        //        while(pointer != null) {
        //            // if the data in current node is specified value
        //            if(pointer.data == value) {
        //                // return true as the value was located
        //                return true;
        //            }
        //
        //            // move onto next Node
        //            pointer = pointer.next;
        //        }
        //    }

        // if value could not be found, or list was empty
        return indexOf(value) != -1;
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
        // if the LinkedIntList is not empty
        if(head != null) {
            // setup index tracker
            int index = 0;

            // setup pointer
            Node pointer = head;

            // run through LinkedIntList
            while (pointer != null) {
                // if the data in current node is specified value
                if (pointer.data == value) {
                    // return the current index
                    return index;
                }

                // move onto next Node
                pointer = pointer.next;

                // update tracker
                index++;
            }
        }

        // if value could not be found, or list was empty
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
        // if the list is not already empty
        if(head != null) {
            // reset head node and point it at nothing
            head.next = null;
            head = null;

            // set the size to 0, as there are no longer any values being tracked
            size = 0;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new LinkedIntListIterator();
    }

    /**
     * Implementation of an Iterator for the LinkedIntList class
     */
    private class LinkedIntListIterator implements Iterator<Integer> {
        /**
         * The current Node being tracked by the Iterator
         */
        private Node current;

        /**
         * Constructs a LinkedIntListIterator with the head tracked as the first Node
         */
        LinkedIntListIterator() {
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
            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            // get the value in current Node
            int value = current.data;

            // move on to the next node
            current = current.next;

            // return the requested value
            return value;
        }
    }
}