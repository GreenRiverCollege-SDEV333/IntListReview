import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList{

    //define what a node is
    private class Node {
        int data;
        Node next;
    }

    //set up head field
    private Node head;
    //set up the size field
    private int size;

    //add constructor
    public LinkedIntList ( )
    {
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
        //set up a new node
        Node theNewOne = new Node();
        theNewOne.data = value;

        if (head == null)
        {
            //the list is currently empty
            head = theNewOne;
            size++;
        }
        else
        {
            //the list currently has some nodes in it.
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
        // creata a new node.
        Node theNewOne = new Node();
        // put the value as the new node data.
        theNewOne.data = value;
        Node current = head;

        if(head == null)
        {
            // if the list is empty
            head = theNewOne;
            size++;
        }
        else {
            //if the list is not empty
            while (current.next != null) {
                current = current.next;
            }
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
        // Create a node pointer to head
        Node current = head;
        // create a new node
        Node theNewOne = new Node();
        //set the value to the new node data.
        theNewOne.data = value;
        if(current != null) { // if the point is not null or any of the current value is not null
            if (index == 0) { // if the index is 0, we can use addfront that is already created.
                addFront(value);
            } else{ // else if there is already values in there, we will do a fori loop that ends with the index
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            //create a temp node so we wont lose the data.
            Node temp = current.next;
            // set the current.next connect to the new node.
            current.next = theNewOne;
            //set the new node . next connects to the existing node.
            theNewOne.next = temp;
            size++;
            }
        } else {
            throw new NullPointerException(" The list is empty ");
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if(head == null)
        {
            throw new NoSuchElementException("The list is empty");
        }
        else {
            head = head.next;
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if(head == null) // if the head is null meaning there is no list at all , the list is empty, can not remove anything
        {
            throw new NullPointerException("The head is null, meaning there is no list. ");
        }
        else if(head.next == null) // if the head.next is null meaning there is only one item in a list. it will delete itself.
        {
            head = null;
            size--;
        }
        else { // else if there is more than 1 item in list, it will check for the next next node
            // create a pointer that starts at head.
            Node current = head;
            //check for the next next node instead of next node.
            while(current.next.next != null){
                //current will move to next node if there next next node is not null
                current = current.next;
            }
            //if the next next node is null, it will stopped and cut off the current.next and set it to null
            current.next = null;
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
        //TODO case for zero

        Node current = head;
        for (int i = 0; i < index - 1 ; i++) {
            current = current.next;
        }
        Node temp = current.next;
        current.next = current.next.next;
        size--;
        return temp.data;
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
        //TODO CASE FOR ZERO
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        return current.next.data;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        //this will loop through all the Linked-list.
        Node current = head;
        while (current.next != null )
        {
            current = current.next;
            if( current.data == value) {
                return true;
            }
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
        Node current = head;
        if(head.data == value )
        {
            return index;
        }
        while(current.next != null )
        {
            current = current.next;
            index++;
            if(current.data == value)
            {
                return index;
            }
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
        if(head == null ){
            return true;
        }else {
            return false;
        }
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
        SinglyLinkedIterator theIterator = new SinglyLinkedIterator();
        return theIterator;
    }
    //helper class/type define how the iterator works
    private class SinglyLinkedIterator implements Iterator<Integer> {
        private Node current;

        public SinglyLinkedIterator( ) {
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
            if(current == null)
            {
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
            if(current == null)
            {
                throw new NoSuchElementException("There is no next one to go to! ");
            }
            int item = current.data;
            current = current.next;
            return item;
        }
    }
}
