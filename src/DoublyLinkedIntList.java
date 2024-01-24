import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedIntList implements IntList
{
    //private fields
    int size;

    private class Node {
        int data;
        Node next;      //address of the node "after" this one in line
        Node last;      //address of the node "before" this one in line

        public Node() {
            next = null;
            last = null;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedIntList() {
        // an empty list has 3 sentinel (dummy) nodes that serve as bookends
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.last = head;
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
    public void addFront(int value)
    {
        Node newNode = new Node();
        Node tempNode = head;
        newNode.data = value;

        //assign head to new value if no value is there
        if (head.data == 0)
        {
            //assign the new node as the head
            head = newNode;
            //head as tail
            tail = head;
            //reference each other
            size++;
        }
        // if there is, then assign
        // head.last to the new node
        // assign the new node to next
        // and assign the head to new node
        else
        {
            head.last = newNode;
            head = newNode;
            head.next = tempNode;
            size++;
        }
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value)
    {
        //create node with new value
        Node newNode = new Node();
        newNode.data = value;

        //assign the next node of tail to new node
        //reassign the tail to the new node
        //increase size

        //current tail
        tail.next = newNode;

        //new tail
        newNode.last = tail;
        tail = newNode;
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
    public void add(int index, int value)
    {
        //throw out of bounds exception if out of range
        if (index < size || index > size)
        {
            throw new IndexOutOfBoundsException("The given index is out of range");
        }

        //keep track of index, current node, previous node, and create new node
        int currentIndex = 0;
        Node current = head;
        Node newNode = new Node();
        newNode.data = value;
        Node previousNode = current.last;

        //if there's only one node
        if (head == tail)
        {
            //reassign all nodes
            //head reassignments
            head.next = newNode;

            //new node reassignments
            newNode.last = head;
            newNode.next = tail;

            //tail
            tail = newNode;
            tail.last = head;
            tail.next = new Node();
            size++;
        }
        else
        {
            //traverse list - while currentIndex does not equal the index
            while (currentIndex != index)
            {
                previousNode = current;
                current = current.next;
                currentIndex++;
            }
            //if found, add the node by connecting all nodes to each other
            //previous node
            previousNode.next = newNode;

            //new node
            newNode.last = previousNode;
            if (current == null)
            {
                tail = newNode;
                size++;
            }
            else {
                newNode.next = current.next;
                size++;
            }
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()
    {
        //change the head to head.next
        //reassign the new heads last to node
        head = head.next;
        head.last = null;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        if (size > 0) {
            //set up a temporary variable for convenience
            Node theOneToRemove = tail.last;

            theOneToRemove.last.next = tail;
            tail.last = theOneToRemove.last;

            //optional, but strongly recommended to clean up
            theOneToRemove.next = null;
            theOneToRemove.last = null;
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
    public int remove(int index)
    {
        //index out of bounds
        if (index > size || index < size)
        {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        //current index and current node
        Node current = head;
        int currentIndex = 0;
        int returnValue = 0;

        //traverse through list and compare
        while (currentIndex != index)
        {
            current = current.next;
            currentIndex++;
        }
        //remove the node by reassign/rearranging the nodes
        //previous.next to next node,
        //next node to previous
        returnValue = current.data;
        current.last = current.next;
        current.next.last = current.last;

        //reduce the size and return value
        size--;

        return returnValue;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index)
    {
        //check if the index is out of bounds
        //get the size and check the index
        if (index > size)
        {
            throw new IndexOutOfBoundsException("The index is out of range");
        }

        //traverse list with current starting at the head
        //and current index
        Node current = head;
        int currentIndex = 0;

        if (index == 0)
        {
            return head.data;
        }
        else
        {
            // while loop that traverses list and
            // increments current index
            while (index != currentIndex)
            {
                current = current.next;
                currentIndex++;
            }
            return current.data;
        }
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value)
    {
        // create current node
        Node current = head;

        // run through list until you hit the value
        while (current.data != value)
        {
            // check if the next node is null (this means we've hit the
            // end of the list and the value does not exist
            if (current.next == null)
            {
                return false;
            }
            current = current.next;
        }
        return true;
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
    public int indexOf(int value)
    {
        // create current node and currentIndex
        Node current = head;
        int currentIndex = 0;

        // run through list until you hit the value
        while (current.data != value)
        {
            current = current.next;
            currentIndex++;
        }
        return currentIndex;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size()
    {
        //check if the list is empty
        if (head == null)
        {
            throw new NoSuchElementException("The list is empty");
        }

        //use current to traverse linked list
        //and keep count
        Node current = head;
        int count = 0;

        //move through until you get to the end
        while (current != null)
        {
            current = current.next;
            count++;
        }
        return count;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear()
    {
        head = null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        DoublyLinkedIterator theIterator = new DoublyLinkedIterator();
        return theIterator;
    }

    private class DoublyLinkedIterator implements Iterator<Integer>{

        private Node current;

        public DoublyLinkedIterator() {
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
        public boolean hasNext()
        {
            //return current != null; <----- another way to write this
            if (current == null) {
                return false;
            }
            else {
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
        public Integer next()
        {
            if (current == null)
            {
                throw new NoSuchElementException("There is no next one to go to!!");
            }
            int item = current.data;
            current = current.next;
            return item;
        }
    }
}
