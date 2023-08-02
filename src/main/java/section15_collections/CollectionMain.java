package section15_collections;

import java.util.*;

public class CollectionMain {

    public static void main(String[] args) {

        // Collection 대신 List 사용 가능 (List extends Collection
        // Collection 사용 시 ArrayList, TreeSet, HashSet등 사용 가능
        Collection<String> list = new HashSet<>();
        String[] names = {"Anna", "Bob", "Carol", "David", "Edna", "Yujin"};
        list.addAll(Arrays.asList(names));
        System.out.println(list);

        list.add("Fred");
        list.addAll(Arrays.asList("George", "Gary", "Grace"));
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));

        list.removeIf(s -> s.charAt(0) == 'G');
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));
//        list.sort();
        // Collection interface는 sort를 선언하지 않음


    }

}
