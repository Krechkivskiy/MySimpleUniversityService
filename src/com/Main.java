package com;

import com.university.controller.ActionController;
import com.university.db.DbConnection;
import com.university.instruction.UserTutorial;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        DbConnection.initDB();
        Scanner scanner = new Scanner(System.in);
        ActionController controller = new ActionController();
        int exitPoint = 0;
        while (exitPoint != 1) {
            UserTutorial userTutorial = new UserTutorial();
            int choosenDepartment = 0;
            choosenDepartment = userTutorial.welcomeList();
            int exitPointToDepartment = 0;
            while (choosenDepartment != 2) {
                int numberOfCommand = userTutorial.showIstrucrions();
                controller.performCommand(numberOfCommand, choosenDepartment);
                System.out.println(" ");
                System.out.println("Do you want to continue action in this department? 1 yes," +
                        " 2 comeback to department menu");
                exitPointToDepartment = scanner.nextInt();
            }
        }
    }
}
