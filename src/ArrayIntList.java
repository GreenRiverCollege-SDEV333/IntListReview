import java.util.Arrays;
import java.util.Iterator;

public class ArrayIntList implements IntList{

    //size and length are different
    // size: amount of elements in array has to have a value
    // length: amount of spots in array does not have to have a value
   private int size;
   private int[] buffer;

   public ArrayIntList(){
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
        // loops do same thing just different ways to do it
//       // going from back of array to not erase data.
//     for (int i = size; i >= 1; i--) {
//
//         buffer[i] = buffer[i - 1];
//       }

        if(size == buffer.length){
            resize(size + 2);
        }

        for (int i = size - 1; i >= 0; i--) {
            buffer[i+1] = buffer[i];

        }

//         buffer[4] = buffer[3];
//         buffer[3] = buffer[2];
//         buffer[2] = buffer[1];
//         buffer[1] = buffer[0];

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
        if(size == buffer.length){
            resize(size + 2);
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
        if(size == buffer.length){
            resize(size + 2);
        }
        for (int i = size; i >= 0; i--) {
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
        // starts from back of array then replace the index +1
       // basically shift everything one opposite of addfront

        for (int i = 0; i < size - 1; i++) {
            buffer[i] = buffer[i + 1];
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
     // reduce size or zero it out
        buffer[size - 1] = 0;
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
        if(index < 0){
            throw new IndexOutOfBoundsException("Index can not be negative");
        }
        if(index >= size){
            throw new IndexOutOfBoundsException("Index is higher than size");
        }

        // save copy of the value to be removed so we can return it later
        int removedValue = buffer[index];

        // shift values to the left
        for(int i = index; i <= size-1; i++){
            buffer[i] = buffer[1 + i]; // buffer[3] = buffer[4] 3 becomes 4, buffer[4] = buffer[5]  4 becomes 5
        }

        buffer[size - 1] = 0;
        //size decrement
        size--;

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
        for (int i = 0; i < size; i++) {
            if(contains(value)){
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
       if(size == 0){
           return true;
       }

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
      // while size is not 0 remove the items at index
//        while(size != 0){
//          remove(0);
//      }
        // iterating over array and setting values to zero
        for (int i = 0; i < size; i++) {
            buffer[i] = 0;
        }
        size = 0;
//        creating new array
//        buffer = new int[10];
//        size = 0;
    }

    private void resize(int newSize){
       // create a new space separate from the old buffer
        int[] temp = new int[newSize];

        // copy everything over from the buffer into new buffer
        for (int i = 0; i < buffer.length; i++) {
            temp[i] = buffer[i];

        }
        // reassign temp data back to buffer with bigger array
        buffer = temp;
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
    private static class IntListIterator implements Iterable<Integer>{
//    private int 1;

    private IntListIterator(){
        ;
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

    //iterate are what enables main/client to use for each loop
    // on my intlist


    @Override
    public String toString() {
        return "ArrayIntList{" + " " +
                 Arrays.toString(buffer) +
                '}';
    }
}
