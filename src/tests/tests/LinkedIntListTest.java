package tests;
import lists.ArrayIntList;
import lists.LinkedIntList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for ArrayIntList
 * @author tobygoetz
 * @version 1.0
 */
public class LinkedIntListTest {
    public LinkedIntList list = new LinkedIntList();
    public Exception exception;
    public static final int ITERATIONS = 15;

    /**
     * Test adds Integer values to the front when empty, almost empty,
     * not empty and when buffer is larger than intial size of 10 is
     * surpassed.
     */
    @Test
    public void addFrontTest() {
        assertEquals(0, list.size());
        for (int i = 0; i <= ITERATIONS; i++) {
            list.addFront(i);
            // Index 0 changes everytime addFront is called
            assertEquals(i, list.get(0));
        }
    }

    /**
     * Test adds Integer values to the back when empty, almost empty,
     * not empty and when buffer is larger than intial size of 10 is
     * surpassed.
     */
    @Test
    public void addBackTest() {
        list.clear();
        assertEquals(0, list.size());
        for (int i = 0; i <= ITERATIONS; i++) {
            list.addBack(i);
            // Index 0 changes everytime addFront is called
            assertEquals(i, list.get(list.size() - 1));
        }
    }

    /**
     * Test adds Integer values at specific index when empty, almost
     * empty,not empty and when buffer is larger than intial size of
     * 10 is surpassed.
     */
    @Test
    public void addTest() {
        list.clear();
        assertEquals(0, list.size());
        for (int i = 0; i <= ITERATIONS; i++) {
            list.add(i, i);
            // Index at i incrementing
            assertEquals(i, list.get(i));
        }

        for (int i = ITERATIONS; i >= 0; i--) {
            list.add(i, i);
            // Index at i decrementing
            assertEquals(i, list.get(i));
        }

        //IndexOutOfBoundsException is thrown if -1 is called
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    list.add(-1, ITERATIONS);
                });

        //IndexOutOfBoundsException is thrown if index larger than
        // the amount of indices is called
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    list.add(list.size() + 1, ITERATIONS);
                });
    }

    /**
     * Test removes Integer values from the front of ArrayIntList when
     * empty, almost empty and not empty
     */
    @Test
    public void removeFrontTest() {
        list.clear();
        assertEquals(0, list.size());

        //test with empty array
        list.removeFront();
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    list.get(0);
                });
        assertTrue(list.isEmpty());

        //test with 1 value in array
        list.addFront(ITERATIONS);
        list.removeFront();
        assertTrue(list.isEmpty());

        for (int i = 0; i <= ITERATIONS; i++) {
            list.add(i, i);
        }
        for (int i = 0; i < ITERATIONS; i++) {
            int removedValue = list.get(1);
            list.removeFront();
            assertEquals(removedValue, list.get(0));
        }
    }

    /**
     * Test removes Integer values from the front of ArrayIntList when
     * empty, almost empty and not empty
     */
    @Test
    public void removeBackTest() {
        list.clear();
        assertEquals(0, list.size());

        //test with empty array
        list.removeBack();
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    list.get(0);
                });
        assertTrue(list.isEmpty());

        //test with 1 value in array
        list.addFront(ITERATIONS);
        list.removeBack();
        assertTrue(list.isEmpty());

        //Finish this for removed
//        for (int i = 0; i <= ITERATIONS; i++) {
//            array.add(i, i);
//        }
//        for (int i = 0; i < ITERATIONS; i++) {
//            int removedValue = array.get(1);
//            array.removeFront();
//            assertEquals(removedValue, array.get(0));
//        }
    }

    /**
     * Test removes Integer values at specific index when empty, almost
     * empty,not empty and when buffer is larger than intial size of
     * 10 is surpassed.
     */
    @Test
    public void removeTest() {
        list.clear();
        assertEquals(0, list.size());

        //test with empty array
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    list.get(0);
                });
        assertTrue(list.isEmpty());

        //test with index higher than size of array
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    list.get(list.size());
                });
        assertTrue(list.isEmpty());

        //test with one value in array
        list.addFront(0);
        list.remove(0);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        for (int i = 0; i <= ITERATIONS; i++) {
            list.add(i, i);
        }
        for (int i = 0; i < ITERATIONS; i++) {
            int removedValue = list.get(1);
            list.remove(0);
            assertEquals(removedValue, list.get(0));
        }
    }

    /**
     * Test get method returns for empty, almost empty
     * and exception throw due to Index out of bounds
     */
    @Test
    public void getTest() {
        list.clear();
        assertEquals(0, list.size());

        //test with empty array
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    list.get(0);
                });
        assertTrue(list.isEmpty());

        //test with index greater than size of array
        //test with empty array
        exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    list.get(1);
                });
        assertTrue(list.isEmpty());

        //reassign values
        this.fillArray(list);

        //test the return values of get()
        for (int i = 0; i <= ITERATIONS; i++) {
            int getValue = list.get(i);
            assertEquals(getValue, list.get(i));
        }
    }

    /**
     * Test contains() for non-existent values, existing values,
     * against empty list
     */
    @Test
    public void containsTest() {
        list.clear();
        assertEquals(0, list.size());

        //Test if empty
        assertFalse(list.contains(ITERATIONS));

        //Test if value 1 exists
        list.add(0, 1);
        assertTrue(list.contains(1));

        //test if Iterations exists
        this.fillArray(list);
        assertTrue(list.contains(ITERATIONS));

        //test if number does not exist
        assertFalse(list.contains(80085));
    }

    /**
     * Test IndexOf() for no values, some values,
     * against empty list
     */
    @Test
    public void IndexOfTest() {
        //saftey check
        list.clear();
        assertEquals(0, list.size());

        //test bounds of IndexOf()
        assertEquals(-1, list.indexOf(-ITERATIONS));

        //test if indices match value returns of all indices
        System.out.println(list);
        for (int i = 0; i < ITERATIONS; i++) {
            list.addBack(i);
        }
        for (int i = 0; i < ITERATIONS; i++) {
            list.addBack(i);
            assertEquals(i, list.indexOf(i));
        }
    }

    /**
     * Test isEmpty() for no values, some values,
     * against empty list
     */
    @Test
    public void isEmptyTest() {
        //saftey check
        list.clear();
        assertEquals(0, list.size());

        //test against non-empty array
        this.fillArray(list);
        assertFalse(list.isEmpty());
    }

    /**
     * Test size() for no values, some values,
     * against empty list
     */
    @Test
    public void sizeTest() {
        //saftey check
        list.clear();
        assertEquals(0, list.size());

        //test against non-empty array
        for (int i = 0; i < ITERATIONS; i++) {
            list.addBack(i);
            assertEquals(i + 1, list.size());
        }
    }

    /**
     * Test clear() for no values, some values,
     * against empty list
     */
    @Test
    public void clearTest() {
        //saftey check
        list.clear();
        assertEquals(0, list.size());

        //test against non-empty array
        this.fillArray(list);
        list.clear();
        assertEquals(0, list.size());
    }

    /**
     * Helper method to fill the array in this class
     * @param arr Field array
     */
    public void fillArray(LinkedIntList arr) {
        //reassign values
        for (int i = 0; i <= ITERATIONS; i++) {
            list.addFront(i);
            // Index 0 changes everytime addFront is called
            assertEquals(i, list.get(0));
        }
    }
}
