package section15_collections.challenge_hashmap;

import java.util.*;

public class AdventureMain {

    record Direction(String direction, Location location) {

        private Location findInDirection(String direction) {
            return this.direction.equals(direction) ? this.location : null;
        }

    }

    public static void main(String[] args) {

        Map<String, Location> map = new HashMap<>();
        Location forest = new Location("Forest", "at the edge of a thick dark forest",
                null, "Road", "Lake", null);
        Location hill = new Location("Hill", "on top of hill with a view in all directions",
                "Forest", null, "Road", null);
        Location road = new Location("Road", "start point",
                "Forest", "Valley", "WellHouse", "Hill");
        Location valley = new Location("Valley", "in a forest valley beside a tumbling stream",
                "Road", null, "Stream", "Hill");
        Location stream = new Location("Stream", "near a stream with a rocky bed",
                "WellHouse", null, null, "Valley");
        Location wellHouse = new Location("Well House", "inside a well house for a small spring",
                "Lake", "Stream", null, "Road");
        Location lake = new Location("Lake", "by an alpine lake surrounded by wildflowers",
                null, "WellHouse", null, "Forest");
        map.put("Forest", forest);
        map.put("Hill", hill);
        map.put("Road", road);
        map.put("Valley", valley);
        map.put("Stream", stream);
        map.put("WellHouse", wellHouse);
        map.put("Lake", lake);
        Location currentLocation = road;
        Scanner scanner = new Scanner(System.in);

        while (currentLocation != null) {
            System.out.printf("%nYou're standing %s%n", currentLocation.description());
            System.out.println("From here, you can see");
            printDirection(currentLocation);
            String input = scanner.next().toUpperCase();
            if ("EWSNQ".contains(input)) {
                switch (input) {
                    case "N" -> currentLocation = map.get(currentLocation.north());
                    case "S" -> currentLocation = map.get(currentLocation.south());
                    case "E" -> currentLocation = map.get(currentLocation.east());
                    case "W" -> currentLocation = map.get(currentLocation.west());
                    case "Q" -> currentLocation = null;
                }
            } else {
                System.out.println("Wrong input. Try again");
            }
        }

    }

    private static void printDirection(Location currentLocation) {
        if (currentLocation.north() != null) {
            System.out.printf("- A %s to the North (N)%n", currentLocation.north());
        }
        if (currentLocation.south() != null) {
            System.out.printf("- A %s to the South (S)%n", currentLocation.south());
        }
        if (currentLocation.east() != null) {
            System.out.printf("- A %s to the East (E)%n", currentLocation.east());
        }
        if (currentLocation.west() != null) {
            System.out.printf("- A %s to the West (W)%n", currentLocation.west());
        }
        System.out.print("Select Your Compass Direction (Q to quit): ");
    }

}
