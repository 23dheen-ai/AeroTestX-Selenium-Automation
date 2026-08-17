package com.aerotestx.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aerotestx.utils.ConfigReader;

public class DatabaseUtils {

	private Connection connect;
	
	public void connect() throws SQLException {
		
		String url = ConfigReader.getProperty("db.url");
		
		String userName = ConfigReader.getProperty("db.username");
		
		String password = ConfigReader.getProperty("db.password");
		
		connect= DriverManager.getConnection(url, userName, password);
		
		System.out.println("Database connection successful");
		
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		
		Statement statement = connect.createStatement();
		
		return statement.executeQuery(query);
	}
	
	public void closeConnection()
            throws SQLException {

        if (connect != null) {
            connect.close();
        }
}}
