package ru.synergy;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DDL {
    final String urlDB;

    public DDL(String urlDB) {
        this.urlDB = urlDB;
    }

    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS employees \n" +
                "(\n" +
                "employee_id integer PRIMARY KEY AUTOINCREMENT,\n" +
                "first_name VARCHAR(20) NOT NULL,\n" +
                "last_name VARCHAR(20) NOT NULL\n" +
                ");";
        try (
                Connection connection = DBConnection.getConnection(urlDB);
                Statement statement = connection.createStatement()
        ) {
            statement.execute(query);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
