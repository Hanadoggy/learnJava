package section17_stream.challenge;

import section17_stream.challenge_terminal.Course;
import section17_stream.challenge_terminal.CourseEngagement;
import section17_stream.challenge_terminal.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course cgj = new Course("CGJ", "Creating games in Java");

        int currentYear = LocalDate.now().getYear();
        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc, cgj))
                .filter(s -> s.getYearEnrolled() >= (currentYear - 4))
                .limit(10000)
                .toList();

        System.out.println(students.stream()
                .mapToInt(Student::getYearEnrolled)
                .summaryStatistics());

        System.out.println(students.stream()
                .mapToInt(s -> s.getEngagementMap().size())
                .summaryStatistics());

        Map<String, Long> mappedActivity = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode,
                        Collectors.counting()));
        mappedActivity.forEach((k, v) -> System.out.println(k + " " + v));

        Map<Integer, Long> classCounts = students.stream()
                .collect(Collectors.groupingBy(s -> s.getEngagementMap().size(),
                        Collectors.counting()));
        classCounts.forEach((k, v) -> System.out.println(k + " " + v));

        var percentages = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode,
                        Collectors.summarizingDouble(CourseEngagement::getPercentComplete)));
        percentages.forEach((k, v) -> System.out.println(k + " " + v));

        var yearMap = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode,
                        Collectors.groupingBy(CourseEngagement::getLastActivityYear,
                                Collectors.counting())));
        yearMap.forEach((k, v) -> System.out.println(k + " " + v));

    }

}
