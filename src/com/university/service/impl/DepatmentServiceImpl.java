package com.university.service.impl;

import com.university.dao.DepartmentDao;
import com.university.dao.impl.DepartmentDaoImpl;
import com.university.service.DepartmentService;

import java.util.List;

public class DepatmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    public DepatmentServiceImpl() {
        departmentDao = new DepartmentDaoImpl();
    }

    @Override
    public void showManager(int departamentId) {
        System.out.println("Head of " + departmentDao.getById(departamentId) + " department" +
                "is  " + departmentDao.getManager(departamentId).getName());
    }

    @Override
    public void showStatistic(int departamentId) {
        List<String> statistic = departmentDao.showStatistic(departamentId);
        statistic.forEach(s -> System.out.println(s));
    }

    @Override
    public void showMiddleSalary(int idDepartment) {
        System.out.println("The average salary of  " + departmentDao.getById(idDepartment) + "is  " +
                departmentDao.middleSalary(idDepartment));
    }

    @Override
    public void showCountOfEmployers(int departmentId) {
        System.out.println("Count of employeers is  " + departmentDao.countOfEmployers(departmentId));

    }

    @Override
    public void showAll() {
        departmentDao.getAll().forEach(departament -> System.out.println(departament));
    }
}
