package com.gayatri.scms.util;

import com.gayatri.scms.model.Student;

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


}