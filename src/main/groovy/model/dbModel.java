package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class dbModel {
    String database = "investigacion";
    String host = "jdbc:mysql://localhost:3306/" + database;
    String user = "root";
    String password = "yourPass!"; // Cambiar por la contrasenia de tu servidor local.

    // Retorna una conexión con la DB local.
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(host, user, password);
    }

}
