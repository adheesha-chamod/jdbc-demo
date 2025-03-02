package com.adheesha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_TYPE = "jdbc:postgresql";
    private static final String DB_HOST = "localhost";
    private static final int DB_PORT = 5432;
    private static final String DB_NAME = "jdbc-demo";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";

    private static final String URL = String.format("%s://%s:%d/%s", DB_TYPE, DB_HOST, DB_PORT, DB_NAME);


    // private constructor to prevent instantiation
    private DatabaseConnection() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed!", e);
        }
    }
}
