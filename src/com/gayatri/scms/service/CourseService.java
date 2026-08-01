package com.gayatri.scms.service;

import com.gayatri.scms.dao.CourseDAO;
import com.gayatri.scms.model.Course;

public class CourseService {

    private CourseDAO courseDAO;

    public CourseService() {
        courseDAO = new CourseDAO();
    }

    public void addCourse(Course course) {
        courseDAO.addCourse(course);
    }

    public void viewCourses() {
        courseDAO.viewCourses();
    }

    public void searchCourse(String courseId) {
        courseDAO.searchCourse(courseId);
    }

    public void deleteCourse(String courseId) {
        courseDAO.deleteCourse(courseId);
    }
}