import java.util.Iterator;

public class ArrayIntList implements IntList{


    //  fields
    private int size;
    private int[] buffer;
    public ArrayIntList (){
        //initialize my field
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
        //check if the buffer is full
        if (size == buffer.length) {
            resize(size * 2);
        }
        //crete space for the new value
        size++;

        //Shift all the number after index 0 to the right
        for (int i = size; i > 0 ; i-- ){
            buffer[i] = buffer[i - 1];
        }
        //set the value in the front
        buffer[0] = value;

        /*In class
        for (int i = size; i >= 1; i--)
        {
            buffer[i] = buffer[i - 1];
        }
            buffer[4] = buffer[3];
            buffer[3] = buffer[2];
            buffer[2] = buffer[1];
            buffer[1] = buffer[0];
            buffer[0] = value;
            size++;*/
    }
    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        // TODO: check to see if we are full - if so, we need to create a larger buffer
        //This if statement will check whether the buffer is full
        // if the buffer is full the size is double to make room
        if(size == buffer.length){
            resize(size * 2);
        }
        buffer [size] = value;
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
            throw new IndexOutOfBoundsException("Index out of range");
        }
        //resize if the index is bigger than the size
        if (size == buffer.length) {
            resize(size * 2);
        }


        //This for loop will shift the number at and after index to the right
        for (int i = size; i > index; i--) {
            buffer[i] =buffer[i - 1];
        }
        //add the new value to the desire index
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

        //remove the front value and shift the rest of the code to the left
        // shift to the left which replace index 0 with index 1
        for (int i = 0; i < size - 1; i++){
            buffer[i] = buffer[i+1];
        }
        buffer[size - 1] = 0;
        size--;
}


    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        //set the end of the buffer to 0
        if(size > 0)
       {
        //reduce size of buffer
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

    if (index < 0) {
        throw new IndexOutOfBoundsException("Index can not be negative");
    }
    else if (index >= size){
        throw new IndexOutOfBoundsException("Index is higher than size");
    }

    //save a copy of the value to be removed, so we can return it later
    int copyOfRemovalValue = buffer[index];

    // shift values to the left
        for (int i = index; i <= size - 1 ; i++) {
            buffer[i] =buffer[i+1];
        }

        //decrement size
        size--;

        return copyOfRemovalValue;
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
        //check if the index is out of range
        if (index < 0 || index >= size) {//promo out of bound when index is less than 0 or more than size
            throw new IndexOutOfBoundsException("Index out of range");
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
        return size == 0 ;
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

    private void resize(int newSize){
        //Create new space, separate from
        int[] newBuffer = new int[newSize];

        //copy everything from buffer to new buffer
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }
        //set the new space into buffer
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
        return null;
    }
}
