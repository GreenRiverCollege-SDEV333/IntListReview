import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList implements IntList {

    private class Node {
        int data;
        Node next;
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
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
        Node newNode = new Node();
        newNode.data = value;
        if (head == null) {
            head = newNode;
            this.size++;
        } else {
            newNode.next = head;
            head = newNode;
            this.size++;
        }
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        Node current = head;
        Node newNode = new Node();
        newNode.data = value;

        if (current == null) {
            addFront(value);
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
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
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node newNode = new Node();
        newNode.data = value;
        if(index == 0) {
            this.addFront(value);
        } else if (index == size) {
            this.addBack(value);
        }else {
            Node current = head.next;
            Node previous = head;
            int currentIndex = 1;
            while(current != null) {
                if(currentIndex == index){
                    newNode.next = current;
                    previous.next = newNode;
                    size++;
                }
                previous = current;
                current = current.next;
                currentIndex++;
            }
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if (head != null) {
            head = head.next;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        Node current = head;
        if (head == null) {
            return;
        } else if (current.next == null) {
            head = null;
            size--;
            return;
        }
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
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
        int value = 0;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else if (head == null) {
            throw new NoSuchElementException("Empty List");
        } else if (index == 0) {
            value = head.data;
            head.data = 0;
            head = head.next;
            size--;
            return value;
        }

        Node current = head.next;
        Node previous = head;
        int currentIndex = 1;
        while (current != null) {
            if (currentIndex == index) {
                value = current.data;
                current.data = 0;
                previous.next = current.next;
                size--;
                return value;
            }
            previous = current;
            current = current.next;
            currentIndex++;
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
        if (head == null) {
            throw new NoSuchElementException("The list is empty");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        int value = -1;
        int currentIndex = 0;
        Node current = head;
        while (current != null) {
            if (currentIndex == index) {
                return current.data;
            }
            current = current.next;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException("Index beyond size of list");
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        if (head == null) {
            return false;
        }
        Node current = head;
        while (current.next != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
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
        if (head == null) {
            return -1;
        }
        Node current = head;
        int currentIndex = 0;
        while (current != null) {
            if (current.data == value) {
                return currentIndex;
            }
            current = current.next;
            currentIndex++;
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
        Node current = head;
        //Manually sets all data stores to a value of 0 to ensure no remnants prior to GC are cleanup available.
        while (current != null) {
            current.data = 0;
            current = current.next;
        }
        head = null;
        size = 0;
    }

    /**
     * Pretty Print of the Linked List
     *
     * @return the formatted string to print
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;

        //if the list is empty return just an empty list indicator
        if (current == null) {
            return "[]";
        }
        // Builds the standard array print out format for Java to make pretty prints
        sb.append('[');
        while (current.next != null) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        sb.append(current.data);
        sb.append(']');
        return sb.toString();
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
