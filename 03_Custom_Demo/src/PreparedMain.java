import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PreparedMain {

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
            .prepareStatement("SELECT * FROM employees WHERE salary > ?");

        preparedStatement.setString(1, "10'; SELECT * FROM employees;");
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println(resultSet.getFetchSize());

        System.out.println(preparedStatement);
    }
}
