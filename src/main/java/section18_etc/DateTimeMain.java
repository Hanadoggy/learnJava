package section18_etc;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTimeMain {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate Five5 = LocalDate.of(2022, 5, 5);
        System.out.println(Five5);

        LocalDate may5th = LocalDate.of(2022, Month.MAY, 5);
        System.out.println(may5th);

        LocalDate day125 = LocalDate.ofYearDay(2022, 125);
        System.out.println(day125);

        LocalDate may5 = LocalDate.parse("2022-05-05");
        System.out.println(may5);

        System.out.println(may5.getYear() + " " + may5.getMonth() + " " + may5.getMonthValue() +
                " " + may5.getDayOfMonth() + " " + may5.getDayOfWeek() + " " + may5.getDayOfYear());

        System.out.println(may5.get(ChronoField.YEAR));
        System.out.println(may5.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(may5.get(ChronoField.DAY_OF_MONTH));
        System.out.println(may5.get(ChronoField.DAY_OF_YEAR));

        System.out.println(may5.withYear(2000));
        System.out.println(may5.withMonth(3));
        System.out.println(may5.withDayOfMonth(4));
        System.out.println(may5.withDayOfYear(126));
        System.out.println(may5);
        System.out.println(may5.with(ChronoField.DAY_OF_YEAR, 126));
        System.out.println(may5.plusYears(1));
        System.out.println(may5.plusMonths(12));
        System.out.println(may5.plusDays(365));
        System.out.println(may5.plusWeeks(52));
        System.out.println(may5.plus(365, ChronoUnit.DAYS));

        System.out.println("May5 > today ? " + may5.isAfter(today));
        System.out.println("today > May5 ? " + may5.isBefore(today));

        System.out.println("May5 > today ? " + may5.compareTo(today));
        System.out.println("today > May5 ? " + today.compareTo(may5));
        System.out.println("today = now ? " + today.compareTo(LocalDate.now()));
        System.out.println("today = now ? " + today.equals(LocalDate.now()));
        System.out.println(today.isLeapYear());
        System.out.println(may5.minusYears(2).isLeapYear());


        System.out.println("------------------------------");
        may5.datesUntil(may5.plusDays(7))
                .forEach(System.out::println);

        System.out.println("------------------------------");
        may5.datesUntil(may5.plusYears(1), Period.ofDays(7))
                .forEach(System.out::println);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime sevenAM = LocalTime.of(7, 0);
        System.out.println(sevenAM);

        LocalTime sevenThirty = LocalTime.of(7, 30, 15);
        System.out.println(sevenThirty);

        LocalTime sevenPM = LocalTime.parse("19:00");
        LocalTime sevenThirtyPM = LocalTime.parse("19:30:15.1000");
        System.out.println(sevenPM.get(ChronoField.AMPM_OF_DAY));
        System.out.println(sevenThirtyPM.get(ChronoField.AMPM_OF_DAY));

        System.out.println(sevenThirtyPM.getHour());
        System.out.println(sevenThirtyPM.get(ChronoField.HOUR_OF_DAY));
    }

}
