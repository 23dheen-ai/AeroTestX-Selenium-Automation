package com.aerotestx.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aerotestx.utils.ConfigReader;

public class DatabaseUtils {

	private static Connection connection;

    public static Connection getConnection()
            throws Exception {

        String url =
                ConfigReader.getProperty("db.url");

        String userName =
                ConfigReader.getProperty("db.username");

        String pass =
                ConfigReader.getProperty("db.password");

        if (connection == null) {

            connection =
                    DriverManager.getConnection(
                            url,
                            userName,
                            pass
                    );
        }

        return connection;
    }

    public static ResultSet executeQuery(
            String query)
            throws Exception {

        PreparedStatement statement =
                getConnection()
                .prepareStatement(query);

        return statement.executeQuery();
    }

    // NEW METHOD
    public static String getSingleValue(
            String query,
            String columnName)
            throws Exception {

        try (PreparedStatement statement =
                     getConnection()
                     .prepareStatement(query);

             ResultSet result =
                     statement.executeQuery()) {

            if (result.next()) {
                return result.getString(
                        columnName
                );
            }

            return null;
        }
    }

    public static void closeConnection()
            throws Exception {

        if (connection == null) {

            connection.close();
        }
    }
	}
