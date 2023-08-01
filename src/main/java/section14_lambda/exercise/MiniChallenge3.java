package section14_lambda.exercise;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class MiniChallenge3 {

    public static void main(String[] args) {

        Consumer<String> lambda = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            System.out.println(returnVal);
        };

        lambda.accept("1234567890");
    }

}
