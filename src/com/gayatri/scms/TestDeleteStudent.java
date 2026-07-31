package com.gayatri.scms;

import com.gayatri.scms.dao.StudentDAO;

public class TestDeleteStudent {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        dao.deleteStudent(1);

    }
}