package section17_stream.challenge_terminal;

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

        Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(10)
                .forEach(System.out::println);
    }

}
