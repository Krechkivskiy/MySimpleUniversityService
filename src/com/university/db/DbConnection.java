package com.university.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String CREATE_DEPARTMENT = "CREATE TABLE department "  +
            "(id INT auto_increment PRIMARY KEY, name VARCHAR (255) NOT NULL," +
            "employeer_id INT);";

    private static final String CREATE_EMPLOYEE = "CREATE TABLE employees (id INT auto_increment PRIMARY KEY, " +
            "name VARCHAR (255), surname VARCHAR(255) NOT NULL, salary INT, position VARCHAR (255)"
            + ",department_id INT )";

    private static final String UPDATE_DEPARTMENT = "ALTER TABLE department ADD CONSTRAINT " +
            "departmans_employees_id_fk FOREIGN KEY (employeer_id) REFERENCES employees(id)";

    private DbConnection() {
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/university?createDatabaseIfNotExists";
        String login = "root";
        String password = "12345";
        return DriverManager.getConnection(url, login, password);
    }

    public static void initDB() {
        try {
            Connection connection = getConnection();
               connection.prepareStatement(CREATE_DEPARTMENT).execute();
              connection.prepareStatement(CREATE_EMPLOYEE).execute();
                connection.prepareStatement(UPDATE_DEPARTMENT).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}