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

        thirdList.addFront(1);
        thirdList.addFront(2);
        thirdList.addFront(3);

        // testing .add method
        thirdList.add(1, 4);
        thirdList.add(2, 5);

        for(int i = 0; i < thirdList.size(); i++) {
            System.out.print(thirdList.get(i) + " ");
        }


    }
}