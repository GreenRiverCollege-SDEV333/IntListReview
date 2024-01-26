import org.junit.Test;
import static org.junit.Assert.*;

public class DoublyLinkedIntListTests {

    @Test
    public void testAddFront() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addFront(1);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void testAddFrontEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addFront(10);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    public void testAddBack() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addBack(1);
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void testAddBackEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addBack(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    public void testAdd() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.add(0, 1);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void testAddEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.add(0, 10);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    public void testRemoveFront() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.removeFront();
        assertEquals(1, list.size());
        assertEquals(2, list.get(0));
    }

    @Test
    public void testRemoveBack() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.removeBack();
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void testRemove() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.remove(0);
        assertEquals(1, list.size());
        assertEquals(2, list.get(0));
    }

    @Test
    public void testRemoveEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    public void testGet() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        assertEquals(2, list.get(1));
    }

    @Test
    public void testGetEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testContains() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        assertTrue(list.contains(1));
        assertFalse(list.contains(3));
    }

    @Test
    public void testContainsEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        assertFalse(list.contains(1));
    }

    @Test
    public void testIndexOf() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        assertEquals(-1, list.indexOf(2));
        assertEquals(-1, list.indexOf(3));
    }

    @Test
    public void testIndexOfEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        assertEquals(-1, list.indexOf(1));
    }

    @Test
    public void testIsEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyNotEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addBack(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        assertEquals(2, list.size());
    }

    @Test
    public void testSizeEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        assertEquals(0, list.size());
    }

    @Test
    public void testClear() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClearEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIterator() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);

        int[] expectedValues = {1, 2, 3};
        int index = 0;

        for (int value : list) {
            assertEquals(expectedValues[index], value);
            index++;
        }
    }

    @Test
    public void testIteratorEmpty() {
        DoublyLinkedIntList list = new DoublyLinkedIntList();
        assertFalse(list.iterator().hasNext());
    }
}
