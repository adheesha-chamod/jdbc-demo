package com.adheesha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        fetchAllStudents();

//        addStudent(4, "Alice", 85);
//        fetchAllStudents();

//        updateMarks(4, 95);
//        fetchAllStudents();

//        deleteStudent(4);
//        fetchAllStudents();
    }

    private static void fetchAllStudents() {
        String query = "SELECT * FROM students";

        // 'try-with-resources' ensures Connection, PreparedStatement & ResultSet are closed automatically
        try (
                Connection dbConnection = DatabaseConnection.getConnection();
                PreparedStatement pst = dbConnection.prepareStatement(query);
                ResultSet res = pst.executeQuery()
        ) {
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                int marks = res.getInt("marks");
                System.out.println("id: " + id + ", name: " + name + ", marks: " + marks);
            }
        } catch (RuntimeException | SQLException e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }

    private static void addStudent(int id, String name, int marks) {
        String query = "INSERT INTO students (id, name, marks) VALUES (?, ?, ?)";

        try (
                Connection dbConnection = DatabaseConnection.getConnection();
                PreparedStatement pst = dbConnection.prepareStatement(query)
        ) {
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, marks);

            pst.execute();
            System.out.println("Inserted successfully!");
        } catch (RuntimeException | SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
    }

    private static void updateMarks(int id, int marks) {
        String query = "UPDATE students SET marks = ? WHERE id = ?";

        try (
                Connection dbConnection = DatabaseConnection.getConnection();
                PreparedStatement pst = dbConnection.prepareStatement(query)
        ) {
            pst.setInt(1, marks);
            pst.setInt(2, id);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Updated successfully! Rows affected: " + rowsAffected);
            } else {
                System.out.println("No student found with Id: " + id);
            }
        } catch (RuntimeException | SQLException e) {
            System.err.println("Error updating data: " + e.getMessage());
        }
    }

    private static void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";

        try (
                Connection dbConnection = DatabaseConnection.getConnection();
                PreparedStatement pst = dbConnection.prepareStatement(query)
        ) {
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deleted successfully!");
            } else {
                System.out.println("No student found with Id: " + id);
            }
        } catch (RuntimeException | SQLException e) {
            System.err.println("Error deleting data: " + e.getMessage());
        }
    }
}