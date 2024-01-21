package ru.synergy;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UPDATE {
    final String urlDB;

    public UPDATE(String urlDB) {
        this.urlDB = urlDB;
    }

    public void insertQuery() {
        String query = "INSERT INTO employees (first_name, last_name) VALUES\n" +
                "('Steven', 'King'),\n" +
                "('Neena', 'Kochhar'),\n" +
                "('Lex', 'De Haan'),\n" +
                "('Aleksander', 'Hunold'),\n" +
                "('Bruce', 'Ernst'),\n" +
                "('David', 'Austin'),\n" +
                "('Valli', 'Pataballa'),\n" +
                "('Diana', 'Lorentz');";
        try (
                Connection connection = DBConnection.getConnection(urlDB);
                Statement statement = connection.createStatement()
        ) {
            statement.execute(query);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAll() {
        try (
                Connection connection = DBConnection.getConnection(urlDB);
                Statement statement = connection.createStatement()
        ) {
            statement.execute("DELETE FROM employees;");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}