//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static <ArrayIntList> void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        IntList firstList = new ArrayList();

        ArrayList secondList = new ArrayList();

        IntList thirdList = new ArrayList();
        thirdList.addFront(15);
        thirdList.addFront(12);
        thirdList.addFront(7);
        
        for (int value : thirdList) {
            System.out.println(value);
        }
    }
}