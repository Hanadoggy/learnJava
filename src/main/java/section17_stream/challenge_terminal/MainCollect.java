package section17_stream.challenge_terminal;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(345)
                .toList();

        Set<Student> japaneseStudents = students.stream()
                .filter(s -> s.getCountryCode().equals("JP"))
                .collect(Collectors.toSet());
        System.out.println("# of Japanese Students = " + japaneseStudents.size());

        Set<Student> underThirty = students.stream()
                .filter(s -> s.getAgeEnrolled() < 30)
                .collect(Collectors.toSet());
        System.out.println("# of Under Thirty Students = " + underThirty.size());

        Set<Student> youngJapanese1 = new TreeSet<>(Comparator.comparing(Student::getStudentId));
        youngJapanese1.addAll(japaneseStudents);
        youngJapanese1.retainAll(underThirty);
        youngJapanese1.forEach(s -> System.out.print(s.getStudentId() + " "));
        System.out.println();

        Set<Student> youngJapanese2 = students.stream()
                .filter(s -> s.getAgeEnrolled() < 30)
                .filter(s -> s.getCountryCode().equals("JP"))
                .collect(() -> new TreeSet<>(Comparator.comparing(Student::getStudentId)), TreeSet::add, TreeSet::addAll);
        // collect에는 두 가지 오버로딩 메서드가 존재한다
        // factory method를 사용하는 메서드와 직접 supplier, accumulator, combiner를 제공하는 메서드로 나뉜다
        youngJapanese2.forEach(s -> System.out.print(s.getStudentId() + " "));
        System.out.println();

        String countryList = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("", (r, v) -> r + " " + v);
        System.out.println("countryList = " + countryList);


    }

}
