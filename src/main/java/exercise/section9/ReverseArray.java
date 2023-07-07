package exercise.section9;

import java.util.Arrays;

public class ReverseArray {

    private static void reverse(int[] array) {

        int temp = 0;
        int len = array.length;
        int[] copy = Arrays.copyOf(array, len);
        for (int i = 0; i < len / 2; i++) {
            temp = array[i];
            array[i] = array[len - i - 1];
            array[len - i - 1] = temp;
        }

        System.out.printf("Array = %sReversed array = %s",
                Arrays.toString(copy), Arrays.toString(array));
    }
}
