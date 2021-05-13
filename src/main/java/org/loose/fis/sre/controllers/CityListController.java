package org.loose.fis.sre.controllers;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.dizitart.no2.SortOrder;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.services.UserService;
import org.loose.fis.sre.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static org.dizitart.no2.FindOptions.sort;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class CityListController implements Initializable {
    private static ObjectRepository<User> REPOSITORY = UserService.getUserRepository();
    private static ArrayList<String> listOfCity = new ArrayList<String>();
    private ObservableList<String> city = FXCollections.observableArrayList(listOfCity);
    private static String selectedCity;
    private Stage stage = new Stage();
    private Stage anotherStage;

    @FXML
    private Button bookListButton;
    @FXML
    private Button hotelsButton;
    @FXML
    private Button logoutButton;
    @FXML
    private ListView cityList;
    @FXML
    private TextField cityName;

    private Object TextFields;

    public static void getAllCity(){
        REPOSITORY = UserService.getUserRepository();
        Cursor<User> city = REPOSITORY.find(eq("role","City"),sort("nameOfCity", SortOrder.Ascending));
        listOfCity.clear();

    }

    public static ArrayList<String> getListOfAgencies() {
        return listOfCity;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int ROW_HEIGHT = 24;
        cityList.maxHeightProperty().bind(Bindings.size(city).multiply(ROW_HEIGHT));
        cityList.setItems(city);
        TextFields.bindAutoCompletion(cityName, city);
    }

    @FXML
    public void handleHotels(){
        if(cityName.getText().equals("")==false)
            selectedCity=cityName.getText();
        else
            selectedCity=(String)(cityList.getSelectionModel().getSelectedItem());
        try{
            HotelPageController.setSelectedCity(selectedCity);
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("HotelPage.fxml"));
            Parent root = loader.load();
            HotelPageController controller = loader.getController();
            controller.setAnotherStage(anotherStage);
            stage = (Stage) (hotelsButton.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    @FXML
    public void handleHistory() throws IOException {
        Stage stage = (Stage) bookListButton.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("history.fxml"));
        Parent root = loader.load();
        HistoryController controller = loader.getController();
        controller.setStage(anotherStage);
        stage = (Stage) bookListButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void handleLogout() {
        try{
            Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Stage stage = (Stage) (logoutButton.getScene().getWindow());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void setAnotherStage(Stage anotherStage) {
        this.anotherStage = anotherStage;
    }
}