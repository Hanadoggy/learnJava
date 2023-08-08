package section17_stream;

import section17_stream.challenge_terminal.Course;
import section17_stream.challenge_terminal.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class MainMapping {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course cgj = new Course("CGJ", "Creating Games in Java");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(5000)
                .toList();

        var mappedStudents = students.stream()
                .collect(groupingBy(Student::getCountryCode));
        mappedStudents.forEach((k, v) -> System.out.println(k + " " + v.size()));

        System.out.println("-----------------------------");
        int minAge = 25;
        var youngerSet = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                        filtering(s -> s.getAge() <= minAge, toList())));

        youngerSet.forEach((k, v) -> System.out.println(k + "  " + v.size()));

        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience));
        System.out.println("experienced = " + experienced.get(true).size());

        var expCount = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting()));
        System.out.println("expCount = " + expCount.get(true));

        var experiencedAndActive = students.stream()
                .collect(partitioningBy(s -> s.hasProgrammingExperience() &&
                        s.getMonthsSinceActive() == 0, counting()));
        System.out.println("experiencedAndActive = " + experiencedAndActive.get(true));

        var multiLevel = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                        groupingBy(Student::getGender)));

        multiLevel.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((key, value) -> System.out.println("\t" + key + " " + value.size()));
        });

        long studentBodyCount = 0;
        for (List<Student> list : experienced.values()) {
            studentBodyCount += list.size();
        }
        System.out.println("studentBodyCount = " + studentBodyCount);

        studentBodyCount = experienced.values().stream()
                .mapToInt(l -> l.size())
                .sum();
        System.out.println("studentBodyCount = " + studentBodyCount);

        studentBodyCount = experienced.values().stream()
                .map(l -> l.stream()
                        .filter(s -> s.getMonthsSinceActive() <= 3)
                        .count())
                .mapToLong(l -> l)
                .sum();
        System.out.println("studentBodyCount = " + studentBodyCount);

        long count = experienced.values().stream()
                .flatMap(l -> l.stream())
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active Students = " + count);

        count = multiLevel.values().stream()
                .flatMap(map -> map.values().stream()
                        .flatMap(l -> l.stream()))
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active Students in multiLevel = " + count);

        count = multiLevel.values().stream()
                .flatMap(map -> map.values().stream())
                .flatMap(l -> l.stream())
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active Students in multiLevel = " + count);
    }

}
