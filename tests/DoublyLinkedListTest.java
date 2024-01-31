import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedList list = new DoublyLinkedList();
    @Test
    void addFront() {
//          TODO  Does the method work when the data structure is empty?
                list.addFront(20);
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
                list.addFront(3000);
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
                list.addFront(2);
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 100000; i++) {
                list.addFront(i);
        }
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s



        //the displays
        int index = -1;
        for (int numbers : list) {

            System.out.println("index " + index + ": " +  numbers);
            index++;
        }
    }

    @Test
    void addBack() {
        //          TODO  Does the method work when the data structure is empty?
                list.addBack(1);
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
                list.addBack(39);
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
                list.addBack(21900);
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 2000000; i++) {
            list.addBack(i );
        }
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s



        //the displays
        int index = -1;
        for (int numbers : list) {

            System.out.println("index " + index + ": " +  numbers);
            index++;
        }
    }

    @Test
    void add() {
        //  TODO  Does the method work when the data structure is empty?
                list.add(0, 12);
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
                list.add(0,23);
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
                list.add(0,39);
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 10000; i++) {
            list.add(2, i );
        }

//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s
                //if the index is input as more than size or less than zero, it will throw out errors



        //the displays
        int index = -1;
        for (int numbers : list) {

            System.out.println("index " + index + ": " +  numbers);
            index++;
        }
    }

    @Test
    void removeFront() {
        //  TODO  Does the method work when the data structure is empty?
        list.removeFront();
        list.removeFront();
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
                list.add(0, 23);
                list.removeFront();

//          TODO Does the method work when the data structure has 2 or more items (not empty)?
                list.add(0,129);
                list.add(0,288);
                list.removeFront();
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        //FILL THE ARRAY WITH NUMBERS
        for (int i = 0; i < 2000; i++) {
                list.add(1,i);
        }
        list.removeFront();
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s
        //there are no parameters.


        //the displays
        int index = -1;
        for (int numbers : list) {

            System.out.println("index " + index + ": " +  numbers);
            index++;
        }
    }

    @Test
    void removeBack() {
        //  TODO  Does the method work when the data structure is empty?
        list.removeBack();
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront(3993);
        list.removeBack();
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront(3003);
        list.addFront(3004);
        list.removeBack();
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 10000; i++) {
            list.addBack(i);
        }
        list.removeBack();
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s
        //there are no parameters.


        //the displays
        int index = -1;
        for (int numbers : list) {

            System.out.println("index " + index + ": " +  numbers);
            index++;
        }
    }



    @Test
    void remove() {
        //  TODO  Does the method work when the data structure is empty?
        // it is a remove method, if the list is empty, it will tell the user that the list is empty .
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront(203);
        list.remove(0);
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront(3993);
        list.addFront(3434);
        list.remove(0);
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 2900; i++) {
            list.addFront(10 + i );
        }
        list.remove(334);
        list.remove(444);
        list.remove(2199);
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s
        //it will throw exceptions if the index is less than zero or if the index is more than the list.

        //the displays
        int index = -1;
        for (int numbers : list) {

            System.out.println("index " + index + ": " +  numbers);
            index++;
        }
    }

    @Test
    void get() {
        //  TODO  Does the method work when the data structure is empty?
        //it will throw an exception if the list is empty.
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront(2);
        assertEquals(2, list.get(0));
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addBack(2390);
        list.addBack(2993);
        assertEquals(2390, list.get(1));
        assertEquals(2993, list.get(2));
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 2000; i++) {
            list.addBack(i * 1);
        }
        assertEquals(99, list.get(102) );
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s

        //the displays
        int index = -1;
        for (int numbers : list) {

            System.out.println("index " + index + ": " +  numbers);
            index++;
        }
    }

    @Test
    void contains() {
        //  TODO  Does the method work when the data structure is empty?
        assertEquals(false, list.contains(239));

//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront(239);
        assertEquals(true, list.contains(239));
        assertEquals(false, list.contains(23333));

//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addBack(269);
        assertEquals(true, list.contains(269));
        assertEquals(false, list.contains(23333));

//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 10; i++) {
            list.addBack(293 + i);
        }
        assertEquals(true, list.contains(293));
        assertEquals(true, list.contains(295));
        assertEquals(true, list.contains(296));

//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s




        //the displays
        int index = -1;
        for (int numbers : list) {

            System.out.println("index " + index + ": " +  numbers);
            index++;
        }
    }

    @Test
    void indexOf() {
        //  TODO  Does the method work when the data structure is empty?
            assertEquals(-1, list.indexOf(2000));


//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront(204);
        assertEquals(0, list.indexOf(204));
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addBack(3004);
        assertEquals(1, list.indexOf(3004));
        assertEquals(-1 , list.indexOf(200));
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 200; i++) {
            list.addBack(i);
        }
        assertEquals(105, list.indexOf(103));
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s




        //the displays
        int index = -1;
        for (int numbers : list) {

            System.out.println("index " + index + ": " +  numbers);
            index++;
        }

    }

    @Test
    void isEmpty() {
        //  TODO  Does the method work when the data structure is empty?
        assertEquals(true, list.isEmpty());
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addBack(200);
        assertEquals(false, list.isEmpty());
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addBack(203);
        assertEquals(false, list.isEmpty());
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 3000; i++) {
            list.addBack(i * 238 * ( i +293 ) * 3);
        }
        assertEquals(false, list.isEmpty());
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s




        //the displays
        int index = -1;
        for (int numbers : list) {

            System.out.println("index " + index + ": " +  numbers);
            index++;
        }

    }

    @Test
    void size() {
//          TODO  Does the method work when the data structure is empty?
        assertEquals(0, list.size());
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront(203);
        assertEquals(1, list.size());
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront(39490);
        assertEquals(2, list.size());
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 304534; i++) {
            list.addFront(i);
        }
        assertEquals(304536, list.size());
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s




        //the displays
        int index = -1;
        for (int numbers : list) {

            System.out.println("index " + index + ": " +  numbers);
            index++;
        }

    }

    @Test
    void clear() {
        //  TODO  Does the method work when the data structure is empty?
        list.clear();
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront(39494);
        list.clear();
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront(3948494);
        list.clear();
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 3994; i++) {
            list.addFront(29499 * (i ^ ( 7273 * 342789) ) );
        }
        list.clear();
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s




        //the displays
        int index = -1;
        for (int numbers : list) {

            System.out.println("index " + index + ": " +  numbers);
            index++;
        }
    }
}