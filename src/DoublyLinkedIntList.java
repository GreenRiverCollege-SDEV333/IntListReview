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
Node firstNode=pre.next;

Node newNode = new Node();
newNode.data=value;
newNode.next =firstNode;
newNode.prev=pre;

pre.next=newNode;
firstNode.prev=newNode;
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
if (index<0||index>size){
    throw new IndexOutOfBoundsException("index out of range");
}
Node current = pre;
        for(int i =0; i<index;i++){
            current=current.next;
        }
Node theNewNode = new Node();
theNewNode.data=value;
        theNewNode.next=current.next;
        theNewNode.prev=current;
//update
        current.next.prev=theNewNode;
        current.next=theNewNode;
        size++;
    }

    @Override
    public void removeFront() {
        if (size == 0) {
            return;//empty
        }
        //skip first node
        pre.next=pre.next.next;
        pre.next.prev=pre;


        size--;
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out range");
        }
        Node current = pre;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        int removedValue = current.next.data;
        current.next = current.next.next;
        current.next.prev = current;
        size--;
        return removedValue;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of range");
        }
        Node current = pre.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    @Override
    public boolean contains(int value) {
        Node current = pre.next;
        while (current!=post){
            if(current.data==value){
                return true;
            }
            current=current.next;
        }
        return false;
    }

    @Override
    public int indexOf(int value) {
        Node current = pre.next;
        int index=0;
        while (current!=post){
            if (current.data==value){
                return index;
            }
            current=current.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
pre.next=null;
post.prev=null;
pre=null;
post=null;
size=0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}