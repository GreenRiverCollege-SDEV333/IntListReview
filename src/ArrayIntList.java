import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList {

    //fields

    // the number of indexes in the array which have a value.
    private int size;
    private int[] buffer;

    public ArrayIntList(){
        //initialize fields
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
        //resize buffer if all its index spaces are filled
        if(size == buffer.length){
            resize(size * 2);
        }

        for (int i = size; i >= 1 ; i--) { // Count 5,4,3,2,1
            buffer[i] =  buffer[i - 1];            //copy from 4,3,2,1,0
        }

//        for (int i = size - 1; i >= 0 ; i--) {
//            buffer[i +1] =  buffer[i];
//        }
//        buffer[4] <- buffer[3];
//        buffer[4] <- buffer[3];
//        buffer[4] <- buffer[3];
//        buffer[4] <- buffer[3];

        //put the value at the front of the array at position 0
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
//        if (size == buffer.length){
//            int[] temp = new int[size + 10];
//            for (int i = 0; i < size; i++) {
//                temp[i] = buffer[i];
//
//            }
//            //point to the new buffer
//            buffer = temp;
//        }
        if(size == buffer.length){
            resize(size*2);
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
        if(index < 0){
            throw new IndexOutOfBoundsException("Index can not be less than 0");
        }
        if(index >= buffer.length){
            //resize array to allow for that index position
            resize(index);
        }
        if (size == buffer.length){
            resize(size*2);
        }
        if(index < size){
            //index less than size, move every value from size to index to the right
            // buffer[i] = buffer[i -1]
            //buffer [index] = value
            for (int i = size; i > index; i--){
                buffer[i] =  buffer[i-1];

            }
            buffer[index] = value;
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if(!isEmpty()){
            for (int i = 0; i < size - 1; i++) {
                buffer[i] = buffer[i+1];
            }
            //optional, but a good idea - since we shifted everything to the left by 1.
            //we want to clear out the right-most value to be zero
            buffer[size-1] = 0;
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        //could also use size>0
        if(!isEmpty()){
            buffer[size-1] = 0;
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
        //check if index is out of bounds
        if(index >= size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }
        else if(index < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }

        for (int i = index; i < size; i++) {
            buffer[i] = buffer[i+1];
        }

        //Set the last value to zero
        buffer[size-1] = 0;

        //don't forget to decrease size
        size--;
        return 0;
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

        if(index >= size){
            throw new IndexOutOfBoundsException();
        }
        else{
            return buffer[index];
        }
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        if(size == 0 || buffer.length == 0){
            return false;
        }
        for (int i = 0; i < size; i++){
            if(buffer[i] == value){
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
        if(size == 0 || buffer.length == 0){
            return -1;
        }
        for(int i = 0; i < size; i++){
            if(buffer[i] == value){
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

        return size() == 0;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size() {
        //not sure if we are supposed to check if there are actually values,
        // but since we don't know if 0 is supposed to be a value in the Array
        // we would have to rely on size to tell us.

        return size;

    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        //this is one way.
//        for (int i = 0; i < size; i++) {
//            buffer[i] = 0;
//        }

        //create a new buffer, other one just disappears
        buffer = new int[10];

        size = 0;

    }

    private void resize(int newSize){

        //create a new space, separate from old space (buffer)
        int[] newBuffer = new int[newSize];

        //copy everything over from buffer into newBuffer
        for (int i = 0; i < size; i++) {
            newBuffer[i] = buffer[i];
        }

        //override old buffer with new buffer
        buffer = newBuffer;

        //the old space is no longer "pointed to" and will eventually be cleaned up by the garbage collector.
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        IntListIterator theInterator = new IntListIterator();
        return theInterator;
    }

    //create a private helper Iterator class
    private class IntListIterator implements Iterator<Integer>{
        private int i;

        public IntListIterator(){i = 0;}

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
            if (i > size){
                throw new NoSuchElementException("i is now out of bounds.");
            }
            int currentValue = buffer[i];
            i++;
            return currentValue;
        }
    }

    //iterators are what enables main/client to use a for-each loop on my IntList
}
