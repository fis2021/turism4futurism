package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class HomeController{

    @FXML
    private Button logoutButton;

    @FXML
    private Button hotelsButton;

    @FXML
    private Button historyButton;

    public void handlehotels() throws IOException {
        Stage primary = new Stage();
        Stage stage = (Stage) hotelsButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("hotels.fxml"));
        Scene nextScene = new Scene(root, 600, 400);
        primary.setScene(nextScene);
        primary.show();
    }


    public void handleHistory() throws IOException {
        Stage primary = new Stage();
        Stage stage = (Stage) historyButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("history.fxml"));
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