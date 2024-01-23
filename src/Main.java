//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

        System.out.println("Array tests:");
        // test addFront
        IntList list = new ArrayIntList();
        list.addFront(1);
        list.addFront(2);
        list.addFront(3);

        printList(list);

        // test addBack
        list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);

        printList(list);

        // test add
        list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.add(0,5); // test add front
        list.add(1, 5); // test add mid
        list.add(5, 5); // test add end


        printList(list);

        System.out.println("Contains 5: " + list.contains(5));
        System.out.println("Contains 7: " + list.contains(7));
        System.out.println("Index of value \"1\": " + list.indexOf(1));
        System.out.println("Index of value \"7\": " + list.indexOf(7));
        System.out.println("Get value at index \"4\": " +list.get(4));

        // test removals
        System.out.println("Remove front");
        printList(list);
        list.removeFront();
        printList(list);

        System.out.println("Remove back");
        printList(list);
        list.removeBack();
        printList(list);

        System.out.println("Remove at specific index 2");
        printList(list);
        int val = list.remove(2);
        printList(list);
        System.out.println("Value removed: " + val);



        System.out.println();
        System.out.println("******************");
        System.out.println("Linked list tests: ");
        // test addFront
        list = new LinkedIntList();
        list.addFront(1);
        list.addFront(2);
        list.addFront(3);

        printList(list);

        // test addBack
        list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);

        printList(list);

        // test add
        list = new LinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.add(0,5); // test add front
        list.add(1, 5); // test add mid
        list.add(5, 5); // test add end


        printList(list);

        System.out.println("Contains 5: " + list.contains(5));
        System.out.println("Contains 7: " + list.contains(7));
        System.out.println("Index of value \"1\": " + list.indexOf(1));
        System.out.println("Index of value \"7\": " + list.indexOf(7));
        System.out.println("Get value at index \"4\": " +list.get(4));

        // test removals
        System.out.println("Remove front");
        printList(list);
        list.removeFront();
        printList(list);

        System.out.println("Remove back");
        printList(list);
        list.removeBack();
        printList(list);

        System.out.println("Remove at specific index 2");
        printList(list);
        val = list.remove(2);
        printList(list);
        System.out.println("Value removed: " + val);

    }

    public static void printList(IntList list) {
        System.out.print("[");
        for (var i : list) {
            System.out.print(i + ",");
        }
        System.out.print("]");
        System.out.println();
    }
}