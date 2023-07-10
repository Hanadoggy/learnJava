package basic.interfaces;

public class Test {

    public static void main(String[] args) {

        inFLight(new Jet());

//        OrbitEarth.log("Testing " + new Satellite());

        orbit(new Satellite());
    }

    private static void inFLight(FlightEnabled flier) {
        flier.takeOff();
        flier.transition(FlightStages.LAUNCH);
        flier.fly();
        if (flier instanceof Trackable trackable) {
            trackable.track();
        }
        flier.land();
    }

    private static void orbit(OrbitEarth flier) {

        flier.takeOff();
        flier.fly();
        flier.land();
    }
}
