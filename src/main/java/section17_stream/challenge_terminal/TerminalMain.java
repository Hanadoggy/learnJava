package section17_stream.challenge_terminal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalMain {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");
//        Student yujin = new Student("KR", 2019, 20, "F", true, jmc, pymc);
//        System.out.println(yujin);
//
//        yujin.watchLecture("JMC", 10, 5, 2019);
//        yujin.watchLecture("PYMC", 7, 7, 2020);
//        System.out.println(yujin);

        var studentData = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(345)
                .toList();

        System.out.printf("Male = %d, Female = %d%n",
                studentData.stream()
                        .filter(d -> d.getGender().equals("M"))
                        .count(),
                studentData.stream()
                        .filter(d -> d.getGender().equals("F"))
                        .count());

        System.out.printf("less than 30 = %d, between 30 and 60 = %d, over 60 = %d%n",
                studentData.stream()
                        .filter(d -> d.getAge() < 30)
                        .count(),
                studentData.stream()
                        .filter(d -> d.getAge() >= 30 && d.getAge() < 60)
                        .count(),
                studentData.stream()
                        .filter(d -> d.getAge() >= 60)
                        .count());

        System.out.println("SummaryStatistics on student's age = " +
                studentData.stream()
                        .mapToInt(Student::getAge)
                        .summaryStatistics());

        studentData.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        for (String country : List.of("AU", "USA", "JP", "KR", "UK", "GR")) {
            System.out.printf("Student's from %s = %d%n", country,
                    studentData.stream()
                            .filter(s -> s.getCountryCode().equals(country))
                            .count());
        }

        System.out.println();
        boolean longTerm = studentData.stream()
                .anyMatch(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                        (s.getMonthsSinceActive() < 12));

        long longTermCount = studentData.stream()
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                        (s.getMonthsSinceActive() < 12))
                .count();
        System.out.printf("longTerm student? %s%nlongTerm students count? %d", longTerm, longTermCount);

        List<Student> longTimeLearners = studentData.stream()
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                        (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
//                .toList();
//                .toArray(Student[]::new);
                .collect(Collectors.toList());

        longTimeLearners.forEach(System.out::println);
    }

}
