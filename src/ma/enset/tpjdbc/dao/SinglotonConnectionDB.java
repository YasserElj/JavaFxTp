package ma.enset.tpjdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SinglotonConnectionDB {
    private static Connection connection;
   static{
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc?user=root&password");
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }

    public static Connection getConnection() {
        return connection;
    }
}