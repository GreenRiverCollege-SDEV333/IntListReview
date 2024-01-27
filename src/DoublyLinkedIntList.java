import java.util.Iterator;

public class DoublyLinkedIntList implements IntList {
    // private fields

    private class Node {
        int data;
        Node next;      // address of the node "after" this one in line
        Node prev;      // address of the node "before" this one in line

        public Node() {
            next = null;
            prev = null;
        }
    }

    private Node pre;
    private Node post;
    private int size;

    // constructor
    public DoublyLinkedIntList() {
        // an empty list has 2 sentinel (dummy) nodes that serve as bookends
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
        size = 0;
    }


    @Override
    public void addFront(int value) {
        Node newNode = new Node();
        newNode.data = value;

        newNode.next = pre.next;
        newNode.prev = pre;

        pre.next.prev = newNode;
        pre.next = newNode;

        size++;
    }

    @Override
    public void addBack(int value) {
        Node theLastOne = post.prev;

        // set up my new node and fill it out (data, prev, next)
        Node theNewOne = new Node();
        theNewOne.data = value;
        theNewOne.next = post;
        theNewOne.prev = theLastOne;

        // go to the end of the list's sentinel, and update it's prev
        post.prev = theNewOne;

        // go to the node before the new one, and update it's next
        theLastOne.next = theNewOne;

        size++;

    }

    @Override
    public void add(int index, int value) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index is out of bound");
        }else if (index == 0){
            addFront(value);
        }else if (index == size){
            addBack(value);
        }
        //Create a new node
        Node  node = new Node();
        // store value into new node
        node.data = value;

        //move node to the desire index
        Node current;
        if (index < size / 2) {
            current = pre.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = post.prev;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        // 10 20 30
        //new node head =  value (5)
        //insertion at index 1

        node.next = current;        //new node 5 20
        node.prev = current.prev; //
        current.prev.next = node;
        current.prev = node;

        size++;

    }

    @Override
    public void removeFront() {
        if (size > 0 ){
            Node current = pre.next;
            pre.next = current.next;
            current.next.prev = pre;
            size--;
        }
    }

    @Override
    public void removeBack() {
        if (size > 0) {
            // set up a temp variable for convenience
            Node theOneToRemove = post.prev;

            theOneToRemove.prev.next = post;
            post.prev = theOneToRemove.prev;

            // optional, but strongly recommended to clean up
            theOneToRemove.next = null;
            theOneToRemove.prev = null;
            theOneToRemove.data = 0;

            size--;
        }
    }

    @Override
    public int remove(int index) {
        return 0;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        Node current;
        // we want to determine whether the index is closer to end or the beginning of the list
        if (index < size / 2) {// if the is less than 1/2 of the size, the index is closer to the begining of the list
            current = pre.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {//if the index larger than 1/2 of the size than it start at the end of the list
            current = post.prev;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.data;
    }

    @Override
    public boolean contains(int value) {
        Node current = pre.next;

        for (int i = 0; i < size; i++) {// the for loop will check the list from the beginning
            if (current.data == value){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(int value) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}