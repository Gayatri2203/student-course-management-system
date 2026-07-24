package com.gayatri.scms;

import java.util.Scanner;
import com.gayatri.scms.model.Student;
import java.util.ArrayList;
import com.gayatri.scms.service.StudentService;

public class Main {
    static ArrayList<Student> students = new ArrayList<>();

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

                    scanner.nextLine();   // Clear the leftover newline

                    Student student1 = new Student();

                    System.out.print("Enter Student Name: ");
                    student1.name = scanner.nextLine();

                    System.out.print("Enter Student Age: ");
                    student1.age = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Student Email: ");
                    student1.email = scanner.nextLine();
                    studentService.addStudent(student1);

                    System.out.println("\nStudent Added Successfully!");
                    System.out.println("----------------------------");
                    System.out.println("Name  : " + student1.name);
                    System.out.println("Age   : " + student1.age);
                    System.out.println("Email : " + student1.email);

                    break;

                case 2:
                    studentService.viewStudents();

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