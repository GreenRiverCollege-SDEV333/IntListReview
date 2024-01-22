import java.util.Arrays;
import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        // create ArrayIntList
        ArrayIntList testList = new ArrayIntList();

        //add methods
        testList.add(0, 1);
        testList.add(1, 3);
        testList.add(2, 5);
        Iterator<Integer> itr = testList.iterator();
        System.out.println("add():");
        printArray(testList, itr);
        System.out.println();

        System.out.println("addFront()");
        testList.addFront(6);
        System.out.println("Front: " + testList.get(0));
        printArray(testList, itr);

        System.out.println();
        System.out.println("addBack()");
        testList.addBack(50);
        printArray(testList, itr);

        System.out.println();
        System.out.println("removeFront()");
        testList.removeFront();
        printArray(testList, itr);

        System.out.println();
        System.out.println("removeBack()");
        testList.removeBack();
        printArray(testList, itr);

        System.out.println();
        System.out.println("remove()");
        testList.remove(1);
        printArray(testList, itr);

        System.out.println();
        System.out.println("get()");
        System.out.println(testList.get(1));

        System.out.println();
        System.out.println("contains()");
        System.out.println("Contains 10: " + testList.contains(10));
        System.out.println("Contains 1: " + testList.contains(1));

        System.out.println();
        System.out.println("indexOf()");
        System.out.println("Index of 1: " + testList.indexOf(1));
        System.out.println("Index of 5: " + testList.indexOf(5));
        System.out.println("Index of 3: " + testList.indexOf(3));

        System.out.println();
        System.out.println("isEmpty()");
        ArrayIntList emptyList = new ArrayIntList();
        System.out.println("emptyList: " + emptyList.isEmpty());
        System.out.println("testList: " + testList.isEmpty());

        System.out.println();
        System.out.println("size()");
        System.out.println("Size of testList: " + testList.size());

        System.out.println();
        System.out.println("resize()");
        System.out.println("currentList: " + testList.size());
        testList.resize(20);
        for (int i = 0; i <= 20; i++)
        {
            testList.add(i, 4);
        }
        System.out.println(testList.size());




//        // where an iterator gets used:
//        for (int value : thirdList)
//        {
//            System.out.println(value);
//        }
//
//        //alternate way to use an iterator
//        Iterator<Integer> itr = thirdList.iterator();
//        while (itr.hasNext()) {
//            int value = itr.next();
//            System.out.println(value);
//        }




//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }

    }

    public static void printArray(ArrayIntList list, Iterator<Integer> iterator)
    {
        System.out.print("testList = {");
        iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println("}");
    }
}