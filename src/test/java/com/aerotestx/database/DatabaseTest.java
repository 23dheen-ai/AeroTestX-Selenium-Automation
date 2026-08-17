package com.aerotestx.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DatabaseTest {

	@Test
	public void  connectToDatabase() throws SQLException {
		
		DatabaseUtils dataBase = new DatabaseUtils();
		
		dataBase.connect();
		
		String query =BookingQueries.getBookingById(1);
		
		ResultSet resultSet = dataBase.executeQuery(query);
		
		Assert.assertTrue(resultSet.next(), "Booking should exist");
		
		String passengerName = resultSet.getString("passenger_name");
		
		String depatureCity = resultSet.getString("departure_city");
		
		String destinationCity = resultSet.getString("destination_city");
		
		double amount = resultSet.getDouble("amount");

	    String status = resultSet.getString("status");
		
	    Assert.assertEquals(passengerName, "John Doe");
	    
	    Assert.assertEquals(depatureCity, "Boston");
	    
	    Assert.assertEquals(destinationCity, "New York");
	    
	    Assert.assertEquals(amount, 250.00, 0.001);
	    
	    Assert.assertEquals(status, "CONFIRMED");
		
		dataBase.closeConnection();
	}
}
