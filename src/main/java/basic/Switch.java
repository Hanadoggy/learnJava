package basic;

public class Switch {

    /**
     * Enhanced Switch Statement
     * Java 14 에서 추가됨
     * default 값은 필수
     * code block 안에서는 return 대신 yield 사용
     */
    public static void printSwitch(int value) {

        switch (value) {
            case 1 -> System.out.println("Value was 1");
            case 2 -> System.out.println("Value was 2");
            case 3, 4, 5 -> {
                System.out.println("Was a 3, a 4, or a 5");
                System.out.println("Actually it was a " + value);
            }
            default -> System.out.println("Was not 1, 2, 3, 4, or 5");
        }
    }

    public static String getQuarter(String month) {
        return switch (month) {
            // 내부에서 return 문 생략 가능
            case "JANUARY", "FEBRUARY", "MARCH" -> "1st";
            case "APRIL", "MAY", "JUNE" -> "2nd";
            case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
            default -> {
                // code block 내에서 return 하려면 yield 사용
                String badResponse = month + " is bad";
                yield badResponse;
            }
        };
    }
}
