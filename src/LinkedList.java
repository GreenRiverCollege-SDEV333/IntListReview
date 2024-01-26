import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList implements IntList{

    public class Node {
        int data;
        Node next;
    }
    Node head;
    public int size;

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
        Node newNode = new Node();
        newNode.data = value;

        if (head == null){
            head = newNode;
            size++;
        }
        else{
            newNode.next = head;
            head = newNode;
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
        //create new node
        Node temp = new Node();
        temp.data = value;

        if (head == null){
            head = temp;
            size++;
        }
        else{
            Node curr;
            //set reference to head
            curr = head;

            //move till the last element
            while(curr.next != null){
                curr = curr.next;
            }

            //set last node to temp
            curr.next = temp;
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
        Node curr;
        Node temp = new Node();
        temp.data = value;

        if (index < 0){
            throw new IndexOutOfBoundsException("The index value is out of bounds");
        }

        //adding at the front
        else if (index == 0 || size==0 ){
            temp.next = head;
            head = temp;
            size++;
        }

        //adding at the end of the list
        else if (index >= size){
            curr = head;
            while (curr.next != null){
                curr = curr.next;
            }

            //set the second to last reference to
            curr.next = temp;
            size++;
        }
        //adding at index position
        else{
            curr = head;
            //traverse through the linked list
            for (int i = 0; i < index-1; i++) {
                curr = curr.next;
            }
            //saves the next reference of current.
            Node saveReference = curr.next;

            //set the node equal to temp
            curr.next = temp;

            //set reference to the node after for temp
            temp.next = saveReference;
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
        //head is empty do nothing
        if (head == null){
            return;
        }
        else{
            //skip to the next node
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
        if (head==null){
            return;
        }
        else{
            Node temp = head;
            while(temp.next.next != null){

                //advance node
                temp = temp.next;
            }

            //set the last element to null
            temp.next = null;
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
        Node curr;

        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("This index is invalid");
        }
        //removing at the front
        if (index == 0){
            curr = head;
            Node saveNode = curr;

            //remove the front node
            head = head.next;
            size--;
            return saveNode.data;
        }

        //removing at the end
        else if(index == size-1){
            curr = head;
            while (curr.next.next != null){
                curr = curr.next;
            }

            Node saveNode = curr.next;
            //save current value to this variable
            curr.next = null;
            size--;
            return saveNode.data;
        }

        else{
            curr = head;

            //advance index number of places to before the removed element
            for (int i = 0; i < index -1; i++) {
                curr = curr.next;
            }
            Node prev = curr;

            //save the node being removed
            Node saveNode = curr.next;

            //form a new reference
            prev.next = curr.next.next;

            size--;
            return saveNode.data;

        }

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
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("This index is invalid");
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;

    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        Node curr = head;

        while (curr.next != null){

            //found within the list
            if (curr.data == value){
                return true;
            }

            //advances through the list
            curr = curr.next;
        }

        //not found within list
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
     * This method returns whether the index is valid or not
     *
     * @param index the index trying to get accessed
     * @return boolean of out of bounds or not
     */
    public boolean isOutOfBound(int index){
        return index < 0 || index >= size;
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

    private class SinglyLinkedIterator implements Iterator<Integer> {

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
            return current != null;
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
                throw new NoSuchElementException("There is no next one to go to!");
            }
            int curInt = current.data;

            //iterate one
            current = current.next;
            return curInt;
        }
    }
}
