import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static ArrayIntList testList = new ArrayIntList();
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        System.out.println();

//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }


        System.out.println("Is the array empty? " + testList.isEmpty());
        testList.addFront(7);
        testList.addFront(3);
        testList.addFront(69);
        testList.addFront(44);
        testList.addFront(55);
        testList.addBack(5);
        testList.add(6, 99);

        System.out.println("Does the list contain the number 5: "+testList.contains(5));
        System.out.println("The first occurence of the number 7 is at index: "+testList.indexOf(7));
        System.out.println("Is the array empty? " + testList.isEmpty());

        printArray();
        System.out.println();
        testList.removeFront();
        printArray();
        System.out.println();
        testList.removeBack();
        printArray();
        System.out.println();
        testList.remove(1);
        printArray();
        System.out.println();
        testList.clear();
        printArray();

    }

    public static void printArray(){
        System.out.println("TestList size: "+testList.size());
        for(int i = 0; i<testList.size();i++){
            System.out.println("Index "+i+":Value :"+testList.get(i));
        }
    }
}