package com.gayatri.scms.service;

import com.gayatri.scms.model.Student;

import java.util.ArrayList;

import com.gayatri.scms.util.FileManager;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {

        students.add(student);

        FileManager.saveStudent(student);

    }

    public void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No students found.");
            return;
        }

        int count = 1;

        for (Student student : students) {

            System.out.println("---------------------");
            System.out.println("Student " + count++);
            System.out.println(student);

        }

    }
    public void searchStudent(String searchName) {

        boolean found = false;

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(searchName)) {

                System.out.println("\nStudent Found");
                System.out.println("----------------");
                System.out.println(student);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
    public boolean updateStudent(String searchName, int newAge, String newEmail) {

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(searchName)) {

                student.setAge(newAge);
                student.setEmail(newEmail);

                return true;
            }
        }

        return false;
    }
    public boolean deleteStudent(String deleteName) {

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(deleteName)) {

                students.remove(student);

                return true;
            }
        }

        return false;
    }

}