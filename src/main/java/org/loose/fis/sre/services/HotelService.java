package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.Hotels;

import java.util.List;

import static org.loose.fis.sre.services.FileSystemService.getPathToHotel;


public class HotelService {
    private static ObjectRepository<Hotels> offerRepository;
    private static Nitrite database;

    public static void initDatabase() {
        FileSystemService.initHotelsDirectory();
        database = Nitrite.builder()
                .filePath(getPathToHotel("hotels.db").toFile())
                .openOrCreate("test", "test");

        offerRepository = database.getRepository(Hotels.class);
    }

    public static void addOffer(String id, String nameOfAgency, String hotelName, String price) {
        offerRepository.insert(new Hotels(id, cityName, hotelName, price));
    }

    public static ObjectRepository<Hotels> getHotelsRepository() {
        return hotelsRepository;
    }

    public static Nitrite getDatabase() {
        return database;
    }

    public static List<Hotels> getAllHotels() {
        return hotelsRepository.find().toList();
    }
}