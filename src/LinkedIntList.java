import java.util.Iterator;

public class LinkedIntList implements IntList{

    // define  what a node is
    private class Node {
        int data;
        Node next;
        @Override
        public String toString() {
            return "" + data +
                    ", " + next;
        }
    }

    // set up the head
    private Node head;

    // set up the size field
    private int size;

    // add a constructor to initialize the fields
    public LinkedIntList(){
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
        //set up new node
        Node theNewOne = new Node();
        theNewOne.data = value;

        if (head == null){
            //this list is currently empty
            head = theNewOne;
            size++;
        }
        else{
            //this list currently has some nodes in it
            theNewOne.next = head;
            //everything from the right gets saved to the left
            head = theNewOne;
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
    Node theNewOne = new Node();
    theNewOne.data = value;
        if(size == 0)
        {
            head = theNewOne;
            size++;
        }
        else
        {
            // keeps track of where you are in the list
          Node temp = head;
          // if temp. next is not null
          while (temp.next != null)
          {
              // then iterate through the list
              temp = temp.next;
          }
          // if temp.next is null then theNewOne is temp.next
          temp.next = theNewOne;
          size++;
        }
    }
    @Override
    public String toString() {
        return "[" +
                "" + head +
                ", size=" + size +
                ']';
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
        Node theNewOne = new Node();
        theNewOne.data = value;
        if(index > size || index < 0){throw new  IndexOutOfBoundsException();
        } else {

            if(size == 0){
                head = theNewOne;
            }else {
                Node prev = null;
                Node temp = head;
                for (int i = 0; i < index; i++) {
                    prev = temp;
                    temp = temp.next;
                }
                theNewOne.next = temp;
                if (prev == null) {
                    head = theNewOne;
                } else {
                    prev.next = theNewOne;
                }
            }
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
        if (head == null){
            //this list is currently empty
            System.out.println("this list is empty");
        }
        else{
            //this list currently has some nodes in it
            head = head.next;
            //everything from the right gets saved to the left
            size--;

        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if (head == null){
            //this list is currently empty
            System.out.println("this list is empty");
        }
        else
        {
            // keeps track of where you are in the list
            Node temp = head;
            // if temp. next .next is not null
            while (temp.next.next != null)
            {
                // then iterate through the list
                temp = temp.next;
            }
            // if temp.next is null then theNewOne is temp.next
            temp.next = null;
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
        if(index >= size || index < 0){throw new  IndexOutOfBoundsException();}
        Node prev = null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            prev = temp;
            temp = temp.next;
        }
        if (prev == null) {
            head = temp.next;
        } else {
            prev.next = temp.next;
        }
        size--;
        return temp.data;
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
        Node temp;
        int result = 0;
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            temp = head;
            for (int i = 0; i < size; i++) {
                // then iterate through the list
                if (i == index) {
                    result = temp.data;
                } else{
                    temp = temp.next;
                }


            }
        }
        return result;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        Node temp = head;
        // if temp. next is not null
        while (temp != null)
        {
            // then iterate through the list
            if(temp.data == value){
                return true;
            }else {
                temp = temp.next;
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
        if(value == 0){
            return head.data;
        }
        Node temp = head;
        int i;
        for (i = 0; i < size; i++) {
            if (temp.data == value) {
                return i;
            } else {
                temp = temp.next;
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
        while (head != null){
            head = head.next;
        }
        head = null;
        size = 0;
    }
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
       SinglyLinkedIterator theIterator = new SinglyLinkedIterator();
        return theIterator;
    }

    private class SinglyLinkedIterator implements Iterator<Integer>{

    // private int i;   // index of the item I am on in the arraylist
        private Node current;

        public SinglyLinkedIterator(){
            current = head;
        }

        @Override
        public boolean hasNext() {
          return current != null;
        }

        @Override
        public Integer next() {
            int item = current.data;
            current = current.next;
            return item;
        }
    }
}
