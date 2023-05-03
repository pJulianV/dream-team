package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class dbModel {
    String database = "dreamTeam";
    String host = "jdbc:mysql://localhost:3306/" + database;
    String user = "root";
    String password = "1234"; 
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(host, user, password);
    }

}
