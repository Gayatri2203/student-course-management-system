package com.gayatri.scms.dao;

import com.gayatri.scms.database.DBConnection;
import com.gayatri.scms.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAO {

    public void addCourse(Course course) {


        String sql = "INSERT INTO courses(course_id, course_name, duration, credits) VALUES (?, ?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            if (connection == null) {
                System.out.println("Database connection failed.");
                return;
            }

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, course.getCourseId());
            preparedStatement.setString(2, course.getCourseName());
            preparedStatement.setString(3, course.getDuration());
            preparedStatement.setInt(4, course.getCredits());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Course added successfully!");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void viewCourses() {

        String sql = "SELECT * FROM courses";

        try {

            Connection connection = DBConnection.getConnection();

            if (connection == null) {
                System.out.println("Database connection failed.");
                return;
            }

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("\n========== Course List ==========\n");

            while (resultSet.next()) {

                System.out.println("Course ID   : " + resultSet.getString("course_id"));
                System.out.println("Course Name : " + resultSet.getString("course_name"));
                System.out.println("Duration    : " + resultSet.getString("duration"));
                System.out.println("Credits     : " + resultSet.getInt("credits"));

                System.out.println("------------------------------");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
    public void searchCourse(String courseId) {

        String sql = "SELECT * FROM courses WHERE course_id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            if (connection == null) {
                System.out.println("Database connection failed.");
                return;
            }

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, courseId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                System.out.println("\n===== Course Found =====");

                System.out.println("Course ID   : " + resultSet.getString("course_id"));
                System.out.println("Course Name : " + resultSet.getString("course_name"));
                System.out.println("Duration    : " + resultSet.getString("duration"));
                System.out.println("Credits     : " + resultSet.getInt("credits"));

            } else {

                System.out.println("Course not found.");

            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
    public void deleteCourse(String courseId) {

        String sql = "DELETE FROM courses WHERE course_id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            if (connection == null) {
                System.out.println("Database connection failed.");
                return;
            }

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, courseId);

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {

                System.out.println("Course deleted successfully!");

            } else {

                System.out.println("Course not found.");

            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}