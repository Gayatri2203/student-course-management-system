package com.gayatri.scms.service;

import com.gayatri.scms.dao.StudentDAO;
import com.gayatri.scms.model.Student;

public class StudentService {

    private StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public void viewStudents() {
        studentDAO.viewStudents();
    }

    public void searchStudent(int studentId) {
        studentDAO.searchStudentById(studentId);
    }

    public void updateStudent(int studentId, int newAge, String newEmail) {
        studentDAO.updateStudent(studentId, newAge, newEmail);
    }

    public void deleteStudent(int studentId) {
        studentDAO.deleteStudent(studentId);
    }
}