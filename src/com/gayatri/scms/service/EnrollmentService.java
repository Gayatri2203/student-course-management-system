package com.gayatri.scms.service;

import com.gayatri.scms.dao.EnrollmentDAO;

public class EnrollmentService {

    private EnrollmentDAO enrollmentDAO;


    public EnrollmentService() {
        enrollmentDAO = new EnrollmentDAO();
    }


    public void enrollStudent(int studentId, String courseId) {


        if(!enrollmentDAO.studentExists(studentId)){

            System.out.println("Student does not exist.");

            return;

        }


        if(!enrollmentDAO.courseExists(courseId)){

            System.out.println("Course does not exist.");

            return;

        }


        if(enrollmentDAO.alreadyEnrolled(studentId, courseId)){


            System.out.println("Student already enrolled in this course.");

            return;

        }


        enrollmentDAO.enrollStudent(studentId, courseId);

    }


    public void viewEnrollments() {

        enrollmentDAO.viewEnrollments();

    }


    public void removeEnrollment(int studentId, String courseId) {

        enrollmentDAO.removeEnrollment(studentId, courseId);

    }


    public void getCoursesByStudent(int studentId) {

        enrollmentDAO.getCoursesByStudent(studentId);

    }


    public void getStudentsByCourse(String courseId) {

        enrollmentDAO.getStudentsByCourse(courseId);

    }

}