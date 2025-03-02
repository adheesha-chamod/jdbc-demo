package com.adheesha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        /**
         * import the packages
         * load and register the driver(db connector) | optional -> handle automatically
         * create the connection
         * create statement
         * execute the statement
         * process the result
         * close the connection
         */

        final String DB_TYPE = "jdbc:postgresql";
        final String DB_HOST = "localhost";
        final int DB_PORT = 5432;
        final String DB_NAME = "jdbc-demo";
        final String DB_USER = "postgres";
        final String DB_PASSWORD = "postgres";

        // Construct the connection URL dynamically
        final String URL = String.format("%s://%s:%d/%s", DB_TYPE, DB_HOST, DB_PORT, DB_NAME);

        try {
            Connection dbConnection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed!", e);
        }
    }
}