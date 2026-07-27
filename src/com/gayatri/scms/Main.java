package com.gayatri.scms;

import java.util.Scanner;
import com.gayatri.scms.model.Student;
import com.gayatri.scms.service.CourseManager;
import com.gayatri.scms.service.StudentService;
import com.gayatri.scms.model.Course;
import com.gayatri.scms.util.FileManager;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        StudentService studentService = new StudentService();

        CourseManager courseManager = new CourseManager();
        courseManager.setCourses(FileManager.loadCourses());
        FileManager.loadEnrollments(studentService, courseManager);
        System.out.println("Working Directory: " + System.getProperty("user.dir"));

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
                case 0:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                case 1: {

                    scanner.nextLine();

                    addStudent(scanner, studentService);

                    break;
                }

                case 2:

                    studentService.viewStudents();
                    break;

                case 3: {

                    scanner.nextLine();

                    searchStudent(scanner, studentService);

                    break;
                }

                case 4: {

                    scanner.nextLine();

                    updateStudent(scanner, studentService);

                    break;
                }

                case 5: {

                    scanner.nextLine();

                    deleteStudent(scanner, studentService);

                    break;
                }

                case 6: {

                    scanner.nextLine();

                    addCourse(scanner, courseManager);

                    break;
                }
                case 7:{

                    courseManager.viewCourses();

                    break;
                }
                case 8: {

                    scanner.nextLine();

                    searchCourse(scanner, courseManager);

                    break;
                }
                case 9: {

                    scanner.nextLine();

                    deleteCourse(scanner, courseManager);

                    break;
                }
                case 10: {

                    scanner.nextLine();

                    assignCourseToStudent(scanner, studentService, courseManager);

                    break;
                }
                case 11: {

                    displayDashboard(studentService, courseManager);

                    break;
                }

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

        System.out.println("----- Student Management -----");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");

        System.out.println();

        System.out.println("----- Course Management -----");
        System.out.println("6. Add Course");
        System.out.println("7. View Courses");
        System.out.println("8. Search Course");
        System.out.println("9. Delete Course");

        System.out.println();

        System.out.println("----- Enrollment -----");
        System.out.println("10. Assign Course to Student");
        System.out.println();
        System.out.println("----- Dashboard -----");
        System.out.println("11. View Dashboard");

        System.out.println();

        System.out.println("0. Exit");
        System.out.println();
    }
    public static void addStudent(Scanner scanner, StudentService studentService) {

        String name = readValidName(scanner);

        int age = readValidAge(scanner);

        String email = readValidEmail(scanner);

        Student student = new Student(name, age, email);

        studentService.addStudent(student);

        System.out.println("\nStudent Added Successfully!");
    }
    public static void searchStudent(Scanner scanner, StudentService studentService) {

        System.out.print("Enter Student ID to Search: ");

        int studentId = scanner.nextInt();
        scanner.nextLine();

        Student student = studentService.searchStudentById(studentId);

        if (student != null) {

            System.out.println("\nStudent Found");
            System.out.println("----------------------");
            System.out.println(student);

        } else {

            System.out.println("\nStudent not found.");

        }
    }
    public static void updateStudent(Scanner scanner, StudentService studentService) {

        String name = readValidName(scanner);

        System.out.println("Enter New Details");

        int newAge = readValidAge(scanner);

        String newEmail = readValidEmail(scanner);

        boolean updated = studentService.updateStudent(name, newAge, newEmail);

        if (updated) {

            System.out.println("\nStudent Updated Successfully!");

        } else {

            System.out.println("\nStudent Not Found!");

        }

    }
    public static void deleteStudent(Scanner scanner, StudentService studentService) {

        System.out.print("Enter Student ID to Delete: ");

        int studentId = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = studentService.deleteStudent(studentId);

        if (deleted) {

            System.out.println("\nStudent Deleted Successfully!");

        } else {

            System.out.println("\nStudent Not Found!");

        }
    }
    public static void addCourse(Scanner scanner, CourseManager courseManager) {

        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Duration: ");
        String duration = scanner.nextLine();

        System.out.print("Enter Credits: ");
        int credits = scanner.nextInt();

        Course course = new Course(courseId, courseName, duration, credits);

        courseManager.addCourse(course);

        FileManager.saveCourse(course);
        System.out.println("saveCourse() completed.");

        System.out.println("\nCourse Added Successfully!");
    }
    public static void searchCourse(Scanner scanner, CourseManager courseManager) {

        System.out.print("Enter Course ID to Search: ");
        String courseId = scanner.nextLine().trim();

        Course course = courseManager.searchCourse(courseId);

        if (course != null) {

            System.out.println("\nCourse Found!");
            System.out.println(course);

        } else {

            System.out.println("\nCourse Not Found!");

        }
    }
    public static void deleteCourse(Scanner scanner, CourseManager courseManager) {

        System.out.print("Enter Course ID to Delete: ");
        String courseId = scanner.nextLine().trim();

        boolean deleted = courseManager.deleteCourse(courseId);

        if (deleted) {

            FileManager.rewriteCourses(courseManager.getCourses());

            System.out.println("\nCourse Deleted Successfully!");

        } else {

            System.out.println("\nCourse Not Found!");

        }
    }
    public static void assignCourseToStudent(Scanner scanner,
                                             StudentService studentService,
                                             CourseManager courseManager) {

        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        Student student = studentService.searchStudentById(studentId);

        if (student == null) {
            System.out.println("\nStudent not found!");
            return;
        }

        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();

        Course course = courseManager.searchCourse(courseId);

        if (course == null) {
            System.out.println("\nCourse not found!");
            return;
        }

        student.assignCourse(course);

        FileManager.saveEnrollment(student.getStudentId(), course.getCourseId());

        System.out.println("\nCourse assigned successfully!");
    }
    public static void displayDashboard(StudentService studentService,
                                        CourseManager courseManager) {

        System.out.println("\n====================================");
        System.out.println("           DASHBOARD");
        System.out.println("====================================");

        int totalStudents = studentService.getStudents().size();
        int totalCourses = courseManager.getCourses().size();

        System.out.println("Total Students : " + totalStudents);
        System.out.println("Total Courses  : " + totalCourses);

        double averageAge = 0;

        if (totalStudents > 0) {

            int totalAge = 0;

            for (Student student : studentService.getStudents()) {
                totalAge += student.getAge();
            }

            averageAge = (double) totalAge / totalStudents;
        }

        System.out.printf("Average Age    : %.2f%n", averageAge);

        System.out.println("====================================");
        int totalEnrollments = 0;

        for (Student student : studentService.getStudents()) {
            totalEnrollments += student.getEnrolledCourses().size();
        }

        System.out.println("Total Enrollments : " + totalEnrollments);
    }

}