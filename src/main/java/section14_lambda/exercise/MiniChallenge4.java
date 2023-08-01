package section14_lambda.exercise;

import java.util.function.*;

public class MiniChallenge4 {

    public static void main(String[] args) {

        UnaryOperator<String> lambda = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return String.valueOf(returnVal);
        };

        BiConsumer<UnaryOperator<String>, String> launcher = (o, s) ->
                System.out.println(o.apply(s));

        launcher.accept(lambda, "1234567890");
    }

}
