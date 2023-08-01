package section14_lambda.exercise;

import java.util.function.UnaryOperator;

public class MiniChallenge2 {

    public static void main(String[] args) {

        UnaryOperator<String> lambda = (s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };
    }

}
