package section18_etc.challenge_dice;

import java.util.*;

public class DiceMain {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random r = new Random();

    public static void main(String[] args) {

        List<Integer> dices = new ArrayList<>();

        do {
            rollDice(dices);
        } while (!pickLosers(dices));
        System.out.println("Game over, Real game would score and continue");
    }

    private static void rollDice(List<Integer> dices) {

        int randomCount = 5 - dices.size();
        var newDice = r.ints(randomCount, 1, 7)
                .sorted()
                .boxed()
                .toList();
        dices.addAll(newDice);
        System.out.println("You're dice are : " + dices);
    }

    private static boolean pickLosers(List<Integer> dices) {

        System.out.println("Press Enter to Score.");
        System.out.println("Type \"ALL\" to re-roll all the dice.");
        System.out.println("List numbers (separated by spaces) to re-roll selected dice.");
        System.out.print("--> ");
        String input = scanner.nextLine();
        if (input.isBlank()) {
            return true;
        }
        try {
            removeDice(dices, input.split(" "));
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("Bad input, Try again");
        }

        return false;
    }

    private static void removeDice(List<Integer> dices, String[] selected) {

        if (selected.length == 1 && selected[0].contains("ALL")) {
            dices.clear();
        } else {
            for (String removed : selected) {
                dices.remove(Integer.valueOf(removed));
            }
            System.out.println("Keeping " + dices);
        }
    }

}
