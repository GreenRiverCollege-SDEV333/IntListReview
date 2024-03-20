
import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");



        //////////////////////
        //// ArrayIntList ////
        //////////////////////

        //wasn't sure how to do tests which broke the program and keep the
        // program working for the rest of the tests
        IntList firstList;

        ArrayIntList secondList = new ArrayIntList();

        IntList thirdList = new ArrayIntList();
        thirdList.addFront(15);
        thirdList.addFront(12);
        thirdList.addBack(8);
        thirdList.add(1, 10);
        System.out.println("ThirdList built");
        for(int value : thirdList){
            System.out.println(value);
        }

        thirdList.removeFront();
        thirdList.removeBack();
        //add more values to continue testing
        thirdList.addFront(9);
        thirdList.addFront(23);
        thirdList.addBack(77);
        thirdList.remove(2);
        System.out.println("The value at index 3 is: " + thirdList.get(3));
        System.out.println("The buffer array contains 10 " + thirdList.contains(10)); //note that 10 has been removed above
        System.out.println("The buffer array contains 77 " + thirdList.contains(77));
        System.out.println("The index position of value 4 is " + thirdList.indexOf(4));
        System.out.println("This index position of 9 is " + thirdList.indexOf(9));
        System.out.println("The array thirdList is empty: " + thirdList.isEmpty());
        System.out.println("The array secondList is empty: " + secondList.isEmpty());
        System.out.println("The size of the thirdList is: " + thirdList.size());
        thirdList.addFront(9);
        thirdList.addFront(23);
        thirdList.addBack(77);
        thirdList.addFront(15);
        thirdList.addFront(12);
        thirdList.addBack(8);
        thirdList.add(1, 10);
        System.out.println("The new size of the thirdList is: " + thirdList.size());

        //Where an iterator gets used
//        for(int value : thirdList){
//            System.out.println(value);
//        }

        //alternate way to use an iterator
        Iterator<Integer> itr = thirdList.iterator();
        while(itr.hasNext()){
            int value = itr.next();
            System.out.println(value);
        }

        thirdList.clear();
        System.out.println("Array is cleared " + thirdList.isEmpty());
        //Where an iterator gets used
        for(int value : thirdList){
            System.out.println(value);
        }


        ///////////////////////
        //// LinkedIntList ////
        ///////////////////////

        LinkedIntList fourthList = new LinkedIntList();
        System.out.println();
        System.out.println("Start LinkedIntList");

        fourthList.addFront(25);
        fourthList.addFront(30);
        fourthList.addBack(6);
        System.out.println("add to index 1 value 8");
        fourthList.add(1, 8);
        System.out.println("The current value in index 4: " + fourthList.get(4));
        System.out.println("add to index 4 value 10");
        fourthList.add(4, 10);
        System.out.println("The current size is " + fourthList.size());
        //Where an iterator gets used
        for(int value : fourthList){
            System.out.println(value);
        }

        System.out.println("The value at index 1 is: " + fourthList.get(1));
        //this throws an error (as intended)
//        System.out.println("The value at index 10 is: " + fourthList.get(10) );
        System.out.println("Contains the number 30 " + fourthList.contains(30));
        System.out.println("Contains the number 20 " + fourthList.contains(20));
        System.out.println("The index position of 6 is " + fourthList.indexOf(6));
        System.out.println("The index position of 10 is " + fourthList.indexOf(10));

        fourthList.removeFront();
        System.out.println("Removing front node");
        for(int value : fourthList){
            System.out.println(value);
        }

        //remove the last value 6
        fourthList.removeBack();
        System.out.println("Removing last node");
        for(int value: fourthList){
            System.out.println(value);
        }

        System.out.println("Removing index 2: " + fourthList.remove(2));
        for(int value: fourthList){
            System.out.println(value);
        }

        System.out.println("Removing index 2: " + fourthList.remove(2));
        for(int value: fourthList){
            System.out.println(value);
        }

        System.out.println("The size of the LinkedList is: " + fourthList.size());
        System.out.println("The linkedlist is empty: " + fourthList.isEmpty());
        System.out.println("Clearing list");
        fourthList.clear();
        System.out.println("The linkedlist is empty: " + fourthList.isEmpty());

        /////////////////////////////
        //// DoublyLinkedIntList ////
        /////////////////////////////


    }
}