import java.util.Iterator;

public class ArrayList implements IntList{

    private int size;

    private int[] buffer;

    public ArrayList(){
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
        for (int i = size - 1; i>=0; i--){ // shift elements
        buffer[i+1] = buffer[i];
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
        if (size == buffer.length) {
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index not in range"); // throw exception. get used to this!!
        }
        if (size == buffer.length) { //double array size to assure space for new element
            resize(size * 2);
        }
        for (int i = size - 1; i >= 0; i--) { // shift elements to the right
            buffer[i + 1] = buffer[i];
        }
        buffer[index] = value; //insert the new value at the given index
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if (size > 0){
            for (int i = 0; i <= size - 2; i++) {
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
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot remove from an empty list");
        }else{
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
        if (index < 0 || index >= size) { //or do an if else instead of on "or" so I can be more specific with my error messages
            throw new IndexOutOfBoundsException("number not in array");
        }
        int numberRemoved = buffer[index];
        // Shift elements to the left (taken from remove front)
        for (int i = index; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
        }
        buffer[size -1] = 0;
        size--;
        return numberRemoved; //return the number removed from the position
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("number not in array");
        }

        return buffer[index];  // return given #
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
            if (buffer[i] == value) {
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
            if (buffer[i] == value) {
                return i; // Value found, return its index
            }
        }
        return -1; // Value not found in the list
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
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        buffer = new int[10];
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
    //create a private helper iterator class
    private class IntListIterator implements Iterator<Integer>{
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
         * @throws @NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next() {
            int currentValue = buffer[i];
            i++;
            return null;
        }
    }
    //iterators enables main/client to use a for-each loop
    // on my intlist

    @Override
    public void resize(int newSize){
        int[] newBuffer = new int[newSize]; //create a new array that will be larger
        for (int i = 0; i < buffer.length; i++){
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;
        // this overwrites the previous array with our new larger array
    }
}
