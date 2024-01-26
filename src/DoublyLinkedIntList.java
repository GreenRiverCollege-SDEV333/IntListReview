import java.util.Iterator;
import java.util.NoSuchElementException;
/*
Kayley Young
DoublyLinkedIntList: a linked node (singly linked) implementation of the IntList interface.
 the class implementation uses sentinel (dummy) nodes at the front and back of the list.
 This is required for our class's implementation.
 */
public class DoublyLinkedIntList implements IntList{

    //private fields
    private class Node{
        int data;
        Node next; //address of the node "after" this one in line
        Node prev; //address of the node "before" this one in line

        //constructor to set any new node with nulls be default
        public Node(){

             next = null;
             prev = null;
        }
    }

    private Node pre;
    private Node post;
    private int size;

    public DoublyLinkedIntList(){
        //an empty list has 2 sentinel(dummy) nodes that serve as bookends
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
        size = 0;
    }
    //helper to view values inside the linked list
    public void print() {
        Node current = pre.next;
        while (current != post) {
            System.out.println(current.data);
            current = current.next;  // move to next node
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
       // Node theFirstOne = pre.next;
        Node theNewOne = new Node();
        theNewOne.data = value;
        theNewOne.next = pre.next;
        theNewOne.prev = pre;

        //to go to the end of the list's sentinel, and update it's prev
        post.prev = theNewOne;
        // go to the node before the new one,  and update it's next
        pre.next = theNewOne;

        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {


        //set up my new node and fill it out(data, prev, next)
        Node theNewOne = new Node();
        theNewOne.data = value;
        theNewOne.next = post;
        theNewOne.prev = post.prev;
        // go to the node before the new one,  and update it's next
        post.prev.next = theNewOne;
        post.prev = theNewOne;

        //to go to the end of the list's sentinel, and update it's prev
       // pre.next = theNewOne;

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
        Node newNode = new Node();
        newNode.data = value;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if(index == 0){
            newNode.next=pre.next;
            newNode.prev=pre;
            pre.next.prev = newNode;
            pre.next = newNode;
        }else {
            Node current = pre;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            //set the previous and next node to point at corrected references
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
            size++;

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if (size > 0){
            Node theOneToRemove = pre.next;

            pre.next = theOneToRemove.next;
            theOneToRemove.next.prev = pre;

            theOneToRemove.next = null;
            theOneToRemove.prev = null;
            theOneToRemove.data = 0;
            size--;
        }else{
            throw new IndexOutOfBoundsException("List is empty");
        }

    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (size > 0){
            //for convenience
            Node theOneToRemove = post.prev;

            theOneToRemove.prev.next = post;
            post.prev = theOneToRemove.prev;

            //optional to clean up
            theOneToRemove.next = null;
            theOneToRemove.prev = null;
            theOneToRemove.data = 0;

            size--;
        }else{
            throw new IndexOutOfBoundsException("List is empty");
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = pre.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        int removedValue = current.data;

        current.prev.next = current.next;
        current.next.prev = current.prev;

        current.prev = null;
        current.next = null;

        size--;

        return removedValue;
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
        Node current = pre.next;
        if (index < 0 || index > size || current == post) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if(index == 0){
             current=pre.next;
        }else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
            int value = current.data;
            return value;

    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        Node current = pre;//traverse the list from start to finish
        if(current == null){
            throw new IndexOutOfBoundsException("Array is empty");
        }
        while(current!= post){
            if(current.data == value){
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
        int index = -1;
        Node current = pre;//traverse the list from start to finish
        if(current == null){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }
        while(current!= post){
            if(current.data == value){
                return index;
            }
            index++;
            current = current.next;
        }

        return -1;// if value is not found
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return size ==0;
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
        while (pre!= null){
            Node clear = pre;
            pre = pre.next;
        }
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
    private class DoublyLinkedIterator implements Iterator<Integer>{
        private Node current;

        public DoublyLinkedIterator(){
            current = pre.next;

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
            //can also do return current !=post;
            if (current == post){
                return false;
            }
            else{
                return true;
            }
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            if (current == post){
                throw new NoSuchElementException("there is no next one to go to");
            }

            current = current.next;
            int item = current.data;
            return item;
        }
    }
}
