package driver;

import lists.ArrayIntList;
import lists.LinkedIntList;

public class Main {
    public static void main(String[] args) {

        LinkedIntList linkedIntList = new LinkedIntList();

        linkedIntList.addFront(5);
        linkedIntList.addFront(4);
        linkedIntList.addFront(3);
        linkedIntList.addFront(2);
        linkedIntList.addFront(1);
        linkedIntList.addFront(0);
        System.out.println(linkedIntList);

        linkedIntList.addBack(6);
        linkedIntList.addBack(7);
        linkedIntList.addBack(8);
        linkedIntList.addBack(9);
        System.out.println(linkedIntList);

        linkedIntList.add(10, 10);
        System.out.println(linkedIntList);

        linkedIntList.remove(3);
        System.out.println(linkedIntList);
        linkedIntList.removeBack();
        System.out.println(linkedIntList);
        linkedIntList.removeFront();
        System.out.println(linkedIntList);
        System.out.println(linkedIntList.get(4));
        System.out.println(linkedIntList.contains(1));
        System.out.println(linkedIntList.contains(10));
        System.out.println(linkedIntList.indexOf(1));
        System.out.println(linkedIntList.isEmpty());
        LinkedIntList linkedIntListEmpty = new LinkedIntList();
        System.out.println(linkedIntListEmpty.isEmpty());
        System.out.println(linkedIntList.size());
        linkedIntList.clear();
        System.out.println(linkedIntList);


//    ArrayIntList arrayIntList = new ArrayIntList();
//
//        arrayIntList.addFront(5);
//        arrayIntList.addFront(4);
//        arrayIntList.addFront(3);
//        arrayIntList.addFront(2);
//        arrayIntList.addFront(1);
//        arrayIntList.addFront(0);
//
//        arrayIntList.addBack(6);
//        arrayIntList.addBack(7);
//        arrayIntList.addBack(8);
//        arrayIntList.addBack(9);
//
//        System.out.println("Printing array");
//        System.out.println(arrayIntList);
//
//        System.out.println("\nremove: Removing number from third index (should be removing number 3)");
//        arrayIntList.remove(3);
//        System.out.println(arrayIntList);
//
//        System.out.println("\nremoveFront: Removing number from the front (should be removing number 0)");
//        arrayIntList.removeFront();
//        System.out.println(arrayIntList);
//
//        System.out.println("\nremoveBack: Removing number from the end (should be removing number 9)");
//        arrayIntList.removeBack();
//        System.out.println(arrayIntList);
//
//        System.out.println("\nadd: adding 3 back to the array");
//        arrayIntList.add(2, 3);
//        System.out.println(arrayIntList);
//
//        System.out.println("\nget: getting value from index 0 (should be 1)");
//        System.out.println(arrayIntList.get(0));
//
//        System.out.println("\ncontains: checking if array contains 1 (should be true)");
//        System.out.println(arrayIntList.contains(1));
//
//        System.out.println("\ncontains: checking if array contains 10 (should be false)");
//        System.out.println(arrayIntList.contains(10));
//
//        System.out.println("\nindexOf: looking for first instance of the value 3 and getting its index (should be 2)");
//        System.out.println(arrayIntList.indexOf(3));
//
//        System.out.println("\nisEmpty: checking if array is empty (it should return false)");
//        System.out.println(arrayIntList.isEmpty());
//
//        ArrayIntList arrayIntListEmpty = new ArrayIntList();
//        System.out.println("\nisEmpty: checking if array is empty (it should return true)");
//        System.out.println(arrayIntListEmpty.isEmpty());
//
//        System.out.println("\nsize: returns size (should be 8)");
//        System.out.println(arrayIntList.size());
//
//        System.out.println("\nclear: array should be empty once this is called");
//        System.out.println("before: " + arrayIntList);
//        arrayIntList.clear();
//        System.out.println(" after: " + arrayIntList);

    }
}
