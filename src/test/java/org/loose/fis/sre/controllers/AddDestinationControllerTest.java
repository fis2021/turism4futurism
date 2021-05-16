package org.loose.fis.sre.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.fis.sre.services.DestinationService;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class AddDestinationControllerTest {

    public static final String CITY = "city";
    public static final String HOTEL = "hotel";
    public static final String BUS = "Bus";
    public static final String PRICE = "100";
    public static final String INVALID_PRICE = "100euro";
    public static final String PLANE = "Plane";

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
        DestinationService.initDatabase();
    }

    @AfterEach
    void tearDown() throws Exception {
        DestinationService.close();
        UserService.close();
    }

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addDestination.fxml"));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("Add Destination Test");
        primaryStage.show();
    }

    @Test
    @DisplayName("Verify that cancel button is working properly")
    void testCancelButton(FxRobot robot) {
        robot.clickOn("#cancelButton");
        robot.clickOn("#adminWindow");
    }

    @Test
    @DisplayName("Add a destination correctly - bus")
    void testAddDestinationCorrectlyForBus(FxRobot robot) {
        robot.clickOn("#cityField");
        robot.write(CITY);
        robot.clickOn("#hotelField");
        robot.write(HOTEL);
        robot.clickOn("#transportType");
        robot.clickOn(BUS);
        robot.clickOn("#priceField");
        robot.write(PRICE);

        robot.clickOn("#saveButton");
        assertThat(robot.lookup("#addDestinationMessage").queryText()).hasText("Destination added successfully!");
    }

    @Test
    @DisplayName("Invalid price - bus")
    void testInvalidPriceForBus(FxRobot robot) {
        robot.clickOn("#cityField");
        robot.write(CITY);
        robot.clickOn("#hotelField");
        robot.write(HOTEL);
        robot.clickOn("#transportType");
        robot.clickOn(BUS);
        robot.clickOn("#priceField");
        robot.write(INVALID_PRICE);

        robot.clickOn("#saveButton");
        assertThat(robot.lookup("#addDestinationMessage").queryText()).hasText("The price is invalid!");
    }

    @Test
    @DisplayName("Add a destination correctly - plane")
    void testAddDestinationCorrectlyForPlane(FxRobot robot) {
        robot.clickOn("#cityField");
        robot.write(CITY);
        robot.clickOn("#hotelField");
        robot.write(HOTEL);
        robot.clickOn("#transportType");
        robot.clickOn(PLANE);
        robot.clickOn("#priceField");
        robot.write(PRICE);

        robot.clickOn("#saveButton");
        assertThat(robot.lookup("#addDestinationMessage").queryText()).hasText("Destination added successfully!");
    }

    @Test
    @DisplayName("Invalid price - plane")
    void testInvalidPriceForPlane(FxRobot robot) {
        robot.clickOn("#cityField");
        robot.write(CITY);
        robot.clickOn("#hotelField");
        robot.write(HOTEL);
        robot.clickOn("#transportType");
        robot.clickOn(PLANE);
        robot.clickOn("#priceField");
        robot.write(INVALID_PRICE);

        robot.clickOn("#saveButton");
        assertThat(robot.lookup("#addDestinationMessage").queryText()).hasText("The price is invalid!");
    }

    @Test
    @DisplayName("Not enough data of the destination - city field empty")
    void test(FxRobot robot) {
        robot.clickOn("#hotelField");
        robot.write(HOTEL);
        robot.clickOn("#transportType");
        robot.clickOn(PLANE);
        robot.clickOn("#priceField");
        robot.write(PRICE);

        robot.clickOn("#saveButton");
        assertThat(robot.lookup("#addDestinationMessage").queryText()).hasText("Not enough data of the destination!");
    }

}