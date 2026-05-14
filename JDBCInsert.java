import java.sql.*;

public class JDBCInsert {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college2";
        String username = "root";
        String password = "root";

        try {

            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            // SQL Query
            String query =
                    "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, 101);
            pst.setString(2, "Rahul");
            pst.setInt(3, 20);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Record Inserted Successfully!");
            }

            pst.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// javac -cp ".;mysql-connector-j-9.7.0.jar" JDBCInsertExample.java 
// java -cp ".;mysql-connector-j-9.7.0.jar" JDBCInsertExample  