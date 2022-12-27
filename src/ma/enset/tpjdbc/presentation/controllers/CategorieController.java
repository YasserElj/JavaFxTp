package ma.enset.tpjdbc.presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.tpjdbc.dao.CategorieDaoImpl;
import ma.enset.tpjdbc.dao.entities.Categorie;

import java.net.URL;
import java.util.ResourceBundle;

public class CategorieController implements Initializable {
    @FXML
    private TextField textFieldNom;
    @FXML
    private TableView<Categorie> tableView;
    @FXML
    private TableColumn<Categorie,Integer>colId;
    @FXML
    private TableColumn<Categorie,String>colNom;
    private ObservableList<Categorie> categories= FXCollections.observableArrayList();
    private ma.enset.tpjdbc.services.CatalogueServiceImpl catalogue=new ma.enset.tpjdbc.services.CatalogueServiceImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        catalogue.setCategorieDao(new CategorieDaoImpl());
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tableView.setItems(categories);
        loadCategorie();
    }
    @FXML
    public  void addCategorie(){
        Categorie c=new Categorie(1,textFieldNom.getText());
        catalogue.addCategorie(c);
        textFieldNom.clear();
        loadCategorie();
    }
    public void loadCategorie(){
        categories.clear();
        categories.addAll(catalogue.getAllCategories());
    }
    @FXML
    public  void removeCategorie(){
        catalogue.removeCategorie(tableView.getSelectionModel().getSelectedItem().getId());
        loadCategorie();
    }
}
