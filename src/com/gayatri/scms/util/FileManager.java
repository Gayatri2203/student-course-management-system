package com.gayatri.scms.util;

import com.gayatri.scms.model.Student;

import java.io.FileWriter;
import java.io.IOException;

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
    public static void loadStudents() {

    }

}