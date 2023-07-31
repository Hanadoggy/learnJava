package section10_list;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyIterator {

    public static void run() {

        String[] list = new String[]{"Alice Springs", "Brisbane", "Lake Wivenhoe", "Darwin", "Canberra", "Sydney",
                "Hobart", "Melbourne", "Toowoomba"};
        List<String> myList = List.of(list);

        Iterator iterator = myList.iterator();
        System.out.print("City list: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();

        var listIterator = myList.listIterator();
        System.out.print("City list: ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + ", ");
        }
        System.out.println();

        System.out.print("City list: ");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + ", ");
        }
        System.out.println();
    }
}
