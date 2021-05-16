package org.loose.fis.sre.services;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.loose.fis.sre.exceptions.DestinationIncompleteException;
import org.loose.fis.sre.exceptions.IncorrectPasswordException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Destination;
import org.loose.fis.sre.model.User;

import javax.crypto.Cipher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DestinationServiceTest {

    public static final String CITY = "city";
    public static final String HOTEL = "hotel";
    public static final String BUS = "Bus";
    public static final double PRICE = 100;

    @BeforeEach
    void setUp() throws Exception{
        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        //UserService.initDatabase();
        DestinationService.initDatabase();
    }

    @AfterEach
    void tearDown() {
        DestinationService.close();
      //  UserService.close();
    }

    @Test
    @DisplayName("Destination database is initialized and there are no users")
    void testDataBaseIsInitializedAndNoUserIsPersisted() {
        assertThat(DestinationService.getAllUsers()).isNotNull();
        //assertThat(DestinationService.getAllUsers()).isEmpty();
    }

    @Test
    @DisplayName("Destination is successfully persisted to Database")
    void testDestinationIsAddedToDatabase() throws DestinationIncompleteException {

        DestinationService.addDestination(CITY, HOTEL, BUS, PRICE);
        assertThat(DestinationService.getAllUsers()).isNotEmpty();
        assertThat(DestinationService.getAllUsers()).size().isEqualTo(1);

        Destination destination = DestinationService.getAllUsers().get(0);

        assertThat(destination.getCity()).isEqualTo(CITY);
        assertThat(destination.getHotel()).isEqualTo(HOTEL);
        assertThat(destination.getTypeOfTransport()).isEqualTo(BUS);
        assertThat(destination.getPricePerson()).isEqualTo(PRICE);
    }

}