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
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1: {

                    scanner.nextLine();

                    String name = readValidName(scanner);
                    int age = readValidAge(scanner);
                    String email = readValidEmail(scanner);

                    Student student = new Student(name, age, email);

                    studentService.addStudent(student);

                    System.out.println("\nStudent Added Successfully!");

                    break;
                }

                case 2:

                    studentService.viewStudents();
                    break;

                case 3:

                    scanner.nextLine();

                    System.out.print("Enter Student Name to Search: ");
                    String searchName = scanner.nextLine().trim();

                    studentService.searchStudent(searchName);

                    break;

                case 4: {

                    scanner.nextLine();

                    System.out.print("Enter Student Name to Update: ");
                    String name = scanner.nextLine().trim();

                    int newAge = readValidAge(scanner);

                    System.out.print("Enter New Email: ");
                    String email = readValidEmail(scanner);

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
                        System.out.println("\nStudent Deleted Successfully!");
                    } else {
                        System.out.println("\nStudent Not Found!");
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

    // ------------------------
    // Helper Methods
    // ------------------------

    public static String readValidName(Scanner scanner) {

        while (true) {

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine().trim();

            if (!name.isEmpty()) {
                return name;
            }

            System.out.println("Name cannot be empty.");
        }
    }

    public static int readValidAge(Scanner scanner) {

        while (true) {

            System.out.print("Enter Student Age: ");

            try {

                int age = scanner.nextInt();

                if (age >= 1 && age <= 120) {

                    scanner.nextLine();
                    return age;
                }

                System.out.println("Age must be between 1 and 120.");

            } catch (Exception e) {

                System.out.println("Please enter numbers only.");
                scanner.nextLine();
            }
        }
    }

    public static String readValidEmail(Scanner scanner) {

        while (true) {

            System.out.print("Enter Student Email: ");

            String email = scanner.nextLine().trim();

            if (email.contains("@") && email.contains(".")) {
                return email;
            }

            System.out.println("Invalid email format.");
        }
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