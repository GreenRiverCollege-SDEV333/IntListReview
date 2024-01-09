import java.util.Iterator;

public class ArrayIntList implements IntList
{
    private int size;
    private int[] buffer;

    public ArrayIntList()
    {
        //initialize my fields
        size = 0;
        buffer = new int[10];
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
        // start at 0, stop at the last element, increase by one
        for (int i = 0; i <= size; i++)
        {
            //shift over to the right
            buffer[i + 1] = buffer[i];
        }
        buffer[4] = buffer[3];
        buffer[3] = buffer[2];
        buffer[2] = buffer[1];
        buffer[1] = buffer[0];

        // put the value at the front of the array at position 0
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
        // TODO: check to see if we are full - if so, we need to create a larger buffer
        if (size == buffer.length)
        {
            resize(size * 2);
        }

        buffer[size] = value;
        size += 1;
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
        if (size == buffer.length)
        {
            resize(size * 2);
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
        // for loop to shift elements to the left
        // buffer[0] = buffer[1]
        // buffer[1] = buffer[2]
        for (int i = 0; i < size - 1; i++)
        {
            buffer[i] = buffer[i + 1];
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        buffer[size - 1] = 0;
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
        //first, check the index to see if it is valid
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        else if (index >= size)
        {
            throw new IndexOutOfBoundsException("Index is higher than size");
        }

        //save a copy of the value to be removed so we can return it later
        int copyOfRemovedValue = buffer[index];

        //shift values to the left
        for (int i = index; index <= size - 1; index++)
        {
            buffer[i] = buffer[i + 1];
        }

        //reassign the last value of the size to 0
        buffer[size - 1] = 0;

        //don't forget to decrement size
        size--;

        return copyOfRemovedValue;
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
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear()
    {
        for (int i = 0; i < size; i++)
        {
            buffer[i] = 0;
        }
        //another way to do this

        //buffer = new int[10];
        //size = 0;
    }

    private void resize(int newSize)
    {
        //create new space, separate from the old space (buffer)
        int[] newBuffer = new int[newSize];

        //copy everything over from buffer into newBuffer
        for (int i = 0; i < buffer.length; i++)
        {
            newBuffer[i] = buffer[i];
        }

        // set the new space into buffer
        buffer = newBuffer;

        //the old buffer space is no longer "pointed to" and will eventually
        //be cleaned up by the garbage collector
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
