import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIntList implements IntList
{

    //define what a node is
    private class Node
    {
        int data;
        Node next;
    }

    //set up the head of the list
    private Node head;

    //set up the size field
    private int size;

    //constructor
    public LinkedIntList()
    {
        head = null;
        size = 0;
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value)
    {
        //set up a new node
        Node theNewOne = new Node();

        if (head == null)
        {
            //the list is currently empty
            head = theNewOne;
            size++;
        }
        else
        {
            //the list currently has nodes in it
            theNewOne.next = head;
            head = theNewOne;
            size++;
        }
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value)
    {
        //set up a new node
        Node theNewOne = new Node();

        //getting an iterator set up
        SinglyLinkedIterator iterator = new SinglyLinkedIterator();

        //as long as there's another node, scoot the iterator forward along the list.
        while(iterator.hasNext())
        {
            iterator.current = iterator.current.next;
        }

        //if the iterator can't move forward, then put the new Node into that empty space.
        if(!iterator.hasNext())
        {
            iterator.current.next = theNewOne;
            size++;
        }
    }

    /**
     * Inserts the specified value at the specified position in this list.
     * Shifts the value currently at that position (if any) and any subsequent
     * values to the right.
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value)
    {
        //setting up a size variable and an iterator to walk through the list
        int currentIndex = 0;
        SinglyLinkedIterator iterator = new SinglyLinkedIterator();

        //as long as the next index isn't the one where the new value belongs AND the next index exists, move forward.
        while (currentIndex != index + 1 && iterator.hasNext())
        {
            iterator.current = iterator.current.next;
            currentIndex++;
        }
        //if the next index IS the one where the value belongs, then create a new node there and link it to the old
        //"next".
        if (currentIndex + 1 == index)
        {
            //to start, create a new Node. link it up to the current "next" node.
            Node theNewOne = new Node();
            theNewOne.next = iterator.current.next;

            //now, link up the current Node to the newly-created "next" node.
            iterator.current.next = theNewOne;

            //I hope it's that simple...
            //wait, increment the size.
            size++;
        }
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront()
    {
        //Re-wire "head" to point to the Node in front of the node to be removed, then... let the GC grab it?
        //I think...
        if (head == null)
        {
            System.out.println("Empty list! Sorry!");
        }
        else
        {
            //storing the front node in a proper variable
            Node theOneToRemove = head.next;

            //adjusting head's pointer to point to the next one in the list
            head.next = theOneToRemove.next;

            //cutting off the old front from the rest of the list entirely
            theOneToRemove.next = null;

            //decrement the size...
            size--;
        }
    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack()
    {
        //so, check if the Node in front of the current one's "next" field is null? And if it is, that must be the
        //back of the list. In which case, cut off the current one's "next" field so that the old "back" floats off
        //and gets eaten by the GC.
        SinglyLinkedIterator iterator = new SinglyLinkedIterator();

        //as long as the Node in front of this one doesn't have a null pointer...
        while(iterator.current.next.next != null)
        {
            //go forward.
            iterator.current = iterator.current.next;
        }

        //if we're at the second-to-last node...
        if (iterator.current.next.next == null)
        {
            //let the last node go. It's IDE food now.
            iterator.current.next = null;
        }
    }

    /**
     * Removes the value at the specified position in this list.
     * Shifts any subsequent values to the left. Returns the value
     * that was removed from the list.
     *
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int remove(int index)
    {
        if (index > size)
        {
            throw new IndexOutOfBoundsException("Provided index is too high.");
        }
        else if (index < 0)
        {
            throw new IndexOutOfBoundsException("Negative indexes are not supported.");
        }
        else
        {
            //walk through the list, keeping track of what node you're on, and when your pointer is pointing to the Node
            //you're looking for, store that Node in a variable, grab its pointer to redirect your current Node, then
            //set the stored Node's next to null so it floats away like a piece of driftwood in the ocean.

            //gonna recycle some of my solution for add(), really hoping this works since it's largely untested...

            //setting up a size variable and an iterator to walk through the list
            int currentIndex = 0;
            SinglyLinkedIterator iterator = new SinglyLinkedIterator();

            //as long as the next index isn't the index indicated AND the next index exists, move forward.
            while (currentIndex != index + 1 && iterator.hasNext())
            {
                iterator.current = iterator.current.next;
                currentIndex++;
            }
            //if the next index IS the one we're looking for, store that Node in a variable.
            if (currentIndex + 1 == index)
            {
                //store the Node in a variable.
                Node theOneToRemove = iterator.current.next;

                //from here, I need to grab the pointer from this new variable and give it to the current Node.
                iterator.current.next = theOneToRemove.next;

                //cut the stored Node's next field and return its data.
                //also decrement the list size.
                size--;
                theOneToRemove.next = null;
                return theOneToRemove.data;
            }
        }
        //otherwise, return -1, I suppose.
        return -1;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index)
    {
        if (index > size)
        {
            throw new IndexOutOfBoundsException("Provided index is too high.");
        }
        else if (index < 0)
        {
            throw new IndexOutOfBoundsException("Negative indexes are not supported.");
        }
        else
        {
            //walk through the list, keeping track of what node you're on, and when your pointer is pointing to the Node
            //you're looking for, return the Node data at that particular index.

            //gonna recycle some of my solution for add(), really hoping this works since it's largely untested...

            //setting up a size variable and an iterator to walk through the list
            int currentIndex = 0;
            SinglyLinkedIterator iterator = new SinglyLinkedIterator();

            //as long as the next index isn't the index indicated AND the next index exists, move forward.
            while (currentIndex != index + 1 && iterator.hasNext())
            {
                iterator.current = iterator.current.next;
                currentIndex++;
            }
            //if the next index IS the one we're looking for, return the data at that index.
            if (currentIndex + 1 == index)
            {
                return iterator.current.next.data;
            }
        }
        //otherwise, return -1.
        return -1;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value)
    {
        //walk through the list, keeping track of what node you're on, and if the Node you're on has the value you're
        //looking for, return true. Otherwise, return false.

        //gonna recycle some of my solution for add(), really hoping this works since it's largely untested...

        SinglyLinkedIterator iterator = new SinglyLinkedIterator();

        //as long as the next index exists, check for the value and move forward.
        while (iterator.hasNext())
        {
            if (iterator.current.data == value)
            {
                return true;
            }
            iterator.current = iterator.current.next;
        }
        //if the iterator makes it to the end of the list and didn't return true, then it's not here. return false.
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    @Override
    public int indexOf(int value)
    {

        //walk through the list, keeping track of what node you're on, and if your current Node has the data being
        //requested in it, return the currentIndex variable. Otherwise, keep going.

         //gonna recycle some of my solution for add(), really hoping this works since it's largely untested...

         //setting up a size variable and an iterator to walk through the list
         int currentIndex = 0;
         SinglyLinkedIterator iterator = new SinglyLinkedIterator();

         //as long as the next index exists, move forward.
         while (iterator.hasNext())
         {
             //check for if the value's here...
             if (iterator.current.data == value)
             {
                 //if it is, return the current index.
                 return currentIndex;
             }
             else
             {
                 //if it isn't, iterate the current index instead.
                 currentIndex++;
             }
             //then move forward.
            iterator.current = iterator.current.next;

         }
         //if it isn't found by the time the iterator reaches the end of the list it's not here. return -1.
        return -1;
    }

    /**
     * Returns true if this list contains no values.
     *
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty()
    {
        //just check if the size is 0; if it is, it's empty. If it isn't, it's not empty.
        if (size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns the number of values in this list.
     *
     * @return the number of values in this list
     */
    @Override
    public int size()
    {
        //just return the size field.
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear()
    {
        //make a new one entirely. Wipe the slate clean.
        head = null;
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        return new SinglyLinkedIterator();
    }

    //helper class/type that defines how the iterator works
    private class SinglyLinkedIterator implements Iterator<Integer>
    {

        private Node current;

        public SinglyLinkedIterator()
        {
            current = head;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext()
        {
            //compute the result of whether or not current equals null, then return it
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Integer next()
        {
            if (current != null)
            {
                int item = current.data;
                current = current.next;
                return item;
            }
            else
            {
                throw new NoSuchElementException("End of list reached.");
            }
        }
    }
}
