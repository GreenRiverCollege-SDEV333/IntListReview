import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
  /*
        //ArrayIntList
        //create and array and add values to each index
        ArrayIntList secondList = new ArrayIntList();
        secondList.add(0,0);
        secondList.add(1,2);
        secondList.removeFront();

        //test each method call


        secondList.addFront(0);
        secondList.addBack(3);
        secondList.add(2,11);
        //secondList.removeFront();
       //secondList.removeBack();
        secondList.remove(2);
        secondList.add(4,0);

        for( int value: secondList){
            System.out.println(value);
        }

        System.out.println("\n"+ secondList.get(1));
        System.out.println(secondList.contains(1));
        System.out.println(secondList.indexOf(1));
        System.out.println(secondList.isEmpty());
        System.out.println(secondList.size());
        secondList.clear();
        System.out.println("\n"+ secondList.contains(1));
        System.out.println(secondList.indexOf(1));
        System.out.println(secondList.isEmpty());
        System.out.println(secondList.size());

*/
        //LinkedIntList
        LinkedIntList thirdList = new LinkedIntList();
        thirdList.addFront(1);
        thirdList.addFront(0);
        thirdList.removeFront();
        thirdList.print();
        /*
        thirdList.add(1,10);
        thirdList.add(2,5);
        thirdList.addBack(0);
        thirdList.print();

        System.out.println(thirdList.isEmpty());
        System.out.println(thirdList.size());
        System.out.println(thirdList.indexOf(10));
        System.out.println(thirdList.indexOf(11));
        System.out.println(thirdList.contains(0));
        System.out.println(thirdList.contains(2));
        System.out.println(thirdList.get(0));
        System.out.println(thirdList.get(4));
        System.out.println(thirdList.remove(0));
        System.out.println(thirdList.remove(3)+"\n");
        thirdList.removeFront();
        thirdList.print();
        System.out.println("\n");
        thirdList.clear();
        thirdList.print();  //test it is empty
        //System.out.println(thirdList.get(0));  test it is empty
*/
       /* //doublyLinkedList
        DoublyLinkedIntList fourthList = new DoublyLinkedIntList();
        fourthList.addFront(0);
        //fourthList.print();
        fourthList.addBack(7);
        fourthList.removeFront();
        fourthList.print();

        fourthList.print();
        fourthList.add(1,11);
        fourthList.print();
        System.out.println("\n");
        fourthList.removeBack();
        fourthList.print();
        fourthList.remove(1);
        fourthList.print();
        System.out.println(fourthList.get(0));
        System.out.println(fourthList.contains(7));
        System.out.println(fourthList.indexOf(7));
        System.out.println(fourthList.isEmpty());
        fourthList.removeBack();
        System.out.println(fourthList.isEmpty());
        System.out.println(fourthList.size());
        fourthList.addFront(7);
        fourthList.add(1,11);
        fourthList.clear();
        System.out.println(fourthList.isEmpty());
        fourthList.iterator();
       */
    }

}