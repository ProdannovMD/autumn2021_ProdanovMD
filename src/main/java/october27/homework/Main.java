package october27.homework;

import java.util.Arrays;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(4);
        System.out.println("init test:");
        System.out.println(linkedList);

        linkedList.remove(3);
        System.out.println("remove third test:");
        System.out.println(linkedList);

        linkedList.remove(new Integer(3));
        System.out.println("remove value 3 test:");
        System.out.println(linkedList);

        linkedList.add(1, 6);
        linkedList.add(0, 1);
        System.out.println("add 6 to 1st and 1 to 0th places test:");
        System.out.println(linkedList);

        System.out.println("contains element 2 test:");
        System.out.println(linkedList.contains(2));

        Integer[] integers = linkedList.toArray(new Integer[0]);
        System.out.println("to integer array test:");
        System.out.println(Arrays.toString(integers));

        System.out.println("iterator test:");
        ListIterator<Integer> iterator = linkedList.listIterator();
        while (iterator.hasNext())
            System.out.printf("%d - %s\n", iterator.nextIndex(), iterator.next());
    }
}
