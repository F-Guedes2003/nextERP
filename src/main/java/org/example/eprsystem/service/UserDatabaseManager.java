package org.example.eprsystem.service;

import java.sql.DriverManager;
import java.sql.SQLException;

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
            System.err.println(e.getMessage());
        }
    }


}
