import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        IntList firstList;

        ArrayIntList secondList = new ArrayIntList();

        IntList thirdList = new ArrayIntList();
        thirdList.addFront(15);
        thirdList.addFront(12);
        thirdList.addBack(8);

        //where an iterator gets used:
        for (int value : thirdList)
        {
            System.out.println(value);
        }

//        alternate way to use an iterator
//        Iterator<Integer> itr = thirdList.iterator();
//        while(itr.hasNext())
//        {
//            int value = itr.next();
//            System.out.println(value);
//        }
    }

    public static double findAverage(IntList theList)
    {
        return 0.0;
    }
}