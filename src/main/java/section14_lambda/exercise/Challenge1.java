package section14_lambda.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Challenge1 {

    private static Random random = new Random();

    public static void main(String[] args) {

        List<String> names = new ArrayList<>(
                List.of("Yujin", "WonYoung", "Ohtani", "Kazuha", "Bob", "Anna", "Hana", "Seorin"));
        names.replaceAll(s ->
            s.toUpperCase() + " " + getMiddleName(random.nextInt(0, 5)) + ". " + getReversedName(s).toUpperCase()
        );

        System.out.println("To UpperCase and add Middle Name and add Last Name with Reversed first name");
        names.forEach(System.out::println);

        System.out.println("---------");
        names.removeIf(s -> {
            String first = s.substring(0, s.indexOf(" "));
            String last = s.substring(s.lastIndexOf(" ") + 1);
            return !first.equalsIgnoreCase(last);
        });
        names.forEach(System.out::println);
    }

    private static String getMiddleName(int num) {
        return switch (num) {
            case 0 -> "A";
            case 1 -> "B";
            case 2 -> "C";
            case 3 -> "D";
            case 4 -> "E";
            default -> "F";
        };
    }

    private static String getReversedName(String name) {
        return new StringBuilder(name).reverse().toString();
    }

}
