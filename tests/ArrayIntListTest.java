import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {
    /**
     * Create ArrayIntList at start
     */
    private final ArrayIntList testArrayIntList = new ArrayIntList();

    /**
     * The default max capacity of buffer, at creation
     */
    private final int DEFAULT_BUFFER_LENGTH = 10;

    /**
     * The first index in buffer is 0
     */
    private final int FIRST_INDEX = 0;

    /**
     * The value returned by methods if value not found
     */
    private final int INVALID_INDEX = -1;

    /**
     * The standard filler value added to buffer prior to testing method
     */
    private final int FILLER_VALUE = 5;

    /**
     * The standard value used to test methods
     */
    private final int TEST_VALUE = 20;

    @Test
    void addFront_bufferContainsOneValue_addedSuccessfully() {
        // add initial value
        testArrayIntList.addBack(FILLER_VALUE);

        // add expected value to front
        testArrayIntList.addFront(TEST_VALUE);

        // ensure expected value is at index 0
        assertEquals(TEST_VALUE, testArrayIntList.get(FIRST_INDEX));
    }

    @Test
    void addFront_bufferContainsMultipleValues_addedSuccessfully() {
        // add several initial values
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);

        // add expected value to front
        testArrayIntList.addFront(TEST_VALUE);

        // ensure expected value is at index 0
        assertEquals(TEST_VALUE, testArrayIntList.get(FIRST_INDEX));
    }

    @Test
    void addFront_bufferEmpty_addedSuccessfully() {
        testArrayIntList.addFront(TEST_VALUE);

        // ensure expected value is at index 0
        assertEquals(TEST_VALUE, testArrayIntList.get(FIRST_INDEX));
    }

    @Test
    void addFront_bufferFull_addedSuccessfully() {
        // add 10 values to buffer
        for(int i = 0; i < DEFAULT_BUFFER_LENGTH; i++) {
            testArrayIntList.addBack(FILLER_VALUE);
        }

        // add 11th value to front
        testArrayIntList.addFront(TEST_VALUE);

        // ensure expected value is at index 0
        assertEquals(TEST_VALUE, testArrayIntList.get(FIRST_INDEX));

    }

    @Test
    void addBack_bufferContainsOneValue_addedSuccessfully() {
        // add initial value
        testArrayIntList.addFront(FILLER_VALUE);

        // add expected value to back
        testArrayIntList.addBack(TEST_VALUE);

        // ensure expected value is at final index
        assertEquals(TEST_VALUE, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void addBack_bufferContainsMultipleValues_addedSuccessfully() {
        // add several initial values
        testArrayIntList.addFront(FILLER_VALUE);
        testArrayIntList.addFront(FILLER_VALUE);
        testArrayIntList.addFront(FILLER_VALUE);

        // add expected value to back
        testArrayIntList.addBack(TEST_VALUE);

        // ensure expected value is at final index
        assertEquals(TEST_VALUE, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void addBack_bufferEmpty_addedSuccessfully() {
        testArrayIntList.addBack(TEST_VALUE);

        // ensure the expected value is at final index
        assertEquals(TEST_VALUE, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void addBack_bufferFull_addedSuccessfully() {
        // add 10 values to buffer
        for(int i = 0; i < DEFAULT_BUFFER_LENGTH; i++) {
            testArrayIntList.addFront(FILLER_VALUE);
        }

        // add 11th value to back
        testArrayIntList.addBack(TEST_VALUE);

        // ensure expected value is at final index
        assertEquals(TEST_VALUE, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void add_bufferContainsOneValue_addedSuccessfully() {
        // add initial value
        testArrayIntList.addBack(FILLER_VALUE);

        // add expected value to buffer
        testArrayIntList.add(1, TEST_VALUE);

        // ensure expected value is at final index
        assertEquals(TEST_VALUE, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void add_bufferContainsMultipleValues_addedSuccessfully() {
        // add several initial values
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);

        // add expected value somewhere in buffer
        testArrayIntList.add(2, TEST_VALUE);

        // ensure expected value is at middle index
        assertEquals(TEST_VALUE, testArrayIntList.get(2));
    }

    @Test
    void add_bufferEmpty_addedSuccessfully() {
        testArrayIntList.add(0, TEST_VALUE);

        // ensure the expected value is at final index
        assertEquals(TEST_VALUE, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void add_bufferFull_addedSuccessfully() {
        // add 10 values to buffer
        for(int i = 0; i < DEFAULT_BUFFER_LENGTH; i++) {
            testArrayIntList.addBack(FILLER_VALUE);
        }

        // add 11th value to buffer
        testArrayIntList.add(2, TEST_VALUE);

        // ensure expected value is at final index
        assertEquals(TEST_VALUE, testArrayIntList.get(2));
    }

    @Test
    void add_invalidIndexNegative_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to add value at invalid index
            testArrayIntList.add(-1, TEST_VALUE);
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
            testArrayIntList.add(1, TEST_VALUE);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeFront_bufferContainsOneValue_removedSuccessfully() {
        // add value to remove
        testArrayIntList.addFront(TEST_VALUE);

        // attempt to remove front value from buffer
        testArrayIntList.removeFront();

        // ensure buffer is now empty
        assertTrue(testArrayIntList.isEmpty());
    }

    @Test
    void removeFront_bufferContainsMultipleValues_removedSuccessfully() {
        // add several initial values
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);

        // add value to remove
        testArrayIntList.addFront(TEST_VALUE);

        // attempt to remove front value from buffer
        testArrayIntList.removeFront();

        // ensure value was removed from buffer
        assertNotEquals(TEST_VALUE, testArrayIntList.get(FIRST_INDEX));
        assertEquals(3, testArrayIntList.size());
    }

    @Test
    void removeFront_bufferEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove value at 0
            testArrayIntList.removeFront();
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void removeBack_bufferContainsOneValue_removedSuccessfully() {
        // add value to remove
        testArrayIntList.addFront(TEST_VALUE);

        // attempt to remove back value from buffer
        testArrayIntList.removeBack();

        // ensure buffer is now empty
        assertTrue(testArrayIntList.isEmpty());
    }

    @Test
    void removeBack_bufferContainsMultipleValues_removedSuccessfully() {
        // add several initial values
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);

        // add value to remove
        testArrayIntList.addBack(TEST_VALUE);

        // attempt to remove back value from buffer
        testArrayIntList.removeBack();

        // ensure value was removed from buffer
        assertNotEquals(TEST_VALUE, testArrayIntList.get(testArrayIntList.size()) - 1);
        assertEquals(3, testArrayIntList.size());
    }

    @Test
    void removeBack_bufferEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove value at 0
            testArrayIntList.removeBack();
        }

        catch (NoSuchElementException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void remove_bufferContainsOneValue_removedSuccessfully() {
        // add value to remove
        testArrayIntList.addBack(TEST_VALUE);

        // attempt to remove value from buffer
        assertEquals(TEST_VALUE, testArrayIntList.remove(FIRST_INDEX));

        // ensure buffer is now empty
        assertTrue(testArrayIntList.isEmpty());
    }

    @Test
    void remove_bufferContainsMultipleValues_removedSuccessfully() {
        // add several initial values
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);

        // add value to remove
        testArrayIntList.addBack(TEST_VALUE);

        // attempt to remove value from buffer
        assertEquals(TEST_VALUE, testArrayIntList.remove(testArrayIntList.size() - 1));

        // ensure value was removed from buffer
        assertEquals(3, testArrayIntList.size());
    }

    @Test
    void remove_bufferEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to remove value at 0
            testArrayIntList.remove(FIRST_INDEX);
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
            // attempt to remove value at invalid index
            testArrayIntList.remove(-1);
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
            // attempt to remove value at invalid index
            testArrayIntList.remove(1);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void get_bufferContainsOneValue_returnsValue() {
        // add expected value to buffer
        testArrayIntList.addFront(TEST_VALUE);

        // attempt to retrieve expected value
        assertEquals(TEST_VALUE, testArrayIntList.get(FIRST_INDEX));
    }

    @Test
    void get_bufferContainsMultipleValues_returnsValue() {
        // add several initial values
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);

        // add value to retrieve
        testArrayIntList.addBack(TEST_VALUE);

        // attempt to retrieve expected value
        assertEquals(TEST_VALUE, testArrayIntList.get(testArrayIntList.size() - 1));
    }

    @Test
    void get_bufferEmpty_throwsException() {
        // setup flag
        boolean exceptionThrown = false;

        try {
            // attempt to get value from empty buffer
            testArrayIntList.get(FIRST_INDEX);
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
            testArrayIntList.get(-1);
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
            testArrayIntList.get(1);
        }

        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        // check if exception was thrown
        assertTrue(exceptionThrown);
    }

    @Test
    void contains_valueExists_returnsTrue() {
        // add several initial values
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);

        // add value to check for
        testArrayIntList.addBack(TEST_VALUE);

        // check if value is in buffer
        assertTrue(testArrayIntList.contains(TEST_VALUE));
    }

    @Test
    void contains_valueNotInBuffer_returnsFalse() {
        // add several initial values
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);
        testArrayIntList.addBack(FILLER_VALUE);

        // check if value is in buffer
        assertFalse(testArrayIntList.contains(TEST_VALUE));
    }

    @Test
    void contains_bufferEmpty_returnsFalse() {
        assertFalse(testArrayIntList.contains(TEST_VALUE));
    }

    @Test
    void indexOf_valueExists_returnsIndex() {
        // add expected value to front
        testArrayIntList.addFront(TEST_VALUE);

        // check if index matches
        assertEquals(FIRST_INDEX, testArrayIntList.indexOf(TEST_VALUE));
    }

    @Test
    void indexOf_valueInvalid_returnsInvalidIndexFlag() {
        // add values so the buffer is not empty
        testArrayIntList.addFront(FILLER_VALUE);
        testArrayIntList.addFront(FILLER_VALUE);
        testArrayIntList.addFront(FILLER_VALUE);

        // ensure invalid index flag returns
        assertEquals(INVALID_INDEX, testArrayIntList.indexOf(TEST_VALUE));
    }

    @Test
    void indexOf_bufferEmpty_returnsInvalidIndexFlag() {
        assertEquals(INVALID_INDEX, testArrayIntList.indexOf(TEST_VALUE));
    }

    @Test
    void isEmpty_bufferContainsMultipleValues_returnsFalse() {
        // add values so the buffer is not empty
        testArrayIntList.addFront(FILLER_VALUE);
        testArrayIntList.addFront(FILLER_VALUE);
        testArrayIntList.addFront(FILLER_VALUE);

        // check if buffer is empty
        assertFalse(testArrayIntList.isEmpty());
    }

    @Test
    void isEmpty_bufferFull_returnsFalse() {
        // add 10 values to buffer
        for(int i = 0; i < DEFAULT_BUFFER_LENGTH; i++) {
            testArrayIntList.addBack(FILLER_VALUE);
        }

        // check if buffer is empty
        assertFalse(testArrayIntList.isEmpty());
    }

    @Test
    void isEmpty_bufferEmpty_returnsTrue() {
        // check if buffer is empty
        assertTrue(testArrayIntList.isEmpty());
    }

    @Test
    void size_bufferContainsMultipleValues_returnsSize() {
        // add values so the buffer is not empty
        testArrayIntList.addFront(FILLER_VALUE);
        testArrayIntList.addFront(FILLER_VALUE);
        testArrayIntList.addFront(FILLER_VALUE);

        assertEquals(3, testArrayIntList.size());
    }

    @Test
    void size_bufferEmpty_returnsSize() {
        assertEquals(0, testArrayIntList.size());
    }

    @Test
    void size_bufferFull_returnsSize() {
        // add 10 values to buffer
        for(int i = 0; i < DEFAULT_BUFFER_LENGTH; i++) {
            testArrayIntList.addBack(FILLER_VALUE);
        }

        assertEquals(DEFAULT_BUFFER_LENGTH, testArrayIntList.size());
    }

    @Test
    void clear_bufferContainsMultipleValues_clearsSuccessfully() {
        // add values so the buffer is not empty
        testArrayIntList.addFront(FILLER_VALUE);
        testArrayIntList.addFront(FILLER_VALUE);
        testArrayIntList.addFront(FILLER_VALUE);

        // clear the buffer
        testArrayIntList.clear();

        assertTrue(testArrayIntList.isEmpty());
    }

    @Test
    void clear_bufferEmpty_clearsSuccessfully() {
        // clear the buffer
        testArrayIntList.clear();

        assertTrue(testArrayIntList.isEmpty());
    }

    @Test
    void clear_bufferFull_clearsSuccessfully() {
        // add 10 values to buffer
        for(int i = 0; i < DEFAULT_BUFFER_LENGTH; i++) {
            testArrayIntList.addBack(FILLER_VALUE);
        }

        // clear the buffer
        testArrayIntList.clear();

        assertTrue(testArrayIntList.isEmpty());
    }
}