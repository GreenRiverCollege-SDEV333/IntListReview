import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList{
    //fields
    private int size;
    private int[] buffer;

    public ArrayIntList(){
        //initialize my fields
        size = 0;
        buffer = new int[10];
    }

    /**
     * Inserts the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        if(size == buffer.length){
            resize(size * 2);
        }

        //5,4,3,2,1 then save in [0]
        for (int i = size; i >= 1 ; i--) { //count 5, 4, 3, 2, 1
            buffer[i] = buffer[i - 1]; //copy from 4, 3, 2, 1, 0
        }

        //put the value at the front of the array position [0]
        buffer[0] = value;
        size++;
    }

    /**
     * Inserts the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        //if buffer is full, create a larger buffer
        if(size == buffer.length){
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
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        if(size == buffer.length){
            resize(size * 2);
        }

        //shift elements to the right
        for (int i = size; i > index; i--) {
            buffer[i] = buffer[i - 1];
        }

        //add the value at the specified index
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
        if(!isEmpty()){
            for (int i = 0; i <= size - 2; i++) {
                buffer[i]  = buffer[i + 1];
            }

            //clear the last value to avoid duplicates
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
        if(!isEmpty()){
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
        //check index to see if it is valid
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //save a copy of the value to removed, so we can return it later
        int valueToRemove = buffer[index];

        //shift values to the left
        for (int i = index; i < size - 1; i++) {
            buffer[i] = buffer[i+1];
        }

        //empty the last/redundant index
        buffer[size - 1] = 0;

        //decrement size
        size--;

        return valueToRemove;
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
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        System.out.println(buffer[index]);
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
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == value){
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
        for (int i = 0; i <= size; i++) {
            if (value == buffer[i]){
                return i;
            }else{
                i++;
            }
        }
        return -1;
    }

    /**
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    /**
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
//        //go through each index of the array and set it to 0
//        for (int i = 0; i < size; i++) {
//            buffer[i] = 0;
//            i++;
//        }

        //create a new array and overwrite the old
        buffer = new int[10];
        size = 0;
    }

    private void resize(int newSize){
        //create new space, separate form old space (buffer)
        int[] newBuffer = new int[newSize];

        //copy everything over from buffer into newBuffer
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }

        //set the new space into buffer
        buffer = newBuffer;

        //the old buffer space is no longer "pointed to" and will
        //eventually be cleaned up by the garbage collector
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

        //constructor
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
            if(i >= size){
                throw new NoSuchElementException("i is now out of bounds");
            }
            int currentValue = buffer[i];
            i++;
            return currentValue;
        }
    }

    //iterators are what enables main/ client to use a for-each loop
    //on my IntList
}
