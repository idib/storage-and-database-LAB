package com.sadb.transformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL = System.getenv("dest_oracle_url");
    private static final String USER = System.getenv("dest_oracle_user");
    private static final String PASSWORD = System.getenv("dest_oracle_password");

    public static Connection getDestDBConnection() throws SQLException {
        return getConnection(URL, USER, PASSWORD);
    }

    public static Connection getConnection(String url, String userName, String password) throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}
