package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.text.Text;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.collections.ObservableList;

import org.loose.fis.sre.services.HotelService;
import org.loose.fis.sre.model.Hotels;

import java.io.IOException;
import java.util.Objects;


public class ViewProductsClientController{

    @FXML
    private Text viewProductsClientMessage;

    @FXML
    private TableView tableView;

    @FXML
    public void initialize() {
        ObservableList<Hotels> data = tableView.getItems();
        for (Hotels hotels : HotelService.hotelRepository.find()) {
            data.add(new Hotels(hotels.getCityName(), hotels.getHotelName(), hotels.getPrice()));
        }
        tableView.getSelectionModel().clearSelection();
    }


    @FXML
    public void handleBackButtonAction()
    {
        try {
            Stage stage = (Stage) viewProductsClientMessage.getScene().getWindow();
            Parent Login = FXMLLoader.load(getClass().getClassLoader().getResource("client.fxml"));
            Scene scene = new Scene(Login, 900, 600);
            stage.setScene(scene);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}