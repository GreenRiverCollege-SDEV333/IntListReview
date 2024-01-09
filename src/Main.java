//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        IntList firstList;
        ArrayIntList secondList = new ArrayIntList();
        IntList thirdList = new ArrayIntList();

        thirdList.addFront(15);
        thirdList.addFront(12);
        thirdList.addFront(8);

        for (int value : thirdList) {
            System.out.println(value);
        }


    }
}