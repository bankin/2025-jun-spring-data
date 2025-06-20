package bg.softuni.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/%s";
    private static Connection connection;

    public static void createConnection(
            String username, String password, String dbName) throws SQLException {

        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);

        String formattedJdbc = String.format(JDBC_URL, dbName);

        connection = DriverManager.getConnection(formattedJdbc, props);
    }

    public static Connection getConnection() {
        return connection;
    }
}
