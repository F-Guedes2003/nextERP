package org.example.eprsystem.service;

import org.example.eprsystem.models.User;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDatabaseManager implements DatabaseService{

    @Override
    public void create(String name, String cnpj, String password) {
        String sql = """
                INSERT INTO user (name, cnpj, password)
                VALUES (?, ?, ?);
                """;
        try(var connection = DriverManager.getConnection("jdbc:sqlite:app.db")) {
            var statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, cnpj);
            statement.setString(3, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage() + "Error on create(database)");
        }
    }

    public Optional<User> findOne(String cnpj, String password) {
        String sql = """
                SELECT * FROM user
                WHERE cnpj = ? AND password = ?;
                """;
        try(var connection = DriverManager.getConnection("jdbc:sqlite:app.db")) {
            var statement = connection.prepareStatement(sql);
            statement.setString(1, cnpj);
            statement.setString(2, password);
            ResultSet qr = statement.executeQuery();

            if(qr.next()) {
                String name = qr.getString("name");
                User user = new User(name, cnpj, password);
                return Optional.of(user);
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage()  + "Error on findOne(database)");
        }

        return Optional.empty();
    }
}
