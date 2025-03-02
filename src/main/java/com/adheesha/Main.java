package com.adheesha;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        try {
            Connection dbConnection = DatabaseConnection.getConnection();
            System.out.println("Connected to the database successfully!");
        } catch (RuntimeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}