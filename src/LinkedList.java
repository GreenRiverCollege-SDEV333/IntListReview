import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList implements IntList {

    //define what a node is
    private static class Node{
        int data;
        Node nextNode;

        Node(int data){
            this.data = data;
            this.nextNode = null;

        }
    }
    //set up the head
    private Node head;
    //set up the size field
    private int size;

    //add constructor to initialize the data
    public LinkedList(){
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
        Node theNewNode = new Node(value);
        if (head == null){
            head = theNewNode;
            size++;
            //linkedList is empty

        }else{
            theNewNode.nextNode = head;
            head = theNewNode;
            //LinkedList has nodes in it
        }

    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        Node theNewNode = new Node(value);
        if (head == null){
            head = theNewNode; //check if node is empty, if it is, assign the new node to the head
    } else {
            Node currentNode = head; //create new variable current node
            while (currentNode.nextNode != null) { //iterate through the list until a null node value is found
                currentNode = currentNode.nextNode; //currentNode keeps track of position in the list
            }
            currentNode.nextNode = theNewNode; //once a null value is found, assign it to that value
        }
        size++; //increase size of list
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
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
        if (index == 0) {
            addFront(value);
        } else {
            Node theNewNode = new Node(value);
            Node currentNode = head;
            int filter = 0;
            // Move currentNode to the node just before the index where we want to insert
            while (filter < index - 1) {
                currentNode = currentNode.nextNode;
                filter++;
            }
            // Link the new node to the rest of the list
            theNewNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = theNewNode;
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
    if (head != null){
        head = head.nextNode;
        size--;
    }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     * very similar to addback method
     */
    @Override
    public void removeBack() {
    if (head == null) {
        throw new IndexOutOfBoundsException("index is out of bounds!");
        }
    if (size == 1) {
        head = null;
    }else{
        Node currentNode = head; //create new variable current node
        while (currentNode.nextNode.nextNode != null) { //iterate through the list until a null node value is found
            currentNode = currentNode.nextNode; //currentNode keeps track of position in the list,
                                                // it keeps track of the next node's next node so we know which nodes next value is null
        }
        currentNode.nextNode = null; //assign that node to null essentially removing node
    }
    size--; //subtract 1 from the size
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
        int removedData = 0;
        if(index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
        if (index == 0){ //if list is empty
            head = null;
    } else { //if list has data
            Node currentNode = head; //assign head to current node to track value
            int filter = 0; //use filter as an iterator count
            while (filter < index - 1) { //while filter is less than the last index value
                currentNode = currentNode.nextNode;
                filter++;
            }
            removedData = currentNode.nextNode.data; //when the value is found, assign removed data to it
            currentNode.nextNode = currentNode.nextNode.nextNode;
        }

        size--; //subtract the size
        return removedData; //return removed data
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
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node currentNode = head; //assign currentNode to head to track value
        for (int filter = 0; filter < index; filter++) { //create value filter to iterate through the list
            currentNode = currentNode.nextNode; //when value is found, assign it
        }

        return currentNode.data; //return the data
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        Node currentNode = head; //assign current node to track value
        while (currentNode != null) {
            if (currentNode.data == value) {
                return true;
            }
            currentNode = currentNode.nextNode;
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
        Node currentNode = head;
        for (int filter = 0; filter < size; filter++) { //filter counts the index
            if (currentNode.data == value) {
                return filter; //when data is found, it returns the index
            }
            currentNode = currentNode.nextNode;
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
        return head == null;
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
    size = 0; //clear by assigning size to 0
    head = null; //assigning head to null will assure clearance
    }

    @Override
    public void resize(int newSize) {
        throw new UnsupportedOperationException("resizing is not allowed");
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new singlyLinkedIterator(); // this just inlines the variable so its 1 line of code instead of 2.
        /*ORRR
        singlyLinkedIterator myIterator = new singlyLinkedIterator();
        return myIterator; //using two lines makes it more readable
         */
    }
    //helper class defines how the iterator works
    private class singlyLinkedIterator implements Iterator<Integer>{
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
            if (current == null || current.nextNode == null) {
                return false;
            } else {
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
            if(current == null){
                throw new NoSuchElementException("there is not next node to go to!");
            }
            int item = current.data;
            current = current.nextNode;
            return item;
        }
    }
}
