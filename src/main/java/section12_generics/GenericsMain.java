package section12_generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain {

    public static void main(String[] args) {

        int studentCount = 10;
        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        printList(lpaStudents);

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches(
                "Course", "Python");
        System.out.println("--- print list in match ---");
        printList(matches);

        var students2023 = QueryList.getMatches(lpaStudents, "YearStarted", "2021");
        printList(students2023);
    }

    public static void printList(List<? extends Student> students) {

        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

//    public static <T extends Student> void printList(List<T> students) {
//
//        for (var student : students) {
//            System.out.println(student.getYearStarted() + ": " + student);
//        }
//        System.out.println();
//    }
}
