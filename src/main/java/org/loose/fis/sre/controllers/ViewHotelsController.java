package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.loose.fis.sre.model.ProductType;
import org.loose.fis.sre.services.MaterialService;
import org.loose.fis.sre.services.ProductTypeService;

public class ViewHotelsController {
    @FXML
    private Button backButton;

    @FXML
    private TableView<ProductType> typeTable;
    @FXML
    private TableColumn<ProductType, String> productTypeColumn;
    @FXML
    private TableColumn<ProductType, Integer> productPriceColumn;

    @FXML
    private TableView<Material> materialTable;
    @FXML
    private TableColumn<Material, String> materialNameColumn;
    @FXML
    private TableColumn<Material, Integer> materialPriceColumn;

    public void initialize() {
        productTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        typeTable.setItems(types);

        materialNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        materialPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        materialTable.setItems(materials);
    }

    private ObservableList<ProductType> types = FXCollections.observableArrayList(ProductTypeService.productTypes());
    private ObservableList<Material> materials = FXCollections.observableArrayList(MaterialService.materials());

    public void handleBackButtonAction() throws Exception{
        Stage window = (Stage) materialTable.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/startUser.fxml"));
        window.setScene(new Scene(root, 800,600));
    }
}