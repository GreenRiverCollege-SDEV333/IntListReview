import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayIntListTests {

    @Test
    public void testAddFront() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(5);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));
    }

    @Test
    public void testAddFrontEmpty() {
        ArrayIntList list = new ArrayIntList();
        list.addFront(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    public void testAddBack() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(5);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));
    }

    @Test
    public void testAddBackEmpty() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    public void testAdd() {
        ArrayIntList list = new ArrayIntList();
        list.add(0, 5);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));
    }

    @Test
    public void testAddEmpty() {
        ArrayIntList list = new ArrayIntList();
        list.add(0, 10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    public void testRemoveFront() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.removeFront();
        assertEquals(1, list.size());
        assertEquals(2, list.get(0));
    }

    @Test
    public void testRemoveBack() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.removeBack();
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void testRemove() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.remove(0);
        assertEquals(1, list.size());
        assertEquals(2, list.get(0));
    }

    @Test
    public void testRemoveEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    public void testGet() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        assertEquals(2, list.get(1));
    }

    @Test
    public void testGetEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testContains() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        assertTrue(list.contains(1));
        assertFalse(list.contains(3));
    }

    @Test
    public void testContainsEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertFalse(list.contains(1));
    }

    @Test
    public void testIndexOf() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        assertEquals(1, list.indexOf(2));
        assertEquals(-1, list.indexOf(3));
    }

    @Test
    public void testIndexOfEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertEquals(-1, list.indexOf(1));
    }

    @Test
    public void testIsEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyNotEmpty() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        assertEquals(2, list.size());
    }

    @Test
    public void testSizeEmpty() {
        ArrayIntList list = new ArrayIntList();
        assertEquals(0, list.size());
    }

    @Test
    public void testClear() {
        ArrayIntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClearEmpty() {
        ArrayIntList list = new ArrayIntList();
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIterator() {
        ArrayIntList list = new ArrayIntList();
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
        ArrayIntList list = new ArrayIntList();
        assertFalse(list.iterator().hasNext());
    }
}
