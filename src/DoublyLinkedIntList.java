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
        Node previousNode = tail.last;

        // set up my new node and fill it out (data, prev, next)
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = tail;
        newNode.last = previousNode;

        //go to the end of the list's sentinel, and update its prev
        tail.last = newNode;

        //go to the node before the new one, and update its next
        previousNode.next = newNode;

        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value)
    {

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

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()
    {

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
    public int get(int index)
    {
        //check if the index is out of bounds
        //get the size and check the index
        if (index > size || index < size)
        {
            throw new IndexOutOfBoundsException("The index is out of range");
        }

        //traverse list with current starting at the head
        //and current index
        Node current = head;
        int currentIndex = 0;

        // while loop that traverses list and
        // increments current index
        while (index != currentIndex)
        {
            current = current.next;
            currentIndex++;
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
        // create current node
        Node current = head;

        // also check if the next node is null
        // run through list until you hit the value
        while (current.data != value)
        {
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
        return 0;
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
        return null;
    }
}
