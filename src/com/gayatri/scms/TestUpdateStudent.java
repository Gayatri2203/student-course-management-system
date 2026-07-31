package com.gayatri.scms;

import com.gayatri.scms.dao.StudentDAO;

public class TestUpdateStudent {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        dao.updateStudent(1, 24, "gayatri_updated@gmail.com");

    }
}