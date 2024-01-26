import org.junit.Test;
import static org.junit.Assert.*;

public class SinglyLinkedIntListTests {

    @Test
    public void testAddFront() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addFront(1);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void testAddFrontEmpty() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addFront(10);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    public void testAddBack() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addBack(1);
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void testAddBackEmpty() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addBack(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    public void testAdd() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.add(0, 1);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void testAddEmpty() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.add(0, 10);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    public void testRemoveFront() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.removeFront();
        assertEquals(1, list.size());
        assertEquals(2, list.get(0));
    }

    @Test
    public void testRemoveBack() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.removeBack();
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void testRemove() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.remove(0);
        assertEquals(1, list.size());
        assertEquals(2, list.get(0));
    }

    @Test
    public void testRemoveEmpty() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    public void testGet() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        assertEquals(2, list.get(1));
    }

    @Test
    public void testGetEmpty() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testContains() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        assertTrue(list.contains(1));
        assertFalse(list.contains(3));
    }

    @Test
    public void testContainsEmpty() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        assertFalse(list.contains(1));
    }

    @Test
    public void testIndexOf() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        assertEquals(-1, list.indexOf(2));
        assertEquals(-1, list.indexOf(3));
    }

    @Test
    public void testIndexOfEmpty() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        assertEquals(-1, list.indexOf(1));
    }

    @Test
    public void testIsEmpty() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyNotEmpty() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addBack(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        assertEquals(2, list.size());
    }

    @Test
    public void testSizeEmpty() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        assertEquals(0, list.size());
    }

    @Test
    public void testClear() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.addBack(1);
        list.addBack(2);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClearEmpty() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIterator() {
        SinglyLinkedIntList list = new SinglyLinkedIntList();
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
        SinglyLinkedIntList list = new SinglyLinkedIntList();
        assertFalse(list.iterator().hasNext());
    }
}
