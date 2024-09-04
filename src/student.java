import java.sql.*;

class S {
    String  DB_URL = "jdbc:mysql://localhost:3306/student";
    String USER = "root";
    String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.sql.jdbc.Driver");

            stmt = conn.createStatement();

            // String insertQuery = "INSERT INTO student (name, roll_number) VALUES ('John Doe', 12345)";
            // stmt.executeUpdate(insertQuery);
            // System.out.println("Student data inserted successfully.");

            String selectQuery = "SELECT * FROM student";
            ResultSet resultSet = stmt.executeQuery(selectQuery);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int rollNumber = resultSet.getInt("roll_number");
                System.out.println("Name: " + name + ", Roll Number: " + rollNumber);
            }

            String updateQuery = "UPDATE student SET name = 'Jane Smith' WHERE roll_number = 12345";
            stmt.executeUpdate(updateQuery);
            System.out.println("Record modified successfully.");

            String deleteQuery = "DELETE FROM student WHERE roll_number = 12345";
            stmt.executeUpdate(deleteQuery);
            System.out.println("Record deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
