import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList{

    // define what a node is
    private class Node{
        int data;
        Node next;
    }

    // set up the head fields
    private Node head;

    //  set up the size field
    private int size;

    // add a constructor to initial the fields

    public LinkedIntList(){
        head = null;
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
        // set up a new node
        Node theNewOne = new Node();
        theNewOne.data = value;

        if (head == null){
            // the list is currently empty
            head = theNewOne;
        }
        else {
            // the list is currently has some nodes in it
            theNewOne.next = head;
            head = theNewOne;
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
        Node theLastOne = new Node();
        if (head == null){
            theLastOne.data = value;
            head = theLastOne;
        } else {
            while(head.next != null){
                theLastOne = head.next;
        }
        Node newNode = new Node();
        newNode.data = value;
        theLastOne.next = newNode;
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
        Node indexNode = new Node();
        for(int i  = 0; i < index; i++){
            indexNode = head.next;
        }
        Node newNode = new Node();
        newNode.data = value;
        indexNode.next = new Node();

        size++;

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {

    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {

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
        SinglyLinkedIterator theIterator = new SinglyLinkedIterator();
        return theIterator;
    }

    // helper class/type that defines how the iterator works
    private class SinglyLinkedIterator implements Iterator<Integer> {

        // private int i;       // the index of the item I am on in the arraylist
        private Node current;

        public SinglyLinkedIterator(){
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if(current == null){
                throw new NoSuchElementException("There is no next one to go to!");
            }
            int item = current.data;
            current = current.next;
            return item;
        }
    }
}
