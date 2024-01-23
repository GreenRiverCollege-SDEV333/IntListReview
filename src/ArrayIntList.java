import java.util.Iterator;

public class ArrayIntList implements IntList {

    private final int STEP = 100;
    int[] array;
    int size;

    public ArrayIntList() {
        size = 0;
        array = new int[100];
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
        autoResize();

        // shift all right
        for (int i = size(); i > 0; i--) {
            array[i] = array[i-1];
        }
        array[0] = value;
        size += 1;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        autoResize();

        array[size] = value;
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
    public void add(int index, int value) {
        autoResize();

        if (index > size()) throw new IndexOutOfBoundsException();

        // shift all rhs right by 1
        for (int i = size(); i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = value;
        size += 1;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {

        // skip if empty
        if (size() == 0) return;

        // shift all values left
        for (int i = 0; i < size() ; i++) {
            array[i] = array[i+1];
        }

        // lower size by 1
        size -= 1;

        autoResize();
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {


        // skip if empty
        if (size() == 0) return;

        // just decrement the size, in my opinion there's no need to change the value at size,
        // since it will be overwritten when adding new elements.
        size -= 1;

        autoResize();

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
        // skip if empty
        if (size() == 0 || index > size()) throw new IndexOutOfBoundsException();

        int value = get(index);

        // shift all values left
        for (int i = index; i < size() ; i++) {
            array[i] = array[i+1];
        }

        // lower size by 1
        size -= 1;

        autoResize();

        return value;
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
        if (index >= size()) throw new IndexOutOfBoundsException();

        return array[index];
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        for (var i : this) {
            if (value == i) return true;
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
        // loop through array, find value, or return invalid index
        for (int i = 0; i < size(); i++) {
            if (value == array[i]) return i;
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
        return size() == 0;
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
        array = new int[100];
        size = 0;
    }

    // resizes array based on size/array capacity
    private void autoResize() {
        // on reach capacity
        if (size() == array.length - 1 ) {
            // create a new array with more space
            int[] buffer = new int[array.length + STEP];

            // copy array values to buffer
            for (int i = 0; i < size(); i++) {
                buffer[i] = array[i];
            }

            // assign array to buffer
            array = buffer;
        }

        // on too much capacity
        else if (size() < array.length - STEP) {
            // create new array with less space
            int[] buffer = new int[array.length - STEP];

            // copy array values to buffer
            for (int i = 0; i < size(); i++) {
                buffer[i] = array[i];
            }

            // and assign buffer to array
            array = buffer;
        }

    }



    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public Integer next() {
                return array[index++];
            }
        };
    }
}
