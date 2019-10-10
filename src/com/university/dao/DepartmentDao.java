package com.university.dao;

import com.university.entity.Departament;
import com.university.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentDao {

    Optional<Employee> getManager(int departamentId);

    List<String> showStatistic(int departamentId);

    int middleSalary(int idDepartment);

    int countOfEmployers(int departmentId);

    List<Departament> getAll();

    String getById(int id);
}
