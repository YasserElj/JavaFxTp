package ma.enset.tpjdbc.presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.tpjdbc.dao.CategorieDaoImpl;
import ma.enset.tpjdbc.dao.ProduitDaoImpl;
import ma.enset.tpjdbc.dao.entities.Categorie;
import ma.enset.tpjdbc.dao.entities.Produit;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField prix;
    @FXML
    private TableView<Produit> tableView;
    @FXML
    private TableColumn<Produit,Integer> colId;
    @FXML
    private TableColumn<Produit,String> colNom;
    @FXML
    private TableColumn<Produit,String> colPrix;
    @FXML
    private TableColumn<Produit,String> colCategorie;
    @FXML
    private ComboBox<Categorie> comboBox;

    private ma.enset.tpjdbc.services.CatalogueServiceImpl catalogue=new ma.enset.tpjdbc.services.CatalogueServiceImpl();
    private ObservableList<Produit>produits= FXCollections.observableArrayList();
    private ObservableList<Categorie>categories= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.setItems(categories);
            catalogue.setProduitDao(new ProduitDaoImpl());
        catalogue.setCategorieDao(new CategorieDaoImpl());
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colCategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
            tableView.setItems(produits);
            loadProduits();
    }
    public void loadProduits(){
        produits.clear();
        categories.clear();
        categories.addAll(catalogue.getAllCategories());
        produits.addAll(catalogue.getAllProducts());
    }

    public void addProduct() {
        catalogue.addProduct(new Produit(1,nom.getText(),"a",Double.valueOf(prix.getText()),comboBox.getSelectionModel().getSelectedItem()));
        loadProduits();
    }

    public void removeProduct() {
        catalogue.removeProduct(tableView.getSelectionModel().getSelectedItem().getId());
        loadProduits();
    }
}
