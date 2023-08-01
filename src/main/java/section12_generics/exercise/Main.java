package section12_generics.exercise;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < 20; i++) {
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered");

        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println("Matches");
        var matches = queryList
                .getMatches("PercentComplete", "50");
        printList(matches);
    }

    public static void printList(List<?> students) {

        for (Object student : students) {
            System.out.println(student);
        }
    }

}
