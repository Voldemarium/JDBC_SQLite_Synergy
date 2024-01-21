package ru.synergy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SELECT {
    final String urlDB;

    public SELECT(String urlDB) {
        this.urlDB = urlDB;
    }

    public void printNames() {
        String query = "SELECT first_name, last_name FROM employees;";
        try (
                Connection connection = DBConnection.getConnection(urlDB);
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query)
        ) {
            while (rs.next()) {
                System.out.println("Имя: " + rs.getString("first_name") + "\t" +
                        "Фамилия: " + rs.getString("last_name"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getUpperCaseNames() {
        String query = "SELECT first_name FROM employees;";
        List<String> list = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection(urlDB);
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query)
        ) {
            while (rs.next()) {
                list.add(rs.getString("first_name").toUpperCase());
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    public List<String> getFirstThreeLettersOfNames() {
        String query = "SELECT first_name FROM employees;";
        List<String> list = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection(urlDB);
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query)
        ) {
            while (rs.next()) {
//                System.out.println(rs.getString("first_name").substring(0, 3));
                list.add(rs.getString("first_name").substring(0, 3));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    public List<Integer> getAllId() {
        String query = "SELECT employee_id FROM employees;";
        List<Integer> list = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection(urlDB);
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query)
        ) {
            while (rs.next()) {
//                System.out.println("Id: " + rs.getInt("employee_id"));
                list.add(rs.getInt("employee_id"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void printFirstFiveEntries() {
        String query = "SELECT * FROM employees LIMIT 5;";
        try (
                Connection connection = DBConnection.getConnection(urlDB);
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query)
        ) {
            while (rs.next()) {
                System.out.println(rs.getInt("employee_id") + "\t" +
                        rs.getString("first_name") + "\t" +
                        rs.getString("last_name"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}