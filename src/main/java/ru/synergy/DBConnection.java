package ru.synergy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    //SQLite по умолчанию создает БД с указанным названием в папке проекта
    //Если БД с указанным названием не существует, она ее создаст, если существует, то
    //установит с ней соединение
    public static Connection getConnection(String dbName)
            throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String connectionURL = "jdbc:sqlite:" +  dbName  + ".db";
        return DriverManager.getConnection(connectionURL);
    }
}
