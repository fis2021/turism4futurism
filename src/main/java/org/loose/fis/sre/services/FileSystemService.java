package org.loose.fis.sre.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService{
    public static String APPLICATION_FOLDER = ".users";
    public static String HOTELS_FOLDER =".hotels";
    public static String BOOKINGS_FOLDER =".bookings";
    private static final String USER_FOLDER = System.getProperty("user.home");

    public static Path getPathToFile(String... path) {
        return getApplicationHomeFolder().resolve(Paths.get(".", path));
    }

    public static Path getPathToHotel(String... path) {
        return getHotelsHomeFolder().resolve(Paths.get(".", path));
    }

    public static Path getApplicationHomeFolder() {
        return Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    }

    public static Path getHotelsHomeFolder(){
        return Paths.get(USER_FOLDER,HOTELS_FOLDER);
    }

    public static Path getBookingsHomeFolder() {
        return Paths.get(USER_FOLDER,BOOKINGS_FOLDER);
    }

    public static void initDirectory() {
        Path applicationHomePath = FileSystemService.getApplicationHomeFolder();
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }

    public static void initBookingDirectory() {
        Path bookingsHomePath = FileSystemService.getBookingsHomeFolder();
        if (!Files.exists(bookingsHomePath))
            bookingsHomePath.toFile().mkdirs();
    }

    public static void initHotelsDirectory(){
        Path hotelsHomePath = FileSystemService.getHotelsHomeFolder();
        if (!Files.exists(hotelsHomePath))
            hotelsHomePath.toFile().mkdirs();
    }

    public static Path getPathToBooking(String... path) {
        return getBookingsHomeFolder().resolve(Paths.get(".", path));
    }
}