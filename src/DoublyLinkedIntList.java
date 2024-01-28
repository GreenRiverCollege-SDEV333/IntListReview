import java.util.Iterator;

public class DoublyLinkedIntList implements IntList{
    // private fields
    private class Node {
        int data;
        Node next; // address of the node "after" this one in line
        Node prev; // address of the node "before" this one in line

        public Node()
        {
            next = null;
            prev = null;
        }
    }

    private Node pre;
    private Node post;
    private int size;

    //constructor
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
        Node theFirstOne = pre.next;
        // set up my new node and fill it out (data, prev, next)
        Node theNewOne = new Node();
        theNewOne.data = value;
        theNewOne.prev = pre;
        theNewOne.next = theFirstOne;
        // go to the front of the list's sentinel, and update it's next
        pre.next = theNewOne;
        // go to the node after the new one, and update it's prev
        theFirstOne.prev = theNewOne;
        // increment size
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
        // set up my new node and fill it out (data, prev, next)
        Node theNewOne = new Node();
        theNewOne.data = value;
        theNewOne.next = post;
        theNewOne.prev = theLastOne;
        // go to the end of the list's sentinel, and update it's prev
        post.prev = theNewOne;
        // go to the node before the new one, and update it's next
        theLastOne.next = theNewOne;
        // increment size
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
        if(size < index)
        {
            System.out.println("Index out of bounds!");
            return;
        }
        if(size == 0)
        {
            Node theNewOne = new Node();
            theNewOne.data = value;
            theNewOne.next = post;
            theNewOne.prev = pre;
            pre.next = theNewOne;
            post.prev = theNewOne;
            size++;
            return;
        }
        Node current = pre;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node theNewOne = new Node();
        theNewOne.data = value;
        theNewOne.next = current.next;
        theNewOne.next.prev = theNewOne;
        current.next = theNewOne;
        theNewOne.prev = current;
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if(size > 0)
        {
            // set up a temporary variable for convenience
            Node theOneToRemove = pre.next;
            theOneToRemove.next.prev = pre;
            pre.next = theOneToRemove.next;
            // decrement size
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if(size > 0)
        {
            // set up a temporary variable for convenience
            Node theOneToRemove = post.prev;
            theOneToRemove.prev.next = post;
            post.prev = theOneToRemove.prev;
            /*
            if you do not want to create a temp variable:
            post.prev = post.prev.prev;
            post.prev.prev.next = post;
             */

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
        // check if index is valid
        if(index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index given!");
        }
        // set midpoint to check which sentinel value is closer
        int mid = size / 2;
        // check if index is closer to pre
        if(index <= mid)
        {
            Node current = pre.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            // save value to be returned
            int valueToBeReturned = current.data;
            // move prev.next to next Node
            current.prev.next = current.next;
            // move next.prev to prev Node
            current.next.prev = current.prev;
            size--;
            return valueToBeReturned;
        }
        // else, index is closer to post
        Node current = post.prev;
        for (int i = size-1; i > index; i--) {
            current = current.prev;
        }
        // save value to be returned
        int valueToBeReturned = current.data;
        // move prev.next to next Node
        current.prev.next = current.next;
        // move next.prev to prev Node
        current.next.prev = current.prev;
        size--;
        return valueToBeReturned;
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
        // check if index is valid
        if(index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index given!");
        }
        // set midpoint to check which sentinel value is closer
        int mid = size / 2;
        // check if index is closer to pre
        if(index <= mid)
        {
            Node current = pre.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }
        // else, index is closer to post
        Node current = post.prev;
        for (int i = size-1; i > index; i--) {
            current = current.prev;
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
        Node current = pre;
        while(current != post)
        {
            if(current.data == value)
            {
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
        int indexCounter = 0;
        while(current != post)
        {
            if(current.data == value)
            {
                return indexCounter;
            }
            current = current.next;
            indexCounter++;
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
        return null;
    }
}
