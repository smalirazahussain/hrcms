package Tests;//package Tests;//package Tests;
////
////import java.time.LocalDate;
////import java.util.Random;
////
////public class Generate_Random_Date {
////
////    public LocalDate generateRandomDate() {
////        Random random = new Random();
////
////        // Generate random year between a certain range (e.g., 1970 and 2023)
////        int year = random.nextInt(2023 - 1970 + 1) + 1970;
////
////        // Generate random month (1-12)
////        int month = random.nextInt(12) + 1;
////
////        // Generate random day based on the month
////        int maxDay = 31; // Set a default maximum day
////        if (month == 4 || month == 6 || month == 9 || month == 11) {
////            maxDay = 30;
////        } else if (month == 2) {
////            // February can have 28 or 29 days depending on leap year
////            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
////                maxDay = 29;
////            } else {
////                maxDay = 28;
////            }
////        }
////        int day = random.nextInt(maxDay) + 1;
////
////        // Create a Date object
////        return LocalDate.of(year, month, day);
////       // return LocalDate.of(year - 1900, month - 1, day);
////        //return LocalDate.of(day, month - 1, year - 1900);
////    }
////
////    }
////
////
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Random;
//import java.util.Locale;
//
//public class Generate_Random_Date {
//
//    public String generateFormattedRandomDate() {
//        Random random = new Random();
//
//        // Generate random year between a certain range (e.g., 1970 and 2023)
//        int year = random.nextInt(2023 - 1970 + 1) + 1970;
//
//        // Generate random month (1-12)
//        int month = random.nextInt(12) + 1;
//
//        // Generate random day based on the month
//        int maxDay = 31; // Set a default maximum day
//        if (month == 4 || month == 6 || month == 9 || month == 11) {
//            maxDay = 30;
//        } else if (month == 2) {
//            // February can have 28 or 29 days depending on leap year
//            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
//                maxDay = 29;
//            } else {
//                maxDay = 28;
//            }
//        }
//        int day = random.nextInt(maxDay) + 1;
//
//        // Create a LocalDate object
//        LocalDate randomDate = LocalDate.of(year, month, day);
//
//        // Format the LocalDate using the desired format "dd-MMM-yyyy" with English month abbreviation
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
//        return randomDate.format(formatter);
//    }
//
//
//}
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Locale;

public class Generate_Random_Date {

    public static String generateFormattedRandomDate() {
        Random random = new Random();

        // Generate random year between a certain range (e.g., 1970 and 2023)
        int year = random.nextInt(2023 - 1970 + 1) + 1970;

        // Generate random month (1-12)
        int month = random.nextInt(12) + 1;

        // Generate random day based on the month
        int maxDay = 31; // Set a default maximum day
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDay = 30;
        } else if (month == 2) {
            // February can have 28 or 29 days depending on leap year
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                maxDay = 29;
            } else {
                maxDay = 28;
            }
        }
        int day = random.nextInt(maxDay) + 1;

        // Create a LocalDate object
        LocalDate randomDate = LocalDate.of(year, month, day);

        // Format the LocalDate using the desired format "dd-MMM-yyyy" with English month abbreviation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
        return randomDate.format(formatter);
    }

    public static @NotNull String generateFormattedRandomFutureDate() {
        Random random = new Random();

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Generate random year between a certain range (e.g., 1970 and 2023)
        int year = random.nextInt(2050 - 2024 + 1) + 2024;

        // Generate random month (1-12)
        int month = random.nextInt(12) + 1;

        // Generate random day based on the month
        int maxDay = 31; // Set a default maximum day
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDay = 30;
        } else if (month == 2) {
            // February can have 28 or 29 days depending on leap year
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                maxDay = 29;
            } else {
                maxDay = 28;
            }
        }

        // Generate random day that is after the current day
        int day = random.nextInt(maxDay - currentDate.getDayOfMonth()) + currentDate.getDayOfMonth() + 1;

        // Create a LocalDate object
        LocalDate randomDate = LocalDate.of(year, month, day);

        // Format the LocalDate using the desired format "dd-MMM-yyyy" with English month abbreviation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
        return randomDate.format(formatter);
    }
}
