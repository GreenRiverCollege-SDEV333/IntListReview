import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Getting practice with implementing an ArrayList type class
 * @author Zalman I.
 */
public class ArrayIntList implements IntList {
    /**
     * An array used to store values placed within ArrayIntList
     */
    private int[] buffer;

    /**
     * The number of values stored within buffer
     */
    private int size;

    /**
     * Constructs an ArrayIntList with an empty buffer, and a default max capacity of 10 values
     */
    public ArrayIntList() {
        // setup buffer with default length of 10
        buffer = new int[10];

        // no values are stored in buffer
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
    public void addFront(int value) {
        //    // if the buffer contains values
        //    if(size != 0) {
        //        // if the buffer is full, increase max capacity
        //        doubleMaxCapacity();
        //
        //        // run through buffer backwards, up to first index
        //        for(int i = size; i > 0; i--) {
        //            // get value at previous index and place in current index
        //            buffer[i] = buffer[i - 1];
        //        }
        //    }
        //
        //    // add the given value at index 0
        //    buffer[0] = value;
        //
        //    // increase size as one more value is in buffer
        //    size++;

        // utilize add method to add value at front of buffer
        add(0, value);
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        //    // if the buffer is full, increase max capacity
        //    doubleMaxCapacity();
        //
        //    // add given value at last unused index of buffer
        //    buffer[size] = value;
        //
        //    // increase size as one more value is in buffer
        //    size++;

        // utilize add method to add value at back of buffer
        add(size, value);
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
        // if index out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // if the buffer contains values
        if(size != 0) {
            // if the buffer is full, increase max capacity
            doubleMaxCapacity();

            // run through buffer backwards, up to given index
            for(int i = size; i > index; i--) {
                // get value at previous index and place in current index
                buffer[i] = buffer[i - 1];
            }
        }

        // add the given value at given index
        buffer[index] = value;

        // increase size as one more value is in buffer
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        // if buffer contains no values
        if(size == 0) {
            throw new NoSuchElementException("Cannot remove values from empty ArrayIntList");
        }

        // run through buffer
        for(int i = 0; i < size; i++) {
            // place the value at next index in current index
            buffer[i] = buffer[i + 1];
        }

        // clear final value in buffer
        buffer[size - 1] = 0;

        // account for removal of value
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        // if buffer contains no values
        if(size == 0) {
            throw new NoSuchElementException("Cannot remove values from empty ArrayIntList");
        }

        // clear final value in buffer
        buffer[size - 1] = 0;

        // account for removal of value
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
    public int remove(int index) {
        // if index out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // if buffer contains no values
        if(size == 0) {
            throw new NoSuchElementException("Cannot remove values from empty ArrayIntList");
        }

        // get the value at given index of buffer
        int requestedValue = buffer[index];

        // run through buffer
        // starting at given index, going up to size, and accounting for removal of requested value
        for(int i = index; i <= size - 1; i++) {
            // place the value at next index in current index
            buffer[i] = buffer[i + 1];
        }

        // account for removal of value
        size--;

        // return the requested value
        return requestedValue;
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
        // if index out of range
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is not a valid index");
        }

        // if buffer contains no values
        if(size == 0) {
            throw new NoSuchElementException("Cannot remove values from empty ArrayIntList");
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
        //    // run through buffer
        //    for(int i = 0; i < buffer.length; i++) {
        //        // check if value stored at current index is the specified value
        //        if(buffer[i] == value) {
        //            // the value exists within the buffer
        //            return true;
        //        }
        //    }
        //
        //    // the value does not exist within buffer
        //    return false;

        // if index could not be found, returns false
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
    public int indexOf(int value) {
        // run through buffer
        for(int i = 0; i < buffer.length; i++) {
            // check if value stored at current index is the specified value
            if(buffer[i] == value) {
                // return the current index, as that is where the specified value is located
                return i;
            }
        }

        // if the value does not exist in buffer
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
        // create an empty array with the current buffer's length
        buffer = new int[buffer.length];

        // set the size to 0, as there are no longer any values being tracked
        size = 0;
    }

    /**
     * If the buffer has no more remaining space, double its max capacity
     */
    private void doubleMaxCapacity() {
        // if there is no more space left
        if(size == buffer.length) {
            // double the maximum capacity of the array
            resize(buffer.length * 2);
        }
    }

    /**
     * Increases the length of the ArrayIntList's buffer by the given value
     */
    private void resize(int newSize) {
        // create a new buffer, with double the capacity of the existing buffer
        int[] newBuffer = new int[newSize];

        // run through previous buffer and copy over all values
        for(int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }

        // replace buffer with newBuffer, now with double the length
        buffer = newBuffer;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new ArrayIntListIterator();
    }

    /**
     * Implementation of an Iterator for the ArrayIntList class
     */
    private class ArrayIntListIterator implements Iterator<Integer> {
        /**
         * The current index being tracked by the Iterator
         */
        private int index;

        /**
         * Constructs an ArrayIntListIterator with the index initialized to 0
         */
        ArrayIntListIterator() {
            index = 0;
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
            return index < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            // get the value at current index of buffer
            int currValue = buffer[index];

            // move on to next element
            index++;

            // return the value
            return currValue;
        }
    }
}