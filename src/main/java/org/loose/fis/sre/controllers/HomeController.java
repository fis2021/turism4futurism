package org.loose.fis.sre.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.Booking;
import org.loose.fis.sre.services.BookingService;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class HomeController{

    private static String username;
    private Stage anotherStage;
    private static ObjectRepository<Booking> BOOKING_REPOSITORY = BookingService.getBookingRepository();
    private int ok;

    @FXML
    private Button logoutButton;
    @FXML
    private Button cityListButton;


    @FXML
    public void initialize() {
        findBookings();
        Platform.runLater(()->{
            if(ok == 1) messageText.setText("hi there");
        });
    }

    @FXML
    public void handleCityList(){
        try {
            CityListController.getAllCity();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("cityList.fxml"));
            Parent root = loader.load();
            anotherStage = (Stage) (bookListButton.getScene().getWindow());
            CityListController controller = loader.getController();
            controller.setAnotherStage(anotherStage);
            Stage stage = (Stage) (cityListButton.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    @FXML
    public void handleLogout() {
        try {
            Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Stage stage = (Stage) (logoutButton.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    @FXML
    public  void handleHistory() throws Exception{
        try {
            CityListController.getAllCity();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("historyBooking.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) (bookListButton.getScene().getWindow());
            anotherStage = (Stage) (bookListButton.getScene().getWindow());
            HistoryBookingController controller = loader.getController();
            controller.setStage(anotherStage);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void findBookings() {
        try {
            this.ok = 0;
            BOOKING_REPOSITORY = BookingService.getBookingRepository();
            Cursor<Booking> cursor = BOOKING_REPOSITORY.find(eq("clientUsername", username));
            for (Booking b : cursor) {
                if (b.getMessage().contains("Accepted") || b.getMessage().contains("Rejected")) {
                    Date d1,d2;
                    LocalDate now = LocalDate.now();
                    String date1 = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    d1 = formatter.parse(date1);
                    d2 = formatter.parse(b.getCheckOutDate());
                    if(d2.compareTo(d1) >= 0) {
                        this.ok = 1;
                    }
                }

            }

        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

    }

    public static void setUsername(String username) {
        HomePageController.username = username;
    }
}