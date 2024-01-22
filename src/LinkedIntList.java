import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList
{
    //private fields
    private class Node
    {
        int data;
        Node next;
    }
    
    private Node head;
    private int size;
    
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
        //copy head
        Node newNode = head;

        //reassign head to new value and point to old head
        head = new Node();
        head.data = value;
        head.next = newNode;

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
        //create new node
        Node newNode = new Node();
        newNode.data = value;

        //check if list is empty
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            //helper node
            Node temp = head;

            //traverse to end of list
            while(temp.next != null)
            {
                temp = temp.next;
            }

            //assign former tail pointer to new tail
            temp.next = newNode;
        }

        //increment size
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
        //check if index out of bounds
        indexOutOfBoundsChecker(index);

        //create new node to be inserted
        Node newNode = new Node();
        newNode.data = value;

        //if node is added at the end
        if (index == size)
        {
            addBack(value);
            return;
        }

        //create helpers
        Node temp = head;
        Node prev = null;
        int currIndex = 0;

        //traverse to specified index
        while(currIndex != index)
        {
            prev = temp;
            temp = temp.next;
            currIndex++;
        }

        //change pointers
        newNode.next = temp;
        if (prev != null)
        {
            prev.next = newNode;
        }
        else
        {
            head = newNode;
        }

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
        if(size > 0)
        {
            head = head.next;
            size--;
        }
    }
    
    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        if(size > 0)
        {
            //if list is size 1 remove set head to null
            if(size == 1)
            {
                head = null;
            }
            else
            {
                Node temp = head;

                while(temp.next.next != null)
                {
                    temp = temp.next;
                }

                temp.next = null;
            }

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
    public int remove(int index)
    {
        indexOutOfBoundsChecker(index);

        //if index 0
        if(index == 0)
        {
            if(head == null)
            {
                throw new IndexOutOfBoundsException("Index out of range");
            }

            int removedValue = head.data;
            head = head.next;
            size--;
            return removedValue;
        }

        //helpers
        Node temp = head;
        Node prev = null;
        int currIndex = 0;

        //traverse to index
        while(currIndex != index)
        {
            if (temp == null)
            {
                throw new IndexOutOfBoundsException("Index out of range");
            }

            prev = temp;
            temp = temp.next;
            currIndex++;
        }

        //remove node
        prev.next = temp.next;

        //return value that was removed and decrement size
        size--;
        return temp.data;
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
        Node temp = head;
        int currIndex = 0;

        //traverse to index
        while(currIndex != index)
        {
            if (temp == null)
            {
                throw new IndexOutOfBoundsException("Index out of range");
            }
            temp = temp.next;
            currIndex++;
        }

        if (temp == null)
        {
            throw new IndexOutOfBoundsException("Index out of range");
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
    public boolean contains(int value)
    {
        //helper node
        Node temp = head;

        //traverse list
        while(temp != null)
        {
            //check if current node has specified value
            if(temp.data == value)
            {
                return true;
            }

            //continue traversing
            temp = temp.next;
        }

        //if not found, return false
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
        Node temp = head;
        int currIndex = 0;

        //traverse list
        while(temp != null)
        {
            //check if current node has specified value
            if(temp.data == value)
            {
                return currIndex;
            }

            //continue traversing
            temp = temp.next;
            currIndex++;
        }

        //return -1 if not found
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
        //if list is empty
        if(head == null)
        {
            return;
        }

        //reassign head to point to null
        head.next = null;
        head = null;

        //set size to 0
        size = 0;
    }
    
    @Override
    public Iterator<Integer> iterator()
    {
        return new SinglyLinkedIterator();
    }
    
    //helper class that defines how the iterator works
    private class SinglyLinkedIterator implements Iterator<Integer>
    {
        private Node curr;
        
        public SinglyLinkedIterator()
        {
            curr = head;
        }
        
        @Override
        public boolean hasNext()
        {
            return curr != null;
        }
    
        @Override
        public Integer next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException("Iterator at end");
            }

            int data = curr.data;
            curr = curr.next;

            return data;
        }
    }

    private void indexOutOfBoundsChecker(int index)
    {
        if(index > size || index < 0)
        {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }
}
