package com.gayatri.scms;

import com.gayatri.scms.dao.CourseDAO;

public class TestViewCourses {

    public static void main(String[] args) {

        CourseDAO dao = new CourseDAO();

        dao.viewCourses();

    }
}