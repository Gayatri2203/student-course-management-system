package com.gayatri.scms;

import com.gayatri.scms.dao.CourseDAO;

public class TestSearchCourse {

    public static void main(String[] args) {

        CourseDAO dao = new CourseDAO();

        dao.searchCourse("CS101");

    }
}