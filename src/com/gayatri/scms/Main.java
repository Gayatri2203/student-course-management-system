package com.gayatri.scms;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println(" Student Course Management System");
        System.out.println("======================================");

        System.out.print("Enter your name: ");

        String name = scanner.nextLine();

        System.out.println();

        System.out.println("Welcome " + name + "!");
        System.out.println("Let's build an amazing Java project together.");

        scanner.close();
    }
}