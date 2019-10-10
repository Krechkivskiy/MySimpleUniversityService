package com.university.controller;

import com.university.service.DepartmentService;
import com.university.service.EmployeeService;
import com.university.service.impl.DepatmentServiceImpl;
import com.university.service.impl.EmployeeServiceImpl;

import java.util.Scanner;

public class ActionController {

    private DepartmentService departmentService;
    private EmployeeService employeeService;
    private Scanner scanner;

    public ActionController() {
        employeeService = new EmployeeServiceImpl();
        departmentService = new DepatmentServiceImpl();
    }

    public void performCommand(int commandId, int departmentId) {
        switch (commandId) {
            case 1:
                departmentService.showManager(departmentId);
                break;
            case 2:
                departmentService.showStatistic(departmentId);
                break;
            case 3:
                departmentService.showMiddleSalary(departmentId);
                break;
            case 4:
                departmentService.showCountOfEmployers(departmentId);
                break;
            case 5:
                System.out.println("Please enter keyword to searching ");
                scanner = new Scanner(System.in);
                String keyword = scanner.next();
                employeeService.find(keyword);
                break;
        }
    }
}
