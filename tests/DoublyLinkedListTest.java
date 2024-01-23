/*
 * Giovan Cervantes
 * Jan 21st, 2024
 * jUnit tests for DoublyLinkedList.java
 */


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
        // Test for empty list

        // Test for single item list
        assertEquals(1, singleValList.get(0));
        singleValList.removeFront();
        assertTrue(singleValList.isEmpty());

        // Test for multi val list
        assertEquals(1, multiValList.get(0));
        multiValList.removeFront();
        assertEquals(2, multiValList.get(0));
    }

    @Test
    void removeBack() {
        // Test for empty list

        // Test for single item list
        assertEquals(1, singleValList.get(singleValList.size() - 1));
        singleValList.removeBack();
        assertTrue(singleValList.isEmpty());

        // Test for multi val list
        assertEquals(10, multiValList.get(multiValList.size() - 1));
        multiValList.removeBack();
        assertEquals(9, multiValList.get(multiValList.size() - 1));
    }

    @Test
    void remove() {
        // Test for empty list

        // Test for single item list
        assertEquals(1, singleValList.get(0));
        singleValList.remove(0);
        assertTrue(singleValList.isEmpty());

        // Test for multi val list
        assertEquals(4, multiValList.get(3));
        multiValList.remove(3);
        assertEquals(5, multiValList.get(3));
    }

    @Test
    void get() {
        // Test for empty list
        assertEquals(-1, emptyList.get(0));

        // Test for single item list
        assertEquals(1, singleValList.get(0));

        // Test for multi val list
        assertEquals(10, multiValList.get(9));
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
        // Test for empty list
        assertEquals(-1, emptyList.indexOf(5));

        // Test for single item list
        assertEquals(0, singleValList.indexOf(1));

        // Test for multi val list
        assertEquals(8, multiValList.indexOf(9));
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
        assertTrue(emptyList.isEmpty());
        emptyList.clear();

        // tests single val list
        assertEquals(1, singleValList.size());
        singleValList.clear();
        assertEquals(0, singleValList.size());

        // tests multiple val list
        assertEquals(10, multiValList.size());
        multiValList.clear();
        assertEquals(0, multiValList.size());
    }

    @Test
    void iterator() {
        // Test for empty list
        assertEquals(0, emptyList.iterator().next());

        // Test for single item list
        assertEquals(1, singleValList.iterator().next());

        // Test for multi val list
        assertEquals(1, multiValList.iterator().next());
    }
}