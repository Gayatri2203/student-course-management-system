package com.gayatri.scms;

import com.gayatri.scms.dao.CourseDAO;
import com.gayatri.scms.model.Course;

public class TestCourseDAO {

    public static void main(String[] args) {

        CourseDAO dao = new CourseDAO();

        Course course = new Course(
                "CS101",
                "Java Programming",
                "6 Months",
                4
        );

        dao.addCourse(course);
    }

}