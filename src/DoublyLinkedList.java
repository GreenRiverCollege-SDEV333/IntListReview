/*
 * Giovan Cervantes
 * Jan 21st, 2024
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList implements IntList {

    // Private fields
    private class Node {
        int data;
        Node next; // address of the node "after" this one in line
        Node prev; // address of the node "before" this one in line

        public Node() {
            next = null;
            prev = null;
        }
    }

    // sentinel/dummy nodes
    private Node pre;
    private Node post;
    private int size;

    public DoublyLinkedList() {
        // an empty list has 2 sentinel (dummy) nodes that serve as bookends
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
        // create a placeholder node for the original first node
        Node originalFirst = pre.next;

        // the new node to be added to the front
        Node theNewNode = new Node();
        theNewNode.data = value;

        // set theNewNode.next to the original first
        theNewNode.next = originalFirst;

        // set theNewNode.prev to the pre sentinel
        theNewNode.prev = pre;

        // connects the originalFirst to the new node
        originalFirst.prev = theNewNode;

        // connects the pre sentinel node to the new node
        pre.next = theNewNode;

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

        // set up the new node and fill it out
        Node theNewNode = new Node();
        theNewNode.data = value;
        theNewNode.next = post;
        theNewNode.prev = theLastOne;

        // go to the end of the list's sentinel, and update its prev
        post.prev = theNewNode;

        // go to the node before the new one, and update it's next
        theLastOne.next = theNewNode;

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
        if(isEmpty() && index == 0) {
            addFront(value);
        } else if(index > (size - 1) || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = pre.next;
            int counter = 0;
            while(current.next != null) {
                if(counter == index) {
                    Node newNode = new Node();
                    newNode.data = value;

                    newNode.next = current;
                    newNode.prev = current.prev;
                    current.prev = newNode;
                    newNode.prev.next = newNode;
                }
                current = current.next;
                counter++;
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
        if(size > 0) {
            Node removed = pre.next;

            pre.next = removed.next;
            removed.next.prev = pre;

            removed.next = null;
            removed.prev = null;
            removed.data = 0;

            size--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if(size > 0) {
            Node removed = post.prev;

            removed.prev.next = post;
            post.prev = removed.prev;

            removed.next = null;
            removed.prev = null;
            removed.data = 0;

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
        if(index > (size - 1) || index < 0 || isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = pre.next;
            int counter = 0;
            while(current.next != null) {
                if(counter == index) {
                    int removed = current.data;
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    return removed;
                }
                current = current.next;
                counter++;
            }
        }
        return -1;
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
        if(isEmpty() && index == 0) {
            return -1;
        } else if(index > (size - 1) || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = pre.next;
            int counter = 0;
            while(current.next != null) {
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
        if(!isEmpty()) {
            Node current = pre.next;
            while(current.next != null) {
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
        if(!isEmpty()) {
            Node current = pre.next;
            int counter = 0;
            while(current.next != null) {
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
        return this.size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        pre.next = post;
        post.prev = pre;

        pre.prev = null;
        post.next = null;

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

    // helper class/type that defines how the iterator works

    private class DoublyLinkedIterator implements Iterator<Integer> {

        private Node current;

        public DoublyLinkedIterator() {
            this.current = pre.next;
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
