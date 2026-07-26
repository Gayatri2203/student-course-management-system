package com.gayatri.scms.util;

import com.gayatri.scms.model.Student;
import com.gayatri.scms.model.Course;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileManager {

    public static void saveStudent(Student student) {

        try {

            FileWriter writer = new FileWriter("students.txt", true);

            writer.write(
                    student.getStudentId() + "," +
                            student.getName() + "," +
                            student.getAge() + "," +
                            student.getEmail() + "\n"
            );

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving student to file.");
        }

    }
    public static void saveCourse(Course course) {

        System.out.println("Saving course to file...");

        try {

            FileWriter writer = new FileWriter("courses.txt", true);

            writer.write(
                    course.getCourseId() + "," +
                            course.getCourseName() + "," +
                            course.getDuration() + "," +
                            course.getCredits() + "\n"
            );

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving course to file.");
            e.printStackTrace();
        }
    }
    public static ArrayList<Student> loadStudents() {
        System.out.println("Loading students from file...");

        ArrayList<Student> students = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println("Reading: " + line);


                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String email = parts[3];

                Student student = new Student(id, name, age, email);

                students.add(student);
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("No previous student records found.");
        }

        return students;
    }
    public static ArrayList<Course> loadCourses() {

        System.out.println("Loading courses from file...");

        ArrayList<Course> courses = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader("courses.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                String courseId = parts[0];
                String courseName = parts[1];
                String duration = parts[2];
                int credits = Integer.parseInt(parts[3]);

                Course course = new Course(courseId, courseName, duration, credits);

                courses.add(course);
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("No previous course records found.");
        }

        return courses;
    }
    public static void rewriteStudents(ArrayList<Student> students) {
        try {

            FileWriter writer = new FileWriter("students.txt");

            for (Student student : students) {

                writer.write(
                        student.getStudentId() + "," +
                                student.getName() + "," +
                                student.getAge() + "," +
                                student.getEmail() + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error updating student records.");
        }

    }
    public static void rewriteCourses(ArrayList<Course> courses) {

        try {

            FileWriter writer = new FileWriter("courses.txt");

            for (Course course : courses) {

                writer.write(
                        course.getCourseId() + "," +
                                course.getCourseName() + "," +
                                course.getDuration() + "," +
                                course.getCredits() + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error updating course records.");
        }
    }


}