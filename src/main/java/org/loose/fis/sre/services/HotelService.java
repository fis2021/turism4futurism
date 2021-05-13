package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.Hotels;

import java.util.List;

import static org.loose.fis.sre.services.FileSystemService.getPathToHotel;


public class HotelService {
    private static ObjectRepository<Hotels> hotelRepository;
    private static Nitrite database;

    public static void initDatabase() {
        FileSystemService.initHotelsDirectory();
        database = Nitrite.builder()
                .filePath(getPathToHotel("hotels.db").toFile())
                .openOrCreate("test", "test");

        hotelRepository = database.getRepository(Hotels.class);
    }

    public static void addHotel(String id, String cityName, String hotelName, String price) {
        hotelRepository.insert(new Hotels(id, cityName, hotelName, price));
    }

    public static ObjectRepository<Hotels> getHotelsRepository() {
        return hotelRepository;
    }

    public static Nitrite getDatabase() {
        return database;
    }

    public static List<Hotels> getAllHotels() {
        return hotelRepository.find().toList();
    }
}