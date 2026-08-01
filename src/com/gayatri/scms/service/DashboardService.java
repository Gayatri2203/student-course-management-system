package com.gayatri.scms.service;


import com.gayatri.scms.dao.DashboardDAO;


public class DashboardService {


    private DashboardDAO dashboardDAO;


    public DashboardService(){

        dashboardDAO = new DashboardDAO();

    }



    public void displayDashboard(){


        System.out.println();
        System.out.println("====================================");
        System.out.println("              DASHBOARD");
        System.out.println("====================================");


        int totalStudents = dashboardDAO.getTotalStudents();

        int totalCourses = dashboardDAO.getTotalCourses();

        int totalEnrollments = dashboardDAO.getTotalEnrollments();



        System.out.println("Total Students      : " + totalStudents);

        System.out.println("Total Courses       : " + totalCourses);

        System.out.println("Total Enrollments   : " + totalEnrollments);


        System.out.println("------------------------------------");


        dashboardDAO.getMostPopularCourse();


        System.out.println("====================================");

    }


}