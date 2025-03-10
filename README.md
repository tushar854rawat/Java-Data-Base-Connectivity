Java Database Connectivity (JDBC)

Overview

This repository provides a guide and implementation of Java Database Connectivity (JDBC), which is an API used to connect Java applications with relational databases like MySQL, PostgreSQL, SQLite, and others.

Prerequisites

Before using JDBC, ensure you have the following installed:

Java Development Kit (JDK) (Version 8 or later recommended)

A relational database (e.g., MySQL, PostgreSQL, SQLite, etc.)

JDBC Driver for your chosen database

An Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse (optional)

Installation

Step 1: Add JDBC Driver

Depending on the database, download the appropriate JDBC driver:

MySQL: Download MySQL Connector/J

PostgreSQL: Download PostgreSQL JDBC Driver

SQLite: Download SQLite JDBC Driver

Step 2: Add the Driver to Your Project

If using Maven, add the dependency to your pom.xml:

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>

If using a .jar file, add it to your project's classpath manually.

Basic JDBC Example

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // Database URL
        String user = "root"; // Database username
        String password = "password"; // Database password

        try {
            // Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            // Create a statement
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            // Process the result set
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }

            // Close connections
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

Common JDBC Operations

1. Insert Data
   String query = "INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com')";
statement.executeUpdate(query);
2. Update Data
   String query = "UPDATE users SET email = 'newemail@example.com' WHERE id = 1";
statement.executeUpdate(query);
3.Delete Data
  String query = "DELETE FROM users WHERE id = 1";
statement.executeUpdate(query);


Best Practices

Always close database connections (connection.close()) after use.

Use PreparedStatement instead of Statement to prevent SQL injection.

Handle exceptions properly using try-catch blocks.

Use connection pooling for better performance in large-scale applications.

Contributions

Contributions are welcome! Please submit a pull request or raise an issue for improvements.
