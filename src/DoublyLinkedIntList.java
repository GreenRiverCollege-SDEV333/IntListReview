import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedIntList implements IntList {
    private class Node {
        int data;
        Node next; // address of the node after this one in line
        Node prev; // address of the node before this one in line

        public Node() {
            next = null;
            prev = null;
        }
    }

    private Node pre;
    private Node post;
    private int size;

    public DoublyLinkedIntList() {
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
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = pre.next;
        newNode.next.prev = newNode;
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
        Node theNewOne = new Node();
        theNewOne.data = value;
        theNewOne.next = post;
        theNewOne.prev = theLastOne;

        // go to the end of the list's sentinel and update it's prev.
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
        Node finder = pre;
        for (int i = 0; i < index; i++) {
            finder = finder.next;
            }
        Node newNode = new Node();
        newNode.next = finder.next;
        finder.next = newNode;
        newNode.prev = finder;
        newNode.next.prev = newNode;
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        pre.next.data = 0;
        pre.next.next.prev = pre;
        pre.next = pre.next.next;

        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        Node theOneToRemove = post.prev;

        theOneToRemove.prev.next = post;
        post.prev = theOneToRemove.prev;
        theOneToRemove.next = null;
        theOneToRemove.prev = null;
        theOneToRemove.data = 0;

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
        Node finder = pre;
        for (int i = 0; i < index; i++) {
            finder = finder.next;
        }
        finder.prev.next = finder.next;
        finder.next.prev = finder.prev;
        finder.data = 0;
        finder.prev = null;
        finder.next = null;
        size--;
        return finder.data;
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
        Node finder = pre;
        for (int i = 0; i < index; i++) {
            finder = finder.next;
        }
        return finder.data;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        Node finder = pre;
        while (finder != post) {
            if (finder.data == value) {
                return true;
            }
            finder = finder.next;
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
        Node finder = pre;
        for (int i = 0; finder != post; i++) {
            if (finder.data == value) {
                return i;
            }
            finder = finder.next;
        }
        return -404;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return size > 0;
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
        return new DoublyLinkedIntList.DoublyLinkedIterator();
    }
    private class DoublyLinkedIterator implements Iterator<Integer> {

        private DoublyLinkedIntList.Node current;

        public DoublyLinkedIterator() {
            current = pre;
        }

        @Override
        public boolean hasNext() {
            if (current == null || current.next == null) {
                return false;
            } else {
                return true;
            }
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