package driver;

import  lists.DoublyLinkedIntList;


/**
 * @author tobygoetz
 * @version 1.0
 */
public class Driver {

    /**
     * Program to test DoublyLinkedIntList
     * @param args command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedIntList firstList = new DoublyLinkedIntList();
        firstList.addBack(1);
        firstList.addBack(2);
        firstList.addBack(3);

        firstList.printList();

        firstList.addFront(4);
        firstList.printList();
        firstList.addFront(5);
        firstList.printList();

        firstList.add(5, 100);
        firstList.printList();

        firstList.removeFront();
        firstList.printList();

        firstList.removeFront();
        firstList.printList();

        firstList.removeBack();
        firstList.printList();

        DoublyLinkedIntList emptyList = new DoublyLinkedIntList();

        emptyList.printList();
        emptyList.removeBack();
        emptyList.removeFront();

        firstList.printList();
        firstList.addBack(4);
        firstList.addBack(5);
        firstList.addBack(6);
        firstList.addBack(7);
        firstList.addBack(8);
        firstList.addBack(9);
        firstList.addFront(0);
        firstList.printList();


        int removedValue = firstList.remove(2);
        firstList.printList();
        System.out.println(removedValue);
        
    }
}
