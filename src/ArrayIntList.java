import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList {

    // fields:
    private int size;
    private int[] buffer;

    public ArrayIntList() {
        this.size = 0;
        this.buffer = new int[10];
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
        for(int i = size - 1; i >= 0; i--) {
            buffer[i + 1] = buffer[i];
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
        if(size == buffer.length) {
            increaseBuffer(2);
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
        if(size == buffer.length) {
            increaseBuffer(2);
        }
        for(int i = size + 1; i > 0; i--) {
            buffer[i + 1] = buffer[i];
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
        if(size > 0) {
            buffer[0] = 0;
            for(int i = 0; i < size - 1; i++) {
                buffer[i] = buffer[i + 1];
            }
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if(size > 0) {
            buffer[size] = 0;
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
        int removedInt = 0;
        try {
            removedInt = buffer[index];
            for (int i = index; i < size; i++) {
                buffer[i] = buffer[i + 1];
            }
            size--;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("no bueno");
        }

        return removedInt;
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
        boolean result = false;
        for(int i = 0; i < size; i++) {
            if (buffer[i] == value) {
                result = true;
                break;
            }
        }
        return result;
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
        int result = -1;
        if(size > 0) {
            for(int i = 0; i < size; i++ ) {
                if(buffer[i] == value) {
                    result = i;
                }
            }
        }
        return result;
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
        for(int i = 0; i < size; i++) {
            buffer[i] = 0;
        }
        size = 0;
    }

    /**
     * Doubles the buffer length, copying any current data into the new
     * array.
     */
    private void increaseBuffer(int increase) {
        int[] hold = new int[buffer.length];
        System.arraycopy(buffer, 0, hold, 0, buffer.length);

        buffer = new int[hold.length * increase];
        System.arraycopy(hold, 0, buffer, 0, hold.length);
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

    private class IntListIterator implements Iterator<Integer> {

        //Private fields
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
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            int currentVal = buffer[i];
            i++;
            return currentVal;
        }
    }
}
