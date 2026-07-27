package com.gayatri.scms.model;
import java.util.ArrayList;

public class Student {

    private static int idCounter = 1001;

    private int studentId;
    private String name;
    private int age;
    private String email;
    private ArrayList<Course> enrolledCourses;

    public Student(String name, int age, String email) {
        this.studentId = idCounter++;
        this.name = name;
        this.age = age;
        this.email = email;
        enrolledCourses = new ArrayList<>();
    }
    public Student(int studentId, String name, int age, String email) {

        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.email = email;
        enrolledCourses = new ArrayList<>();

    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
    public void assignCourse(Course course) {

        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {

        StringBuilder details = new StringBuilder();

        details.append("=========================\n");
        details.append("Student Details\n");
        details.append("=========================\n");
        details.append("ID    : ").append(studentId).append("\n");
        details.append("Name  : ").append(name).append("\n");
        details.append("Age   : ").append(age).append("\n");
        details.append("Email : ").append(email).append("\n");

        details.append("Courses:\n");

        if (enrolledCourses.isEmpty()) {

            details.append("None\n");

        } else {

            for (Course course : enrolledCourses) {
                details.append("- ")
                        .append(course.getCourseName())
                        .append("\n");
            }
        }

        details.append("=========================");

        return details.toString();
    }
}