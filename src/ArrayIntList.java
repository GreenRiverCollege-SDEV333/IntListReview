import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList
{
    //fields
    private int size;
    private int[] buffer;
    
    public ArrayIntList()
    {
        size = 0;
        buffer = new int[10];
    }
    
    private void resize(int newSize)
    {
        int[] newBuffer = new int[newSize];
    
        for (int i = 0; i < buffer.length; i++)
        {
            newBuffer[i] = buffer[i];
        }
        
        buffer = newBuffer;
    }
    
    private void sizeCheck()
    {
        if (size == buffer.length)
        {
            resize(size * 2);
        }
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
        sizeCheck();

        for (int i = size; i > 0; i--)
        {
            buffer[i] = buffer[i - 1];
        }

        buffer[0] = value;
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
        sizeCheck();
        
        buffer[size] = value;
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
        sizeCheck();
    }
    
    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()
    {
        //helpers
        int prev = 0;
        int curr = 1;

        //reassign values to shift left
        for(int i = 0; i < size; i++)
        {
            buffer[prev] = buffer[curr];
        }
    }
    
    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        //traverse to end of buffer and set to 0
        buffer[buffer.length - 1] = 0;

        //decrement size
        size--;
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

        int removedValue = buffer[index];

        for (int i = index; i < size - 1; i++)
        {
            buffer[i] = buffer[i + 1];
        }

        size--;
        return removedValue;
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

        return buffer[index];
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
        for (int num:buffer)
        {
            if (num == value)
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
    public int indexOf(int value)
    {
        //helper
        int currIndex = 0;

        for(int val:buffer)
        {
            if(val == value)
            {
                //return index value was found at
                return currIndex;
            }

            //increment currIndex
            currIndex++;
        }

        //value not found
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
        buffer = new int[10];
        
        size = 0;
    }
    
    
    @Override
    public Iterator<Integer> iterator()
    {
        return new IntListIterator();
    }
    
    //create private helper iterator class
    private class IntListIterator implements Iterator<Integer>
    {
        private int i;
    
        public IntListIterator()
        {
            i = 0;
        }
    

        @Override
        public boolean hasNext()
        {
            return i < size;
        }
    

        @Override
        public Integer next()
        {
            if (i >= size)
            {
                throw new NoSuchElementException("i is out of bounds");
            }
            
            int curr = buffer[i];
            i++;
            return curr;
        }
    }

    private void indexOutOfBoundsChecker(int index)
    {
        if(index >= size || size < 0)
        {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }
}
