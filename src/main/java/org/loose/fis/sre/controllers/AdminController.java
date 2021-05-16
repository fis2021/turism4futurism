package org.loose.fis.sre.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;


public class AdminController {

    @FXML
    private Button addDestinationButton;

    @FXML
    private Button removeDestinationButton;

    @FXML
    private Button logoutAdminButton;

    public void handleAddDestination() throws IOException {
        Stage primary = new Stage();
        Stage stage = (Stage) addDestinationButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("addDestination.fxml"));
        Scene nextScene = new Scene(root, 600, 400);
        primary.setScene(nextScene);
        primary.show();
    }

    public void handleRemoveDestination() throws IOException {
        Stage primary = new Stage();
        Stage stage = (Stage) removeDestinationButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("removeDestination.fxml"));
        Scene nextScene = new Scene(root, 600, 400);
        primary.setScene(nextScene);
        primary.show();
    }

    public void handleLogoutAdmin() throws IOException {
        Stage primary = new Stage();
        Stage stage = (Stage) logoutAdminButton.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        Scene nextScene = new Scene(root, 600, 400);
        primary.setScene(nextScene);
        primary.show();
    }
}
