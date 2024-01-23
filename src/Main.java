import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static <ArrayIntList> void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

        IntList firstList = new ArrayList();

        ArrayList secondList = new ArrayList();

        IntList thirdList = new ArrayList();
        thirdList.addFront(15);
        thirdList.addFront(12);
        thirdList.addFront(7);
        thirdList.removeBack();
        thirdList.removeFront();
        thirdList.add(1,33);
        System.out.println(thirdList.contains(33));
        thirdList.remove(1);
        thirdList.addBack(44);
        System.out.println(thirdList.contains(33));
        System.out.println(thirdList.indexOf(44));


        for (int value : thirdList) {
            System.out.println(value);
        }

        LinkedIntList linkedList = new LinkedIntList();
        linkedList.addFront(1);
        linkedList.addBack(2);
        linkedList.add(1, 3);

        linkedList.removeFront();
        linkedList.removeBack();
        linkedList.remove(0);

        linkedList.addFront(1);
        linkedList.addBack(2);
        linkedList.addBack(3);

        System.out.printf("Value at 1 is %d\n", linkedList.get(1));
        System.out.printf("It is %b that the list contains %d\n", linkedList.contains(3), 3);
        System.out.printf("It is %b that the list is empty\n", linkedList.isEmpty());

        System.out.printf("The list contains %d things\n", linkedList.size());
        linkedList.clear();
        System.out.printf("The list contains %d things after clearing it\n", linkedList.size());

        Iterator<Integer> linkedItr = linkedList.iterator();



//        DoublyLinkedIntList testing = new DoublyLinkedIntList();
//        testing.addFront(333);
//        testing.addBack(123);
//        testing.addBack(357);
//        System.out.println(testing.contains(333));
//        System.out.println(testing.contains(123));
//        System.out.println(testing.contains(135));
//        System.out.println(testing.contains(357));
//
//        System.out.println(testing.indexOf(333));
//        System.out.println(testing.indexOf(123));
//        System.out.println(testing.indexOf(135));
//        System.out.println(testing.indexOf(357));
    }
}