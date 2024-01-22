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

    }

    @Override
    public void removeFront() {

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
        return 0;
    }

    @Override
    public boolean contains(int value) {
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
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
