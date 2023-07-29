package exercise.section14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MiniChallenge {

    public void challenge1() {

        List<String> list = new ArrayList<>(List.of("Ahn Yujin", "Bob Amazon"));
        list.forEach(sentence ->
                Arrays.asList(sentence.split(" "))
                        .forEach(s -> System.out.println(s)));
    }

    public void challenge2() {

        UnaryOperator<String> func = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // challenge3
        System.out.println(func.apply("1234567890"));
    }

    public static void mainChallenge() {

        String[] names = {"Ahn", "Bob", "Charly", "David", "Ed", "Fred", "Gag", "Hanna", "Ive", "jaj"};

        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("--> Transform to Uppercase");
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);
        backedByArray.replaceAll(s -> s + " " + getRandomChar('A', 'D') + ".");
        System.out.println("--> Add random middle initial");
        System.out.println(Arrays.toString(names));

        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
        System.out.println("--> Add reversed name as last name");
        Arrays.asList(names).forEach(s -> System.out.println(s));

        System.out.println("--> Remove names where first = last");
        List<String> newList = new ArrayList<>(List.of(names));
        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(
                s.substring(s.lastIndexOf(" ") + 1)
        ));

        // method references
        newList.forEach(System.out::println);
    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) new Random().nextInt((int) startChar, (int) endChar + 1);
    }

    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }

    public static void main(String[] args) {
        mainChallenge();
    }
}

