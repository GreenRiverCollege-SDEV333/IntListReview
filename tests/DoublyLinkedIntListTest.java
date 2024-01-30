import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedIntListTest {
    /**
     * Create LinkedIntList at start
     */
    private final DoublyLinkedIntList testDoublyLinkedIntList = new DoublyLinkedIntList();

    /**
     * The first index in list is 0
     */
    private final int FIRST_INDEX = 0;

    /**
     * The value returned by methods if value not found
     */
    private final int INVALID_INDEX = -1;

    /**
     * The standard filler value added to container prior to testing method
     */
    private final int FILLER_VALUE = 5;

    /**
     * The standard value used to test methods
     */
    private final int TEST_VALUE = 20;

    @Test
    void addFront_listContainsNode_addedSuccessfully() {
        // add initial values
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        // add test value
        testDoublyLinkedIntList.addFront(TEST_VALUE);

        // ensure expected value is at index 0
        assertEquals(TEST_VALUE, testDoublyLinkedIntList.get(FIRST_INDEX));
    }

    @Test
    void addFront_listContainsMultipleNodes_addedSuccessfully() {
        // add several initial values
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        // add test value
        testDoublyLinkedIntList.addFront(TEST_VALUE);

        // ensure expected value is at index 0
        assertEquals(TEST_VALUE, testDoublyLinkedIntList.get(FIRST_INDEX));
    }

    @Test
    void addFront_listEmpty_addedSuccessfully() {
        // make test value new head
        testDoublyLinkedIntList.addFront(TEST_VALUE);

        // ensure expected value is at index 0
        assertEquals(TEST_VALUE, testDoublyLinkedIntList.get(FIRST_INDEX));
    }

    @Test
    void addBack_listContainsNode_addedSuccessfully() {
        // add initial value
        testDoublyLinkedIntList.addFront(FILLER_VALUE);

        // add test value
        testDoublyLinkedIntList.addBack(TEST_VALUE);

        // ensure expected value is at end of list
        assertEquals(TEST_VALUE, testDoublyLinkedIntList.get(testDoublyLinkedIntList.size() - 1));
    }

    @Test
    void addBack_listContainsMultipleNodes_addedSuccessfully() {
        // add several initial values
        testDoublyLinkedIntList.addFront(FILLER_VALUE);
        testDoublyLinkedIntList.addFront(FILLER_VALUE);
        testDoublyLinkedIntList.addFront(FILLER_VALUE);

        // add test value
        testDoublyLinkedIntList.addBack(TEST_VALUE);

        // ensure expected value is at end of list
        assertEquals(TEST_VALUE, testDoublyLinkedIntList.get(testDoublyLinkedIntList.size() - 1));
    }

    @Test
    void addBack_listEmpty_addedSuccessfully() {
        // make test value new tail
        testDoublyLinkedIntList.addBack(TEST_VALUE);

        // ensure expected value is at end of list
        assertEquals(TEST_VALUE, testDoublyLinkedIntList.get(testDoublyLinkedIntList.size() - 1));
    }

    @Test
    void add_listContainsNode_addedSuccessfully() {
        // add initial value
        testDoublyLinkedIntList.addFront(FILLER_VALUE);

        // add test value
        testDoublyLinkedIntList.add(FIRST_INDEX + 1, TEST_VALUE);

        // ensure expected value is at expected index
        assertEquals(TEST_VALUE, testDoublyLinkedIntList.get(FIRST_INDEX + 1));
    }

    @Test
    void add_listContainsMultipleNodes_addedSuccessfully() {
        // add several initial values
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        // add test value
        testDoublyLinkedIntList.add(2, TEST_VALUE);

        // ensure expected value is at expected index
        assertEquals(TEST_VALUE, testDoublyLinkedIntList.get(2));
    }

    @Test
    void add_listEmpty_addedSuccessfully() {
        // add test value to list
        testDoublyLinkedIntList.add(FIRST_INDEX, TEST_VALUE);

        // ensure expected value is in list
        assertEquals(TEST_VALUE, testDoublyLinkedIntList.get(FIRST_INDEX));
    }

    @Test
    void add_invalidIndexNegative_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to add value at invalid index
            testDoublyLinkedIntList.add(-1, TEST_VALUE);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void add_invalidIndexMoreThanSize_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to add value at invalid index
            testDoublyLinkedIntList.add(1, TEST_VALUE);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeFront_listContainsNode_removedSuccessfully() {
        // add value to remove
        testDoublyLinkedIntList.addFront(TEST_VALUE);

        // attempt to remove value from list
        testDoublyLinkedIntList.removeFront();

        // ensure list is now empty
        assertTrue(testDoublyLinkedIntList.isEmpty());
    }

    @Test
    void removeFront_listContainsMultipleNodes_removedSuccessfully() {
        // add several initial values
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        // add value to remove
        testDoublyLinkedIntList.addFront(TEST_VALUE);

        // attempt to remove front value from list
        testDoublyLinkedIntList.removeFront();

        // ensure value was removed from list
        assertNotEquals(TEST_VALUE, testDoublyLinkedIntList.get(FIRST_INDEX));
        assertEquals(3, testDoublyLinkedIntList.size());
    }

    @Test
    void removeFront_listEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove value at front
            testDoublyLinkedIntList.removeFront();
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeBack_listContainsNode_removedSuccessfully() {
        // add value to remove
        testDoublyLinkedIntList.addBack(TEST_VALUE);

        // attempt to remove value from list
        testDoublyLinkedIntList.removeFront();

        // ensure list is now empty
        assertTrue(testDoublyLinkedIntList.isEmpty());
    }

    @Test
    void removeBack_listContainsMultipleNodes_removedSuccessfully() {
        // add several initial values
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        // add value to remove
        testDoublyLinkedIntList.addBack(TEST_VALUE);

        // attempt to remove front value from list
        testDoublyLinkedIntList.removeBack();

        // ensure value was removed from list
        assertNotEquals(TEST_VALUE, testDoublyLinkedIntList.get(testDoublyLinkedIntList.size() - 1));
        assertEquals(3, testDoublyLinkedIntList.size());
    }

    @Test
    void removeBack_listEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove value at back
            testDoublyLinkedIntList.removeBack();
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void remove_listContainsNode_removedSuccessfully() {
        // add value to remove
        testDoublyLinkedIntList.addFront(TEST_VALUE);

        // attempt to remove value from list
        testDoublyLinkedIntList.remove(FIRST_INDEX);

        // ensure list is now empty
        assertTrue(testDoublyLinkedIntList.isEmpty());
    }

    @Test
    void remove_listContainsMultipleNodes_removedSuccessfully() {
        // add several initial values
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        // add value to remove
        testDoublyLinkedIntList.add(2, TEST_VALUE);

        // attempt to remove value from list
        testDoublyLinkedIntList.remove(2);

        // ensure value was removed from list
        assertNotEquals(TEST_VALUE, testDoublyLinkedIntList.get(2));
        assertEquals(3, testDoublyLinkedIntList.size());
    }

    @Test
    void remove_listEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove value at back
            testDoublyLinkedIntList.remove(FIRST_INDEX);
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void remove_invalidIndexNegative_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to add value at invalid index
            testDoublyLinkedIntList.remove(-1);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void remove_invalidIndexMoreThanSize_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to add value at invalid index
            testDoublyLinkedIntList.remove(1);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void get_listContainsNode_returnsValue() {
        // add expected value to list
        testDoublyLinkedIntList.addFront(TEST_VALUE);

        // attempt to retrieve expected value
        assertEquals(TEST_VALUE, testDoublyLinkedIntList.get(FIRST_INDEX));
    }

    @Test
    void get_listContainsMultipleNodes_returnsValue() {
        // add several initial values
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        // add value to retrieve
        testDoublyLinkedIntList.addBack(TEST_VALUE);

        // attempt to retrieve expected value
        assertEquals(TEST_VALUE, testDoublyLinkedIntList.get(testDoublyLinkedIntList.size() - 1));
    }

    @Test
    void get_listEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to get value from empty list
            testDoublyLinkedIntList.get(FIRST_INDEX);
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void get_invalidIndexNegative_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to get value from invalid index
            testDoublyLinkedIntList.get(-1);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void get_invalidIndexMoreThanSize_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to get value from invalid index
            testDoublyLinkedIntList.get(1);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void contains_valueInList_returnsTrue() {
        // add several initial values
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        // add value to check for
        testDoublyLinkedIntList.addBack(TEST_VALUE);

        // check if value is in list
        assertTrue(testDoublyLinkedIntList.contains(TEST_VALUE));
    }

    @Test
    void contains_valueNotInList_returnsFalse() {
        // add several initial values
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        // check if value is in list
        assertFalse(testDoublyLinkedIntList.contains(TEST_VALUE));
    }

    @Test
    void contains_listEmpty_returnsFalse() {
        assertFalse(testDoublyLinkedIntList.contains(TEST_VALUE));
    }

    @Test
    void indexOf_valueExists_returnsIndex() {
        // add expected value to front
        testDoublyLinkedIntList.addFront(TEST_VALUE);

        // check if index matches
        assertEquals(FIRST_INDEX, testDoublyLinkedIntList.indexOf(TEST_VALUE));
    }

    @Test
    void indexOf_valueInvalid_returnsInvalidIndexFlag() {
        // add values so list is not empty
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        // ensure invalid index flag returns
        assertEquals(INVALID_INDEX, testDoublyLinkedIntList.indexOf(TEST_VALUE));
    }

    @Test
    void indexOf_listEmpty_returnsInvalidIndexFlag() {
        assertEquals(INVALID_INDEX, testDoublyLinkedIntList.indexOf(TEST_VALUE));
    }

    @Test
    void isEmpty_listContainsMultipleNodes_returnsSize() {
        // add values so the list is not empty
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        // check if list is empty
        assertFalse(testDoublyLinkedIntList.isEmpty());
    }

    @Test
    void isEmpty_listEmpty_returnsSize() {
        // ensure list is empty
        assertTrue(testDoublyLinkedIntList.isEmpty());
    }

    @Test
    void size_listContainsMultipleNodes_returnsSize() {
        // add values so the list is not empty
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        assertEquals(3, testDoublyLinkedIntList.size());
    }

    @Test
    void size_listEmpty_returnsSize() {
        assertEquals(0, testDoublyLinkedIntList.size());
    }

    @Test
    void clear_listContainsMultipleNodes_clearsSuccessfully() {
        // add values so list is not empty
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);
        testDoublyLinkedIntList.addBack(FILLER_VALUE);

        // clear the list
        testDoublyLinkedIntList.clear();

        // ensure list is empty
        assertTrue(testDoublyLinkedIntList.isEmpty());
    }

    @Test
    void clear_listEmpty_clearsSuccessfully() {
        // clear the list
        testDoublyLinkedIntList.clear();

        // ensure list is empty
        assertTrue(testDoublyLinkedIntList.isEmpty());
    }
}