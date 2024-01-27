package driver;

import lists.ArrayIntList;
import  lists.DoublyLinkedIntList;
import lists.LinkedIntList;


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
//        DoublyLinkedIntList firstList = new DoublyLinkedIntList();
//        firstList.addBack(1);
//        firstList.addBack(2);
//        firstList.addBack(3);
//
//        firstList.printList();
//
//        firstList.addFront(4);
//        firstList.printList();
//        firstList.addFront(5);
//        firstList.printList();
//
//        firstList.add(5, 100);
//        firstList.printList();
//
//        firstList.removeFront();
//        firstList.printList();
//
//        firstList.removeFront();
//        firstList.printList();
//
//        firstList.removeBack();
//        firstList.printList();
//
//        DoublyLinkedIntList emptyList = new DoublyLinkedIntList();
//
//        emptyList.printList();
//        emptyList.removeBack();
//        emptyList.removeFront();
//
//        firstList.printList();
//        firstList.addBack(4);
//        firstList.addBack(5);
//        firstList.addBack(6);
//        firstList.addBack(7);
//        firstList.addBack(8);
//        firstList.addBack(9);
//        firstList.addFront(0);
//        firstList.printList();
//
//
//        int removedValue = firstList.remove(2);
//        firstList.printList();
//        System.out.println(removedValue);
//
//        firstList.printList();
//        int valueAtIndex = firstList.get(8);
//        System.out.println(valueAtIndex);
//
//        firstList.printList();
//        System.out.println(firstList.contains(10));
//
//        firstList.printList();
//        System.out.println(firstList.indexOf( 6));
//
//        System.out.println(firstList.isEmpty());
//        System.out.println(emptyList.isEmpty());
//
//        System.out.println(firstList.size());
//        System.out.println(emptyList.size());
//
//        System.out.println(firstList.isEmpty());
//
//        firstList.clear();
//        firstList.printList();
//        System.out.println(firstList.isEmpty());
//
//        ArrayIntList arrOne = new ArrayIntList();
//
//        System.out.println(arrOne);
//
//        arrOne.addFront(3);
//        arrOne.addFront(2);
//        arrOne.addFront(1);
//        arrOne.addFront(0);
//
//        arrOne.addBack(4);
//        arrOne.addBack(5);
//        arrOne.addBack(6);
//        arrOne.addBack(7);
//        arrOne.addBack(8);
//        arrOne.addBack(9);
//        arrOne.addBack(10);
//
//        arrOne.add(5, 100);
//        arrOne.add(0, 100);
//        arrOne.add(13, 100);
//        arrOne.add(0, 100);
//
//
//        System.out.println(arrOne);
//        System.out.println();
//
//
//
//        arrOne.removeFront();
//        System.out.println(arrOne);
//        arrOne.removeFront();
//        System.out.println(arrOne);
//        arrOne.removeFront();
//        System.out.println(arrOne);
//        arrOne.removeFront();
//        System.out.println(arrOne);
//        arrOne.removeFront();
//        System.out.println(arrOne);
//        arrOne.removeFront();
//        System.out.println(arrOne);
//        arrOne.removeFront();
//        System.out.println(arrOne);
//        arrOne.removeFront();
//        System.out.println(arrOne);
//
//        arrOne.removeBack();
//        System.out.println();
//        System.out.println(arrOne);
//
//        // remove back does not stop because isEmpty is not complete
//
//        int removed = arrOne.remove(0);
//        System.out.println(arrOne);
//        System.out.println(removed);
//
//        System.out.println();
//        System.out.println(arrOne);
//        valueAtIndex = arrOne.get(0);
//        System.out.println(valueAtIndex);
//
//        System.out.println(arrOne.indexOf(11));
//
//        System.out.println(arrOne.isEmpty());
//        ArrayIntList emptyArr = new ArrayIntList();
//        System.out.println(emptyArr.isEmpty());
//
//        System.out.println();
//        System.out.println(arrOne);
//        arrOne.removeBack();
//        System.out.println(arrOne);
//        arrOne.removeBack();
//        System.out.println(arrOne);
//        arrOne.removeBack();
//        System.out.println(arrOne);
//        arrOne.removeBack();
//        System.out.println(arrOne);
//        arrOne.removeBack();
//        System.out.println(arrOne);
//        arrOne.removeBack();
//        System.out.println(arrOne);
//        arrOne.removeBack();
//        System.out.println(arrOne);
//
//
//        int removed2 = arrOne.remove(2);
//        System.out.println(arrOne);
//        System.out.println(removed2);
//
//        int removed3 = arrOne.remove(2);
//        System.out.println(arrOne);
//        System.out.println(removed3);
//
//        int removed4 = arrOne.remove(2);
//        System.out.println(arrOne);
//        System.out.println(removed4);
//
//        int removed5 = arrOne.remove(2);
//        System.out.println(arrOne);
//        System.out.println(removed5);
//
//        System.out.println();
//        LinkedIntList linkedIntList = new LinkedIntList();
//
////        System.out.println(linkedIntList);
//
//        linkedIntList.addFront(1);
//        System.out.println(linkedIntList);
//        linkedIntList.addFront(2);
//        System.out.println(linkedIntList);
////
//        linkedIntList.addBack(2);
//        System.out.println(linkedIntList);
//
//        linkedIntList.addBack(3);
//        System.out.println(linkedIntList);
//
//        linkedIntList.removeFront();
//        System.out.println(linkedIntList);
//        linkedIntList.removeFront();
//        System.out.println(linkedIntList);
//        linkedIntList.removeFront();
//        System.out.println(linkedIntList);
//        //iterate to make sure last node is eliminated
//        linkedIntList.removeFront();
//        System.out.println(linkedIntList);
//        //iterate to make sure last node is eliminated
//        linkedIntList.removeFront();
//        System.out.println(linkedIntList);
//
//        LinkedIntList list = new LinkedIntList();
//        linkedIntList.addFront(3);
//        linkedIntList.addFront(2);
//        linkedIntList.addFront(1);
//        System.out.println(linkedIntList);
//
//        System.out.println(linkedIntList.get(2));
//
//
//        System.out.println();
//        System.out.println(linkedIntList);
//        System.out.println(linkedIntList.remove(1));
//
//        System.out.println(linkedIntList);
//        linkedIntList.add(1,4);
//        System.out.println(linkedIntList);
//
//
//        System.out.println(linkedIntList.contains(0));
//        System.out.println(linkedIntList.isEmpty());
//        System.out.println(linkedIntList);
//        System.out.println(linkedIntList.indexOf(0));
//        System.out.println(linkedIntList.size());
//        linkedIntList.clear();
//        System.out.println(linkedIntList);
//        System.out.println(linkedIntList.size());
//
//        System.out.println(linkedIntList);
//
//
//
//        System.out.println(linkedIntList);
//        linkedIntList.removeBack();
//        System.out.println(linkedIntList);
//        linkedIntList.removeBack();
//        System.out.println(linkedIntList);
//        linkedIntList.removeBack();
//        System.out.println(linkedIntList);
//        linkedIntList.removeBack();
//        System.out.println(linkedIntList);
//        linkedIntList.removeBack();
//        System.out.println(linkedIntList);
//
//        ArrayIntList array = new ArrayIntList();
//        array.addFront(3);
//        array.addFront(2);
//        array.addFront(1);
//        System.out.println(array);
//
//        System.out.println(array.get(0));
//        array.addFront(0);
//        System.out.println(array);
//
//        array.add(-1, 1000);

        LinkedIntList list = new LinkedIntList();
        System.out.println(list);
        list.addFront(3);
        list.addFront(2);
        list.addFront(1);
        System.out.println(list);

        list.addBack(4);
        list.addBack(5);
        list.addBack(6);
        System.out.println(list);

        System.out.println(list.get(0));
        list.addFront(100);
        System.out.println(list);
        list.clear();
        System.out.println(list);
        list.addFront(100);
        list.addFront(200);
        list.addFront(300);

        System.out.println(list);












    }
}
