import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest
{

    @Test
    void testAddFront()
    {
        ArrayIntList list = new ArrayIntList();

        //test when the data structure is empty
        list.addFront(5);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));

        //test when the data structure has one item
        list.addFront(10);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(5, list.get(1));

        //test when the data structure has 2 or more items
        list.addFront(15);
        assertEquals(3, list.size());
        assertEquals(15, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(5, list.get(2));
    }

    @Test
    void testAddBack()
    {
        ArrayIntList list = new ArrayIntList();

        //test when the data structure is empty
        list.addBack(5);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));

        //test when the data structure has one item
        list.addBack(10);
        assertEquals(2, list.size());
        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));

        //test when the data structure has 2 or more items
        list.addBack(15);
        assertEquals(3, list.size());
        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(15, list.get(2));
    }

    @Test
    void testRemoveFront()
    {
        ArrayIntList list = new ArrayIntList();

        //test when the data structure is empty
        assertDoesNotThrow(list::removeFront);

        //test when the data structure has one item
        list.addFront(5);
        assertDoesNotThrow(list::removeFront);
        assertTrue(list.isEmpty());

        //test when the data structure has 2 or more items
        list.addBack(10);
        list.addBack(15);
        assertDoesNotThrow(list::removeFront);
        assertEquals(1, list.size());
        assertEquals(15, list.get(0));
    }

    @Test
    void testRemoveBack()
    {
        ArrayIntList list = new ArrayIntList();

        //test when the data structure is empty
        assertDoesNotThrow(list::removeBack);

        //test when the data structure has one item
        list.addFront(5);
        assertDoesNotThrow(list::removeBack);
        assertTrue(list.isEmpty());

        //test when the data structure has 2 or more items
        list.addBack(10);
        list.addBack(15);
        assertDoesNotThrow(list::removeBack);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void testRemove()
    {
        ArrayIntList list = new ArrayIntList();

        //test when the data structure is empty
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));

        //test when the data structure has one item
        list.addFront(5);
        assertDoesNotThrow(() -> list.remove(0));
        assertTrue(list.isEmpty());

        //test when the data structure has 2 or more items
        list.addBack(10);
        list.addBack(15);
        assertDoesNotThrow(() -> list.remove(1));
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));

        //test when the data structure is "full"
        list.addBack(20);
        list.addBack(25);
        list.addBack(30);
        list.addBack(35);
        assertDoesNotThrow(() -> list.remove(2));
        assertEquals(4, list.size());
        assertEquals(20, list.get(2));

        //test with invalid parameter values
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    void testGet()
    {
        ArrayIntList list = new ArrayIntList();

        //test when the data structure is empty
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));

        //test when the data structure has one item
        list.addFront(5);
        assertEquals(5, list.get(0));

        //test when the data structure has 2 or more items
        list.addBack(10);
        list.addBack(15);
        assertEquals(10, list.get(1));

        //test with invalid parameter values
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void testContains()
    {
        ArrayIntList list = new ArrayIntList();

        //test when the data structure is empty
        assertFalse(list.contains(5));

        //test when the data structure has one item
        list.addFront(5);
        assertTrue(list.contains(5));

        //test when the data structure has 2 or more items
        list.addBack(10);
        list.addBack(15);
        assertTrue(list.contains(10));
        assertFalse(list.contains(20));
    }

    @Test
    void testIndexOf()
    {
        ArrayIntList list = new ArrayIntList();

        //test when the data structure is empty
        assertEquals(-1, list.indexOf(5));

        //test when the data structure has one item
        list.addFront(5);
        assertEquals(0, list.indexOf(5));

        //test when the data structure has 2 or more items
        list.addBack(10);
        list.addBack(15);
        assertEquals(1, list.indexOf(10));
        assertEquals(-1, list.indexOf(20));
    }

    @Test
    void testIsEmpty()
    {
        ArrayIntList list = new ArrayIntList();

        //test when the data structure is empty
        assertTrue(list.isEmpty());

        //test when the data structure has one item
        list.addFront(5);
        assertFalse(list.isEmpty());

        //test when the data structure has 2 or more items
        list.addBack(10);
        list.addBack(15);
        assertFalse(list.isEmpty());
    }

    @Test
    void testSize()
    {
        ArrayIntList list = new ArrayIntList();

        //test when the data structure is empty
        assertEquals(0, list.size());

        //test when the data structure has one item
        list.addFront(5);
        assertEquals(1, list.size());

        //test when the data structure has 2 or more items
        list.addBack(10);
        list.addBack(15);
        assertEquals(3, list.size());
    }

    @Test
    void testClear()
    {
        ArrayIntList list = new ArrayIntList();

        //test when the data structure is empty
        list.clear();
        assertTrue(list.isEmpty());

        //test when the data structure has one item
        list.addFront(5);
        list.clear();
        assertTrue(list.isEmpty());

        //test when the data structure has 2 or more items
        list.addBack(10);
        list.addBack(15);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void testIterator()
    {
        ArrayIntList list = new ArrayIntList();

        //test when the data structure is empty
        assertFalse(list.iterator().hasNext());

        //test when the data structure has one item
        list.addFront(5);
        assertTrue(list.iterator().hasNext());

        //test when the data structure has 2 or more items
        list.addBack(10);
        list.addBack(15);
        assertTrue(list.iterator().hasNext());
    }
}
