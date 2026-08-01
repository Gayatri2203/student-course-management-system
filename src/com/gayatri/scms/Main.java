package com.gayatri.scms;

import java.util.Scanner;

import com.gayatri.scms.model.Student;
import com.gayatri.scms.model.Course;

import com.gayatri.scms.service.StudentService;
import com.gayatri.scms.service.CourseService;
import com.gayatri.scms.service.EnrollmentService;
import com.gayatri.scms.service.DashboardService;


public class Main {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        StudentService studentService = new StudentService();

        CourseService courseService = new CourseService();

        EnrollmentService enrollmentService = new EnrollmentService();

        DashboardService dashboardService = new DashboardService();


        boolean running = true;


        while (running) {


            displayMenu();


            System.out.print("Enter your choice: ");


            int choice;


            try {

                choice = scanner.nextInt();


            } catch (Exception e) {

                System.out.println("Invalid input!");

                scanner.nextLine();

                continue;
            }


            switch (choice) {


                case 1:

                    scanner.nextLine();

                    addStudent(scanner, studentService);

                    break;


                case 2:

                    studentService.viewStudents();

                    break;


                case 3:

                    System.out.print("Enter Student ID: ");

                    int studentId = scanner.nextInt();

                    studentService.searchStudent(studentId);

                    break;


                case 4:

                    updateStudent(scanner, studentService);

                    break;


                case 5:

                    deleteStudent(scanner, studentService);

                    break;


                case 6:

                    scanner.nextLine();

                    addCourse(scanner, courseService);

                    break;


                case 7:

                    courseService.viewCourses();

                    break;


                case 8:

                    scanner.nextLine();

                    System.out.print("Enter Course ID: ");

                    String searchCourseId = scanner.nextLine();


                    courseService.searchCourse(searchCourseId);

                    break;


                case 9:

                    scanner.nextLine();


                    System.out.print("Enter Course ID: ");

                    String deleteCourseId = scanner.nextLine();


                    courseService.deleteCourse(deleteCourseId);

                    break;


                case 10:


                    scanner.nextLine();


                    System.out.print("Enter Student ID: ");

                    int enrollStudentId = scanner.nextInt();


                    scanner.nextLine();


                    System.out.print("Enter Course ID: ");

                    String enrollCourseId = scanner.nextLine();


                    enrollmentService.enrollStudent(
                            enrollStudentId,
                            enrollCourseId
                    );


                    break;


                case 11:


                    enrollmentService.viewEnrollments();

                    break;


                case 12:


                    scanner.nextLine();


                    System.out.print("Enter Student ID: ");

                    int removeStudentId = scanner.nextInt();


                    scanner.nextLine();


                    System.out.print("Enter Course ID: ");

                    String removeCourseId = scanner.nextLine();


                    enrollmentService.removeEnrollment(
                            removeStudentId,
                            removeCourseId
                    );


                    break;


                case 13:


                    System.out.print("Enter Student ID: ");

                    int coursesStudentId = scanner.nextInt();


                    enrollmentService.getCoursesByStudent(
                            coursesStudentId
                    );


                    break;


                case 14:


                    scanner.nextLine();


                    System.out.print("Enter Course ID: ");

                    String studentsCourseId = scanner.nextLine();


                    enrollmentService.getStudentsByCourse(
                            studentsCourseId
                    );


                    break;

                case 15:

                    dashboardService.displayDashboard();

                    break;


                case 0:


                    running = false;

                    System.out.println("Exiting SCMS...");

                    break;


                default:

                    System.out.println("Invalid choice!");

            }


            System.out.println();

        }


        scanner.close();

    }
    // ================= MENU =================

    public static void displayMenu() {


        System.out.println("====================================");
        System.out.println(" Student Course Management System");
        System.out.println("====================================");


        System.out.println("\n----- Student Management -----");

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");


        System.out.println("\n----- Course Management -----");

        System.out.println("6. Add Course");
        System.out.println("7. View Courses");
        System.out.println("8. Search Course");
        System.out.println("9. Delete Course");


        System.out.println("\n----- Enrollment -----");

        System.out.println("10. Enroll Student");
        System.out.println("11. View Enrollments");
        System.out.println("12. Remove Enrollment");
        System.out.println("13. View Courses of Student");
        System.out.println("14. View Students in Course");
        System.out.println("15. View Dashboard");


        System.out.println("\n0. Exit");

        System.out.println();

    }


// ================= STUDENT METHODS =================


    public static void addStudent(
            Scanner scanner,
            StudentService studentService
    ) {


        System.out.print("Enter Student Name: ");

        String name = scanner.nextLine();


        System.out.print("Enter Student Age: ");

        int age = scanner.nextInt();


        scanner.nextLine();


        System.out.print("Enter Student Email: ");

        String email = scanner.nextLine();


        Student student =
                new Student(name, age, email);


        studentService.addStudent(student);


        System.out.println("Student added successfully!");

    }


    public static void updateStudent(
            Scanner scanner,
            StudentService studentService
    ) {


        System.out.print("Enter Student ID: ");

        int studentId = scanner.nextInt();


        System.out.print("Enter New Age: ");

        int age = scanner.nextInt();


        scanner.nextLine();


        System.out.print("Enter New Email: ");

        String email = scanner.nextLine();


        studentService.updateStudent(
                studentId,
                age,
                email
        );

    }


    public static void deleteStudent(
            Scanner scanner,
            StudentService studentService
    ) {


        System.out.print("Enter Student ID: ");

        int studentId = scanner.nextInt();


        studentService.deleteStudent(studentId);

    }


// ================= COURSE METHODS =================


    public static void addCourse(
            Scanner scanner,
            CourseService courseService
    ) {


        System.out.print("Enter Course ID: ");

        String courseId = scanner.nextLine();


        System.out.print("Enter Course Name: ");

        String courseName = scanner.nextLine();


        System.out.print("Enter Duration: ");

        String duration = scanner.nextLine();


        System.out.print("Enter Credits: ");

        int credits = scanner.nextInt();


        Course course =
                new Course(
                        courseId,
                        courseName,
                        duration,
                        credits
                );


        courseService.addCourse(course);


        System.out.println("Course added successfully!");

    }
}