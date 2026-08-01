package com.gayatri.scms.dao;


import com.gayatri.scms.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DashboardDAO {


    // Total Students

    public int getTotalStudents() {


        String sql = "SELECT COUNT(*) FROM students";


        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ){


            if(rs.next()){

                return rs.getInt(1);

            }


        }catch(SQLException e){

            e.printStackTrace();

        }


        return 0;

    }





    // Total Courses

    public int getTotalCourses(){


        String sql = "SELECT COUNT(*) FROM courses";


        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()

        ){


            if(rs.next()){

                return rs.getInt(1);

            }


        }catch(SQLException e){

            e.printStackTrace();

        }


        return 0;

    }






    // Total Enrollments

    public int getTotalEnrollments(){


        String sql = "SELECT COUNT(*) FROM enrollments";


        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()

        ){


            if(rs.next()){

                return rs.getInt(1);

            }


        }catch(SQLException e){

            e.printStackTrace();

        }


        return 0;

    }






    // Most Popular Course

    public void getMostPopularCourse(){


        String sql =
                "SELECT c.course_name, COUNT(e.student_id) AS total_students " +
                        "FROM courses c " +
                        "JOIN enrollments e " +
                        "ON c.course_id = e.course_id " +
                        "GROUP BY c.course_name " +
                        "ORDER BY total_students DESC " +
                        "LIMIT 1";



        try(
                Connection con = DBConnection.getConnection();

                PreparedStatement ps = con.prepareStatement(sql);

                ResultSet rs = ps.executeQuery()

        ){



            if(rs.next()){


                System.out.println(
                        "Most Popular Course : "
                                + rs.getString("course_name")
                );


                System.out.println(
                        "Students Enrolled : "
                                + rs.getInt("total_students")
                );


            }
            else{

                System.out.println("No enrollments available.");

            }



        }catch(SQLException e){

            e.printStackTrace();

        }


    }


}