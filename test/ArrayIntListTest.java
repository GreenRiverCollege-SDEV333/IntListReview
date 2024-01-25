import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {
    @org.junit.jupiter.api.Test
    void addFront() {
        IntList list = new ArrayIntList();
        list.addFront(1);
        list.addFront(2);

        assertEquals(list.get(0), 2);

    }

    @org.junit.jupiter.api.Test
    void addBack() {
        IntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);

        assertEquals(list.get(0), 1);
    }

    @org.junit.jupiter.api.Test
    void add() {
        IntList list = new ArrayIntList();
        list.add(0, 1);
        list.add(0, 2);

        assertEquals(list.get(0),2);
        assertEquals(list.get(1),1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(4, 1));

    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        IntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);

        list.removeFront();
        assertEquals(list.get(0), 2);
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        IntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);

        list.removeBack();
        assertEquals(list.get(0), 1);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        IntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);

        int value = list.remove(1);
        assertEquals(list.get(0),1);
        assertEquals(value, 2);
        assertEquals(list.get(1),3);

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(4));

    }

    @org.junit.jupiter.api.Test
    void get() {
        IntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);

        assertEquals(list.get(1), 2);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(4));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        IntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);

        assertTrue(list.contains(1));
        assertFalse(list.contains(4));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        IntList list = new ArrayIntList();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);

        assertEquals(list.indexOf(1), 0);
        assertEquals(list.indexOf(4), -1);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        IntList list = new ArrayIntList();
        assertTrue(list.isEmpty());
        list.addBack(1);
        assertFalse(list.isEmpty());
        list.removeBack();
        assertTrue(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        IntList list = new ArrayIntList();
        assertEquals(list.size(), 0);
        list.addFront(1);
        assertEquals(list.size(), 1);
        list.removeFront();
        assertEquals(list.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void clear() {
        IntList list = new ArrayIntList();
        list.clear();
        list.addFront(1);
        list.clear();
        assertEquals(list.size(), 0);
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        IntList list = new ArrayIntList();

        int count = 0;
        for(var i : list ) count++;
        assertEquals(count, 0);

        count = 0;
        list.addFront(1);
        for(var i : list ) count++;
        assertEquals(count, 1);

        count = 0;
        list.addFront(1);
        for(var i : list ) count++;
        assertEquals(count, 2);
    }
}