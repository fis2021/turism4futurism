package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.services.BookingService;
import org.loose.fis.sre.services.HotelService;
import org.loose.fis.sre.services.UserService;


public class Main extends Application {


    public void start(Stage stage) throws Exception {
        UserService.initDatabase();
        HotelService.initDatabase();
        BookingService.initDatabase();
        Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}