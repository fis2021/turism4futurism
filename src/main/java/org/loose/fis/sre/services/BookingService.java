package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.Booking;

import java.util.List;

import static org.loose.fis.sre.services.FileSystemService.getPathToBooking;

public class BookingService {
    private static ObjectRepository<Booking> bookingRepository;
    private static Nitrite database;

    public static void initDatabase() {
        FileSystemService.initBookingDirectory();
        database = Nitrite.builder()
                .filePath(getPathToBooking("bookings.db").toFile())
                .openOrCreate("test", "test");

        bookingRepository = database.getRepository(Booking.class);
    }

    public static void addBooking(String id, String clientUsername, String cityName, String hotelName, String nrPers, String totalPrice, String checkInDate, String checkOutDate) {
        bookingRepository.insert(new Booking(id,clientUsername,cityName, hotelName,nrPers,totalPrice,checkInDate,checkOutDate));
    }

    public static Nitrite getDatabase() {
        return database;
    }

    public static ObjectRepository<Booking> getBookingRepository() {
        return bookingRepository;
    }

    public static List<Booking> getAllBookings() {
        return bookingRepository.find().toList();
    }
}