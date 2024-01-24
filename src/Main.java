public class Main
{
    public static void main(String[] args)
    {
        System.out.printf("Hello and welcome!");
        System.out.println();
        ArrayIntList arrayList = new ArrayIntList();

        arrayList.add(0,1);
        arrayList.add(1, 2);
        arrayList.add(2, 3);
        arrayList.add(3, 4);
        arrayList.add(4, 5);

        System.out.println("Array List: ");
        for (int num : arrayList)
        {
            System.out.print(num + ", ");

        }

        System.out.println("remove: " + arrayList.remove(2));

        System.out.println("remove from back: ");
        arrayList.removeBack();

        System.out.println("Remove front: ");
        arrayList.removeFront();

        System.out.println("Array List: ");
        for (int num : arrayList)
        {
            System.out.print(num + ", ");

        }
        System.out.println("add to front: ");
        arrayList.addFront(1);

        System.out.println("add to back: ");
        arrayList.addBack(4);

        System.out.println("Array List: ");
        for (int num : arrayList)
        {
            System.out.print(num + ", ");

        }

        System.out.println("size: " + arrayList.size());
        System.out.println("get: " + arrayList.get(1));
        System.out.println("indexOf: " + arrayList.indexOf(2));

        System.out.println("clear: ");
        arrayList.clear();

        System.out.println("Array List: ");
        for (int num : arrayList)
        {
            System.out.print(num + ", ");

        }

        System.out.println();
        //Linked list tests
        LinkedIntList linkedList = new LinkedIntList();

        linkedList.add(0,1);
        linkedList.add(1, 2);
        linkedList.add(2, 3);
        linkedList.add(3, 4);
        linkedList.add(4, 5);

        System.out.println("Linked List: ");
        linkedList.printList();
        System.out.println();

        System.out.println("remove: ");
        linkedList.remove(2);
        linkedList.printList();
        System.out.println();

        System.out.println("remove from back: ");
        linkedList.removeBack();
        linkedList.printList();
        System.out.println();

        System.out.println("Remove front: ");
        linkedList.removeFront();
        linkedList.printList();
        System.out.println();

        System.out.println("add to front: ");
        linkedList.addFront(1);
        linkedList.printList();
        System.out.println();

        System.out.println("add to back: ");
        linkedList.addBack(3);
        linkedList.printList();
        System.out.println();


        System.out.println("size: " + linkedList.size());
        System.out.println("get: " + linkedList.get(1));
        System.out.println("contains: " + linkedList.contains(1));
        System.out.println("indexOf: " + linkedList.indexOf(2));

        System.out.println("clear: ");
        linkedList.clear();
        linkedList.printList();



        //test DoublyLinkedList
        DoublyLinkedIntList doublyList = new DoublyLinkedIntList();

        System.out.println("Doubly Linked List: ");
        doublyList.add(0,1);
        doublyList.add(1, 2);
        doublyList.add(2, 3);
        doublyList.add(3, 4);
        doublyList.add(4, 5);
        doublyList.printList();
        System.out.println();

        System.out.println("Remove: ");
        doublyList.remove(2);
        doublyList.printList();
        System.out.println();

        System.out.println("Add Back: ");
        doublyList.addBack(6);
        doublyList.printList();
        System.out.println();

        System.out.println("Add Front: ");
        doublyList.addFront(3);
        doublyList.printList();
        System.out.println();

        System.out.println("Remove Back: ");
        doublyList.removeBack();
        doublyList.printList();
        System.out.println();

        System.out.println("size: " + doublyList.size());
        System.out.println("get: " + doublyList.get(1));
        System.out.println("contain: " + doublyList.contains(1));
        System.out.println("contain: " + doublyList.contains(7));

        System.out.println("indexOf: " + doublyList.indexOf(1));

        System.out.println("Clear: ");
        doublyList.clear();
        doublyList.printList();

    }

}