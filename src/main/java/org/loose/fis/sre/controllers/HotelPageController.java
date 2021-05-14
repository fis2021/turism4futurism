package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Hotels;
import org.loose.fis.sre.services.HotelService;

import java.io.IOException;

public class HotelPageController {

    @FXML
    private Button backButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button bookYourChoice;

    @FXML
    private TableColumn<TableSetterGetter, String> cityName;

    @FXML
    private TableColumn<TableSetterGetter, String> hotelName;

    @FXML
    private TableColumn<TableSetterGetter, Integer> price;

    @FXML
    private TableColumn<TableSetterGetter, CheckBox> select;

    @FXML
    private TableView<TableSetterGetter> tableView;

    ObservableList<TableSetterGetter> list = FXCollections.observableArrayList();

    public void backButton() throws IOException {
        Stage primary = new Stage();
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("home.fxml"));
        Scene nextScene = new Scene(root, 600, 400);
        primary.setScene(nextScene);
        primary.show();
    }

    public void logoutButton() throws IOException {
        Stage primary = new Stage();
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        Scene nextScene = new Scene(root, 600, 400);
        primary.setScene(nextScene);
        primary.show();
    }

    public void bookYourChoice() throws IOException {
        Stage primary = new Stage();
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("book.fxml"));
        Scene nextScene = new Scene(root, 600, 400);
        primary.setScene(nextScene);
        primary.show();
    }


    @FXML
    public void initialize() {
        ObservableList<TableSetterGetter> data = tableView.getItems();
        for (Hotels hotels : HotelService.hotelRepository.find()) {
            data.add(new TableSetterGetter(hotels.getCityName(), hotels.getHotelName(), hotels.getPrice()));
        }
        tableView.getSelectionModel().clearSelection();
    }








}
