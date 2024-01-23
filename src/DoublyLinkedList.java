import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList implements IntList {

    private class Node {
        int data;
        Node next;
        Node prev;

        public Node() {
            next = null;
            prev = null;
        }
    }

    private final Node pre;
    private final Node post;
    private int size;

    public DoublyLinkedList() {
        // on empty list, create the 2 sentinel nodes
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
        this.size = 0;
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
        newNode.prev = pre;
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
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = post;
        newNode.prev = post.prev;
        newNode.prev.next = newNode;
        post.prev = newNode;
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node newNode = new Node();
        newNode.data = value;
        Node current = pre.next;
        int currentIndex = 0;
        while (currentIndex != index){
            current = current.next;
            currentIndex++;
        }
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev = newNode;
        newNode.prev.next = newNode;
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     *
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public void removeFront() {
        if (size == 0) {
            throw new NoSuchElementException("The list is empty");
        }
        pre.next.next.prev = pre;
        pre.next = pre.next.next;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     *
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public void removeBack() {
        if (size == 0) {
            throw new NoSuchElementException("The list is empty");
        }
        post.prev.prev.next = post;
        post.prev = post.prev.prev;
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
     * @throws NoSuchElementException    if the list is empty
     */
    @Override
    public int remove(int index) {
        if (size == 0) {
            throw new NoSuchElementException("The list is empty");
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int currentIndex = 0;
        Node current = pre.next;
        while (currentIndex != index) {
            current = current.next;
            currentIndex++;
        }
        int value = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return value;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     * @throws NoSuchElementException    if the list is empty
     */
    @Override
    public int get(int index) {
        if (size == 0) {
            throw new NoSuchElementException("The list is empty");
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = pre.next;
        int currentIndex = 0;
        while (currentIndex != index) {
            current = current.next;
            currentIndex++;
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
        if (size == 0) return false;
        Node current = pre.next;
        while (current != post) {
            if (current.data == value) {
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
     * @throws NoSuchElementException if the list is empty
     */
    @Override
    public int indexOf(int value) {
        if (size == 0) {
            throw new NoSuchElementException("The list is empty");
        }
        int currentIndex = 0;
        Node current = pre.next;
        while (current != post) {
            if (current.data == value) {
                return currentIndex;
            }
            current = current.next;
            currentIndex++;
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
        Node current = pre.next;
        //Manually sets all data stores to a value of 0 to ensure no remnants prior to GC are cleanup available.
        while (current != post) {
            current.data = 0;
            current = current.next;
        }
        pre.next = post;
        post.prev = pre;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = pre.next;

        //if the list is empty return just an empty list indicator
        if (current == post) {
            return "[]";
        }
        //build the standard pretty print array display
        sb.append('[');
        while (current.next != post) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        sb.append(current.data).append(']');
        return sb.toString();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>(){
            Node current = pre.next;

            @Override
            public boolean hasNext(){
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
