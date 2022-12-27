package ma.enset.tpjdbc.dao;

import ma.enset.tpjdbc.dao.entities.Categorie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieDaoImpl implements Dao<Categorie> {

    @Override
    public List<Categorie> findAll() {
        List<Categorie>categories=new ArrayList<>();
        Connection connection= SinglotonConnectionDB.getConnection();
        try {
            Statement st=connection.createStatement();
            st.execute("SELECT * FROM categories");
            ResultSet rs=st.getResultSet();
            while (rs.next()){
                categories.add(new Categorie(rs.getInt("id_cat"),rs.getString("nom_cat")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public Categorie findById(int id) {
        return null;
    }

    @Override
    public boolean remove(int id) {
        int i=0;
        Connection connection= SinglotonConnectionDB.getConnection();
        try {
            PreparedStatement pr=connection.prepareStatement("DELETE FROM CATEGORIES WHERE id_cat=?");
            pr.setInt(1,id);
             i = pr.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  i!=0;
    }

    @Override
    public boolean add(Categorie p) {
        int i=0;
        Connection connection= SinglotonConnectionDB.getConnection();
        try {
            PreparedStatement pr=connection.prepareStatement("INSERT INTO CATEGORIES(nom_cat)VALUES (?)");
            pr.setString(1,p.getNom());
           i= pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i!=0;
    }
}
