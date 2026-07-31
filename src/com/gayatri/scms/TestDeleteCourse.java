package com.gayatri.scms;

import com.gayatri.scms.dao.CourseDAO;

public class TestDeleteCourse {

    public static void main(String[] args) {

        CourseDAO dao = new CourseDAO();

        dao.deleteCourse("CS101");

    }
}