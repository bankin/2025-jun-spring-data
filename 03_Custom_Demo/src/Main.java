import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Connect to SQL Server
        String jdbc = "jdbc:mysql://localhost:3306/soft_uni";
        String username = "root";
        String password = "12345";

        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        Connection connection =
            DriverManager.getConnection(jdbc, properties);

        // Execute query
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM employees WHERE salary > 100000 LIMIT 10");
        ResultSet resultSet = preparedStatement.executeQuery();

        // Parse result
        while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String jobTitle = resultSet.getString("job_title");
            double salary = resultSet.getDouble("salary");

            System.out.printf("%s %s - %.2f%n", firstName, jobTitle, salary);
        }
    }
}