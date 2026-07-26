package com.gayatri.scms.service;

import com.gayatri.scms.model.Course;

import java.util.ArrayList;

public class CourseManager {

    private ArrayList<Course> courses;


    // Constructor
    public CourseManager() {
        courses = new ArrayList<>();
    }


    // Add Course
    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added successfully!");
    }


    // View All Courses
    public void viewCourses() {

        if (courses.isEmpty()) {
            System.out.println("\nNo courses available.");
            return;
        }

        System.out.println("\n========== Course List ==========");

        for (Course course : courses) {
            System.out.println(course);
            System.out.println("--------------------------------");
        }
    }


    // Search Course
    public Course searchCourse(String courseId) {

        for(Course course : courses) {

            if(course.getCourseId().equals(courseId)) {
                return course;
            }
        }

        return null;
    }


    // Delete Course
    public boolean deleteCourse(String courseId) {

        Course course = searchCourse(courseId);

        if(course != null) {
            courses.remove(course);
            return true;
        }

        return false;
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
}