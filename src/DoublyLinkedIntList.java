import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedIntList implements IntList{

    private class Node {
        int data;
        Node next;      //address of the node "after" this one in line
        Node prev;      //address of the node "before" this one in line

        //sets next and prev null by default
        public Node() {
            next = null;
            prev = null;
        }
    }

    private Node pre;
    private Node post;
    private int size;

    public DoublyLinkedIntList(){
        //on empty list has 2 sentinel (dummy) nodes that serve as bookends
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
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
        //current next node in front
        Node save = pre.next;

        //creating the new node
        Node newOne = new Node();
        newOne.data = value;

        //setting reference to the new node
        newOne.prev = pre;
        newOne.next = save;

        //reference for existing nodes
        save.prev = newOne;
        pre.next = newOne;

        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        Node theLastOne = post.prev;

        //create the new node
        Node theNewOne = new Node();
        theNewOne.data = value;

        //setting references to the new node
        theNewOne.next = post;
        theNewOne.prev = theLastOne;

        //references to existing nodes
        post.prev = theNewOne;
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
        Node newOne = new Node();
        newOne.data = value;

        //trying to add at a negative index
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("The index value is out of bounds");
        }
        //adding at the start
        else if(index == 0){
            //setting reference to the new node
            Node save = pre.next;

            newOne.prev = pre;
            newOne.next = save;

            //reference for existing nodes
            save.prev = newOne;
            pre.next = newOne;

        }
        //adding at the end
        else if(index == size){
            Node lastOne = post.prev;

            newOne.next = post;
            newOne.prev = lastOne;

            //references to existing nodes
            post.prev = newOne;
            lastOne.next = newOne;
        }

        //adding in the middle of the list
        else{
            Node curr = pre;
            for (int i = 0; i < index; i++){
                curr = curr.next;
            }

            //setting new reference to the newOne
            newOne.prev = curr;
            newOne.next = curr.next;

            //updating references on existing nodes
            curr.next = newOne;
            curr.next.next.prev = newOne;
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
        //do nothing because it is empty
        if (pre.next == post){
            return;
        }
        else {

            //node reference after the front node is removed
            Node newOne = pre.next.next;

            //updating reference
            pre.next = newOne;

            //checking if the newNode is post, then set it back to equal to pre
            if (newOne == post) {
                post.prev = pre;
            }
            //other node
            else {
                newOne.prev = pre;
            }

            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (size > 0) {
            //the last real node in prev
            Node temp = post.prev;
            temp.prev.next = post;
            post.prev = temp.prev;

            size--;
        }
        else{
            throw new IllegalStateException("the list is empty");
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
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("This index is invalid");
        }

        Node temp = pre;
        for (int i = 0; i <= index; i++) {
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
        return size==0;
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
        pre.next = post;
        post.prev = pre;
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<Integer>{
        private Node curr;

        public DoublyLinkedListIterator(){
            curr = pre.next;
        }

        @Override
        public boolean hasNext() {
            return curr.next != post;
        }

        @Override
        public Integer next() {
            if (curr == post){
                throw new NoSuchElementException("There is no next one to go to!");
            }
            int currInt = curr.data;

            //iterate once
            curr = curr.next;

            return currInt;
        }
    }
}
