import java.util.Iterator;

public class LinkedIntList implements IntList {
    private class Node{
        int data;
        Node next;
    }
    private Node head;
    private int size;

    //add constructor
    public LinkedIntList(){
        head=null;
        size=0;
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
Node theNewOne = new Node ();
if(head == null){
    head= theNewOne;
    size++;
}
else{
    //has some nodes
    theNewOne.next=head;
    head=theNewOne;
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
        if (head == null) {
            head = theNewOne;

        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = theNewOne;
        }
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
if(index<0||index>size){
    throw new IndexOutOfBoundsException("index out of bouncy");
}
Node theNewOne =new Node();
        theNewOne.data=value;

if(index==0){
    //add at beginning of list
    theNewOne.next=head;
    head=theNewOne;
}else{
    Node current = head;
    for(int i =0; i<index-1; i++){
        current=current.next;
    }
    //new node after index-1
    theNewOne.next=current.next;
    current.next=theNewOne;
}size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
if(head!=null){
    head = head.next;
    size--;
}
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {

if(head==null){
    //list is empty
    return;

}
else if(head.next== null){
    //list has only one node
    head = null;

}
else {
    Node current = head;
    while (current.next.next!= null){
        current=current.next;
    }
    //remove last node and
    current.next=null;
}
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
    //remove value at front if list
    @Override
    public int remove(int index) {
        if(index<0||index>= size||head==null){
            throw new IndexOutOfBoundsException("index out of range");
        }
        int removedValue;
        if(index==0){
            removedValue=head.data;
            head= head.next;//update to skip first node

        }
        else{
            Node current = head;
            for(int i = 0; i<index-1; i++){
                current=current.next;
            }
            removedValue=current.next.data;// get node data
            current.next= current.next.next;
        }
        size--;
        return removedValue;//return removed value
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    //get value at specified index
    @Override
    public int get(int index) {
        if(index<0||index>= size||head==null){
            throw new IndexOutOfBoundsException("index of of range");
        }
        Node current = head;
        for(int i = 0; i<index; i++){
            current=current.next;//
        }
        return current.data;// return data
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        Node current = head;
        while (current!=null){
            if(current.data==value){
                return true; //value found
            }
            current=current.next; //move to next
        }
        return false;//value not found
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
        Node current = head;
        int index = 0;
        while (current!=null){
            if(current.data==value){
                return index;// return if calue found
            }
            current=current.next;
            index++;//move to next node
        }
        return -1; //value not found
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    //check if i]list is empty
    @Override
    public boolean isEmpty() {
      return size==0;
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    //get list size
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    //remove all values
    @Override
    public void clear() {
head=null;
size=0;
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
