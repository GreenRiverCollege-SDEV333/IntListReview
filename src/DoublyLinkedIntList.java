import java.util.Iterator;

public class DoublyLinkedIntList implements IntList
{
    //private fields
    private class Node
    {
        int data;
        Node next;
        Node prev;
        
        public Node()
        {
            next = null;
            prev = null;
        }
    }
    
    private Node pre;
    private Node post;
    private int size;
    
    public DoublyLinkedIntList()
    {
        //empty list has 2 sentinel nodes that serve as bookends
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
        //create new head node and connect to old head and pre
        Node newHead = new Node();
        newHead.data = value;
        newHead.next = pre.next;
        newHead.prev = pre;

        //connect old head to new head
        pre.next.prev = newHead;

        //assign new head
        pre.next = newHead;

        //increment size
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
        Node theNewOne = new Node(); //new node
        theNewOne.data = value; //instantiate node value
        theNewOne.next = post; //instantiate node.next
        theNewOne.prev = post.prev; //instantiate node.prev
    
        post.prev.next = theNewOne; //change node.next of node proceeding new node
        post.prev = theNewOne; //change node.prev of post
        size++; //increment size
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
        indexOutOfBoundsChecker(index);

        //helpers
        int currIndex = 0;
        Node currNode = pre.next;

        //traverse to specified index
        while(currIndex < index)
        {
            currNode = currNode.next;
            currIndex++;
        }

        //insert new node
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = currNode.next;
        newNode.prev = currNode;

        //reassign old node forward pointer
        currNode.next = newNode;

        //increment size
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
        //reassign pre
        pre.next = pre.next.next;

        //reassign new head.prev
        pre.next.prev = pre;
    }
    
    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        if (size > 0)
        {
            Node removeNode = post.prev; //make a copy of node to remove
    
            removeNode.prev.next = post; //set the proceeding node's next pointer to post
            post.prev = removeNode.prev; //set the prev pointer of post to the node proceeding the removed node
            
            //set node to null for garbage collector to clean up
            removeNode.data = 0;
            removeNode.next = null;
            removeNode.prev = null;
            
            size--; //decrement size of linkedlist
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
        indexOutOfBoundsChecker(index);

        //helpers
        int currIndex = 0;
        Node currNode = pre.next;

        //traverse to specified index
        while(currIndex < index)
        {
            currNode = currNode.next;
            currIndex++;
        }

        //reassign nodes surrounding currNode
        currNode.prev.next = currNode.next;
        currNode.next.prev = currNode.prev;

        //decrement size
        size--;

        return currNode.data;
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
        indexOutOfBoundsChecker(index);

        //helpers
        int currIndex = 0;
        Node currNode = pre.next;

        //traverse to specified index
        while(currIndex < index)
        {
            currNode = currNode.next;
            currIndex++;
        }

        return currNode.data;
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
        //temp node to traverse list
        Node currNode = pre;

        //traverse list, if value found return true
        while(currNode != null)
        {
            if(currNode.data == value)
            {
                return true;
            }
            currNode = currNode.next;
        }

        //return false if value not found
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
        //helpers
        int index = 0;
        Node currNode = pre;

        //traverse list, if value found return true
        while(currNode != null)
        {
            if(currNode.data == value)
            {
                return index;
            }

            currNode = currNode.next;

            index++;
        }

        //return -1 if value not found
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
        //if size is greater than 0, list is not empty
        return size <= 0;
    }
    
    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size()
    {
        //size is length of list
        return size;
    }
    
    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear()
    {
        //reassign pre and post to each other
        pre.next = post;
        post.prev = pre;
    }
    
    @Override
    public Iterator<Integer> iterator()
    {
        return null;
    }

    private void indexOutOfBoundsChecker(int index)
    {
        if(index >= size)
        {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }
}
