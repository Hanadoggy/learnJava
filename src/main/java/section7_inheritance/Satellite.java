package section7_inheritance;

public class Satellite implements OrbitEarth {

    FlightStages stage = FlightStages.GROUNDED;

    public void transition(String description) {

        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }

    @Override
    public void takeOff() {
        transition("Taking Off");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data Collection while Orbiting");
    }

    @Override
    public void achieveOrbit() {
        transition("Orbit achieved!");
    }
}
