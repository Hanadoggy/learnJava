import basic.*;
import exercise.*;
import exercise.Section8.*;

public class Main {

    public static void main(String[] args) {

        Car car = new Car(4, "ford");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

    }

}
