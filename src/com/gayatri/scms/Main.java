package com.gayatri.scms;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Add Student selected.");
                    break;

                case 2:
                    System.out.println("View Student selected.");
                    break;

                case 3:
                    System.out.println("Search Student selected.");
                    break;

                case 4:
                    System.out.println("Update Student selected.");
                    break;

                case 5:
                    System.out.println("Delete Student selected.");
                    break;

                case 6:
                    System.out.println("Thank you for using SCMS.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println();

        }

        scanner.close();
    }

    public static void displayMenu() {

        System.out.println("====================================");
        System.out.println(" Student Course Management System");
        System.out.println("====================================");

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.println();
    }
}