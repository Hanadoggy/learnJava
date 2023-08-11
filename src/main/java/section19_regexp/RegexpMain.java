package section19_regexp;

import java.util.regex.Pattern;

public class RegexpMain {

    public static void main(String[] args) {

        String helloWorld = "%s %s".formatted("Hello", "World");
        String helloWorld2 = String.format("%s %s", "Hello", "World");
        System.out.println(format("%s %s", "Ahn", "Yujin"));

        String testString = "Anyone can Learn abc's, 123's, and any regular expression";
        String replacement = "(-)";
//        String[] patterns = {"abc", "[123]", "An|ny"};
//        String[] patterns = {"[a-z]", "[0-9]", "[A-Z]"};
        String[] patterns = {"[a-zA-Z]*$", "^[a-zA-Z]{3}", "[aA]ny\\b"};

        for (String pattern : patterns) {
            String output = testString.replaceFirst(pattern, replacement);
            System.out.println("Pattern: " + pattern + " => " + output);
        }

        System.out.println("------------------------------");
        String sentence = "I like motorcycles.";
        Pattern firstPattern = Pattern.compile("[A-Z].*[.]");
        var matcher = firstPattern.matcher(sentence);
        System.out.println(matcher.matches() + " : " + sentence);
        // matcher는 mutable = thread-safe하지 않음, String이 변하지 않아야 함


    }

    private static String format(String regexp, String... args) {

        for (String arg : args) {
            regexp = regexp.replaceFirst("%s", arg);
        }
        return regexp;
    }

}
