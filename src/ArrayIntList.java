import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntList implements IntList {

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
        if (size == 0) {
            buffer[0] = value;
            size++;
        } else {
            doubleSize();
            for (int i = size; i >= 1; i--) {
                buffer[i] = buffer[i-1];
            }
            buffer[0]=value;
            size++;
        }
    }


    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        doubleSize();
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
        doubleSize();
        if (index < 0 || index > size || size==0) {
            throw new IndexOutOfBoundsException("Index ouf of bounds. NOPE!");
        } else {
            for (int i = size; i > index; i--) {
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
        if (size <= 0) {
            throw new NoSuchElementException("Cannot remove element from empty array");
        } else {
            for (int i = 0; i < size; i++) {
                buffer[i] = buffer[i + 1];
            }
        }
        buffer[size] = 0;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (size <= 0) {
            throw new NoSuchElementException("Cannot remove element from empty array");
        } else {
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
        int value = 0;
        if (index < size - 1 && index >= 0) {
            value = buffer[index];
            for (int i = index; i < size; i++) {
                buffer[i] = buffer[i + 1];
            }
            buffer[size] = 0;
            size--;
        } else if (index == size - 1) {
            value = buffer[index];
            buffer[index] = 0;
            size--;
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be less than 0.");
        } else if (index > size) {
            throw new IndexOutOfBoundsException("Index cannot be greater than array length");
        }
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
        if (index >= 0 && index < size) {
            return buffer[index];
        } else {
            throw new IndexOutOfBoundsException("Index cannot be outside the size of the array.");
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
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (buffer[i] == value) {
                index = i;
                return index;
            }
        }
        return index;
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
        int length = buffer.length;
        int[] buffer = new int[length];
        size = 0;
    }

    /**
     * Helper method that doubles the array size using the resize method.
     */
    private void doubleSize() {
        if (size - 1 == buffer.length) {
            resize(buffer.length * 2);
        }
    }

    /**
     * Grows and Shrinks the array as required by data size.
     */
    private void resize(int newSize) {
        int[] newBuffer = new int[newSize];
        System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
        buffer = newBuffer;
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (size > 0) {
            for (int i = 0; i < size-1; i++){
                sb.append(buffer[i]);
                sb.append(',');
                sb.append(' ');
            }
            sb.append(buffer[size-1]);
            sb.append(']');
        } else {
            return "null";
        }
        return sb.toString();
    }

private class IntListIterator implements Iterator<Integer> {
    private int i;

    private IntListIterator() {
        this.i = 0;
    }

    public boolean hasNext() {
        return i < size;
    }

    public Integer next() {
        int currentValue = buffer[i];
        i++;
        return currentValue;
    }
}
}
