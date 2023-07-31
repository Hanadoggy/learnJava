package section5_basic;

public class StringFormat {

    public static void printString() {
        System.out.printf("Your age is %.2f%n", 20.59d);
        System.out.println(String.format("My age is %d", 25));
        System.out.println("Your age is %d".formatted(25));
    }

    /**
     * String은 불변 객체
     * 원본 String을 변경하는 경우 사실 새로운 객체를 생성하는 것 = 참조를 연결해 줘야함
     * StringBuilder는 똑같이 불변 객체인 String을 사용하나 Builder는 원본 값이 변하는 객체의 참조를 가짐
     * 따라서 StringBuilder는 값을 변경하더라도 새롭게 참조를 연결할 필요가 없음
     * 단, StringBuilder는 기본 capacity가 16으로 초과하여 저장할 경우 더 큰 저장 공간에 새로 저장하려고 함
     * 따라서 긴 문자열을 builder에 저장할 경우 처음부터 capacity를 높게 선언하는 것이 효율적
     */
    public static void printStringBuilder() {

        String yujin = "Hello Yujin";
        yujin.concat(" and GoodBye!");

        StringBuilder builder = new StringBuilder("Hello Yujin");
        builder.append(" and GoodBye!");

        System.out.println("String is = " + yujin);
        System.out.println("StringBuilder is = " + builder);
    }

}
