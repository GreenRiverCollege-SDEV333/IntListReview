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

    @Test
    void addFront() {
        emptyList.addFront(3);
        assertFalse(emptyList.isEmpty());
    }

    @Test
    void addBack() {
    }

    @Test
    void add() {
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