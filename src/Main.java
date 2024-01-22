public class Main
{
    public static void main(String[] args)
    {
        System.out.printf("Hello and welcome!");
        System.out.println();

        ArrayIntList arrayList = new ArrayIntList();
        LinkedIntList linkedList = new LinkedIntList();
        DoublyLinkedIntList doublyList = new DoublyLinkedIntList();

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
        System.out.println("indexOf: " + linkedList.indexOf(2));

        System.out.println("clear: ");
        linkedList.clear();
        linkedList.printList();




//        for (int i = 1; i <= 5; i++)
//        {
//            System.out.println("i = " + i);
//
//        }

//        arrayList.add(0, 1);
//        System.out.println(arrayList.get(0));
//        linkedList.addBack(3);
//
//        for (int num : arrayList) {
//            System.out.println(num + " ");
//        }


            //where an iterator gets used:
//            for (int value : thirdList)
//            {
//                System.out.println(value);
//            }

            //alternate way to use an iterator
//            Iterator<Integer> itr = thirdList.iterator();
//            while (itr.hasNext())
//            {
//                int value = itr.next();
//                System.out.println(value);
//            }
    }
}