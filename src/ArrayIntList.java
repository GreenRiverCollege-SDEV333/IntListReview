import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList
{

    //fields
    private int size;
    private int[] buffer;

    public ArrayIntList ()
    {
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
    @java.lang.Override
    public void addFront(int value)
    {
        //index shuffle
        for (int i = size - 1; i > -1; i--)
        {
            buffer[i + 1] = buffer[i];
        }

        //put the value at position 0
        buffer[0] = value;
        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @java.lang.Override
    public void addBack(int value)
    {
        //TODO: check to see if we are full - if so, we need to create a larger buffer

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
    @java.lang.Override
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
    @java.lang.Override
    public void removeFront()
    {

    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @java.lang.Override
    public void removeBack()
    {

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
    @java.lang.Override
    public int remove(int index)
    {
        if (index < 0)
        {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }
        else if (index >= size)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //save a copy of the value to be removed so we can return it later
        int returnValue = buffer[index];

        //shift values from upper indexes down
        for (int i = index; i < size; i++)
        {
            buffer[i] = buffer[i + 1];
        }
        buffer[size - 1] = 0;

        //decrement the size of the list
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
    @java.lang.Override
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
    @java.lang.Override
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
    @java.lang.Override
    public int indexOf(int value)
    {
        return 0;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @java.lang.Override
    public boolean isEmpty()
    {
        return false;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @java.lang.Override
    public int size()
    {
        return 0;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @java.lang.Override
    public void clear()
    {
        buffer = new int[10];
        size = 0;

//        clean, efficient method. Too slow.
//        while (size != 0)
//        {
//            remove(0);
//        }
    }

    private void resize(int newSize)
    {
        //create a new space, separate from the old one
        int[] newBuffer = new int[newSize];

        //copy everything over from buffer into newBuffer
        for (int i = 0; i < size; i++)
        {
            newBuffer[i] = buffer[i];
        }

        //set the new space into buffer
        buffer = newBuffer;

        //the old buffer space is no longer "pointed to" and will eventually be cleaned up by the
        //garbage collector
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

    //create a private helper Iterator class
    private class IntListIterator implements Iterator<Integer>
    {
        //private fields
        private int i;

        private IntListIterator()
        {
            i = 0;
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
            return i < size;
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
            if (i >= size)
            {
                throw new NoSuchElementException("i is out of bounds");
            }

            int currentValue = buffer[i];
            i++;
            return currentValue;
        }
    }
}
