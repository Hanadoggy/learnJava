package section16_etc;

import java.util.Random;

public class Child extends Parent {

    private final int birthOrder = getBirthOrder();
    private final String birthOrderString;

    {
        if (siblings == 0) {
            birthOrderString = "Only";
        } else if (birthOrder == 1) {
            birthOrderString = "First";
        } else if (birthOrder == (siblings + 1)) {
            birthOrderString = "Last";
        } else {
            birthOrderString = "Middle";
        }
        System.out.println("Child: Initializer, birthOrder = " + birthOrder +
                ", birthOrderString = " + birthOrderString);
    }

    public Child() {
        super("sakura", "03/05/2000", 5);
        System.out.println("Child: Constructor");
    }

    private final int getBirthOrder() {

        if (siblings == 0) return 1;
        return new Random().nextInt(1, siblings + 2);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + birthOrderString + " child";
    }
}
