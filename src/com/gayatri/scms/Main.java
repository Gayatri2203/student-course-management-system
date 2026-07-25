package com.gayatri.scms;

import java.util.Scanner;
import com.gayatri.scms.model.Student;

import com.gayatri.scms.service.StudentService;

public class Main {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        StudentService studentService = new StudentService();

        while (running) {

            displayMenu();

            int choice;

            try {

                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

            } catch (Exception e) {

                System.out.println("\nInvalid input! Please enter a number.");

                scanner.nextLine();   // Clear invalid input

                continue;             // Restart the menu
            }

            switch (choice) {

                case 1: {


                    scanner.nextLine();

                    String name;

                    while (true) {

                        System.out.print("Enter Student Name: ");
                        name = scanner.nextLine().trim();

                        if (!name.isEmpty()) {
                            break;
                        }

                        System.out.println("Name cannot be empty.");
                    }

                    int age;

                    while (true) {

                        System.out.print("Enter Student Age: ");
                        age = scanner.nextInt();

                        if (age >= 1 && age <= 120) {
                            break;
                        }

                        System.out.println("Invalid age! Please enter age between 1 and 120.");
                    }
                    scanner.nextLine();

                    String email;

                    while (true) {

                        System.out.print("Enter Student Email: ");
                        email = scanner.nextLine().trim();

                        if (email.contains("@") && email.contains(".")) {
                            break;
                        }

                        System.out.println("Invalid email format.");
                    }

                    Student student1 = new Student(name, age, email);

                    studentService.addStudent(student1);

                    System.out.println("\nStudent Added Successfully!");

                    break;
                }

                case 2:
                    studentService.viewStudents();
                    break;

                case 3:

                    scanner.nextLine();

                    System.out.print("Enter Student Name to Search: ");
                    String searchName = scanner.nextLine();

                    studentService.searchStudent(searchName);

                    break;

                case 4: {

                    scanner.nextLine(); // Clear the leftover newline

                    // Get student name
                    String name;

                    while (true) {

                        System.out.print("Enter Student Name to Update: ");
                        name = scanner.nextLine().trim();

                        if (!name.isEmpty()) {
                            break;
                        }

                        System.out.println("Student name cannot be empty.");
                    }

                    // Get new age
                    int newAge;

                    while (true) {

                        System.out.print("Enter New Age: ");
                        newAge = scanner.nextInt();

                        if (newAge >= 1 && newAge <= 120) {
                            break;
                        }

                        System.out.println("Invalid age! Please enter age between 1 and 120.");
                    }

                    scanner.nextLine(); // Clear the newline

                    // Get new email
                    String email;

                    while (true) {

                        System.out.print("Enter New Email: ");
                        email = scanner.nextLine().trim();

                        if (email.contains("@") && email.contains(".")) {
                            break;
                        }

                        System.out.println("Invalid email format.");
                    }

                    boolean updated = studentService.updateStudent(name, newAge, email);

                    if (updated) {
                        System.out.println("\nStudent Updated Successfully!");
                    } else {
                        System.out.println("\nStudent Not Found!");
                    }

                    break;
                }

                case 5:

                    scanner.nextLine();

                    System.out.print("Enter Student Name to Delete: ");
                    String deleteName = scanner.nextLine().trim();

                    boolean deleted = studentService.deleteStudent(deleteName);

                    if (deleted) {
                        System.out.println("Student Deleted Successfully!");
                    } else {
                        System.out.println("Student Not Found!");
                    }

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