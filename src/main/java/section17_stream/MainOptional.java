package section17_stream;

import section17_stream.challenge_terminal.Course;
import section17_stream.challenge_terminal.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class MainOptional {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .toList();

        Optional<Student> o1 = getStudent(new ArrayList<>(), "first");
        System.out.println("Empty = " + o1.isEmpty() + ", Present = " + o1.isPresent());
        System.out.println(o1);
        o1.ifPresentOrElse(System.out::println, () -> System.out.println("---> Empty"));

        Optional<Student> o2 = getStudent(students, "first");
        System.out.println("Empty = " + o2.isEmpty() + ", Present = " + o2.isPresent());
        System.out.println(o2);
        o2.ifPresent(System.out::println);

//        Student firstStudent = o2.orElse(getDummyStudent(jmc));
        // Optional 내부 데이터가 있으면 반환하고 없으면 Else()안의 내용 실행
        // 객체를 생성하는 메서드 형태로 넘기는 경우 조건에 상관없이 무조건 실행됨, 리소스의 낭비 발생
        // 따라서 orElseGet() 메서드를 이용하여 람다 표현식으로 사용하는 것이 바람직함
        Student firstStudent = o2.orElseGet(() -> getDummyStudent(jmc));
        long id = firstStudent.getStudentId();
        System.out.println("FirstStudent's id is " + id);

        List<String> countries = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .toList();

        Optional.of(countries)
                .map(l -> String.join(",", l))
                .filter(l -> l.contains("JP"))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Missing JP"));
    }

    private static Optional<Student> getStudent(List<Student> list, String type) {

        if (list == null || list.size() == 0) {
            return Optional.empty();
        } else if (type.equals("first")) {
            return Optional.ofNullable(list.get(0));
        } else if (type.equals("last")) {
            return Optional.ofNullable(list.get(list.size() - 1));
        }
        return Optional.ofNullable(list.get(new Random().nextInt(list.size())));
    }

    private static Student getDummyStudent(Course... courses) {

        System.out.println("Getting the dummy student");
        return new Student("NO", 1, 1, "U", false, courses);
    }

}
