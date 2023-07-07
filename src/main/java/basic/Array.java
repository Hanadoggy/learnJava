package basic;

import java.util.Arrays;
import java.util.Random;

public class Array {

    public static void runArray() {

        int[] newArray;
        // array initializer는 선언문 외에는 사용불가
        // newArray = {5, 4, 3, 2, 1};
        newArray = new int[] {5, 4, 3, 2, 1};
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }

        System.out.println();

        int[] zeroArray;
        zeroArray = new int[5];
        // array initializer는 기본값으로 초기화 (0, null)
        for (int i : zeroArray) {
            System.out.print(zeroArray[i] + " ");
        }

        System.out.println();

        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        Arrays.fill(secondArray, 7);
        System.out.println(Arrays.toString(secondArray));

        int[] thirdArray = Arrays.copyOf(firstArray, firstArray.length);
        Arrays.sort(thirdArray);
        System.out.println(Arrays.toString(firstArray) + " is firstArray");
        System.out.println(Arrays.toString(thirdArray) + " is copy of firstArray and sorted");
    }

    public static void binarySearch() {

        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        int mark = Arrays.binarySearch(sArray, "Mark");
        if (mark >= 0) {
            System.out.println("Found Mark in the list");
            System.out.println(sArray[mark] + " index = " + mark);
        }
        System.out.println(Arrays.toString(sArray));
    }



    private static int[] getRandomArray(int len) {

        Random random = new Random();
        int[] array = new int[10];

        for (int i = 0; i < len; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }
}
