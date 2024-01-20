import java.util.Arrays;

/**
 * Driver to work with implemented data structures for 333 Weeks 1-3
 * @author Rob Smith
 * @version 1.0
 */
public class Main {
    public static ArrayIntList testList = new ArrayIntList();
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");
        System.out.println();
        System.out.println("Is the array empty? " + testList.isEmpty());
        System.out.println("Adding elements 0-4 in reverse order");
        for (int i = 0; i < 5; i++) {
            testList.addFront(i);
        }
        System.out.println(testList.toString());
        System.out.println("Adding the value 5 to index 3");
        testList.add(3, 5);
        System.out.println(testList.toString());
        System.out.println("Does it contain a 1? " + testList.contains(1));
        System.out.println("3 is located at index: " + testList.indexOf(3));
        System.out.println("Removing the value 2");
        testList.remove(2);
        System.out.println(testList.toString());
        System.out.println("The array has a size of: " + testList.size());
        System.out.println("Adding enough elements to force a resize");
        for (int i = 0; i < 15; i++){
            testList.addBack(i);
        }
        System.out.println("New array size: "+testList.size());
        System.out.println(testList.toString());
        testList.add(3,3);
        System.out.println(testList.toString());
    }
}