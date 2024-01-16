//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main  {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

            // create variable of type then write a class that implements type and then you can make a new object
            IntList firstList;

            ArrayIntList secondList = new ArrayIntList();

            IntList thirdList = new ArrayIntList();

//            for(int value : thirdList){
//                System.out.println(value);
//            }



            thirdList.add(0,4);
            thirdList.add(1,5);
            thirdList.add(2,6);
            thirdList.add(3,7);
            System.out.println(thirdList);
            thirdList.addBack(65);
            System.out.println(thirdList);
            thirdList.addFront(69);
            System.out.println(thirdList);
            thirdList.removeBack();
            System.out.println(thirdList);
            thirdList.removeFront();
            System.out.println(thirdList);



        }

    }
