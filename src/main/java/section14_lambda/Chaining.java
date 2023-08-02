package section14_lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Chaining {

    public static void main(String[] args) {

        String name = "Ahn";
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String, String> lastName = s -> s.concat(" Yujin");
        Function<String, String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));

        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        // 람다 표현식을 체이닝하여 하나의 기능으로 만든 후 인스턴스화 하여 사용
        Function<String, String[]> f0 = uCase
                .andThen(s -> s.concat(" Yujin"))
                .andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(f0.apply(name)));

        // String(start) -> String -> String[] -> String(result)
        Function<String, String> f1 = uCase
                .andThen(s -> s.concat(" Yujin"))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() + ", " + s[0]);
        System.out.println(f1.apply(name));

        // String -> String -> String[] -> String -> Integer
        Function<String, Integer> f2 = uCase
                .andThen(s -> s.concat(" Yujin"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(", ", s))
                .andThen(String::length);
        System.out.println(f2.apply(name));

        // Consumer는 아무 값도 반환하지 않고 코드만 실행
        // 따라서 체이닝 한 모든 Consumer는 같은 매개변수를 돌려서 사용
        String[] names = {"Ahn", "Yujin", "Hana"};
        Consumer<String> s0 = s -> System.out.print(s.charAt(0));
        Consumer<String> s1 = System.out::println;
        Arrays.asList(names).forEach(s0
                .andThen(s -> System.out.print(" - "))
                .andThen(s1));

        Predicate<String> p1 = s -> s.equals("AHN");
        Predicate<String> p2 = s -> s.equalsIgnoreCase("Ahn");
        Predicate<String> p3 = s -> s.startsWith("A");
        Predicate<String> p4 = s -> s.endsWith("e");

        Predicate<String> combined1 = p1.or(p2);
        System.out.println("combined1 = " + combined1.test(name));

        Predicate<String> combined2 = p3.and(p4);
        System.out.println("combined2 = " + combined2.test(name));

        Predicate<String> combined3 = p3.and(p4).negate();
        System.out.println("combined3 = " + combined3.test(name));

        record Person(String firstName, String lastName) {
        }

        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("Yujin", "Ahn"),
                new Person("WonYoung", "Jang"),
                new Person("Shohei", "Ohtani"),
                new Person("Doto", "Meisho")
        ));

        System.out.println("---------------");
        list.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        list.forEach(System.out::println);

        System.out.println("----------------");
        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);

        System.out.println("----------------");
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName));
        list.forEach(System.out::println);

        System.out.println("----------------");
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName)
                .reversed());
        list.forEach(System.out::println);
    }
}
