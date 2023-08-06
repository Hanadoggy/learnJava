package section16_etc;

import java.util.ArrayList;
import java.util.List;

public class UnmodifiableMain {

    public static void main(String[] args) {

        StringBuilder bobsNotes = new StringBuilder();
        StringBuilder billsNotes = new StringBuilder();

        Student bob = new Student("Bob", bobsNotes);
        Student bill = new Student("Bill", billsNotes);
        billsNotes.append("Bill struggles with generics");

        List<Student> students = new ArrayList<>(List.of(bob, bill));
        List<Student> studentsFirstCopy = new ArrayList<>(students);
        List<Student> studentsSecondCopy = List.copyOf(students);

        studentsFirstCopy.add(new Student("Bonnie", new StringBuilder()));
//        studentsSecondCopy.set(0, new Student("Bonnie", new StringBuilder()));
        bobsNotes.append("Bob was one of my first students");

        StringBuilder bonniesNotes = studentsFirstCopy.get(2).getStudentNotes();
        bonniesNotes.append("Bonnie is taking 3 of my courses");

        students.forEach(System.out::println);
        System.out.println("-------------------------");
        studentsFirstCopy.forEach(System.out::println);
        System.out.println("-------------------------");
        studentsSecondCopy.forEach(System.out::println);
        System.out.println("-------------------------");


    }

}
