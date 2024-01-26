import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList {
    //define what a node is
    private class Node {
        int data;
        Node next;
        public Node(int value){
            this.data=value;
        }

    }

    //set up the head
    private Node head;

    // set up the head field
    private  int size;

    // add a constructor to initialize the fields
     public LinkedIntList(){
         head = null;
         size = 0;
     }

     //helper to view values inside the linked list
    public void print() {
        Node current = head;
        while (current != null) {
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
        // set up a new node
        Node theNewOne = new Node(value);

        if (head == null){
            //the list is currently empty
            head = theNewOne;
            size++;
        }
        else{
            // the list currently has some nodes in it
            theNewOne.next = head;
            head = theNewOne;
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
        // set up a new node
        Node theNewOne = new Node(value);
        if (head == null){
            //the list is currently empty
            head = theNewOne;
            size++;
        }
        else{
            Node current = head;
            if(current == null){
                throw new IndexOutOfBoundsException("Array is empty");
            }
            for (int i = 0; i < size - 1; i++) {
                current = current.next;
            }
            theNewOne.next= current.next;
            current.next = theNewOne;
            size++;
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
        Node theNewOne = new Node(value);
        if(index < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        else if (index > size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }
        if(index == 0){
           theNewOne.next = head;
           head = theNewOne;
           head.data = value;
           size++;
        }else{
            Node current = head;
            if(current == null){
                throw new IndexOutOfBoundsException("Index is higher than size");
            }
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            theNewOne.next= current.next;
            current.next = theNewOne;
            size++;
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if(head != null && head.data ==0){
            head = null;

        }
        if(head == null){
            //if there is nothing to delete
            throw new IndexOutOfBoundsException("Array is empty");
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

        if(current == null){
            //if there is nothing to delete
            throw new IndexOutOfBoundsException("Array is empty");
        }
        if(current.next == null){
            //if there is only 1 value in the array
            current = null;

        }else{
            //for traversing the list to the second to last node, then remove current.next
            while (current.next.next !=null){
                current = current.next;
            }
            current.next = null;
        }
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
        Node current = head;
        int removed;//keep track of the removed value
        if(index < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        else if (index > size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }
        if(index == 0){
            //if removing head
              removed = current.data;
              clear();

        }else{
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            removed = current.next.data;
            current.next = current.next.next;
            size--;
        }

        return removed;

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
        if(index < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        else if (index >= size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
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
        Node current = head;//traverse the list from start to finish
        if(current == null){
            throw new IndexOutOfBoundsException("Array is empty");
        }
        while(current!= null){
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
        int index = 0;
        Node current = head;//traverse the list from start to finish
        if(current == null){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }
        while(current!= null){
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
        while (head!= null){
            Node clear = head;
            head = head.next;
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
        return new SinglyLinkedIterator();
    }
    // helper class/type that defines how the iterator works
    private class SinglyLinkedIterator implements Iterator<Integer>{
        private Node current;

        public SinglyLinkedIterator(){
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
            //can also do return current.next !=null;
            if (current.next == null){
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
             if (current == null){
                 throw new NoSuchElementException("there is no next one to go to");
             }

            current = current.next;
            int item = current.data;
            return item;
        }
    }
}
