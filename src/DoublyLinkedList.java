import java.util.Iterator;

public class DoublyLinkedList implements IntList{
    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     *
     */
    //private fields

    private class Node{
        int data;

        Node next;  // address of the node after this one in line

        Node prev; // address of the node before this one in the line
    }

    public void Node(){
        next = null;
        prev = null;
    }

    private Node next;
    private Node prev;
    private Node post;
    private int size;

    DoublyLinkedList(){
        // set empty list has 2 sentinel nodes that serve as bookends
        prev = new Node();
        post = new Node();
        prev.next = post;
        post.prev = prev;
        size = 0;

    }

    @Override
    public void addFront(int value) {

        // set up node and fill out
        Node theNewOne = new Node();
        theNewOne.data = value;

        //setting the new node in front of post
        theNewOne.prev = post;
        // Setting prev node behind new node -> post -> prev
        theNewOne.prev.prev = prev;

        // setting the node after post to the new node
        post.next = theNewOne;
        // incrementing size
        size++;



    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
       Node theLastOne = prev.prev;

        //set up any new node and fill it out (data,prev,next)
        Node theNewOne = new Node();
        theNewOne.data = value;
        theNewOne.next = post;
        theNewOne.prev = theLastOne;

        // go to the end of the list sentinel and updates its prev
        post.prev = theNewOne;
        // go to the node before the new one, and update its next
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

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {

        if(size > 0) {
            // set up temp variable
            Node theOneToRemove = post;

            theOneToRemove.prev.next = post;

            post.prev.prev = post.prev;

            theOneToRemove.next = null;
            theOneToRemove.prev = null;
            theOneToRemove.data = 0;

            size--;
        }
        
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {

        if(size > 0){


        // set up a temp variable for convience
        Node theOneToRemove = post.prev;

        theOneToRemove.next.prev = post;
        post.prev = theOneToRemove.prev;

        // strong optional cleanup
        theOneToRemove.next = null;
        theOneToRemove.prev = null;
        theOneToRemove.data = 0;

        size--;
    }}

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
