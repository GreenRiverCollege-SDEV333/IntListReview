//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        LinkedIntList listOne = new LinkedIntList();


        listOne.addFront(5);
        listOne.addFront(4);
        listOne.addFront(3);
        listOne.addFront(2);
        listOne.addFront(1);

        for(int i = 0; i < listOne.size(); i++) {
            System.out.print(listOne.get(i) + " ");
        }
        System.out.println("");
        System.out.println(listOne.get(4));

        System.out.println(listOne.contains(3));
        System.out.println(listOne.remove(2));
        System.out.println(listOne.contains(3));

        listOne.add(2, 12);
        System.out.println(listOne.contains(12));
    }
}