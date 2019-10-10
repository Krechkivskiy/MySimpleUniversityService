package com.university.instruction;

import com.university.service.impl.DepatmentServiceImpl;

import java.util.Scanner;

public class UserTutorial {

    private DepatmentServiceImpl depatmentService;
    private Scanner scanner;

    public UserTutorial() {
        depatmentService = new DepatmentServiceImpl();
        scanner = new Scanner(System.in);
    }

    public int welcomeList() {
        System.out.println("Hi welcome to our university program " +
                "you must decide one of department to continue ");
        depatmentService.showAll();
        int numberOfDepartment = scanner.nextInt();
        return numberOfDepartment;
    }

    public int showIstrucrions() {
        System.out.println("1 Show manager of department ");
        System.out.println("2 Show statistic of this department ");
        System.out.println("3 Show middle salary for this department");
        System.out.println("4 Show count of employer in this department");
        System.out.println("5 Global searching ");
        int commandToPerform = scanner.nextInt();
        return commandToPerform;
    }
}
