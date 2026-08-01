package com.gayatri.scms.dao;


import com.gayatri.scms.database.DBConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class EnrollmentDAO {

    public boolean studentExists(int studentId) {


        String sql =
                "SELECT COUNT(*) FROM students WHERE student_id=?";


        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ){

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();


            if(rs.next()){

                return rs.getInt(1) > 0;

            }


        }catch(SQLException e){

            e.printStackTrace();

        }


        return false;

    }
    public boolean courseExists(String courseId) {


        String sql =
                "SELECT COUNT(*) FROM courses WHERE course_id=?";


        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ){

            ps.setString(1, courseId);

            ResultSet rs = ps.executeQuery();


            if(rs.next()){

                return rs.getInt(1) > 0;

            }


        }catch(SQLException e){

            e.printStackTrace();

        }


        return false;

    }
    public boolean alreadyEnrolled(int studentId, String courseId) {


        String sql =
                "SELECT COUNT(*) FROM enrollments " +
                        "WHERE student_id=? AND course_id=?";


        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ){

            ps.setInt(1, studentId);

            ps.setString(2, courseId);


            ResultSet rs = ps.executeQuery();


            if(rs.next()){

                return rs.getInt(1) > 0;

            }


        }catch(SQLException e){

            e.printStackTrace();

        }


        return false;

    }


    // ===============================
    // Assign Course to Student
    // ===============================

    public void enrollStudent(int studentId, String courseId) {


        String sql =
                "INSERT INTO enrollments(student_id, course_id) VALUES (?, ?)";


        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ){


            ps.setInt(1, studentId);

            ps.setString(2, courseId);



            int rows = ps.executeUpdate();



            if(rows > 0){

                System.out.println("Student enrolled successfully.");

            }



        }catch(SQLException e){

            e.printStackTrace();

        }

    }





    // ===============================
    // View All Enrollments
    // JOIN students + courses
    // ===============================

    public void viewEnrollments(){



        String sql =

                "SELECT s.student_id, s.name, c.course_id, c.course_name " +
                        "FROM enrollments e " +
                        "JOIN students s ON e.student_id = s.student_id " +
                        "JOIN courses c ON e.course_id = c.course_id";




        try(
                Connection con = DBConnection.getConnection();

                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery(sql)

        ){



            System.out.println("\n========== ALL ENROLLMENTS ==========");



            while(rs.next()){



                System.out.println(
                        "Student ID : "
                                + rs.getInt("student_id")
                );


                System.out.println(
                        "Student Name : "
                                + rs.getString("name")
                );


                System.out.println(
                        "Course ID : "
                                + rs.getString("course_id")
                );


                System.out.println(
                        "Course Name : "
                                + rs.getString("course_name")
                );


                System.out.println("-----------------------------");


            }



        }catch(SQLException e){

            e.printStackTrace();

        }

    }





    // ===============================
    // Remove Enrollment
    // ===============================

    public void removeEnrollment(int studentId, String courseId){



        String sql =
                "DELETE FROM enrollments WHERE student_id=? AND course_id=?";



        try(
                Connection con = DBConnection.getConnection();

                PreparedStatement ps = con.prepareStatement(sql)

        ){



            ps.setInt(1, studentId);

            ps.setString(2, courseId);



            int rows = ps.executeUpdate();




            if(rows > 0){

                System.out.println("Enrollment removed successfully.");

            }
            else{

                System.out.println("Enrollment not found.");

            }



        }catch(SQLException e){

            e.printStackTrace();

        }

    }





    // ===============================
    // List Courses of a Student
    // ===============================

    public void getCoursesByStudent(int studentId){



        String sql =


                "SELECT c.course_id, c.course_name " +
                        "FROM enrollments e " +
                        "JOIN courses c ON e.course_id=c.course_id " +
                        "WHERE e.student_id=?";




        try(
                Connection con = DBConnection.getConnection();

                PreparedStatement ps = con.prepareStatement(sql)

        ){



            ps.setInt(1, studentId);



            ResultSet rs = ps.executeQuery();



            System.out.println("\nCourses enrolled by student:");



            while(rs.next()){



                System.out.println(
                        rs.getString("course_id")
                                +" - "
                                +rs.getString("course_name")
                );


            }



        }catch(SQLException e){

            e.printStackTrace();

        }

    }





    // ===============================
    // List Students in a Course
    // ===============================

    public void getStudentsByCourse(String courseId){



        String sql =


                "SELECT s.student_id, s.name " +
                        "FROM enrollments e " +
                        "JOIN students s ON e.student_id=s.student_id " +
                        "WHERE e.course_id=?";




        try(
                Connection con = DBConnection.getConnection();

                PreparedStatement ps = con.prepareStatement(sql)

        ){



            ps.setString(1, courseId);



            ResultSet rs = ps.executeQuery();




            System.out.println("\nStudents enrolled in course:");




            while(rs.next()){



                System.out.println(

                        rs.getInt("student_id")
                                +" - "
                                +rs.getString("name")

                );


            }




        }catch(SQLException e){

            e.printStackTrace();

        }


    }


}