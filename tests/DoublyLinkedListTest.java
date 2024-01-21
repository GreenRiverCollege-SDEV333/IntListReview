import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    DoublyLinkedList emptyList = new DoublyLinkedList();
    DoublyLinkedList singleValList = fillList(1);
    DoublyLinkedList multiValList = fillList(10);

    public DoublyLinkedList fillList(int numVal) {
        DoublyLinkedList result = new DoublyLinkedList();
        for(int i = numVal; i > 0; i--) {
            result.addFront(i);
        }
        return result;
    }

    public static void printList(DoublyLinkedList l) {
        for(int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + " ");
        }
        System.out.println(" ");
    }

    @Test
    void addFront() {
        // Test for empty list
        assertTrue(emptyList.isEmpty());
        emptyList.addFront(3);
        assertTrue(emptyList.contains(3));

        // Test for single item list
        assertFalse(singleValList.contains(3));
        singleValList.addFront(3);
        assertTrue(singleValList.contains(3));

        // Test for multi val list
        assertFalse(multiValList.contains(11));
        multiValList.addFront(11);
        assertTrue(multiValList.contains(11));
    }

    @Test
    void addBack() {
        // Test for empty list
        assertTrue(emptyList.isEmpty());
        emptyList.addBack(3);
        assertTrue(emptyList.contains(3));

        // Test for single item list
        assertFalse(singleValList.contains(3));
        singleValList.addBack(3);
        assertTrue(singleValList.contains(3));

        // Test for multi val list
        assertFalse(multiValList.contains(11));
        multiValList.addBack(11);
        assertTrue(multiValList.contains(11));
    }

    @Test
    void add() {
        // Test for empty list
        assertTrue(emptyList.isEmpty());
        emptyList.add(0, 1);
        assertEquals(1, emptyList.get(0));

        // Test for single item list
        assertEquals(1, singleValList.get(0));
        singleValList.add(0,3);
        assertEquals(3, singleValList.get(0));

        // Test for multi val list
        assertEquals(1, multiValList.get(0));
        multiValList.add(0,11);
        assertEquals(11, multiValList.get(0));
    }

    @Test
    void removeFront() {
    }

    @Test
    void removeBack() {
    }

    @Test
    void remove() {
    }

    @Test
    void get() {
    }

    @Test
    void contains() {
        // tests empty list
        assertFalse(emptyList.contains(1));

        // tests single val list
        assertFalse(singleValList.contains(30));
        assertTrue(singleValList.contains(1));

        // tests multiple val list
        assertFalse(multiValList.contains(11));
        assertTrue(multiValList.contains(7));
    }

    @Test
    void indexOf() {
    }

    @Test
    void isEmpty() {
        // tests empty list
        assertTrue(emptyList.isEmpty());

        // tests single value list
        assertFalse(singleValList.isEmpty());
    }

    @Test
    void size() {
        // tests empty list
        assertEquals(0, emptyList.size());

        // tests single val list
        assertEquals(1, singleValList.size());

        // tests multiple val list
        assertEquals(10, multiValList.size());
    }

    @Test
    void clear() {
        // tests empty list
        assertEquals(0, emptyList.size());

        // tests single val list
        assertEquals(1, singleValList.size());
        singleValList.clear();
        assertEquals(0, singleValList.size());

        // tests multiple val list
        assertEquals(10, multiValList.size());
    }

    @Test
    void iterator() {
    }
}