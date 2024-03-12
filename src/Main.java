import org.w3c.dom.ls.LSOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        //instance
        ArrayIntList list = new ArrayIntList();

        list.addFront(9);
        list.addFront(10);
        list.addBack(5);

//print the size of list
        System.out.println("size of the list:" + list.size());
//print value of list
        System.out.println("elements of the list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        //check if 10 is in list
        int valueToFind = 10;
        if (list.contains(valueToFind)) {

            System.out.println("list contains:" + valueToFind);

        } else {
            System.out.println("does not contain:" + valueToFind);
        }

        //remove something from list
        int indexToRemove = 1;
        int removedValue = list.remove(indexToRemove);
        System.out.println("removed number:" + indexToRemove + ":" + removedValue);

        //print uptwd list
        System.out.println("updated list value: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        //clear the list
        list.clear();
        System.out.println("cleard size of list:" + list.size());
        System.out.println();


        //LinkedIntList
        LinkedIntList linkedIntList = new LinkedIntList();
        linkedIntList.addFront(2);
        linkedIntList.addBack(3);
        linkedIntList.add(2, 4);
        System.out.print("linkedIntlist:");
        for (int i = 0; i < linkedIntList.size(); i++) {
            System.out.print(linkedIntList.get(i) + " ");
        }
        System.out.println();
        System.out.println("size:" + linkedIntList.size());
        System.out.println("has 3:" + linkedIntList.contains(3));
        System.out.println("find index for 6" + linkedIntList.indexOf(6));
        linkedIntList.removeFront();
        linkedIntList.removeBack();
        System.out.print("after removing (empty the list):");
        for (int i = 0; i < linkedIntList.size(); i++) {
            System.out.println(linkedIntList.get(i) + "");
        }
        System.out.println("size"+linkedIntList.size());
        System.out.println();


        //DoublyLinkedIntList
        DoublyLinkedIntList doublyList = new DoublyLinkedIntList();
        //added some values to list
        doublyList.addFront(2);
        doublyList.addBack(4);
        doublyList.add(1, 3);// 3 at index 1
        //print list
        System.out.print("doubly-List:");
        for(int i=0; i<doublyList.size(); i++){
            System.out.print(doublyList.get(i)+" ");
        }
        System.out.println();
        //test list size
        System.out.println("list size:"+doublyList.size());
        //does list contian 5?
        System.out.println("does list have 5?"+doublyList.contains(5));
        //for index
        System.out.println("index of 4 in list:"+doublyList.indexOf(4));

        //remove element s from list
        doublyList.removeFront();
        //print updated list
        System.out.print("updated list:");
        for(int i =0;i<doublyList.size();i++){
            System.out.println(doublyList.get(i)+"");
        }
        System.out.println();

        //clear list
        doublyList.clear();
        System.out.print("list cleared- is it empty nowww?"+doublyList.isEmpty());
        //test invalid parametter
        System.out.println();
        try{
            //add at invaild index
            doublyList.add(-1,5);
        }

        catch (IndexOutOfBoundsException e){
            System.out.println(" exception caught"+e.getMessage());
        }
        //remove element at invaild index
        try{
            doublyList.remove(5);

        }catch (IndexOutOfBoundsException e){
            System.out.println("exception caught:"+e.getMessage());
        }
    }

}
