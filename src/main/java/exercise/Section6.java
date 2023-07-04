package exercise;

import java.util.Scanner;

public class Section6 {

    public static void exercise13(int number) {

        // 답안은 14버전 이전 switch 제출
        switch (number) {
            case 0 -> System.out.println("ZERO");
            case 1 -> System.out.println("ONE");
            case 2 -> System.out.println("TWO");
            case 3 -> System.out.println("THREE");
            case 4 -> System.out.println("FOUR");
            case 5 -> System.out.println("FIVE");
            case 6 -> System.out.println("SIX");
            case 7 -> System.out.println("SEVEN");
            case 8 -> System.out.println("EIGHT");
            case 9 -> System.out.println("NINE");
            default -> System.out.println("OTHER");
        }
    }

    public static int exercise14(int month, int year) {

        if (month < 1 || month > 12) {
            return -1;
        } else if (year < 1 || year > 9999) {
            return -1;
        }

        // 답안은 14버전 이전 switch 제출
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 30;
        };
    }

    public static boolean exercise15_1(int number) {

        if (number <= 0) {
            return false;
        }
        return ((number % 2) == 1);
    }

    public static int exercise15_2(int start, int end) {

        if (start > end || start <= 0) {
            return -1;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (exercise15_1(i)) {
                sum += i;
            }
        }

        return sum;
    }

    public static boolean exercise16(int number) {

        String num = Integer.toString(number);
        int flag = (number > 0) ? 0 : 1;
        for (int i = flag; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - i - 1 + flag)) {
                return false;
            }
        }

        return true;
    }

    public static int exercise17(int number) {
        return (number < 0) ? -1 :
                ((int) (number / Math.pow(10, (int) Math.log10(number))) + (number % 10));
    }

    public static int exercise18(int number) {

        if (number < 0) {
            return -1;
        }
        int sum = 0;
        int length = Integer.toString(number).length();
        for (int i = 0; i < length; i++, number /= 10) {
            sum += (((number % 10) % 2) == 0) ? number % 10 : 0;
        }

        return sum;
    }

    public static boolean exercise19(int first, int second) {

        if (first < 10 || first > 99 || second < 10 || second > 99) {
            return false;
        } else if (first / 10 == second / 10 || first / 10 == second % 10) {
            return true;
        } else if (first % 10 == second / 10 || first % 10 == second % 10) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean exercise20_1(int x, int y, int z) {

        if (!exercise20_2(x) || !exercise20_2(y) || !exercise20_2(z)) {
            return false;
        } else if (x % 10 == y % 10 || x % 10 == z % 10 || y % 10 == z % 10) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean exercise20_2(int num) {
        return (num >= 10 && num <= 1000);
    }

    public static void exercise21(int number) {

        if (number < 1) {
            System.out.println("Invalid Value");
        } else {
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static int exercise22(int first, int second) {

        if (first < 10 || second < 10) {
            return -1;
        }

        while (second != 0) {
            int temp = second;
            second = first % second;
            first = temp;
        }

        return first;
    }

    public static boolean exercise23(int number) {

        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return (sum == number);
    }

    public static void exercise24_1(int number) {

        if (number < 0) {
            System.out.println("Invalid Value");
        } else {
            for (int i = exercise24_3(number) - 1; i >= 0; i--) {
                switch ((int) (number / Math.pow(10, i)) % 10) {
                    case 0 -> System.out.print("Zero ");
                    case 1 -> System.out.print("One ");
                    case 2 -> System.out.print("Two ");
                    case 3 -> System.out.print("Three ");
                    case 4 -> System.out.print("Four ");
                    case 5 -> System.out.print("Five ");
                    case 6 -> System.out.print("Six ");
                    case 7 -> System.out.print("Seven ");
                    case 8 -> System.out.print("Eight ");
                    default -> System.out.print("Nine ");
                }
            }
        }
    }

    public static int exercise24_2(int number) {

        boolean flag = false;
        if (number < 0) {
            number = Math.abs(number);
            flag = true;
        }

        int reverse = 0;
        for (int i = exercise24_3(number) - 1; i >= 0; i--) {
            reverse += ((int) (number / Math.pow(10, i)) % 10) * (Math.pow(10, exercise24_3(number) - i - 1));
        }

        return flag ? -reverse : reverse;
    }

    public static int exercise24_3(int number) {
        return (number < 0) ? -1 : Integer.toString(number).length();
    }

    public static boolean exercise25(int bigCount, int smallCount, int goal) {

        for (int i = 0; i <= bigCount; i++, goal -= 5) {
            if (goal >= 0 && smallCount >= goal) {
                return true;
            }
        }

        return false;
    }

    public static int exercise26(int number) {

        if (number <= 1) {
            return -1;
        }

        int max = -1;
        boolean flag = false;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        flag = true;
                        break;
                    }
                }
                max = flag ? max : Math.max(max, i);
                flag = false;
            }
        }

        return max;
    }

    public static void exercise27(int number) {

        if (number < 5) {
            System.out.println("Invalid Value");
        } else {
            for (int i = 0; i < number; i++) {
                System.out.print("*");
            }
            System.out.println();

            for (int i = 1; i < number - 1; i++) {
                System.out.print("*");
                for (int j = 1; j < number - 1; j++) {
                    if (j == i || (number - 1 - j) == i) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println("*");
            }

            for (int i = 0; i < number; i++) {
                System.out.print("*");
            }
        }
    }

    public static void exercise28() {

        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        while (true) {
            try {
                sum += Integer.parseInt(scanner.nextLine());
                count++;
            } catch (NumberFormatException e) {
                System.out.println("SUM = " + sum + " AVG = " + Math.round((double) sum / count));
                break;
            }
        }
    }

    public static int exercise29(double width, double height, double areaPerBucket, int extraBuckets) {

        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }

        int count = 0;
        while (width * height > areaPerBucket * (count + extraBuckets)) {
            count++;
        }

        return count;
    }

    public static int exercise29(double width, double height, double areaPerBucket) {

        if (width <= 0 || height <= 0 || areaPerBucket <= 0) {
            return -1;
        }

        int count = 0;
        while (width * height > areaPerBucket * count) {
            count++;
        }

        return count;
    }

    public static int exercise29(double area, double areaPerBucket) {

        if (area <= 0 || areaPerBucket <= 0) {
            return -1;
        }

        int count = 0;
        while (area > areaPerBucket * count) {
            count++;
        }

        return count;
    }

    private static boolean isLeapYear(int year) {
        return Section5.exercise5(year);
    }
}
