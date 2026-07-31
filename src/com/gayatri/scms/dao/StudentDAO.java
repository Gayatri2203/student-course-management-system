package com.gayatri.scms.dao;

import com.gayatri.scms.database.DBConnection;
import com.gayatri.scms.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class StudentDAO {

    public void addStudent(Student student) {

        String sql = "INSERT INTO students(name, age, email) VALUES (?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getEmail());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student inserted into database successfully!");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
    public void viewStudents() {

        String sql = "SELECT * FROM students";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("\n========== Students ==========\n");

            while (resultSet.next()) {

                System.out.println("ID    : " + resultSet.getInt("student_id"));
                System.out.println("Name  : " + resultSet.getString("name"));
                System.out.println("Age   : " + resultSet.getInt("age"));
                System.out.println("Email : " + resultSet.getString("email"));

                System.out.println("---------------------------");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
    public void searchStudentById(int studentId) {

        String sql = "SELECT * FROM students WHERE student_id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            if (connection == null) {
                System.out.println("Database connection failed.");
                return;
            }

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setInt(1, studentId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                System.out.println("\n===== Student Found =====");

                System.out.println("ID    : " + resultSet.getInt("student_id"));
                System.out.println("Name  : " + resultSet.getString("name"));
                System.out.println("Age   : " + resultSet.getInt("age"));
                System.out.println("Email : " + resultSet.getString("email"));

            } else {

                System.out.println("Student not found.");

            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
    public void updateStudent(int studentId, int newAge, String newEmail) {

        String sql = "UPDATE students SET age = ?, email = ? WHERE student_id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            if (connection == null) {
                System.out.println("Database connection failed.");
                return;
            }

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setInt(1, newAge);
            preparedStatement.setString(2, newEmail);
            preparedStatement.setInt(3, studentId);

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found.");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int studentId) {

        String sql = "DELETE FROM students WHERE student_id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            if (connection == null) {
                System.out.println("Database connection failed.");
                return;
            }

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setInt(1, studentId);

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found.");
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}