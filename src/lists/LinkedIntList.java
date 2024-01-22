package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

import interfaces.IntList;

/**
 * Class that instantiates a Linked List for Integer types
 *
 * @author tobygoetz
 * @version 1.0
 */
public class LinkedIntList implements IntList {

    // Fields
    private Node head;
    private int size;

    /**
     *  Constructor to initialize the fields of LinkedIntList
     */
    public LinkedIntList() {
        head = null;
        size = 0;
    }

    // Node Class
    private class Node {
        private Integer data;
        private Node next;

        /**
         * Constutor for Node that accepts on Integer data
         * and sets the next to null
         * @param data Integer value of Node
         */
        private Node(Integer data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Constutor for Node that accepts on Integer data
         * and sets the next to null
         * @param data Integer Value of Node
         * @param next Points to the next Node in list
         */
        private Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return data + " -> ";
        }
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
        // new Node to be added
        Node addedToFront = new Node(value);

        if (head == null) {
            // the list is currently empty
            head = addedToFront;
        } else {
            // the list currently has some nodes in it
            addedToFront.next = head;
            head = addedToFront;
        } size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {

        Node addToBack = new Node(value);

        if (head == null) {
            head = addToBack;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }
            current.next = addToBack;
        } size++;
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
        int dex = 1;
        //if requested index is out of range throw exception
        if (index < 0 || index > (size )) {
            throw new IndexOutOfBoundsException(
                    "Index must be in the Range 0-" + (size));
            //else find Node at index
        } else {
            //check if index is head
            if (index == 0) {
                addFront(value);
                //check if index is at the end
            } else if (index == (size)) {
                addBack(value);
                //remove everywhere else
            } else {
                Node current = head;
                while (dex <= index - 1) {
                    current = current.next;
                    dex++;
                }
                current.next = new Node(value, current.next);
                size++;
            }
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if (head != null) {
            if (head.next != null) {
                head = head.next;
                size--;
            } else {
                head = null;
                size--;
            }
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {

        if (head != null) {
            Node current = head;

            if (current.next != null) {
                while (current.next.next != null) {
                    current = current.next;
                }
                current.next = null;
                size--;
            } else {
                head = null;
                size = 0;
            }
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
        int dex = 1;
        int removedValue = get(index);

        //if requested index is out of range throw exception
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException(
                    "Index must be in the Range 0-" + (size - 1));
        //else find Node at index
        } else {
            //check if index is head
            if (index == 0) {
                removeFront();
            //check if index is at the end
            } else if (index == (size - 1)) {
                removeBack();
            //remove everywhere else
            } else {
                Node current = head;
                while (dex <= index - 1) {
                    current = current.next;
                    dex++;
                }
                current.next = current.next.next;
                size--;
            } return removedValue;
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
        int dex = 1;

        //if requested index is out of range throw exception
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException(
                    "Index must be in the Range 0-" + (size - 1));
        //else find Node at index
        } else {
            //head is always at index 0
            if (index == 0) {
                return head.data;
            } else {
                Node current = head;
                while(dex <= index) {
                    current = current.next;
                    dex++;
                }
                return dex;
            }
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

        if (head != null) {
            Node current = head;
            if (current.data == value) {
                return true;
            } else {
                while (current.next != null) {
                    current = current.next;
                    if (current.data == value) {
                        return true;
                    }
                }
            }
        } return false;
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
        if (!isEmpty()) {
            Node current = head;
            int index = 0;
            if (contains(value)) {
                while(current.data != value) {
                    current = current.next;
                    index++;
                } return index;
            }
        } return -1;
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

    /**
     * helper class/type that defines how the iterator works
     */
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
            if (current == null) {
                throw new NoSuchElementException("There is no next one to go to!");
            }
            int dataValue = current.data;
            current = current.next;
            return dataValue;
        }

        @Override
        public String toString() {
            return "SinglyLinkedIterator{" +
                    "Node=" + current +
                    '}';
        }
    }

    @Override
    public String toString() {
        Node current = head;
        String list = "LinkedIntList{size=" + size + ", list=[";

        if (current == null) {
            list += "]}";
        } else {
            while (current != null) {
                list += current.data;
                if (current.next != null) {
                    list += ", ";
                } else {
                    list += "]}";
                }
                current = current.next;
            }
        } return list;
    }
}
