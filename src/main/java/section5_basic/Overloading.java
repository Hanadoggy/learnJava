package section5_basic;

public class Overloading {

    /**
     * 메서드를 구분하는 내용은 메서드 이름, 매개변수의 수와 타입 그리고 선언된 순서이다
     * 반환 타입이나 매개변수의 이름은 메서드를 구분하는 내용에 포함되지 않는다
     */
    public static int calc(int input) {
        return input * 1000;
    }

    public static int calc(double input) {
        return (int) (input * 1000);
    }

    public static int calc(int first, int second) {
        return (first + second);
    }

    /* return type, parameter name은 메서드의 구분에 영향 X

    public static void calc(int input) {
        System.out.println("input is " + input);
    }

    public static void calc(int first) {
        System.out.println("first parameter is " + first);
    }

     */
}
