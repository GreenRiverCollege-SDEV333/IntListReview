import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        IntList firstList;

        IntList thirdList = new ArrayIntList();
        thirdList.addFront(15);
        thirdList.addFront(12);
        thirdList.addFront(8);

        //where an iterator gets used:
        for (int value: thirdList) {
            System.out.println(value);
        }

        //alternate way to use an iterator
        Iterator<Integer> itr = thirdList.iterator();
        while (itr.hasNext()){
            int value = itr.next();
            System.out.println(value);
        }

        arrayIntListTest();
    }

    public static void arrayIntListTest(){
        ArrayIntList arrayTest = new ArrayIntList();
        System.out.println("Testing ArrayIntList");

        System.out.println("\naddFront()");
        arrayTest.addFront(1);
        arrayTest.addFront(2);
        arrayTest.addFront(3);
        arrayTest.addFront(4);
        arrayTest.addFront(5);
        for (int value : arrayTest){
            System.out.print(value + ", ");
            //should be: 5,4,3,2,1
        }

        System.out.println("\naddBack()");
        arrayTest.addBack(20);
        for (int value : arrayTest){
            System.out.print(value + ", ");
            //should be: 5,4,3,2,1,20
        }

        System.out.println("\nadd()");
        arrayTest.add(1,13);
        for (int value : arrayTest){
            System.out.print(value + ", ");
            //should be: 5,13,4,3,2,1,20
        }

        System.out.println("\nremoveFront()");
        arrayTest.removeFront();
        for (int value : arrayTest){
            System.out.print(value + ", ");
            //should be: 13,4,2,1,20
        }

        System.out.println("\nremoveBack()");
        arrayTest.removeBack();
        for (int value : arrayTest){
            System.out.print(value + ", ");
            //should be: 13,4,3,2,1
        }

        System.out.println("\nremove()");
        arrayTest.remove(1);
        for (int value : arrayTest){
            System.out.print(value + ", "); //should be: 13,3,2,1
        }

        System.out.println("\nget()");
        arrayTest.get(1); //should be: 3

        System.out.println("contains()");
        System.out.println(arrayTest.contains(1)); //true

        System.out.println("indexOf()");
        System.out.println(arrayTest.indexOf(2)); //2

        System.out.println("isEmpty()");
        System.out.println(arrayTest.isEmpty()); //false

        System.out.println("size()");
        System.out.println(arrayTest.size()); //4

        System.out.println("clear()");
        arrayTest.clear();
        for (int value : arrayTest){
            System.out.print(value + ", "); //empty
        }

    }
}