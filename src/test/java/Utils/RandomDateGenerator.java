package Utils;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateGenerator {
    public static String generateRandomDate(LocalDate startDate, LocalDate endDate) {
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);

        LocalDate randomDate = LocalDate.ofEpochDay(randomEpochDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return randomDate.format(formatter); // Format the date
    }

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(1950, 1, 1);
        LocalDate endDate = LocalDate.of(2010, 12, 31);

        // Generate a random date
        String randomDate = generateRandomDate(startDate, endDate);

        System.out.println("Random Date: " + randomDate);
    }
    public static @NotNull String generateRandomPastTradeLicenseDate() {
        // Get the current date
        LocalDate now = LocalDate.now();

        // Generate a random past date within the last 5 years
        long randomDays = ThreadLocalRandom.current().nextLong(1, 5 * 365);
        LocalDate randomPastDate = now.minusDays(randomDays);

        // Format the date as "12-Mar-2025"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        return randomPastDate.format(formatter);
    }
    public static String generateRandomFutureExpiryDate() {
        LocalDate now = LocalDate.now();

        // Generate a random expiry date within the next 1 to 10 years
        long randomDays = ThreadLocalRandom.current().nextLong(1, 10 * 365);
        LocalDate randomFutureDate = now.plusDays(randomDays);

        // Format the date as "12-Mar-2025"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        return randomFutureDate.format(formatter);
    }

    private static final String[] STREET_NAMES = {
            "Main St", "Highland Ave", "Broadway", "Park Ave", "Oak St", "Maple Rd", "Sunset Blvd", "5th Avenue"
    };

    private static final String[] CITY_NAMES = {
            "New York", "Los Angeles", "San Francisco", "Miami", "Chicago", "Houston", "Dallas", "Dubai"
    };

    private static final String[] STATE_NAMES = {
            "NY", "CA", "TX", "FL", "IL", "WA", "CO", "Dubai"
    };

    private static final Random random = new Random();

    public static String generateRandomCompanyAddress() {
        int streetNumber = random.nextInt(9999) + 1;
        String streetName = STREET_NAMES[random.nextInt(STREET_NAMES.length)];
        String city = CITY_NAMES[random.nextInt(CITY_NAMES.length)];
        String state = STATE_NAMES[random.nextInt(STATE_NAMES.length)];
        int zipCode = 10000 + random.nextInt(90000); // Generates 5-digit zip code

        return streetNumber + " " + streetName + ", " + city + ", " + state + " " + zipCode;
    }

}
