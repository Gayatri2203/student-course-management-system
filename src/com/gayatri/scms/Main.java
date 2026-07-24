package com.gayatri.scms;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        displayWelcomeMessage();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();

        displayStudentDetails(name, age);

        scanner.close();
    }

    public static void displayWelcomeMessage() {
        System.out.println("====================================");
        System.out.println(" Student Course Management System");
        System.out.println("====================================");
    }

    public static void displayStudentDetails(String name, int age) {
        System.out.println();
        System.out.println("Student Details");
        System.out.println("----------------");
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}