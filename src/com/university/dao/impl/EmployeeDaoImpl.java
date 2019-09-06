package com.university.dao.impl;


import com.university.dao.EmployeeDao;
import com.university.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    public EmployeeDaoImpl() {
    }

    @Override
    public List<String> find(String text) {
        List<String> result = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, " +
                    "surname FROM  employees WHERE name like ? or surname like ?");
            preparedStatement.setString(1, "%" + text + "%");
            preparedStatement.setString(2, "%" + text + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getString(1) + " " +
                        resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
