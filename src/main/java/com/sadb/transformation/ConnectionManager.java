package com.sadb.transformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL = System.getenv("dest_oracle_url");
    private static final String USER = System.getenv("dest_oracle_user");
    private static final String PASSWORD = System.getenv("dest_oracle_password");

    private static Connection destOracleConnection;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            destOracleConnection = getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException();
        }
    }

    public static Connection getDestDBConnection() {
        return destOracleConnection;
    }

    public static Connection getConnection(String url, String userName, String password) throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}
