package com.sadb.transformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL = "jdbc:oracle:thin:@sanddb.ct7ose5lnvl9.eu-central-1.rds.amazonaws.com:1521:dbresult";
    private static final String USER = "SandDB";
    private static final String PASSWORD = "132$ndfT7";

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
