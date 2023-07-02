package basic;

public class PrimitiveType {

    public static void printNum() {

        /**
         * 자바는 정수형은 int, 부동소수점은 double을 기본으로 사용한다
         * 숫자는 가독성을 위해 중간에 _ 사용이 가능하다
         */
        int myInt = 1000;
        long myLong = 1000L;
        float myFloat = 1000.5f;
        double myDouble = 1000.6d;
        int money = 2_123_405;

        System.out.println("money = " + money + ", setting is 2_123_405");
        System.out.println("myDouble + myFloat = " + (double) (myDouble + myFloat));
    }

    public static void printString() {

        /**
         * String 연산에서 + 연산자는 연결을 의미한다
         * String은 불변객체이다
         * 따라서 연산할 때 매번 새로운 객체를 생성하여 연산하기에 비효율적이다
         */
        int myInt = 50;
        String myString = "10";
        myString = myString + myInt;

        System.out.println("myString = " + myString);
    }

    public static void printCompoundAssignOper() {

        /**
         * 복합 연산자에는 자료형으로 변환하는 타입 캐스팅이 숨겨져 있다
         * 만약 아래 식에서 타입 캐스팅을 제거한다면 incompatible types error가 발생한다
         */
        int hana = 10;
        hana -= 5.5;

        int doggy = 10;
        doggy = (int) (doggy - 5.5);

        System.out.println("hana = " + hana);
        System.out.println("doggy = " + doggy);
    }
}
