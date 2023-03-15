package com.example.demo;
import java.sql.Connection; // Import the Connection class
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplicationOld {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dev";
        String username = "postgres";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Reading from the 'test' table
            String query = "SELECT number FROM test";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int number = resultSet.getInt("number");
                System.out.println("Number: " + number);
            }

            // Writing to the 'test' table
            query = "INSERT INTO test (number) VALUES (?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, 123); // Set the new value for the 'number' column
            int rowsUpdated = statement.executeUpdate();
            System.out.println(rowsUpdated + " row(s) updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
