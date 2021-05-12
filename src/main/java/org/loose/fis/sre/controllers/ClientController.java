package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;

public class ClientController {

    @FXML
    private Button chDestButton;

    @FXML
    private Button avDestButton;

    @FXML
    private Button logoutButton;

    public void handleChooseDestination() throws IOException {
        Stage primary = new Stage();
        Stage stage = (Stage) chDestButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("chooseDestination.fxml"));
        Scene nextScene = new Scene(root, 600, 400);
        primary.setScene(nextScene);
        primary.show();
    }

    public void handleAvailableDestinations() throws IOException {
        Stage primary = new Stage();
        Stage stage = (Stage) avDestButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("availableDestinations.fxml"));
        Scene nextScene = new Scene(root, 600, 400);
        primary.setScene(nextScene);
        primary.show();
    }

    public void handleLogout() throws IOException {
        Stage primary = new Stage();
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        Scene nextScene = new Scene(root, 600, 400);
        primary.setScene(nextScene);
        primary.show();
    }

}
