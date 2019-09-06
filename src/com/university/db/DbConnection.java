package com.university.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String CREATE_DEPARTMENT = "CREATE TABLE departmans" +
            "(id int auto_increment,name varchar(255) not null," +
            "employeer_id int null,constraint departmans_pktprimary key (id));";

    private static final String CREATE_EMPLOYEE = "create table employees id int auto_increment," +
            "name varchar(255) null,surname varchar(255) not null,salary int,position varchar(255)"
            + " ,department_id int ,tconstraint employeer_pk" +
            "primary key (id),tconstraint employeer_department_id_fk foreign key (department_id) " +
            "references department (id));";

    private static final String UPDATE_DEPARTMENT = "alter table departmans add constraint " +
            "departmans_employees_id_fk foreign key (employeer_id) references employees (id)";

    private DbConnection() {
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/university";
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


/*
 */

/*






 */