//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");


        IntList firstList;

        ArrayIntList secondList = new ArrayIntList();

        IntList thirdList = new ArrayIntList();

        thirdList.addFront(15);
        thirdList.addFront(12);
        thirdList.addFront(8);


        ArrayIntList myList = new ArrayIntList();


        int listSize = myList.size();
        System.out.println("Size of the list: " + listSize);

        myList.addFront(1);
        myList.addFront(5);

        boolean containsValue = myList.contains(12);
        System.out.println("Contains 12: " + containsValue);

        int indexOfValue = myList.indexOf(1);
        System.out.println("Index of 1: " + indexOfValue);

        myList.removeFront();
        System.out.println("Removed front element.");

        // list contents
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }


//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
    }
}