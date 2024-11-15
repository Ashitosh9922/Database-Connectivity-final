package connect4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connectivit {
    public static void main(String[] args) {
        try {
            // Step 1: Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Step 2: Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stud", "root", "Ash123");//database name ,user ,password
            System.out.println("Connection created");
            
            // Step 3: Create a statement
            Statement stmt = con.createStatement();
            
            // Step 4: Write and execute SQL query
            // CREATE - Inserting 5 records in total
            stmt.executeUpdate("INSERT INTO student VALUES (43, 'Ashitosh', 20)");//student table-> (id int,name varchar(30),age int)
            stmt.executeUpdate("INSERT INTO student VALUES (44, 'Neha', 22)");
            stmt.executeUpdate("INSERT INTO student VALUES (45, 'Rahul', 21)");
            stmt.executeUpdate("INSERT INTO student VALUES (46, 'Sneha', 23)");
            stmt.executeUpdate("INSERT INTO student VALUES (47, 'Vikas', 24)");
            System.out.println("5 records inserted successfully");

            // READ
            stmt.executeQuery("SELECT * FROM student");
            System.out.println("Data retrieved successfully");

            // UPDATE
            stmt.executeUpdate("UPDATE student SET name = 'Ashish' WHERE id = 43");
            System.out.println("Data updated successfully");

            // DELETE
            stmt.executeUpdate("DELETE FROM student WHERE id = 47");
            System.out.println("Data deleted successfully");

            
            
            // Close the connection
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
    }
}
