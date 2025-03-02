# JDBC Demo

A simple Java project to learn and practice JDBC (Java Database Connectivity) with PostgreSQL.  
This project demonstrates essential database operations such as fetching, inserting, updating, and deleting records using JDBC.

## Features
- Connects to a PostgreSQL database using JDBC
- Implements CRUD (Create, Read, Update, Delete) operations
- Uses `try-with-resources` for efficient resource management
- Follows best practices for handling SQL exceptions

## Technologies Used
- Java 17
- PostgreSQL 17
- JDBC
- Maven 3.9.6

## Setup Instructions
- Create database
```
CREATE DATABASE <db name>;
```
- Create table
```
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    marks INT NOT NULL
);
```
- Set values to below constants in `DatabaseConfig.java` file with your database details
```
    private static final String DB_TYPE = "<db type>";
    private static final String DB_HOST = "<db host>";
    private static final int DB_PORT = <db port>;
    private static final String DB_NAME = "<db name>";
    private static final String DB_USER = "<db user>";
    private static final String DB_PASSWORD = "<db password>";
```