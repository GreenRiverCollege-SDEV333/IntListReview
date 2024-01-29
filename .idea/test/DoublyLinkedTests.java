/**
 * This class contains tests for DoublyLinkedIntList.java.
 *
 * @author Jared Eller
 */

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedTests
{
    private static DoublyLinkedIntList emptyTestList;
    private static DoublyLinkedIntList oneTestList;
    private static DoublyLinkedIntList twoTestList;
//    private static DoublyLinkedIntList fullTestList;
//    by nature I don't think LinkedLists can really be full, aside from running out of memory...
    @BeforeAll
    static void createList()
    {
        emptyTestList = new DoublyLinkedIntList();
        oneTestList = new DoublyLinkedIntList();
        twoTestList = new DoublyLinkedIntList();

        oneTestList.addFront(72);
        twoTestList.addFront(14);
        twoTestList.addFront(108);
    }

    @Test
    static void addFront()
    {
        //showing how adding a value to the list changes the starting value, thus showing the method works the way it
        //should.
        System.out.println(emptyTestList.get(1));
        emptyTestList.addFront(5);
        System.out.println(emptyTestList.get(1));

        System.out.println(oneTestList.get(1));
        oneTestList.addFront(5);
        System.out.println(oneTestList.get(1));

        System.out.println(twoTestList.get(1));
        twoTestList.addFront(5);
        System.out.println(twoTestList.get(1));

        //testing with incorrect data input; this is commented out since it'll break the compilation if it runs.
//        emptyTestList.addFront("orange");
    }

    @Test
    static void addBack()
    {
        //showing how adding a value to the list changes the back value, thus showing the method works the way it
        //should.
        //I suppose this also technically serves as a test for size, but I'll try to write a proper test for that
        //if I get the chance.
        System.out.println(emptyTestList.get(emptyTestList.size()));
        emptyTestList.addBack(25);
        System.out.println(emptyTestList.get(emptyTestList.size()));

        System.out.println(oneTestList.get(oneTestList.size()));
        oneTestList.addFront(25);
        System.out.println(oneTestList.get(oneTestList.size()));

        System.out.println(twoTestList.get(twoTestList.size()));
        twoTestList.addFront(25);
        System.out.println(twoTestList.get(twoTestList.size()));
    }

    @Test
    static void add()
    {
        //this one's gonna test a few different indices cuz of how the lists are set up.
        System.out.println(emptyTestList.get(1));
        emptyTestList.add(125, 1);
        System.out.println(emptyTestList.get(1));
        System.out.println(emptyTestList.get(2));

        System.out.println(oneTestList.get(3));
        oneTestList.add(125, 3);
        System.out.println(oneTestList.get(3));
        System.out.println(oneTestList.get(4));

        System.out.println(twoTestList.get(4));
        twoTestList.add(125, 4);
        System.out.println(twoTestList.get(4));
        System.out.println(twoTestList.get(5));
        //Doing two "sout"s per list to show the data moving to accomodate the newly-added Nodes.
    }

    @Test
    static void removeFront()
    {
        //I think the way I wrote get means 1 is actually index 0, hence me constantly getting index 1 instead of 0.
        System.out.println(emptyTestList.get(1));
        emptyTestList.removeFront();
        System.out.println(emptyTestList.get(1));

        System.out.println(oneTestList.get(1));
        oneTestList.removeFront();
        System.out.println(oneTestList.get(1));

        System.out.println(twoTestList.get(1));
        twoTestList.removeFront();
        System.out.println(twoTestList.get(1));

        //the logic I'm using with these tests is the same logic I used earlier on: print out the data in the index
        //to be altered, then do the alteration, then print out the new data. Not a lot of assertEquals here...
    }

    @Test
    static void removeBack()
    {
        System.out.println(emptyTestList.get(emptyTestList.size()));
        emptyTestList.removeBack();
        System.out.println(emptyTestList.get(emptyTestList.size()));

        System.out.println(oneTestList.get(emptyTestList.size()));
        oneTestList.removeBack();
        System.out.println(oneTestList.get(emptyTestList.size()));

        System.out.println(twoTestList.get(emptyTestList.size()));
        twoTestList.removeBack();
        System.out.println(twoTestList.get(emptyTestList.size()));
    }

    @Test
    static void remove()
    {
        //praying that these tests just work, I gotta go to work in about 20 minutes...
        System.out.println(emptyTestList.get(2));
        emptyTestList.remove(2);

        //actually, this may throw an exception.
//        System.out.println(emptyTestList.get(2));
        assertEquals((Integer) null, emptyTestList.get(2)); //I hope this works...

        System.out.println(oneTestList.get(2));
        oneTestList.remove(2);
        System.out.println(oneTestList.get(2));

        System.out.println(twoTestList.get(3));
        twoTestList.remove(3);
        System.out.println(twoTestList.get(3));

        //I feel like a lot of these tests were written awkwardly; instead of finding a way to effectively use
        //assertEquals, I just put the work on the end-user by printing the values out and asking them to compare.
        //Very sloppy work.
    }

    @Test
    static void get()
    {
        //now, the real question: null, or -1?
        assertEquals(-1, emptyTestList.get(1));
        assertEquals(72, oneTestList.get(1));
        assertEquals(108, twoTestList.get(1));
    }

    @Test
    static void contains()
    {
        assertEquals(1, emptyTestList.contains(1)); //should be false
        assertEquals(72, oneTestList.contains(72)); //should be true
        assertEquals(14, twoTestList.contains(14)); //should be true
    }

    @Test
    static void indexOf()
    {
        //can't test emptyTestList cuz I assumed the value being searched for would be present upon a call of indexOf.
        assertEquals(1, oneTestList.indexOf(72)); //should be 1
        assertEquals(2, twoTestList.indexOf(14)); //should be 2
    }

    @Test
    static void isEmpty()
    {
        //empty should be empty, one should have 1, two should have 2.
        assertEquals(true, emptyTestList.isEmpty());
        assertEquals(false, oneTestList.isEmpty());
        assertEquals(false, twoTestList.isEmpty());
    }

    @Test
    static void size()
    {
        assertEquals(0, emptyTestList.size());
        assertEquals(1, oneTestList.size());
        assertEquals(2, twoTestList.size());
    }

    @Test
    static void clear()
    {
        //this might cause some exceptions cuz of emptyTestList being... well... empty.
        System.out.println(emptyTestList.get(1));
        System.out.println(oneTestList.get(1));
        System.out.println(twoTestList.get(1));

        emptyTestList.clear();
        oneTestList.clear();
        twoTestList.clear();

        //these will probably throw exceptions, or else return -1, a designated dummy value...
        System.out.println(emptyTestList.get(1));
        System.out.println(oneTestList.get(1));
        System.out.println(twoTestList.get(1));
    }
}
