package com.university.service;

import com.university.entity.Departament;
import com.university.entity.Employee;

import java.util.List;

public interface DepartmentService {

    void showManager(int departamentId);

    void showStatistic(int departamentId);

    void showMiddleSalary(int idDepartment);

    void showCountOfEmployers(int departmentId);

    void showAll();
}
