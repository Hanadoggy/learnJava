package section18_etc.challenge_dice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DiceMain {

    public static void main(String[] args) {

        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        int[] dices = r.ints(5, 1, 7).toArray();
        while (true) {
            printDices(dices);
            String input = scanner.next();
            if ("ALL".contains(input)) {
                dices = r.ints(5, 1, 7).toArray();
            } else if (input.isEmpty() || input == "") {

            } else {
                String[] s = input.split(" ");


            }
        }


    }

    private static void printDices(int[] dices) {
        System.out.println("You're dice are: " + Arrays.toString(dices));
        System.out.println("Press Enter to Score.");
        System.out.println("Type \"ALL\" to re-roll all the dice.");
        System.out.println("List numbers (separated by spaces) to re-roll selected dice.");
        System.out.print("--> ");
    }

}
