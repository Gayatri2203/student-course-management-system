package com.gayatri.scms;

import com.gayatri.scms.dao.StudentDAO;
import com.gayatri.scms.model.Student;

public class TestStudentDAO {

    public static void main(String[] args) {

        Student student =
                new Student("Rahul", 22, "rahul@gmail.com");

        StudentDAO dao = new StudentDAO();

        dao.addStudent(student);

    }
}