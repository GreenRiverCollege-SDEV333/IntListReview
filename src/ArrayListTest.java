import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @org.junit.jupiter.api.Test
    void testAddFront() {
        ArrayList myArray = new ArrayList();
        myArray.addFront(3);
        assertEquals(3, myArray.get(0));
    }

    @org.junit.jupiter.api.Test
    void addBack() {
        ArrayList myArray = new ArrayList();
        myArray.addBack(1);
        assertEquals(1, myArray.get(0));
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        ArrayList list = new ArrayList();
        list.add(0, 12);
        list.add(1, 4);
        list.add(1, 6);
        assertEquals(12, list.get(0));
        assertEquals(6, list.get(1));
        assertEquals(4, list.get(2));
    }

    @org.junit.jupiter.api.Test
    void removeFront() {
        ArrayList myArray = new ArrayList();
        myArray.addFront(1);
        myArray.addFront(2);
        myArray.addFront(3);
        myArray.removeFront();
        assertEquals(2, myArray.get(0));
        assertEquals(1, myArray.get(1));
        myArray.removeFront();
        assertEquals(1,myArray.get(0));
    }

    @org.junit.jupiter.api.Test
    void removeBack() {
        //had to look this test up. super confusing but works for an empty array list.
        //how would I change this to work for checking if just the back number is removed??
        ArrayList myArray = new ArrayList();
        assertThrows(IndexOutOfBoundsException.class, myArray::removeBack);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        ArrayList myList = new ArrayList();
        myList.addFront(1);
        myList.addFront(2);
        myList.addFront(3);
        myList.remove(1);
        assertEquals(3, myList.get(0));
        assertEquals(1, myList.get(1));
    }

    @org.junit.jupiter.api.Test
    void get() {
        ArrayList myList = new ArrayList();
        myList.addFront(1);
        myList.addFront(2);
        myList.addFront(3);
        assertEquals(3, myList.get(0));
        assertEquals(2, myList.get(1));
        assertEquals(1, myList.get(2));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        ArrayList myArray = new ArrayList();
        myArray.addFront(1);
        myArray.addFront(2);
        myArray.addFront(3);
        assertFalse(myArray.contains(5));
        assertTrue(myArray.contains(1));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        ArrayList myArray = new ArrayList();
        myArray.addFront(1);
        myArray.addFront(2);
        myArray.addFront(3);
        assertEquals(2, myArray.indexOf(1));
        assertEquals(-1, myArray.indexOf(10));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        ArrayList myArray = new ArrayList();
        assertTrue(!myArray.isEmpty());
        myArray.addFront(1);
        assertFalse(myArray.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        ArrayList myArray = new ArrayList();
        assertEquals(0, myArray.size());
        myArray.addFront(1);
        myArray.addFront(2);
        myArray.addFront(3);
        assertEquals(3, myArray.size());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        ArrayList myArray = new ArrayList();
        myArray.size();
        myArray.addFront(1);
        myArray.addFront(2);
        myArray.addFront(3);
        myArray.size();
        myArray.clear();
        myArray.size();
    }

    @org.junit.jupiter.api.Test
    void iterator() {

    }

    @org.junit.jupiter.api.Test
    void resize() {
        ArrayList myArray = new ArrayList();
        myArray.size();
        myArray.addFront(1);
        myArray.addFront(2);
        myArray.addFront(3);
        myArray.size();
        myArray.resize(6);
        myArray.size();
    }
}