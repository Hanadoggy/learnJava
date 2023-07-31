package section7_inheritance;

import java.util.Date;

public interface OrbitEarth extends FlightEnabled {

    void achieveOrbit();

    private static void log(String description) {
        var today = new Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description) {
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {

        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Begging Transition to " + nextStage);

        return nextStage;
    }
}
