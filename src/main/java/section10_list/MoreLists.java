package section10_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {

    public static void run() {

        String[] items = {"apples", "bananas", "milk", "eggs"};

        List<String> list = List.of(items);
        System.out.println(list);

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);

        ArrayList<String> nextList = new ArrayList<>(List.of("pickles", "mustard", "cheese"));
        System.out.println(nextList);

        groceries.addAll(nextList);
        System.out.println(groceries);

        System.out.println("Third item = " + groceries.get(2));
        if (groceries.contains("mustard")) {
            System.out.println("List contains mustard");
        }

        groceries.add("yogurt");
        System.out.println("first yogurt = " + groceries.indexOf("yogurt"));
        System.out.println("last yogurt = " + groceries.lastIndexOf("yogurt"));

        groceries.remove(1);
        groceries.remove("yogurt");
        groceries.removeAll(List.of("apples", "eggs"));
        groceries.retainAll(List.of("apples", "milk", "mustard", "cheese"));
        // 전달된 list 항목을 제외한 나머지 삭제
        System.out.println(groceries);

        groceries.clear();
        System.out.println("is Empty = " + groceries.isEmpty());
        groceries.addAll(List.of(("apples"), "milk", "mustard", "cheese"));
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));

        System.out.println(groceries);
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));
    }
}
