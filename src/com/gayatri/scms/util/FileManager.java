package com.gayatri.scms.util;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveStudent(String studentData) {

        try {

            FileWriter writer = new FileWriter("students.txt", true);

            writer.write(studentData + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving student.");

        }

    }

}