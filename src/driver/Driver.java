package driver;

import  Lists.DoublyLinkedIntList;



public class Driver {

    public static void main(String[] args) {
        DoublyLinkedIntList firstList = new DoublyLinkedIntList();
        firstList.addBack(1);
        firstList.addBack(2);
        firstList.addBack(3);

        firstList.printList();

    }
}
