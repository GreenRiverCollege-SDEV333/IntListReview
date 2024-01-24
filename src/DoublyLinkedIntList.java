import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedIntList implements IntList {
    // private fields
    private class Node
    {
        int data;
        Node next; // address of the node after this one in line
        Node prev; // address of the node before this one in line

        //any new Node defaults to null
        public Node() {
            next = null;
            prev = null;
        }
    }

    // sentinel/dummy nodes
    private Node pre;
    private Node post;
    private int size;

    public DoublyLinkedIntList() {
        // an empty list as 2 sentinel (dummy) nodes that serve as bookends
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
    public void addFront(int value)
    {
        Node newNode = new Node();
        newNode.data = value;
        Node firstNode = pre.next;

        newNode.next = firstNode;
        newNode.prev = pre;

        pre.next = newNode;
        firstNode.prev = newNode;
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

        // set up new Node and fill it out
        Node theNewOne = new Node();
        theNewOne.data = value;
        theNewOne.next = post;
        theNewOne.prev = theLastOne;

        // go to the end of the list's sentinel, and update it's prev
        post.prev = theNewOne;

        // go to the node before the new one, and update it's next
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
    public void add(int index, int value)
    {
        Node newNode = new Node();
        newNode.data = value;
        Node lastNode = post.prev;

        newNode.next = post;
        newNode.prev = lastNode;

        lastNode.next = newNode;
        post.prev = newNode;
        size++;

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()
    {
        Node firstNode = pre.next;

        if (firstNode != post)
        {
            Node newNode = firstNode.next;

            pre.next = newNode;
            newNode.prev = pre;
        }
        else
        {
            System.out.println("Cannot remove from the front. List is empty.");
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

            // optional clean up (strongly recommended)
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
    public int remove(int index)
    {
        Node current = pre.next;

        while (current != post) {

            if (current.data == index)
            {
                Node prevNode = current.prev;
                Node nextNode = current.next;

                prevNode.next = nextNode;
                nextNode.prev = prevNode;

            }

            current = current.next;

        }
        return current.data;

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
        Node current = pre;
        for (int i = 0; i < index; i++)
        {
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
    public boolean contains(int value)
    {
        return indexOf(value) != -1;
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
        if (pre == null)
        {
            return -1;
        }
        else
        {
            Node current = pre;
            int index = 0;

            while (current != null)
            {
                if (current.data == value)
                {
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear()
    {
        pre = null;
        post = null;
        size = 0;

    }

    /**
     * Prints out DoublyLinkedList
     */
    public void printList()
    {
        Node current = pre;

        if (pre == null) {
            System.out.println("List is empty");
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<Integer>
    {
        private Node current = pre.next;

        public boolean hasNext() {
            return current != post;
        }

        public Integer next() {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            else
            {

                int item = current.data;
                current = current.next;
                return item;
            }
        }
    }
}

