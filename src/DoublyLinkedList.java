import java.util.Iterator;

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
        return 0;
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
        return false;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size() {
        return 0;
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
        return null;
    }
}