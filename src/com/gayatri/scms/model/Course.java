package com.gayatri.scms.model;


public class Course {


    private String courseId;

    private String courseName;

    private String duration;

    private int credits;



    // Constructor for INSERT

    public Course(String courseId,
                  String courseName,
                  String duration,
                  int credits) {


        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.credits = credits;

    }




    // Getters

    public String getCourseId() {

        return courseId;

    }


    public String getCourseName() {

        return courseName;

    }


    public String getDuration() {

        return duration;

    }


    public int getCredits() {

        return credits;

    }



    // Setters

    public void setCourseId(String courseId) {

        this.courseId = courseId;

    }


    public void setCourseName(String courseName) {

        this.courseName = courseName;

    }


    public void setDuration(String duration) {

        this.duration = duration;

    }


    public void setCredits(int credits) {

        this.credits = credits;

    }



    @Override
    public String toString() {

        return
                "Course ID   : " + courseId +
                        "\nCourse Name : " + courseName +
                        "\nDuration    : " + duration +
                        "\nCredits     : " + credits;

    }

}