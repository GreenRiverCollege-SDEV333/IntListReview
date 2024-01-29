import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayIntTest
{
    private static ArrayIntList testList;

    @BeforeAll
    static void createList()
    {
        testList = new ArrayIntList();
        Random numGen = new Random();

        testList.addFront(5);
        for (int i = 0; i < 4; i++)
        {
            testList.addFront(numGen.nextInt(0,100));
        }
    }

    @Test
    void addFront()
    {
        System.out.println("Expected value: 79");
        testList.addFront(79);
        System.out.println("Actual value: " + testList.get(0));
    }

    @Test
    void addBack()
    {
        System.out.println("Expected value: 31");
        testList.addBack(31);
        System.out.println("Actual value: " + testList.get(testList.size() - 1));
    }

    @Test
    void add()
    {
        System.out.println("Expected value at index 8: 2");
        testList.add(8, 2);
        System.out.println("Actual value at index 8: " + testList.get(8));
    }

    @Test
    void removeFront()
    {
        System.out.println("Expected value at list front: " + testList.get(1));
        testList.removeFront();
        System.out.println("Actual value at list front: " + testList.get(0));
    }

    @Test
    void removeBack()
    {
        System.out.println("Expected value at list end: " + testList.get(testList.size() - 2));
        testList.removeBack();
        System.out.println("Actual value at list end: " + testList.get(testList.size() - 1));
    }

    @Test
    void remove()
    {
        System.out.println("Expected value at index 3: " + testList.get(4));
        testList.remove(3);
        System.out.println("Actual value at index 3: " + testList.get(3));
    }

    @Test
    void contains()
    {
        assertEquals(true, testList.contains(5));
    }

    @Test
    void indexOf()
    {
        assertEquals(0, testList.indexOf(5));
    }

    @Test
    void isEmpty()
    {
        assertEquals(false, testList.isEmpty());
    }

    @Test
    void clear()
    {
        testList.clear();
        assertEquals(true, testList.isEmpty());
    }
}
