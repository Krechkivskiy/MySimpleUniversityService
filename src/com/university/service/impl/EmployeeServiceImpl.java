package com.university.service.impl;

import com.university.dao.EmployeeDao;
import com.university.dao.impl.EmployeeDaoImpl;
import com.university.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void find(String text) {
        System.out.println(employeeDao.find(text));
    }
}
