import basic.*;
import exercise.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(Section6.exercise29(3.4, 2.1, 1.5, 2));
        System.out.println(Section6.exercise29(2.75, 3.25, 2.5, 1));
        System.out.println(Section6.exercise29(3.4, 2.1, 1.5));
        System.out.println(Section6.exercise29(7.25, 4.3, 2.35));
        System.out.println(Section6.exercise29(3.4, 1.5));
        System.out.println(Section6.exercise29(6.26, 2.2));
        System.out.println(Section6.exercise29(3.26, 0.75));
    }

    private static void runPrimitiveType() {

        PrimitiveType.printNum();
        PrimitiveType.printString();
        PrimitiveType.printCompoundAssignOperator();
    }
}
