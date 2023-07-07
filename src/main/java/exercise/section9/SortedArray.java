package exercise.section9;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {

    public static int[] getIntegers(int len) {

        Scanner scanner = new Scanner(System.in);
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        return array;
    }

    public static int[] sortIntegers(int[] array) {
        Arrays.sort(array);
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - i - 1];
        }
        return result;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Element %d contents %d%n", i, array[i]);
        }
    }
}
