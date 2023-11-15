package util;

import org.h2.tools.RunScript;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

// connects to postgreSQL server in AWS
public class ConnectionUtil {

    Dotenv dotenv = Dotenv.load();

    // private static String url = "test";
    private String url = dotenv.get("URL");
    private String username = dotenv.get("PGUSER");
    private String password = dotenv.get("PGPASSWORD");
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
                resetTestDatabase();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static void resetTestDatabase() {
        if (connection == null) {
            getConnection();
        } else {
                System.out.println("IDK HOW I GOT HERE");
        }
        }
    }


