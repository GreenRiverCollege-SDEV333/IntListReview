import java.util.Arrays;

/**
 * Driver to work with implemented data structures for 333 Weeks 1-3
 * @author Rob Smith
 * @version 1.0
 */
public class Main {
    public static ArrayIntList testList = new ArrayIntList();
    public static LinkedList testLink = new LinkedList();
    public static DoublyLinekdList testDouble = new DoublyLinekdList();
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!\n");
        testLink.addFront(44);
        System.out.println(testLink.get(0));
    }
}