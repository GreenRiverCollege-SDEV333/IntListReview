import java.util.Iterator;
import java.util.NoSuchElementException;

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
        //set up a new node
        Node theNewOne = new Node();
        theNewOne.data = value;

        //looking back, it occurs to me that I completely forgot to make the nodes in my LinkedIntList submission
        //actually store the user's inputted data for the add methods... whoops.

        //check if the list is empty or not
        if (pre.next == null)
        {
            //if it is, put it in and point the sentinels to it.
            theNewOne.prev = pre;
            theNewOne.next = post;

            pre.next = theNewOne;
            post.prev = theNewOne;

            //then increment the size.
            size++;
        }
        else
        {
            //if the list isn't empty, store the current "front" in a variable, then "rewire" the "front" and first
            //sentinel to have the proper pointers to the "new" front.
            Node oldFront = pre.next;

            theNewOne.prev = pre;
            theNewOne.next = oldFront;

            pre.next = theNewOne;
            oldFront.prev = theNewOne;

            //increment the size
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
        //set up a new node
        Node theNewOne = new Node();
        theNewOne.data = value;

        //check if the list is empty or not
        if (pre.next == null)
        {
            //if it is, just recycle addFront(). There are no nodes besides the sentinels, so order doesn't matter much.
            addFront(value);
        }
        else
        {
            //if the list isn't empty, store the current "back" in a local variable. Wire up theNewOne, then re-wire
            //the affected nodes so they point to theNewOne.

            Node oldBack = post.prev;

            theNewOne.prev = oldBack;
            theNewOne.next = post;

            post.prev = theNewOne;
            oldBack.next = theNewOne;

            //increment the size
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
    public void add(int index, int value)
    {
        if (index > size)
        {
            throw new IndexOutOfBoundsException("Provided index is too large.");
        }
        else if (index < 0)
        {
            throw new IndexOutOfBoundsException("Provided index cannot be negative.");
        }
        else
        {
            //gonna need an iterator, a node to hold the value, and an index counter variable.
            LinkedIterator iterator = new LinkedIterator();
            Node newNode = new Node();
            newNode.data = value;
            int currentIndex = 0;

            //check if the list is empty; if it is, just recycle addFront(). If it isn't, get to walkin'
            if (pre.next == null)
            {
                addFront(value);
            }
            else
            {
                //scan ahead one Node to ensure that current doesn't accidentally go too far
                while(currentIndex + 1 != index)
                {
                    iterator.current = iterator.current.next;
                    currentIndex++;
                }

                if(currentIndex + 1 == index)
                {
                    //scoot the current node at the user-provided index outta the way; first off, store it in a variable
                    Node oldNode = iterator.current.next;

                    //now wire up the new node so it points to both the "current" node and the "old" node
                    newNode.prev = iterator.current;
                    newNode.next = oldNode;

                    //re-wire the Nodes as necessary
                    iterator.current.next = newNode;
                    oldNode.prev = newNode;

                    //iterate the count
                    size++;
                }
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
        //if the size isn't 0 or 1, since 1 wouldn't work with this solution
        if (size > 1)
        {
            //Grab the first Node in the list and store it in a variable
            Node theOneToRemove = pre.next;

            //now, re-wire the Nodes.
            pre.next = theOneToRemove.next;
            theOneToRemove.next.prev = pre;

            //wipe the slate clean just to be sure.
            theOneToRemove.prev = null;
            theOneToRemove.next = null;
            theOneToRemove.data = 0;

            //de-increment the list
            size--;
        }
        else if (size == 1)
        {
            //now for something a little different: store the Node, reset pre/post's pointers back to null.
            //Then wipe the Node.
            Node theOneToRemove = pre.next;

            pre.next = null;
            post.prev = null;

            theOneToRemove.prev = null;
            theOneToRemove.next = null;
            theOneToRemove.data = 0;

            //and decrement the size...
            size--;
        }
        else
        {
            //in case the list is empty, throw an exception. Kind of worried I'm getting too trigger-happy with these...
            throw new NoSuchElementException("The list is empty. Nothing to remove.");
        }
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
       //gonna need an iterator and an index variable for this one.
        LinkedIterator iterator = new LinkedIterator();
        int currentIndex = 0;

        int dataToReturn = -1;

        //walk through the list. Might've been able to make this into a method...
        while (currentIndex + 1 != index)
        {
            iterator.current = iterator.current.next;
            currentIndex++;
        }

        //if the index is coming up, then go ahead and pop the data out of that Node.
        if (currentIndex + 1 == index)
        {
            Node nodeToRemove = iterator.current.next;
            dataToReturn = nodeToRemove.data;

            //from there, wire the Nodes to go around this Node.
            iterator.current.next = nodeToRemove.next;
            nodeToRemove.next.prev = iterator.current;

            //blank out the nodeToRemove entirely.
            nodeToRemove.prev = null;
            nodeToRemove.next = null;
            nodeToRemove.data = 0;

            //decrement the size.
            size--;
        }

        //return the data.
        return dataToReturn;
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
        //iterator and index variable needed.
        LinkedIterator iterator = new LinkedIterator();
        int currentIndex = 0;
        int dataToReturn = -1;

        if (index > size)
        {
            throw new IndexOutOfBoundsException("The provided index is too large.");
        }
        else if (index < 0)
        {
            throw new IndexOutOfBoundsException("Negative indexes are not permitted.");
        }
        else
        {
            while (currentIndex + 1 != index)
            {
                iterator.current = iterator.current.next;
                currentIndex++;
            }

            if (currentIndex + 1 == index)
            {
                dataToReturn = iterator.current.next.data;
                return dataToReturn;
            }
        }
        return dataToReturn;
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
        //iterator for this one.
        LinkedIterator iterator = new LinkedIterator();

        //as long as the next field isn't null, meaning we're not at post...
        while(iterator.current.next != null)
        {
            //check to see if the current Node's value is what we're looking for.
            if (iterator.current.data == value)
            {
                //if it is, return true and break out of this method.
                return true;
            }
            else
            {
                //otherwise, keep marchin' forward.
                iterator.current = iterator.current.next;
            }
        }
        //if the loop reaches its end, then logically, the provided value isn't in here. Return false.
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
        //iterator and index variable for this one.
        LinkedIterator iterator = new LinkedIterator();
        int currentIndex = 0;

        //am I wrong in thinking some of this code could be turned into its own method? How far should I go when it
        //comes to making my code atomic in size? Maybe Josh imprinted on me too much...

        //we're gonna roll on the assumption that the value is present in the list.
        while (iterator.current.next != null)
        {
            //roll through the list until "next" is null, which would mean we've reached post, which doesn't have data
            //in it in the first place.
            if (iterator.current.data == value)
            {
                //if we've got the data, then go ahead and return the current index.
                return currentIndex;
            }
            else
            {
                //if we don't have the data yet, take a step over to the next Node and increase the current index.
                iterator.current = iterator.current.next;
                currentIndex++;
            }
        }
        //if we never find it, then return -1.
        return -1;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty()
    {
        if (size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size()
    {
        //self-explanatory since we keep track of the size in a variable.
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear()
    {
        //wipe the slate clean.
        pre.next = null;
        post.prev = null;
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        return new LinkedIterator();
    }

    //helper class/type that defines how the iterator works
    //much of this was copy/pasted over from LinkedIntList.java.
    private class LinkedIterator implements Iterator<Integer>
    {

        private DoublyLinkedIntList.Node current;

        public LinkedIterator()
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
        public boolean hasNext()
        {
            //compute the result of whether or not current equals null, then return it
            return current != null;
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
            if (current != null)
            {
                int item = current.data;
                current = current.next;
                return item;
            }
            else
            {
                throw new NoSuchElementException("End of list reached.");
            }
        }
    }
}
