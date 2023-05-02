package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbController {

    private Connection connection;

    public dbController(Connection connection) {
        this.connection = connection;
    }

    public boolean insertFromAPI(String id, String url, String name, String email, String affiliations)
            throws SQLException {

        String query = "INSERT INTO autores (author_id, url, name, affiliatios, email) VALUES (?, ?,?,?,?)";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setString(1, id);
        statement.setString(2, url);
        statement.setString(3, name);
        statement.setString(4, affiliations);
        statement.setString(5, email);
        statement.executeUpdate();

        return true;
    }

    public ResultSet selectByID(String id) throws SQLException {
        String query = "SELECT * FROM autores WHERE id = ?";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setString(1, id);
        return statement.executeQuery();
    }

    public ResultSet selectByAuthorID(String id) throws SQLException {
        String query = "SELECT * FROM autores WHERE author_id = ?";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setString(1, id);
        return statement.executeQuery();
    }

    public ResultSet selectByName(String name) throws SQLException {
        String query = "SELECT * FROM autores WHERE name = ?";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setString(1, name);
        return statement.executeQuery();
    }

    public ResultSet selectAll() throws SQLException {
        String query = "SELECT * FROM autores";
        PreparedStatement statement = this.connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public void update(String author_id, String url, String name, String email, String affiliations)
            throws SQLException {
        String query = "UPDATE autores SET author_id = ?, url = ?, name = ?, email = ?, affiliatios = ? WHERE author_id = ?";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setString(1, author_id);
        statement.setString(2, url);
        statement.setString(3, name);
        statement.setString(4, email);
        statement.setString(5, affiliations);
        statement.setString(6, author_id);
        statement.executeUpdate();
    }

    public void delete(String author_id) throws SQLException {
        String query = "DELETE FROM autores WHERE author_id = ?";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setString(1, author_id);
        statement.executeUpdate();
    }
}
