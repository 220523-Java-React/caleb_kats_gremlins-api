package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=public";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Password";
    private static Connection instance;

    public static Connection getInstance() throws SQLException {
        if(instance == null || instance.isClosed()) {
            instance = DriverManager.getConnection(URL, USER, PASSWORD);
        }

        return instance;
    }

    private ConnectionUtility(){}

}
