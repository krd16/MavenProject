package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

    public static Connection connect() {

        String url = System.getProperty("db.url");
        String user = System.getProperty("db.user");
        String password = System.getProperty("db.pass");

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
