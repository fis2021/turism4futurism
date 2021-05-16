package org.loose.fis.sre.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.fis.sre.exceptions.DestinationIncompleteException;
import org.loose.fis.sre.services.DestinationService;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class ChooseDestinationControllerTest {

    public static final String CITY = "city";
    public static final String ANOTHER_CITY = "another city";
    public static final String HOTEL = "hotel";
    public static final String BUS = "Bus";
    public static final double PRICE = 100;

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
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("chooseDestination.fxml"));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("Client Test");
        primaryStage.show();
    }

    @Test
    @DisplayName("Verify logout button is working properly")
    void testBackButton(FxRobot robot) {
        robot.clickOn("#cancelButton");
        robot.clickOn("#clientWindow");
    }

    @Test
    @DisplayName("Test - booking is working properly")
    void testBookingWorksProperly(FxRobot robot) throws Exception {

        DestinationService.addDestination(CITY, HOTEL, BUS, PRICE);

        robot.clickOn("#refreshTableButton");
        robot.clickOn("#tableView");
        robot.clickOn("city");
        robot.clickOn("#noOfNightsTextField");
        robot.write("3");

        Assertions.assertThat(robot.lookup("#totalPriceText").queryText()).hasText(String.format("300.0"));
    }

    @Test
    @DisplayName("Test - search field is working properly")
    void testSearchFieldIsWorkingProperly(FxRobot robot) throws Exception {

        DestinationService.addDestination(CITY, HOTEL, BUS, PRICE);
        DestinationService.addDestination(ANOTHER_CITY, HOTEL, BUS, PRICE);

        robot.clickOn("#refreshTableButton");
        robot.clickOn("#searchByCityField");
        robot.write("city");
        robot.clickOn("#searchButton");
        robot.clickOn("#tableView");
        robot.clickOn("city");
        robot.clickOn("#noOfNightsTextField");
        robot.write("3");

        Assertions.assertThat(robot.lookup("#totalPriceText").queryText()).hasText(String.format("300.0"));
    }

}