package lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import interfaces.IntList;

/**
 * Class that instantiates an int[] and provides size field
 * contains instance methods implemented from IntList interface
 * to help with adding, removing, etc
 * @author tobygoetz
 * @author Ken Hang
 * @version 1.0
 */
public class ArrayIntList implements IntList {

    // fields:
    private int size;
    private Integer[] buffer;

    /**
     * Constructor for ArrayIntList created a new
     * ArrayIntList with a buffer of 10
     */
    public ArrayIntList() {
        //initialize fields
        size = 0;
        //updated int[] to Integer[] so that 0 can be used in this list
        buffer = new Integer[10];
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
            //loop while index is greater than zero
            for (int i = size; i > 0; i--) {
                //if buffer is at capacity increase buffer by one index
                if (size == buffer.length) {
                    this.resize(buffer.length + 1);
                }
                //index at highest buffer gets shifted right
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
    public void addBack(int value) {

        //if buffer is at capacity increase buffer by one index
        if ( size == buffer.length) {
            resize(size + 1);
        }
        //add value to size which is one index greater than last value
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

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Specified Index Must Be " +
                    "In the Range of 0-" + size);
        } else {
            //loop while index is greater than index value specified
            for (int i = size; i >= index; i--) {
                //if buffer is at capacity increase buffer by one index
                if (size == buffer.length) {
                    this.resize(buffer.length + 1);
                }
                //index at highest buffer gets shifted right
                buffer[i] = buffer[i - 1];
            }
        }
        buffer[index] = value;
        size++;

    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if (!isEmpty()) {
            for (int i = 0; i <= size - 2; i++) {
                buffer[i] = buffer[i + 1];
            }

            //Make sure the last value that was shifted left is set to zero
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
        if (!isEmpty()) {
            buffer[size - 1] = 0;
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
    public int remove(int index) {
        // first, check the index to see if it is valid
        if ( index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        } else if (index >= size) {
            throw new IndexOutOfBoundsException("Index is higher than size");
        }

        // save a copy of the value to be removed so we can return it later
        int copyOfRemovedValue = buffer[index];

        //shift values to the left
        for (int i = 0; i <= size - 1; i++) {
            buffer[i] = buffer[i + 1];

        }

        buffer[size - 1] = 0;
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
    public int get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("No Such Index Value...");
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
        return 0;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
//        for (int i = 0; i < size; i++) {
//            buffer[i] = 0;
//        }
//
//        size = 0;

        buffer = new Integer[10];
        size = 0;
    }

    private void resize(int newSize) {
        //create new space, separate from the old space (buffer)
        Integer[] newBuffer = new Integer[newSize];

        // copy everything over from buffer into newBuffer
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];

        }

        // set the new space into buffer
        buffer = newBuffer;

        // the old space is no longer "pointed to" and will eventually
        // be cleaned up by the garbage collector
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {

        //iterators are what enables main/client to use a for-each lop on Interfaces.IntList
        return new IntListIterator();
    }

    //create a private helper Iterator class
    private class IntListIterator implements Iterator<Integer> {

        // private fields:
        private int i;

        private IntListIterator() {
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
            //check to see if i is greater than size
            if ( i >= size) {
                throw new NoSuchElementException("i is now out of bounds");
            }
            
            int currentValue = buffer[i];
            i++;
            return currentValue;
        }

        @Override
        public String toString() {
            return "IntListIterator{" +
                    "i=" + i +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ArrayIntList{" +
                "size=" + size +
                ", buffer=" + Arrays.toString(buffer) +
                '}';
    }
}
