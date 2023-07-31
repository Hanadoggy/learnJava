package section9_arrays.exercise;

import java.util.Scanner;

public class MinimumElement {

    // 제출은 전부 private 변경
    public static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int[] readElements(int len) {

        Scanner scanner = new Scanner(System.in);
        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.print("Input " + i + " element: ");
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static int findMin(int[] array) {

        int min = array[0];
        for (int i : array) {
            min = Math.min(i, min);
        }

        return min;
    }
}
