package ma.enset.tpjdbc.services;

import ma.enset.tpjdbc.dao.entities.*;

import java.util.List;

public interface CatalogueService {
    ///  products*****************************
    List<Produit> getAllProducts();
    boolean addProduct(Produit p);
    boolean removeProduct(int id);
    Produit findProduct(int id);
    ///  categorie*****************************
    List<Categorie> getAllCategories();
    boolean addCategorie(Categorie p);
    boolean removeCategorie(int id);
    Categorie findCategorie(int id);

}
