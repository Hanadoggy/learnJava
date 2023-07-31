package section7_inheritance;

/**
 * 일반적으로 Record는 class body를 가지지 않지만 상속 받은 경우 상속 받은 메서드를 선언해줘야함
 */
public record DragonFly(String name, String type) implements FlightEnabled {

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}
