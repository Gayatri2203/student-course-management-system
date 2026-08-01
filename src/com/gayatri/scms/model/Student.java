package com.gayatri.scms.model;


public class Student {


    private int studentId;

    private String name;

    private int age;

    private String email;



    // Constructor for INSERT
    public Student(String name, int age, String email) {

        this.name = name;
        this.age = age;
        this.email = email;

    }



    // Constructor for SELECT

    public Student(int studentId, String name, int age, String email) {

        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.email = email;

    }




    public int getStudentId() {

        return studentId;

    }


    public void setStudentId(int studentId) {

        this.studentId = studentId;

    }


    public String getName() {

        return name;

    }


    public void setName(String name) {

        this.name = name;

    }


    public int getAge() {

        return age;

    }


    public void setAge(int age) {

        this.age = age;

    }


    public String getEmail() {

        return email;

    }


    public void setEmail(String email) {

        this.email = email;

    }



    @Override
    public String toString() {

        return
                "Student ID : " + studentId +
                        "\nName       : " + name +
                        "\nAge        : " + age +
                        "\nEmail      : " + email;

    }

}