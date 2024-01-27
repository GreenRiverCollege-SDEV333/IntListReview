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
        secondList.addBack(1);
        secondList.addFront(20);
        secondList.addFront(30);
        secondList.addFront(40);
        secondList.addFront(50);
        secondList.addBack(3000);
        secondList.remove(3);
        for (int number :secondList
             ) {
            System.out.println(number);
        }
        System.out.println("index: " + secondList.get(5));
        System.out.println("This is the size: " + secondList.size());
        System.out.println("is the list empty? " + secondList.isEmpty());


    }
}