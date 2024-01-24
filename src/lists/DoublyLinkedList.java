package lists;

import java.util.Iterator;

public class DoublyLinkedList implements IntList
{

    // define node
    private class Node{
        int data;
        Node next;
        Node last;

        Node(int data){
            this.data = data;
            this.next = null;
            this.last = null;
        }
    }
    // set up head field
    private Node head;
    //set up size field
    private int size;

    // constructor method
    public DoublyLinkedList(){
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
    public void addFront(int value)
    {
        size++;
        DoublyLinkedList.Node newNode = new DoublyLinkedList.Node(value);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value)
    {
        DoublyLinkedList.Node newNode = new DoublyLinkedList.Node(value);

        DoublyLinkedList.Node currentNode = head;

        if(head == null){
            head = new Node(value);
            size++;
            return;
        }

        while(currentNode.next != null){
            currentNode = currentNode.next;
        }

        newNode.last = currentNode;
        currentNode.next = newNode;
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
    public void add(int index, int value)
    {
        if (index < size) {
            throw new IndexOutOfBoundsException();
        }

        DoublyLinkedList.Node newNode = new DoublyLinkedList.Node(value);

        DoublyLinkedList.Node currentNode = head;

        if (index == 0)
        {
            addFront(value);
            size++;
            return;
        }

        if(index > size){
            addBack(value);
            size++;
            return;
        }

            int nodeCount = 0;

            while(currentNode.next != null){
                if(nodeCount == index){
                    Node tempNode = currentNode.next.next;
                    currentNode.next = newNode;
                    newNode.last = currentNode;
                    newNode.next = tempNode;
                }
                currentNode = currentNode.next;

                nodeCount++;
            }
        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()
    {
        if(head == null){
            return;
        }

        head = head.next;
        size--;
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        if(head == null){
            return;
        }

        DoublyLinkedList.Node currentNode = head;

        while (currentNode.next.next != null)
        {
            currentNode = currentNode.next;
        }

        currentNode.next = null;
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
    public int remove(int index)
    {
        int removedValue = -99;

        DoublyLinkedList.Node currentNode = head;

        if(head == null){
            return removedValue;
        }

        if(index == 0){
            removedValue = head.data;
            removeFront();
            return removedValue;
        }

        int nodeCount = 1;

        while(currentNode.next != null){
            if(index == nodeCount){
                removedValue = currentNode.next.data;
                currentNode.next= currentNode.next.next;
            }else{
                currentNode = currentNode.next;
            }
            nodeCount++;
        }
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
    public int get(int index)
    {
        if(head == null){
            return -99;
        }

        DoublyLinkedList.Node current = head;
        for (int i = 0; i < index && current != null; i++)
        {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value)
    {
        if(head == null){
            return false;
        }

        DoublyLinkedList.Node currentNode = head;

        do{
            if(currentNode.data == value){
                return true;
            }else{
                currentNode = currentNode.next;
            }
        }while(currentNode.next != null);

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
    public int indexOf(int value)
    {
        if(head == null){
            return -99;
        }

        DoublyLinkedList.Node currentNode = head;

        int nodeCount = 0;

        do{
            if(currentNode.data == value){
                return nodeCount;
            }else{
                currentNode = currentNode.next;
            }
            nodeCount++;
        }while(currentNode.next != null);

        return -1;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty()
    {
        if(size == 0)
        {
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
    public int size()
    {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear()
    {
        size = 0;
        head = null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        Iterator<Integer> iterator = new Iterator()
        {
            private Node currentNode = head;

            @Override
            public boolean hasNext()
            {
                return currentNode != null;
            }

            @Override
            public Integer next()
            {
                int data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
        return iterator;
    }

    @Override
    public String toString()
    {
        String content;

        if(head == null){
            content = "[ ]";
            return content;
        }

        content = "[ ";

        DoublyLinkedList.Node currentNode = head;

        //Traverse to last node

        while(currentNode.next != null){
            content = content + currentNode.data +", ";
            currentNode = currentNode.next;
        }

        content = content + currentNode.data +" ]";

        return content;
    }
}
