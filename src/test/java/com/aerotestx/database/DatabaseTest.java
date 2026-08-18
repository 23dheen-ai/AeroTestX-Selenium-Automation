package com.aerotestx.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aerotestx.utils.LogUtils;

public class DatabaseTest {

	private static final Logger log =
	        LogUtils.getLogger(DatabaseTest.class);
	@Test
	public void  connectToDatabase() throws SQLException {
		
		DatabaseUtils dataBase = new DatabaseUtils();
		log.info("Connecting to database");
		dataBase.connect();
		log.info("Executing booking validation query");
		String query =BookingQueries.getBookingById(1);
		
		ResultSet resultSet = dataBase.executeQuery(query);
		log.info("Booking record retrieved");
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
	    log.info("Validating booking status");
	    Assert.assertEquals(status, "CONFIRMED");
	    log.info("Validating booking status");
		dataBase.closeConnection();
	}
}
