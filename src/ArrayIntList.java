import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList {

    //fields:
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
    public void addFront(int value) {
        if(size == buffer.length)
        {
            resize(size * 2);
        }

        for(int i = size; i >= 1; i--)
        {
            buffer[i] = buffer[i-1];
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
    public void addBack(int value) {
        //TODO: check to see if we are full - if so, we need to create a larger buffer
        if(size == buffer.length)
        {
            resize(size * 2);
        }

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
    public void add(int index, int value) {
        if(index > size || index < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if(size == buffer.length)
        {
            resize(size * 2);
        }
        if(index == size)
        {
            buffer[index] = value;
        }
        else {
            for(int i = size; i >= index; i--)
            {
                buffer[i] = buffer[i-1];
            }
            buffer[index] = value;
        }
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if(!isEmpty())
        {
            for (int i = 0; i <= size - 2; i++) {
                buffer[i] = buffer[i + 1];
            }
            buffer[size - 1] = 0;
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if(!isEmpty())
        {
            buffer[size-1] = 0;
            size--;
            return;
        }
       throw new NoSuchElementException("There are no elements to remove!");
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
    public int remove(int index) {
        //check to see if index is valid
        if(index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        // save a copy of the value to be returned later
        int removedValue = buffer[index];

        //shift values to the left
        for (int i = index; i < size; i++) {
            buffer[i] = buffer[i+1];
        }
        //remove the final index value
        buffer[size - 1] = 0;
        //decrement size
        size--;
        //return the removed value
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
    public int get(int index) {
        if(index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        return buffer[index];
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if(buffer[i] == value)
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
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if(buffer[i] == value)
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        buffer = new int[buffer.length];
        size = 0;
    }

    private void resize(int newSize)
    {
        int[] newBuffer = new int[newSize];

        for (int i = 0; i < size; i++) {
            newBuffer[i] = buffer[i];
        }
        //set the new space into the buffer
        buffer = newBuffer;

        //the old space is no longer "pointed to" and will eventually
        //be cleaned up by the garbage collector
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new IntListIterator();
    }

    //create a private helper Iterator class
    private class IntListIterator implements Iterator<Integer>{
        //private fields
        private int i;

        private IntListIterator(){
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
        public boolean hasNext() {
            return i < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            if(i >= size)
            {
                throw new NoSuchElementException("i is out of bounds");
            }
            int currentValue = buffer[i];
            i++;
            return currentValue;
        }
    }
}
