import java.util.Iterator;

public class DoublyLinkedIntList implements IntList
{
    //private fields
    private class Node
    {
        int data;
        Node next;  //address of the Node "after" this one
        Node prev;  //address of the Node "before" this one

        public Node()
        {
            //by default, Nodes will point to null.
            next = null;
            prev = null;
        }
    }

    private Node pre;
    private Node post;
    private int size;

    //These two Nodes are sentinel Nodes; dummy Nodes that serve as bookends to the doubly-linked list.
    //They aren't necessary, but they make the job much easier.

    //constructor
    public DoublyLinkedIntList()
    {
        //an empty list has 2 sentinel Nodes; they sandwich all the important stuff that gets added later.
        pre = new Node();
        post = new Node();

        //making the two sentinels point to each other
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

    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value)
    {
        //storing the old "last" Node
        Node theLastOne = post.prev;

        //construct a new Node at the back of the list
        Node theNewOne = new Node();
        theNewOne.data = value;
        theNewOne.next = post;
        theNewOne.prev = theLastOne;

        //re-route the sentinels
        post.prev = theNewOne;
        pre.next = theNewOne;

        //re-route the old "last" Node to point to our newly-created last Node
        theLastOne.next = theNewOne;

        //increment the size of the list
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
        //if the list isn't empty...
        if (size > 0)
        {
            //starting from the back bookend, pointing to the "last" Node in the list
            Node theOneToRemove = post.prev;

            //accessing the Node before the "last" one and re-routing it to the back bookend
            theOneToRemove.prev.next = post;

            //stealing the "prev" pointer from the "last" Node and using it to re-route the back bookend to the new "last"
            post.prev = theOneToRemove.prev;

            //completely clearing the old "last" Node; it's redundant, but for peace of mind.
            //the Garbage Collector will sweep the Node up regardless of whether you clear the Node's values or not.
            theOneToRemove.next = null;
            theOneToRemove.prev = null;
            theOneToRemove.data = 0;

            //de-increment the size of the list
            size--;
        }
        else
        {
            throw new IllegalStateException("List is empty. Nothing can be removed.");
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
        return 0;
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
        return false;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size()
    {
        return 0;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear()
    {

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
