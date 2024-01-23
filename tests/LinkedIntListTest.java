import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedIntListTest {

    LinkedIntList emptyList = new LinkedIntList();
    LinkedIntList singleValList = fillList(1);
    LinkedIntList multiValList = fillList(10);

    public LinkedIntList fillList(int numVal) {
        LinkedIntList result = new LinkedIntList();
        for(int i = numVal; i > 0; i--) {
            result.addFront(i);
        }
        return result;
    }

    public static void printList(LinkedIntList l) {
        for(int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + " ");
        }
        System.out.println(" ");
    }

    @Test
    void addFront() {
        // test for empty list
        emptyList.addFront(20);
        assertEquals(20, emptyList.get(0));

        // test for single item list
        singleValList.addFront(20);
        assertEquals(20, singleValList.get(0));

        // test for multi-item list
        multiValList.addFront(20);
        assertEquals(20, multiValList.get(0));
    }

    @Test
    void addBack() {
        // test for empty list
        emptyList.addBack(20);
        assertEquals(20, emptyList.get(singleValList.size() - 1));

        // test for single item list
        singleValList.addBack(20);
        assertEquals(20, singleValList.get(singleValList.size()) - 1);

        // test for multi-item list
        multiValList.addBack(20);
        assertEquals(20, multiValList.get(multiValList.size() - 1));
    }

    @Test
    void add() {
        // test for empty list
        emptyList.add(0,20);
        assertEquals(20, emptyList.get(0));

        // test for single item list
        singleValList.add(0,20);
        assertEquals(20, singleValList.get(0));

        // test for multi-item list
        multiValList.add(3,20);
        assertEquals(20, multiValList.get(3));
    }

    @Test
    void removeFront() {
        // test for empty list
        // unsure of how to test for a IndexOutOfBoundsException
        
        // test for single item list
        assertFalse(singleValList.isEmpty());
        singleValList.removeFront();
        assertTrue(singleValList.isEmpty());

        // test for multi-item list
        assertEquals(5, multiValList.size());
        multiValList.removeFront();
        assertEquals(4, multiValList.size());
    }

    @Test
    void removeBack() {
        // test for empty list
        // unsure of how to test for a IndexOutOfBoundsException

        // test for single item list
        assertFalse(singleValList.isEmpty());
        singleValList.removeBack();
        assertTrue(singleValList.isEmpty());

        // test for multi-item list
        assertEquals(10, multiValList.size());
        assertEquals(10, multiValList.get(multiValList.size() - 1));
        multiValList.removeBack();
        assertEquals(9, multiValList.size());
        assertEquals(9, multiValList.get(multiValList.size() - 1));
    }

    @Test
    void remove() {
        // test for empty list
        // unsure of how to test for a IndexOutOfBoundsException

        // test for single item list
        assertFalse(singleValList.isEmpty());
        singleValList.remove(0);
        assertTrue(singleValList.isEmpty());

        // test for multi-item list
        assertEquals(10, multiValList.size());
        assertEquals(6, multiValList.get(5));
        multiValList.remove(5);
        assertEquals(9, multiValList.size());
        assertEquals(7, multiValList.get(5));
    }

    @Test
    void get() {
        // test for empty list

        // test for single item list
        assertEquals(1, singleValList.get(0));

        // test for multi-item list
        assertEquals(5, multiValList.get(4));
    }

    @Test
    void contains() {
        // test for empty list
        assertFalse(emptyList.contains(5));
        emptyList.addFront(5);
        assertTrue(emptyList.contains(5));

        // test for single item list
        assertFalse(singleValList.contains(10));
        assertTrue(singleValList.contains(1));

        // test for multi-item list
        assertFalse(multiValList.contains(11));
        assertTrue(multiValList.contains(8));
    }

    @Test
    void indexOf() {
        // test for empty list (currently returns -1 if empty)
        assertEquals(-1, emptyList.indexOf(21));

        // test for single item list
        assertEquals(0, singleValList.indexOf(1));

        // test for multi-item list
        assertEquals(7, multiValList.indexOf(8));
    }

    @Test
    void isEmpty() {
        // test for empty list
        assertTrue(emptyList.isEmpty());

        // test for single item list
        assertFalse(singleValList.isEmpty());

        // test for multi-item list
        assertFalse(multiValList.isEmpty());
    }

    @Test
    void size() {
        // test for empty list
        assertEquals(0, emptyList.size());

        // test for single item list
        assertEquals(1, singleValList.size());

        // test for multi-item list
        multiValList.addFront(20);
        assertEquals(5, multiValList.size());
    }

    @Test
    void clear() {
        // empty list already contains no values so the method wouldn't change anything
        
        // test for single item list
        assertFalse(singleValList.isEmpty());
        singleValList.clear();
        assertTrue(singleValList.isEmpty());
        
        // test for multi-item list
        assertFalse(multiValList.isEmpty());
        multiValList.clear();
        assertTrue(multiValList.isEmpty());
    }
}