//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main  {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

            // create variable of type then write a class that implements type and then you can make a new object
            IntList thirdList = new ArrayIntList();


//
//            thirdList.add(0,4);
//            thirdList.add(1,5);
//            thirdList.add(2,6);
//            thirdList.add(3,9);
//            System.out.println(thirdList);
//            thirdList.addBack(65);
//            System.out.println(thirdList);
//            thirdList.addFront(69);
//            System.out.println(thirdList);
//            thirdList.removeBack();
//            System.out.println(thirdList);
//            thirdList.removeFront();
//            System.out.println(thirdList);
//            System.out.println(thirdList.contains(6));
//            System.out.println(thirdList);
//            System.out.println(thirdList.remove(2));
//            System.out.println(thirdList);
//            thirdList.clear();
//            System.out.println(thirdList);



            IntList linked = new LinkedIntList();
            linked.add(0,1);
            linked.add(1,2);
            linked.add(2,3);
            linked.add(0,66);
            linked.addFront(33);
            linked.addBack(44);
//            System.out.println(linked);
//            linked.removeFront();
//            System.out.println(linked);
//            linked.removeBack();
//            System.out.println(linked);
//            System.out.println(linked.get(3));
//            System.out.println(linked);
//            System.out.println(linked.indexOf(77));
//            linked.add(2, 77);
//            System.out.println(linked.indexOf(77));
//            System.out.println(linked.size());
//            linked.clear();
//            System.out.println(linked.isEmpty());
//            linked.addFront(1);
//            System.out.println(linked.size());

            System.out.println(linked);
            System.out.println(linked.remove(2));
            System.out.println(linked);
            System.out.println(linked.remove(0));
            System.out.println(linked);
            System.out.println(linked.remove(0));
            System.out.println(linked);




        }

    }
