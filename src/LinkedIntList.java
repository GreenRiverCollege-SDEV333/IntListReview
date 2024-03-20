import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList{

    //define node
    //class is type
    private class Node {
        int data;
        Node next;
    }


    //set up the head field
    private Node head;

    //set up the size field
    private int size;


    //add a constructor
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
        Node theNewOne = new Node();
        theNewOne.data = value;
        if(head == null){
            // the list is currently empty
            head = theNewOne;
            //increase size
            size++;
        }
        else{
            // The list has something in it.
            //point the new node at the "first" node (we don't want to lose the list)
            theNewOne.next = head;
            //point the head at the new node
            head = theNewOne;

            //increase size
            size++;
        }
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        //pretty sure we should have a method that builds the node WITH the value
        Node theNewNode = new Node();
        theNewNode.data = value;

        //check to see if the LinkedList is empty
        if (head == null){
            head = theNewNode;
        }

        //set your pointer to move through the linkedlist
        Node current = head;
        //move through the linked list until you get to the last node
        while(current.next != null){
            current = current.next;
        }

        //set the current nodes pointer to the new node
        current.next = theNewNode;
        //increase the size to account for the new node
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
        Node current = head;
        Node theNewNode = new Node();
        theNewNode.data = value;
        int position = 1;
        if(head == null && index == 1){
            head = theNewNode;
        }
        else if(index < 0 ){
            throw new IndexOutOfBoundsException("Index value can not be less than 1.");
        }
        else if(index > size){
            throw new IndexOutOfBoundsException("Index cannot be greater than size: " + (size));
        }
        else{
            while(current.next != null && position != index-1){
                current = current.next;
                position++;
            }
            //add the new node to the next position and increase size
            theNewNode.next = current.next;
            current.next = theNewNode;
            size ++;
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        head = head.next;
        size --;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        Node current = head;
        while(current.next.next!= null){
            current = current.next;
        }
        current.next = null;
        size --;
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
        
        Node current = head;
        int value;
        int position = 1;
        if(head == null){
            throw new IndexOutOfBoundsException("Can not call remove on an empty linkedlist. ");
        }
        else if(index < 0 ){
            throw new IndexOutOfBoundsException("Index value can not be less than 1.");
        }
        else if(index > size){
            throw new IndexOutOfBoundsException("Index cannot be greater than size: " + (size));
        }
        else{
            while(current.next.next != null && position != index-1){

                current = current.next;
                position++;
            }
            //If the node to remove points to null, have previous node point to null
            if(current.next.next == null){
                value = current.next.data;
                current.next = null;
                size --;
            }
            else{
                value = current.next.data;
                current.next = current.next.next;
                size --;
            }

        }

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
        Node current = head;

        if(index < 1 ){
            throw new IndexOutOfBoundsException("Index must be greater than zero");
        }else if(index > size){
            throw new IndexOutOfBoundsException("Index cannot be greater than size: " + size);
        }
        //move the position and the pointer until the position matches the index position.
        int position = 1;
        while (index > position){
            current = current.next;
            position++;
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
        Node current = head;

        while(current != null){
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
        Node current = head;
        int index = 1;
        if(head == null){
            return -1;
        }
        //iterate over the nodes to look for if current is null
        //end loop and returns -1
        while(current != null){
            if (current.data == value){
                return index;
            }

            current = current.next;
            index++;
        }

        //value was not in the linkedList
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
        head = null;
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        singlyLinkedIterator theIterator = new singlyLinkedIterator();

        return theIterator;
    }

    //helper class/type that defines how te iterator works
    private class singlyLinkedIterator implements Iterator<Integer>{

        //track the current node you are on.
        private Node current;

        public singlyLinkedIterator(){
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
//            if (current != null){
//                return true;
//            }
//            else{
//                return false;
//            }
            return current!=null;

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
                throw new NoSuchElementException("There is no next one to go to!!");
            }
            //change current to next node.
            int item = current.data;
            current = current.next;
            return item;
        }
    }
}
