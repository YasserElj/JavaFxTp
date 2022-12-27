package ma.enset.tpjdbc.dao;

import ma.enset.tpjdbc.dao.entities.Categorie;
import ma.enset.tpjdbc.dao.entities.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements Dao<Produit>{

    @Override
    public List<Produit> findAll() {
        List<Produit>produits=new ArrayList<>();
        Connection connection= SinglotonConnectionDB.getConnection();
        try {
            Statement statement =connection.createStatement();
            statement.execute("SELECT * FROM produis,categories where categories.id_cat=produis.id_categorie");
           ResultSet rs= statement.getResultSet();
           while (rs.next()){
               produits.add(new Produit(rs.getInt("id_produit"),rs.getString("nom_produit"),rs.getString("description_produit"),rs.getDouble("prix_produit"),new Categorie(rs.getInt("id_cat"), rs.getString("nom_cat"))));
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produits;
    }

    @Override
    public Produit findById(int id) {
        return null;
    }

    @Override
    public boolean remove(int id) {
        int i=0;
        Connection connection= SinglotonConnectionDB.getConnection();
        try{
            PreparedStatement pr=connection.prepareStatement("DELETE FROM PRODUIS WHERE id_produit =?");
            pr.setInt(1,id);
            i=pr.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return i!=0;
    }

    @Override
    public boolean add(Produit p) {
        int i=0;
        Connection connection= SinglotonConnectionDB.getConnection();
        try{
            PreparedStatement pr=connection.prepareStatement("INSERT INTO PRODUIS(nom_produit,description_produit,prix_produit,id_categorie)VALUES(?,?,?,?)");
            pr.setString(1,p.getNom());
            pr.setString(2,p.getDescription());
            pr.setDouble(3,p.getPrix());
            pr.setInt(4,p.getCategorie().getId());
            i=pr.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return i!=0;
    }
}
