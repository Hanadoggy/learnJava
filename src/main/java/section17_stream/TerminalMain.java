package section17_stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TerminalMain {

    public static void main(String[] args) {

        var result = IntStream.iterate(0, i -> i <= 1000, i -> i = i + 3)
                .summaryStatistics();
        System.out.println("Result = " + result);

        var leapYearData = IntStream.iterate(2000, i -> i <= 2025, i -> i = i + 1)
                .filter(i -> i % 4 == 0)
                .peek(System.out::println)
                .summaryStatistics();
        System.out.println("Leap Year Data = " + leapYearData);

        Chair[] chairs = new Chair[100];
        Arrays.setAll(chairs, i -> new Chair((char) ('A' + i / 10), i % 10 + 1));
//        Arrays.asList(chairs).forEach(System.out::println);

        long reservationCount = Arrays.stream(chairs)
                .filter(Chair::isReserved)
                .count();
        System.out.println("reservationCount = " + reservationCount);

        boolean hasBookings = Arrays.stream(chairs)
                .anyMatch(Chair::isReserved);
        System.out.println("hasBookings = " + hasBookings);

        boolean fullyBooked = Arrays.stream(chairs)
                .allMatch(Chair::isReserved);
        System.out.println("fullyBooked = " + fullyBooked);

        boolean eventWashedOut = Arrays.stream(chairs)
                .noneMatch(Chair::isReserved);
        System.out.println("eventWashedOut = " + eventWashedOut);






    }

}
