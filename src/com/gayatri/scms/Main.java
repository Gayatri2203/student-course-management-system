package com.gayatri.scms;

import java.util.Scanner;
import com.gayatri.scms.model.Student;
import java.util.ArrayList;
import com.gayatri.scms.service.StudentService;

public class Main {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        StudentService studentService = new StudentService();

        while (running) {

            displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:


                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Student Age: ");
                    int age = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Student Email: ");
                    String email = scanner.nextLine();

                    Student student1 = new Student(name, age, email);

                    studentService.addStudent(student1);

                    System.out.println("\nStudent Added Successfully!");

                    break;

                case 2:
                    studentService.viewStudents();
                    break;

                case 3:

                    scanner.nextLine();

                    System.out.print("Enter Student Name to Search: ");
                    String searchName = scanner.nextLine();

                    studentService.searchStudent(searchName);

                    break;

                case 4:

                    scanner.nextLine();

                    System.out.print("Enter Student Name to Update: ");
                    String updateName = scanner.nextLine().trim();

                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine().trim();

                    boolean updated = studentService.updateStudent(updateName, newAge, newEmail);

                    if (updated) {
                        System.out.println("Student Updated Successfully!");
                    } else {
                        System.out.println("Student Not Found!");
                    }

                    break;

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