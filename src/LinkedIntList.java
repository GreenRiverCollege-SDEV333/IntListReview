import java.util.Iterator;

public class LinkedIntList implements IntList {

    // inner node class to handle linked list nodes
    private class Node {
        int data;
        Node next;

        public Node() {
            data = 0;
            next = null;
        }

        public Node(int data) {
            this.data = data;
            next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    int size;
    Node head;

    public LinkedIntList() {
        size = 0;
        head = null;
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
        head = new Node(value, head);
        size = size + 1;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        addBack(value, head);
    }

    private void addBack(int value, Node cur) {
        // if cur is null, the list is empty, initialize a new node. - terminate here
        if (cur == null) {
            size = 1;
            head = new Node(value);
        }

        // if cur.next is null, we found the last element - terminate here
        else if ( cur.next == null ) {
            size ++;
            cur.next = new Node(value);
        }

        // otherwise, traverse the list
        else {
            addBack(value, cur.next);
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

        // do not allow scrolling passed size
        if (index > size) throw new IndexOutOfBoundsException();

        // if adding to index 0, do this instead. that way we don't need null checks
        if (index == 0) {
            addFront(value);
            return;
        }

        size++;

        // move to index
        Node current = head;
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }

        // insert node
        prev.next = new Node(value, current);


    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        // if the head exists, make head = head.next, let garbage collection eat the current head
        if (head != null) {
            head = head.next;
            size--;};
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        removeBack(head, head);
    }

    // recursive implementation
    private void removeBack(Node cur, Node prev) {
        // if current is null, the list is already empty, terminate here
        if (cur == null) return;

        // if the size is 0, just delete the head. terminate here
        if (size() == 1)
        {
            size = 0;
            head = null;
        }

        // if current.next = null, we are at the end. delete the next element of prev and terminate here
        else if (cur.next == null) {
            size --;
            prev.next = null;
        }

        // otherwise, continue to end
        else removeBack(cur.next, cur);

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

        if (index >= size()) throw new IndexOutOfBoundsException();

        // on 1 element list, get the head and delete the list
        if (size() == 1) {
            int value = head.data;
            head = null;
            size = 0;
            return value;
        }

        Node cur = head, prev=head;

        // move to index
        for (int i = 0; i < index; i++) {
            prev = cur;
            cur = cur.next;
        }

        // get return value
        int value = cur.data;

        // prev.next = cur.next will remove value
        prev.next = cur.next;

        return value;
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
        // do not scroll past size
        if (index >= size) throw new IndexOutOfBoundsException();

        // move to value
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.data;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        // because we implemented iterator, we should be able to use an enhanced for loop
        for (var checkVal : this) {
            if (checkVal == value ) return true;
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
        Node cur = head;

        // find the value, if present, by looping through the list
        for (int i = 0; i < size; i++) {
            if (cur.data == value) return i;
            cur = cur.next;
        }

        // nothing was found, return invalid index
        return -1;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
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
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                if (current == null) throw new IndexOutOfBoundsException();
                int data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}