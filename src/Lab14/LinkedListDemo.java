package Lab14;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<String>();
        stringList.addANodeToStart("friend");
        stringList.addANodeToStart ("Good-bye");
        stringList.addANodeToStart ("Hello");
        stringList.outputList ();

        LinkedList<Integer> numberList =
                new LinkedList<Integer>();
        for (int i = 0; i < 10; i++){
            numberList.addANodeToStart(i);
        }
        numberList.deleteHeadNode();
        numberList.outputList();
        numberList.add(3,20);
        System.out.println("-".repeat(30));
        numberList.remove(9);
        numberList.outputList();
    }

}

