import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList implements IntList {

    //private fields
    private class Node {
        int data;
        Node next; //address of the after this one in line

        Node prev; //address of the node before this one in line

        //the Node constructor, next and prev will be null in default, you can change it everytime you construct a node.
        public Node() {
            next = null;
            prev = null;
        }
    }

    //these two fields are like the bookends of the linkedlist
    private Node pre;
    private Node post;
    private int size;

    public DoublyLinkedList() {
        // an empty list has 2 sentinel (dummy) nodes that serves as bookends
        pre = new Node();
        post = new Node();
        pre.next = post; // this will connect the pre to the post
        // pre.prev will be null by default
        post.prev = pre; // this will connect the post to the pre
        //post.next will be null by default
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
        //put the last one into the front
        //renaming the pre.next as theLastOne
        Node theLastOne = pre.next;
        //Create a new node
        Node theNewOne = new Node();
        theNewOne.data = value;

        //connect theNewOne to the book case.
        theNewOne.next = theLastOne;
        theNewOne.prev = pre;
        pre.next = theNewOne;
        theLastOne.prev = theNewOne;

        //increment size..
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        //Renaming the post.prev as theLastOne
        Node theLastOne = post.prev;
        //make a new node
        Node theNewOne = new Node();

        //theNewOne data is set as the value
        theNewOne.data = value;

        //connect theNewOne.next to post Node
        theNewOne.next = post;

        //connect the previous node to pre
        theNewOne.prev = theLastOne;

        //connect the prev from post as theNewOne
        post.prev = theNewOne;

        //connect the next from pre as theNewOne
        theLastOne.next = theNewOne;
        // size will increase everytime a new data is created.
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
            if(size > 0 )
            {
                //rename the pre.next which is the variable in the front .  this to the one to remove
                Node theOneToRemove = pre.next;

                //assign the front to the next node
                theOneToRemove.next.prev = pre;
                pre.next = theOneToRemove.next;
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
            // set up a temp variable for convenience
            Node theOneToRemove = post.prev;
            theOneToRemove.prev.next = post;
            post.prev = theOneToRemove.prev;

            //optional to clean upp
            theOneToRemove.data = 0;
            theOneToRemove.next = null;
            theOneToRemove.prev = null;

            //decrement size
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
        //TODO need to think of cases for post
        Node current = pre; // pre will be 0 the head will count as a 0 index
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node theOneRemove = current.next;
        theOneRemove.next.prev = current;
        current.next = theOneRemove.next;
        size--;
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
        //TODO CASE FOR ZERO AT THE END
        Node current = pre;
        for (int i = 0; i < index ; i++) {
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
        //TODO NEED TO FIGURE OUT IF THERE ARE ZEROS
        Node current = pre;
        while(current.next != null)
        {
            current = current.next;
            if(current.data == value)
            {
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

        return 0;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        if(pre.next == post && post.prev == pre)
        {
            return true;
        }
        else {
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
        DoublyLinkedListIterator theIterator = new DoublyLinkedListIterator();
        return theIterator;
    }

    //helper class/type define how the iterator works
    private class DoublyLinkedListIterator implements Iterator<Integer> {
        private Node current;

        public DoublyLinkedListIterator()
        {
            current = pre;
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
            if (current == null) {
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
            if (current == null) {
                throw new NoSuchElementException("There is no next one to go to! ");
            }
            int item = current.data;
            current = current.next;
            return item;
        }
    }
}
