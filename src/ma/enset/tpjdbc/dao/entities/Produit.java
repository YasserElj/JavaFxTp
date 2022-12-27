package ma.enset.tpjdbc.dao.entities;

import java.io.Serializable;

public class Produit implements Serializable {
    private int id;
    private String nom;
    private String description;
    private Double prix;
    private Categorie categorie;


    public Produit() {
    }

    public Produit(int id,String nom, String description, Double prix,Categorie categorie) {
        this.id=id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.categorie=categorie;
    }
    public Produit(int id,String nom, String description, Double prix) {
        this.id=id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return nom ;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
