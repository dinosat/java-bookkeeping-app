package com.example.buchalti.dao.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnector {
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;
    private static Connection connection;

    static {
        Properties properties = loadProperties();
        URL = "jdbc:postgresql://" +
                properties.getProperty("POSTGRES_HOST") + ":5432/" +
                properties.getProperty("POSTGRES_DATABASE");
        USER = properties.getProperty("POSTGRES_USERNAME");
        PASSWORD = properties.getProperty("POSTGRES_PASSWORD");
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(".env")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
