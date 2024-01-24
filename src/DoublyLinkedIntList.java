import java.util.Iterator;

public class DoublyLinkedIntList implements IntList {

    private class Node {
        int data;
        Node next, prev;

        public Node(int data) {
            this.data = data;
            next=null;
            prev=null;
        }

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    Node head, tail;
    int size;


    public DoublyLinkedIntList() {
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
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            head = new Node(value, null, head);
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

        if (tail == null) {
            tail = new Node(value);
            head = tail;
        } else {
            tail = new Node(value, tail, null);
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
        if (index > size) throw new IndexOutOfBoundsException();
        else if (index == 0) { addFront(value); return; } // if add front or add back, don't do anything fancy.
        else if (index == size) { addBack(value); return; }

        Node cur;



        // check which side to loop from
        // and then move cursor to that position
        if ( (size() - index) > index ) {
            cur = tail;
            index = size() - index;

            for (int i = 0; i < index; i++) {
                cur = cur.prev;
            }

        } else {
            cur = head;
            for (int i = 0; i< index; i++) {
                cur = cur.next;
            }
        }

        // set the previous node to point to the new value
        cur.prev.next = new Node(value, cur.prev, cur);

        // set the current prev node to point to the new value (ie, behind)
        cur.prev = cur.prev.next;

        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if (size() == 0) return;
        head = head.next;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (size() == 0) return;
        tail = tail.prev;
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
        for (var i:this)
            if (value == i) return true;
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
        for (int i = 0; i < size(); i++) {
            if (cur.data == value) return i;
            cur = cur.next;
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
        size=0;
        head=null;
        tail=null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            Node cur = head;
            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public Integer next() {
                if (cur == null) throw new IndexOutOfBoundsException();
                int retval = cur.data;
                cur = cur.next;
                return retval;
            }
        };
    }
}
