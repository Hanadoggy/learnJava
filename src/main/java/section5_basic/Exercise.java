package section5_basic;

public class Exercise {

    public static void exercise1(int number) {
        System.out.println((number > 0) ? "positive" : (number == 0) ? "zero" : "negative");
    }

    public static long exercise2_1(double kilometersPerHour) {

        long result = -1;
        if (kilometersPerHour >= 0) {
            result = Math.round(kilometersPerHour / 1.609);
        }

        return result;
    }

    public static void exercise2_2(double kilometersPerHour) {

        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            long result = Math.round(kilometersPerHour / 1.609);
            System.out.println(kilometersPerHour + " km/h = " + result + " mi/h");
        }
    }

    public static void exercise3(int kiloBytes) {

        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            int megaBytes = kiloBytes / 1024;
            int remains = kiloBytes % 1024;

            System.out.printf("%d KB = %d MB and %d KB%n", kiloBytes, megaBytes, remains);
        }
    }

    public static boolean exercise4(boolean bark, int hourOfDay) {

        boolean result = true;
        if (!bark) {
            result = false;
        } else if (hourOfDay > 23 || hourOfDay < 0) {
            result = false;
        } else if (hourOfDay >= 8 && hourOfDay <= 22) {
            result = false;
        }

        return result;
    }

    public static boolean exercise5(int year) {

        boolean isLeapYear = false;
        if (year >= 1 && year <= 9999) {
            if ((year % 4) == 0) {
                if ((year % 100) != 0) {
                    isLeapYear = true;
                } else if ((year % 100) == 0 && (year % 400) == 0) {
                    isLeapYear = true;
                }
            }
        }

        return isLeapYear;
    }

    public static boolean exercise6(double first, double second) {

        int myFirst = (int) (first * 1000);
        int mySecond = (int) (second * 1000);
        
        return (myFirst == mySecond);
    }

    public static boolean exercise7(int first, int second, int third) {
        return ((first + second) == third);
    }

    public static boolean exercise8_1(int first, int second, int third) {

        boolean result = false;
        if (first >= 13 && first <= 19) {
            result = true;
        } else if (second >= 13 && second <= 19) {
            result = true;
        } else if (third >= 13 && third <= 19) {
            result = true;
        }

        return result;
    }

    public static boolean exercise8_2(int age) {
        return (age >= 13 && age <= 19);
    }

    public static double exercise9(double radius) {

        double result = -1.0d;
        if (radius >= 0) {
            result = radius * radius * Math.PI;
        }

        return result;
    }

    public static double exercise9(double x, double y) {

        double result = -1.0d;
        if (x >= 0 && y >= 0) {
            result = x * y;
        }

        return result;
    }

    public static void exercise10(long minutes) {

        if (minutes < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.printf("%d min = %d y and %d d",
                    minutes,
                    (minutes / (24 * 365 * 60)),
                    (minutes / (24 * 60)) % 365);
        }
    }

    public static void exercise11(int first, int second, int third) {

        if (first < 0 || second < 0 || third < 0) {
            System.out.println("Invalid Value");
        } else {
            if (first == second && second == third) {
                System.out.println("All numbers are equal");
            } else if (first != second && second != third && first != third) {
                System.out.println("All numbers are different");
            } else {
                System.out.println("Neither all are equal or different");
            }
        }
    }

    public static boolean exercise12(boolean summer, int temperature) {

        int temperatureMax = summer ? 45 : 35;
        return (temperature >= 25 && temperature <= temperatureMax);
    }
}
