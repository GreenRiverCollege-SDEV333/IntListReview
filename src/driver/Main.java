package driver;

import Lists.ArrayIntList;
import Interfaces.IntList;

import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        IntList firstList;

        ArrayIntList secondList = new ArrayIntList();

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        IntList thirdList = new ArrayIntList();
        thirdList.addFront(15);
        thirdList.addFront(12);
        thirdList.addBack(8);

        for (int value : thirdList) {
            System.out.println(value);
        }

        //alternate way to use an iterator
        Iterator<Integer> itr = thirdList.iterator();
        while (itr.hasNext()) {
            int value = itr.next();
            System.out.println(value);
        }
    }
}