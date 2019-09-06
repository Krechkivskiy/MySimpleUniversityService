package com.university.dao.impl;

import com.university.dao.DepartmentDao;
import com.university.db.DbConnection;
import com.university.entity.Departament;
import com.university.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private static final String GET_MANAGER = "SELECT * FROM employees where department =?" +
            " and position ='manager'";
    private static final String SHOW_STATISTIC = "SELECT " +
            "COUNT(position) as count from employees where department =? " +
            "and employees.position =?";
    private static final String SHOW_AVG = "SELECT AVG (salary) as AVG from employees " +
            "where department=?";
    private static final String GET_COUNT_OF_EMPLOYEER = "SELECT COUNT(*) as COUNT from employees" +
            " where department = ?";
    private static final String GET_ALL = "SELECT * FROM department";
    private static final String GET_BY_ID = "SELECT name from department where id =?";

    @Override
    public Employee getManager(int departamentId) {
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MANAGER);
            preparedStatement.setInt(1, departamentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Employee(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> showStatistic(int departamentId) {
        List<String> result = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(SHOW_STATISTIC);
            preparedStatement.setInt(1, departamentId);
            preparedStatement.setString(2, "assistant");
            ResultSet assistentResult = preparedStatement.executeQuery();
            while (assistentResult.next()) {
                int count = assistentResult.getInt("count");
                result.add("assistant    " + count);
            }
            PreparedStatement statement = connection.prepareStatement(SHOW_STATISTIC);
            statement.setInt(1, departamentId);
            statement.setString(2, "associate professor");
            ResultSet associateProfessorRes = statement.executeQuery();
            while (associateProfessorRes.next()) {
                int count = associateProfessorRes.getInt("count");
                result.add("associate professor    " + count);
            }
            PreparedStatement prepareStatement = connection.prepareStatement(SHOW_STATISTIC);
            prepareStatement.setInt(1, departamentId);
            prepareStatement.setString(2, "professor");
            ResultSet professorResult = prepareStatement.executeQuery();
            while (professorResult.next()) {
                int count = professorResult.getInt("count");
                result.add("professor    " + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int middleSalary(int idDepartment) {
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_AVG);
            preparedStatement.setInt(1, idDepartment);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("AVG");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int countOfEmployers(int departmentId) {
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_COUNT_OF_EMPLOYEER);
            preparedStatement.setInt(1, departmentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("COUNT");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Departament> getAll() {
        List<Departament> resultList = new ArrayList<>();
        try {
            Connection connection = DbConnection.getConnection();
            ResultSet resultSet = connection.prepareStatement(GET_ALL).executeQuery();
            while (resultSet.next()) {
                resultList.add(new Departament(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public String getById(int id) {
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
