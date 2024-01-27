import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList {

    //fields
    private int size;
    private int[] buffer;

    //constructor
    public ArrayIntList ()
    {
        size = 0;
        buffer = new int[10];
    }

//Testing git commit and push

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        fullSize();
        //if the array is empty
        if (size != 0) {
            //move all the values over to one index.
            for (int i = size; i >= 1; i--) {
                buffer[i] = buffer[i - 1];
            }
            // put the value at the front of the array of position 0 ;
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
        //TODO: Check to see if we are full - if so, we need to create a larger buffer.
        fullSize();

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

        fullSize(); // this will check if the array is full, if it is, it will resize into a bigger array
        // let say we want to add 22 to index 3
        if(size == 0 )
        {
            index = 0;
            buffer[index] = value;
            size++;

        } else if(index > size || index < 0 )
        {
            throw new IndexOutOfBoundsException(" The index is out of bound bruh...");

        }
        else if(index == 0 )
        {
            for (int i = size; i >= 1 ; i--) {
                buffer[i] = buffer[i-1];
            }
            buffer[0] = value;
            size++;
        }
        else {

            for (int i = size; i >= index; i--) {
                buffer[i] = buffer[i - 1];
            }
            buffer[index] = value;
            size++;
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        // get the index of front which will be buffer[0]
        if(size == 0 )
        {
            throw new NoSuchElementException(" The array is empty... ");
        }
        for (int i = 0; i < size; i++) {
            buffer[i] = buffer[i+1];
        }
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        //set the back value as 0
        if(size == 0)
        {
            throw new NoSuchElementException("The array is empty... ");
        }
        buffer[size] = 0;
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
        if(index >= size)
        {
            throw new IndexOutOfBoundsException("invalid index");
        }else if( index < 0)
        {
            throw new IndexOutOfBoundsException("index cannot be negative");
        } else if (size == 0 ) {
            throw new NoSuchElementException("The list is empty ");
        }

        // save a copy of value .
        int copyOfRemovedValue = buffer[index];

        //shift value to left
        for (int i = index; i < size ; i++) {
            buffer[i] = buffer[i+1];
        }
        buffer[size - 1] = 0 ;

        //decrement size
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
        if(index > size)
        {
            throw new IndexOutOfBoundsException("The index is more than the size. ");
        }else if(index < 0 )
        {
            throw new IndexOutOfBoundsException("Index is less than 0, it can not be less than 0");
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
        //it will use loop to search for the value
        if(size == 0 )
        {
            throw new NoSuchElementException(" The list is empty. ");
        }else {

            for (int i = 0; i < size; i++) {
                if (buffer[i] == value) {
                    return true;
                }
            }
            return false;
        }
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

        if(size == 0 )
        {
            throw new RuntimeException("The list is empty. ");
        }
        else {
            for (int i = 0; i < size; i++) {
                if (buffer[i] == value) {
                    return i;
                }

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
        if(size == 0 )
        {
            return true;
        }
        else {
            return false;
        }
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
        buffer = new int [10];
        size = 0 ;


    }


    /**
     * this will make the size of the array to a certain size.
     * @param newSize
     */
    private void resize (int newSize)
    {

        //create a temporary new array with the new size.
        int [] tempBuffer = new int[newSize];

        //copy everything over from buffer into newbuffer.
        for (int i = 0; i < buffer.length; i++) {
            tempBuffer[i] = buffer[i];
        }

        // set the new temp array as the main array .
        buffer  = tempBuffer;
    }

    /**
     * this method will check if the size is equal to the buffer.length,
     * if it is equal to buffer length, it will double the size.
     */
    private void fullSize(){
        if(size >= buffer.length)
        {
            resize(size * 2 );
        }
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

    //create a private helper itorator class.
    private class IntListIterator implements Iterator<Integer>
    {
        //private fields

        private int i ;
        //constructor.
        private IntListIterator ()
        {
            i = 0 ;
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
                throw new NoSuchElementException("i is now out of bounds");
            }
            int currentValue  = buffer[i];
            i++;
            return currentValue;
        }
    }

    //iterator are what enables main/client to use for each loop.

}
