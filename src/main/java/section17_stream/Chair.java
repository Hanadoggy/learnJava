package section17_stream;

import java.util.Random;

public record Chair(char rowMarker, int seatNumber, boolean isReserved) {

    public Chair(char rowMarker, int seatNumber) {
//        this(rowMarker, seatNumber, new Random().nextBoolean());
        this(rowMarker, seatNumber, false);
    }
}
