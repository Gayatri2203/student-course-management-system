package com.gayatri.scms;

import com.gayatri.scms.dao.StudentDAO;

public class TestSearchStudent {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        dao.searchStudentById(1);

    }
}