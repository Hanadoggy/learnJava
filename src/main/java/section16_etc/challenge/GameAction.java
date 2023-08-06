package section16_etc.challenge;

import java.util.function.Predicate;

public record GameAction(char key, String prompt, Predicate<Integer> action) {

}
