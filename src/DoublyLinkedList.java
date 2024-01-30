import java.util.Iterator;

public class DoublyLinkedList implements IntList {
    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     */
    //private fields

    private class Node {
        int data;

        Node next;  // address of the node after this one in line

        Node prev; // address of the node before this one in the line

        @Override
        public String toString() {
            return "" + data + "," + next;
        }

        public Node() {
            next = null;
            prev = null;

        }
    }

    private Node prev;
    private Node post;
    private int size;

    // constructor
    DoublyLinkedList() {
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
        theNewOne.prev = prev;
        // Setting prev node behind new node -> post -> prev
        theNewOne.next = prev.next;

        // setting the node after post to the new node
        theNewOne.prev.next = theNewOne;
        theNewOne.next.prev = theNewOne;

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
        Node theLastOne = post.prev;

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

    @Override
    public String toString() {
        String string = "DoublyLinkedList{";
        Node node = prev.next;
        for (int i = 0; i < size; i++) {
            string += node.data + ", ";
            node = node.next;
        }
        string += "size=" + size + "}";
        return string;
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
        Node theNewOne = new Node();
        theNewOne.data = value;
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        } else {
            if(size == 0){
                prev.next = theNewOne;
                post.prev = theNewOne;
                theNewOne.prev = prev;
                theNewOne.next = post;
            } else {
                Node temp = prev.next;
                for (int i = 0; i <= size; i++) {
                    if(i == index){
                        theNewOne.next = temp;
                        theNewOne.prev = temp.prev;
                        temp.prev = theNewOne;
                        theNewOne.prev.next = theNewOne;

                    }else{
                        // important iterating through nodes temp -> temp.next - > temp -> temp.next
                        temp = temp.next;
                    }
                }

            }
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

        if (size > 0) {
            // set up temp variable
            Node theOneToRemove = prev.next;

            theOneToRemove.prev.next = theOneToRemove.next;
            theOneToRemove.next.prev = theOneToRemove.prev;

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

        if (size > 0) {


            // set up a temp variable
            Node theOneToRemove = post.prev;

            theOneToRemove.prev.next = post;
            post.prev = theOneToRemove.prev;

            // strong optional cleanup
            theOneToRemove.next = null;
            theOneToRemove.prev = null;
            theOneToRemove.data = 0;

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
        int removed = 0;
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node theRemovedOne = prev.next;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    removed = theRemovedOne.data;
                    theRemovedOne.prev.next = theRemovedOne.next;
                    theRemovedOne.next.prev = theRemovedOne.prev;

                }
                theRemovedOne = theRemovedOne.next;
            }
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
        Node node;
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            node = prev.next;
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
        }
        return node.data;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        Node node;
        node = prev.next;
        while (node != post) {
            if (node.data == value) {
                return true;
            }
            node = node.next;

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
        Node node = prev.next;
        for (int i = 0; i < size; i++) {
            if(value == node.data){
                return i;
            } node = node.next;
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
       prev.next = post;
       post.prev = prev;
       size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        DoublyLinkedIterator theIterator = new DoublyLinkedIterator();
        return theIterator;
    }

    private class DoublyLinkedIterator implements Iterator<Integer>{

            // private int i;   // index of the item I am on in the arraylist
            private DoublyLinkedList.Node current;

            public DoublyLinkedIterator(){
                current = prev.next;
            }

            @Override
            public boolean hasNext() {
                return current != null && current != post;
            }

            @Override
            public Integer next() {
                int item = current.data;
                current = current.next;
                return item;
            }
        }
}
