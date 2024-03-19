import java.sql.SQLOutput;
import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        IntList firstList;

        ArrayIntList secondList = new ArrayIntList();

        IntList thirdList = new ArrayIntList();
        thirdList.addFront(15);
        thirdList.addFront(12);
        thirdList.addBack(8);
        thirdList.add(1, 10);
        thirdList.removeFront();
        thirdList.removeBack();
        //add more values to continue testing
        thirdList.addFront(9);
        thirdList.addFront(23);
        thirdList.addBack(77);
        thirdList.remove(2);
        System.out.println("The value at index 3 is: " + thirdList.get(3));
        System.out.println("The buffer array contains 10 " + thirdList.contains(10));
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
    }
}