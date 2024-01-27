import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest {
    ArrayIntList list = new ArrayIntList();
    @Test
    void addFront() {
//          TODO  Does the method work when the data structure is empty?
            list.addFront(1);
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
            list.addFront(1);
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
            list.addFront(1);
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
            for (int i = 0; i < 100; i++) {
                list.addFront(1);
            } //it works but very slow...
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s
            list.addFront(0);


        //the displays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index " + i + ": " + list.get(i));
        }
    }

    @Test
    void addBack() {
        //          TODO  Does the method work when the data structure is empty?
        list.addBack(1);
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addBack(1);
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addBack(1);
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 100; i++) {
            list.addBack(i);
        } //it works but very slow...
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s
        list.addBack(0);


        //the displays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index " + i + ": " + list.get(i));
        }
    }

    @Test
    void add() {
        //  TODO  Does the method work when the data structure is empty?
            list.add(2,399);
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
            list.add(1,1);
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
            list.add(2,100);
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        //FILL THE ARRAY WITH NUMBERS
        for (int i = 0; i < 200; i++) {
            list.addBack(2382 * i /23 *  23);
        }
        list.add(23,29929393);
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s
            list.add(-2,333);
            list.add(3000, 300);
            //if the index is out of index, it will through an exceptions

        //the displays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index " + i + ": " + list.get(i));
        }
    }

    @Test
    void removeFront() {
        //  TODO  Does the method work when the data structure is empty?
                //it will throw an exception if the list is empty.
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
            list.addFront(2);
            list.removeFront();

//          TODO Does the method work when the data structure has 2 or more items (not empty)?
            list.addFront(3);
            list.removeFront();
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        //FILL THE ARRAY WITH NUMBERS
            for (int i = 0; i < 200; i++) {
                list.addBack(2382 * i /23 *  23);
            }
            list.removeFront();
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s
            //there are no parameters.


        //the displays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index " + i + ": " + list.get(i));
        }
    }

    @Test
    void removeBack() {
        //  TODO  Does the method work when the data structure is empty?
        //it will throw an exception if the list is empty.
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront(2);
        list.removeBack();

//          TODO Does the method work when the data structure has 2 or more items (not empty)?
        list.addFront(3);
        list.removeBack();
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        //FILL THE ARRAY WITH NUMBERS
        for (int i = 0; i < 200; i++) {
            list.addBack(2382 * i /23 *  23);
        }
        list.removeBack();
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s
        //there are no parameters.


        //the displays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index " + i + ": " + list.get(i));
        }
    }



    @Test
    void remove() {
        //  TODO  Does the method work when the data structure is empty?

        //it will throw an exception if the list is empty.
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
            list.addFront(2);
            list.remove(0);
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
            list.addBack(1);
            list.addBack(2);
            list.remove(1);
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        //FILL THE ARRAY WITH NUMBERS
        for (int i = 0; i < 2000; i++) {
            list.addBack(200 + i );
        }
            list.remove(34);
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s
        //there are no parameters.
                list.remove(-1);
                //it will throw exception if there is negative indexes.

        //the displays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index " + i + ": " + list.get(i));
        }
    }

    @Test
    void get() {
        //  TODO  Does the method work when the data structure is empty?

        //it will throw an exception if the list is empty.
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
        list.addFront(21);
        assertEquals(21, list.get(0));
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
            list.addBack(23);
            assertEquals(23, list.get(1));
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 2000; i++) {
            list.addBack(i *238482);
        }
            assertEquals(68205852, list.get(288));
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s
            list.get(-2);
            list.get(3000);
            //if the index is less than zero or more than the index, it will throw IndexOutOfBound exception


        //the displays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index " + i + ": " + list.get(i));
        }
    }

    @Test
    void contains() {
        //  TODO  Does the method work when the data structure is empty?
        //it will throw an exception if the list is empty.
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
            list.addBack(2);
            assertEquals(true, list.contains(2));
            assertEquals(false, list.contains(3000));
//          TODO Does the method work when the data structure has 2 or more items (not empty)?
            list.addBack(34);
            assertEquals(true, list.contains(34));
            assertEquals(false,list.contains(20000) );
//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?
        for (int i = 0; i < 2000; i++) {
            list.addBack(3123478 * i + (i * i +1) );
        }
            assertEquals(true, list.contains(1693218841));
            assertEquals(false, list.contains(2003));
//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s




        //the displays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index " + i + ": " + list.get(i));
        }
    }

    @Test
    void indexOf() {
        //  TODO  Does the method work when the data structure is empty?
        //it will throw an exception if the list is empty.

//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?
            list.addBack(30);
            assertEquals(0, list.indexOf(30));
//          TODO Does the method work when the data structure has 2 or more items (not empty)?

//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?

//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s




        //the displays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index " + i + ": " + list.get(i));
        }

    }

    @Test
    void isEmpty() {
        //  TODO  Does the method work when the data structure is empty?
        //it will throw an exception if the list is empty.
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?

//          TODO Does the method work when the data structure has 2 or more items (not empty)?

//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?

//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s




        //the displays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index " + i + ": " + list.get(i));
        }

    }

    @Test
    void size() {
        //  TODO  Does the method work when the data structure is empty?
        //it will throw an exception if the list is empty.
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?

//          TODO Does the method work when the data structure has 2 or more items (not empty)?

//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?

//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s




        //the displays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index " + i + ": " + list.get(i));
        }

    }

    @Test
    void clear() {
        //  TODO  Does the method work when the data structure is empty?
        //it will throw an exception if the list is empty.
//          TODO Does the method work when the data structure has one item (almost empty, but not empty)?

//          TODO Does the method work when the data structure has 2 or more items (not empty)?

//          TODO Does the method work when the data structure is "full" (if "full" is a possibility)?

//          TODO Does the method handle invalid parameter values? (and throws exceptions as appropriate)s




        //the displays
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index " + i + ": " + list.get(i));
        }

    } 
}