import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList{

    // define what a node is
    private class Node {
        int data;
        Node next;
    }

    // set up the head
    private Node head;

    //set up the size field
    private int size;

    // add a constructor to initialize the fields
    LinkedIntList(){
        head = null;
        size = 0;
    }

    /**
     * Prints out the values of each node in the list
     */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
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
        Node newOne = new Node();
        newOne.data = value;
        if(head == null) {
            // the list is currently empty
            newOne.next = null;
            head = newOne;
            size++;
            return;
        }
        // the list currently has some nodes in it
        newOne.next = head;
        head = newOne;
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        //create a new a node with the specified value
        Node newNode = new Node();
        newNode.data = value;

        Node current = head;

        //go to end of list
        while (current.next != null){
            current = current.next;
        }

        //add it to the back
        current.next = newNode;

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
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        //create a new node with the specified data
        Node newNode = new Node();
        newNode.data = value;

        //temporary node to traverse list
        Node current = head;
        int currIndex = 0;

        while (currIndex != index - 1){
            current = current.next;
            currIndex++;
        }

        newNode.next = current.next;
        current.next = newNode;

        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     */
    @Override
    public void removeFront() {
        if (size > 0){
            head = head.next;
        }

        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        Node current = head;
        int currIndex = 1;

        while (currIndex != size()- 1){
            current = current.next;
            currIndex++;
        }

        current.next = null;

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
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node current = head;
        Node prev = null;
        int currIndex = 0;

        while(currIndex != index){
            prev = current;
            current = current.next;
            currIndex++;
        }

        //remove node
        if (prev != null){
            prev.next = current.next;
        }else{ //if removal of head node
            head = current.next;
        }

        size--;
        return current.data;
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
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
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

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        SinglyLinkedIterator theIterator = new SinglyLinkedIterator();
        return theIterator;
    }

    // helper class/type that defines how the iterator works
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
            if(current != null)
            {
                return true;
            }
            return false;

            //return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            if(current == null){
                throw new NoSuchElementException("There is no next one to go to");
            }
            int item = current.data;
            current = current.next;
            return item;
        }
    }
}