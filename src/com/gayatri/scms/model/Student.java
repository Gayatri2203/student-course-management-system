package com.gayatri.scms.model;

public class Student {

    private static int idCounter = 1001;

    private int studentId;
    private String name;
    private int age;
    private String email;

    public Student(String name, int age, String email) {
        this.studentId = idCounter++;
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public Student(int studentId, String name, int age, String email) {

        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.email = email;

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

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "=========================\n" +
                "Student Details\n" +
                "=========================\n" +
                "ID    : " + studentId + "\n" +
                "Name  : " + name + "\n" +
                "Age   : " + age + "\n" +
                "Email : " + email + "\n" +
                "=========================";
    }
}