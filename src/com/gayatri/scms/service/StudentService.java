package com.gayatri.scms.service;

import com.gayatri.scms.model.Student;

import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {

        students.add(student);

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
            System.out.println("Name  : " + student.getName());
            System.out.println("Age   : " + student.getAge());
            System.out.println("Email : " + student.getEmail());

        }

    }

}