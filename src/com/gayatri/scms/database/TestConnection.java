package com.gayatri.scms.database;


import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        Connection connection = DBConnection.getConnection();

        if (connection != null) {

            System.out.println("Connected to MySQL Successfully!");

        } else {

            System.out.println("Connection Failed!");

        }

    }
}