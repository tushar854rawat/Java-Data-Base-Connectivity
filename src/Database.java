import java.sql.*;

public class Database {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "root";

        try {
            // Step 1: Register the JDBC driver 
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Establish the connection
            Connection connection = DriverManager.getConnection(url,username,password);

            // Step 3: Create a statement object
            Statement statement = connection.createStatement();

            // Step 4: Insert records into table
            String insertQuery = "INSERT INTO student (FirstName,LastName,city) VALUES ('dikshant','negi','gadi cannt')";
            statement.executeUpdate(insertQuery);
            System.out.println("Record inserted successfully.");

            // Step 5: Fetch records from table
            String selectQuery = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                String FirstName = resultSet.getString(1);
                String LastName = resultSet.getString(2);
                String city = resultSet.getString(3);
                System.out.println("FirstName: " + FirstName +", LastName: " + LastName +", city" + city );
            }

            // Step 6: Modify records in table
            String updateQuery = "UPDATE student SET FirstName = 'rohan' WHERE city='dehradun'";
            statement.executeUpdate(updateQuery);
            System.out.println("Record updated successfully.");

            // Step 7: Delete records from table
            String deleteQuery = "DELETE FROM student WHERE city ='dheradun'";
            statement.executeUpdate(deleteQuery);
            System.out.println("Record deleted successfully.");

            // Step 8: Close the statement and connection
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}