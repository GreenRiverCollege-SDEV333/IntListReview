import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        IntList secondList = new DoublyLinkedList();
        IntList thirdList = new ArrayIntList();

        secondList.add(0,10);
        secondList.add(1,11);
        secondList.add(2,12);
        secondList.add(3, 13);


        for (int number :secondList
             ) {
            System.out.println(number);
        }
        System.out.println("this is the contain test: " + secondList.contains(14));

        System.out.println("This is the size: " + secondList.size());
        System.out.println("is the list empty? " + secondList.isEmpty());


    }
}