package section14_lambda.exercise;

import java.util.Arrays;
import java.util.function.Consumer;

public class MiniChallenge1 {

    public static void main(String[] args) {

        Consumer<String> lambda = (s) ->
                Arrays.asList(s.split(" ")).forEach(System.out::println);

        lambda.accept("Let's split this up into an array");
    }

}
