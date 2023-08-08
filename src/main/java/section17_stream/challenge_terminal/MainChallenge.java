package section17_stream.challenge_terminal;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainChallenge {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course cgj = new Course("CGJ", "Creating Games in Java");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(5000)
                .toList();
        List<Student> studentData2 = Stream.iterate(1, s -> s <= 5000, s -> s + 1)
                // 후위연산자는 범위 문제로 사용불가
                .map(s -> Student.getRandomStudent(jmc, pymc))
                .toList();
        List<Student> studentData3 = IntStream.rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        double average = students.stream()
                .filter(s -> s.getEngagementMap().containsKey(jmc.courseCode()))
                .mapToDouble(s -> s.getPercentComplete(jmc.courseCode()))
                .average()
                .getAsDouble();
        double totalPercent = students.stream()
                .mapToDouble(s -> s.getPercentComplete("JMC"))
//                .reduce(0, Double::sum);
                .sum();
        double avePercent = totalPercent / students.size();
        System.out.printf("average of Java master class = %.2f%% %n", average);
        System.out.printf("average of Java master class = %.2f%% %n", avePercent);

        System.out.println("--------------------------");

        List<Student> hardWorkers = students.stream()
                .filter(s -> s.getMonthsSinceActive(jmc.courseCode()) == 0)
                .filter(s -> s.getPercentComplete(jmc.courseCode()) >= average * 1.25)
                .sorted(Comparator.comparing(Student::getYearEnrolled))
                .limit(10)
                .toList();

        hardWorkers.forEach(s -> {
            s.addCourse(cgj);
            System.out.println(s);
        });

        System.out.println();

        students.stream()
                .filter(s -> s.getMonthsSinceActive(jmc.courseCode()) == 0)
                .filter(s -> s.getPercentComplete(jmc.courseCode()) >= average * 1.25)
                .sorted(Comparator.comparing(Student::getYearEnrolled))
                .limit(10)
                .forEach(s -> {
                    s.addCourse(cgj);
                    System.out.println(s);
                });
    }

}
