package driver;

import  Lists.DoublyLinkedIntList;



public class Driver {

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



    }
}
