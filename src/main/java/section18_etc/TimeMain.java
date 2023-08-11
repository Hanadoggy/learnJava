package section18_etc;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class TimeMain {

    public static void main(String[] args) {

        System.setProperty("user.timezone", "Asia/Tokyo");

        System.out.println(ZoneId.systemDefault());
        System.out.println("Number of TZs = " + ZoneId.getAvailableZoneIds().size());
        ZoneId.getAvailableZoneIds().stream()
                .filter(s -> s.startsWith("Asia"))
                .sorted()
                .map(ZoneId::of)
                .forEach(z -> System.out.println(z.getId() + " : " + z.getRules()));

        Set<String> jdk8zones = ZoneId.getAvailableZoneIds();
        String[] alter = TimeZone.getAvailableIDs();
        Set<String> oldway = new HashSet<>(Set.of(alter));

        oldway.retainAll(jdk8zones);
        System.out.println(oldway);
        ZoneId bet = ZoneId.of("BET", ZoneId.SHORT_IDS);
        System.out.println(bet);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        Instant instantNow = Instant.now();
        System.out.println(instantNow);

        for (ZoneId z : List.of(
                ZoneId.of("Asia/Tokyo"),
                ZoneId.of("America/New_York"),
                ZoneId.of("Australia/Sydney"))) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("Z:ZZZZ");
            System.out.println(z);
            System.out.println("\t" + instantNow.atZone(z).format(format));
            System.out.println("\t" + z.getRules().getDaylightSavings(instantNow));
            System.out.println("\t" + z.getRules().isDaylightSavings(instantNow));
        }

        Instant dobInstant = Instant.parse("2020-01-01T06:02:00Z");
        LocalDateTime dob = LocalDateTime.ofInstant(dobInstant, ZoneId.of("America/New_York"));
        System.out.println("Your kid's birthdate, LA time = " + dob.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        ZonedDateTime dobTokyo = ZonedDateTime.ofInstant(dobInstant,
                ZoneId.of("Asia/Tokyo"));
        System.out.println("Your kid's birthdate, Tokyo Time = " + dobTokyo.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    }

}
