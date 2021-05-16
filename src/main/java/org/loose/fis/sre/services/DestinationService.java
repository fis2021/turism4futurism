package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.DestinationIncompleteException;
import org.loose.fis.sre.exceptions.IncorrectPasswordException;
import org.loose.fis.sre.exceptions.UsernameDoesNotExistsException;
import org.loose.fis.sre.model.Destination;
import org.loose.fis.sre.model.User;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;
import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class DestinationService {

    private static ObjectRepository<Destination> destinationRepository;
    private static Nitrite database;

    public static void initDatabase() {

        database = Nitrite.builder()
                .filePath(getPathToFile("destination.db").toFile())
                .openOrCreate("test", "test");

        destinationRepository = database.getRepository(Destination.class);
    }

    public static void addDestination(String city, String hotel, String typeOfTransport, double price) throws DestinationIncompleteException {
        if ((city.equals("")) || (hotel.equals("")) || (typeOfTransport.equals(""))) throw new DestinationIncompleteException();
        destinationRepository.insert(new Destination(city, hotel, typeOfTransport, price));
    }

    public static List<Destination> getAllUsers() {
        return destinationRepository.find().toList();
    }

    public static ArrayList<Destination> getAllDestinations() {
        ArrayList<Destination> list = new ArrayList<>();
        for(Destination destination : destinationRepository.find()) {
            list.add(destination);
        }
        return list;
    }

    public static void removeDestination(Destination destination) {
        destinationRepository.remove(eq("hotel",destination.getHotel()));
    }


    public static List<Destination> getDestinationByCity(String city) {
        ArrayList<Destination> list = new ArrayList<>();
        for(Destination destination : destinationRepository.find()) {
            if(destination.getCity().equals(city))list.add(destination);
        }
        return list;
    }

    public static void close() {
        destinationRepository.close();
        database.close();
    }
}
