package org.example.Java_SpringBoot.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DbRepository implements DBREpo {
   @Autowired
    private final Connection connection;

   //    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "root", "root");


    // Constructor to initialize the table creation
    public DbRepository(Connection connection) throws SQLException {
        this.connection = connection;
        createTable();
    }

    // Fetch data from the 'person' table
    public List<Person> getPersonData() {
        List<Person> list = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM person;");
            while (resultSet.next()) {
                Person p = new Person(resultSet.getString(1), resultSet.getInt(2));
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching data: " + e.getMessage());
        }
        return list;
    }

    // Insert a person into the 'person' table
    public int addPerson(Person person) {
        String query = "INSERT INTO person (name, id) VALUES (?, ?)";
        boolean currentAutoCommit = false;

        try {
            currentAutoCommit = connection.getAutoCommit();
            connection.setAutoCommit(false);

            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, person.getName());
                ps.setInt(2, person.getId());
                int output = ps.executeUpdate();
                connection.commit();  // Commit the transaction
                return output;
            }
        } catch (SQLException e) {
            try {
                connection.rollback();  // Roll back if an error occurs
            } catch (SQLException ex) {
                throw new RuntimeException("Error during rollback: " + ex.getMessage());
            }
            throw new RuntimeException("Error adding person: " + e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(currentAutoCommit);  // Restore auto-commit setting
            } catch (SQLException e) {
                throw new RuntimeException("Error restoring auto-commit: " + e.getMessage());
            }
        }
    }

    // Create the 'person' table if it does not exist
    public void createTable() {
        System.out.println("Attempting to create the table...");
        String createTableSQL = "CREATE TABLE IF NOT EXISTS person (" +
                "name VARCHAR(20), " +
                "id INT PRIMARY KEY)";
        try {
            connection.createStatement().execute(createTableSQL);
            System.out.println("Table created or already exists.");
        } catch (SQLException e) {
            throw new RuntimeException("Error creating table: " + e.getMessage());
        }
    }
}
