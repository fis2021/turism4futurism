package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.model.Destination;
import org.loose.fis.sre.services.DestinationService;

import java.io.IOException;
import java.util.List;

public class RemoveDestinationController {

    public TableView<Destination> table;
    @FXML
    private Button backButton;

    public TableColumn<Destination, String> city;
    public TableColumn<Destination, String> hotel;
    public TableColumn<Destination, String> typeOfTransport;
    public TableColumn<Destination, Double> pricePerson;

    private void initTableColumns(TableView<Destination> tableview)
    {
        city = new TableColumn<>("City");
        city.setMinWidth(100);
        city.setCellValueFactory(new PropertyValueFactory<>("city"));

        hotel = new TableColumn<>("Hotel");
        hotel.setMinWidth(100);
        hotel.setCellValueFactory(new PropertyValueFactory<>("hotel"));

        typeOfTransport = new TableColumn<>("Type Of Transport");
        typeOfTransport.setMinWidth(100);
        typeOfTransport.setCellValueFactory(new PropertyValueFactory<>("typeOfTransport"));

        pricePerson = new TableColumn<>("Price per Person");
        pricePerson.setMinWidth(100);
        pricePerson.setCellValueFactory(new PropertyValueFactory<>("pricePerson"));

        table.getColumns().addAll(city,hotel,typeOfTransport,pricePerson);
    }

    public void handleRefresh()
    {
        table.getItems().clear();
        table.getColumns().clear();
        table.setEditable(true);

        initTableColumns(table);

        List<Destination> clientsList = DestinationService.getAllDestinations();
        final ObservableList<Destination> data = FXCollections.observableArrayList(clientsList);
        table.setItems(data);
    }

    public void handleBack() throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        Stage primary = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("admin.fxml"));
        Scene nextScene = new Scene(root, 600, 400);
        primary.setScene(nextScene);
        primary.show();
        stage.close();
    }

    public void handleRemoveSelectedButton() throws IOException {
        Destination destination = table.getSelectionModel().getSelectedItem();
        DestinationService.removeDestination(destination);
        handleRefresh();
    }

}
