package com.aerotestx.database;

import java.sql.ResultSet;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aerotestx.utils.LogUtils;

public class DatabaseTest {

	private static final Logger log = LogUtils.getLogger(DatabaseTest.class);

	@Test(description = "Verify booking exists in database", groups = { "database", "regression" })
	public void verifyBookingInDatabase() throws Exception {
		log.info("Getting JDBC check for API integration");
		String bookingId = "1";

		String query = BookingQueries.getBookingById(bookingId);

		ResultSet result = DatabaseUtils.executeQuery(query);

		Assert.assertTrue(result.next(), "Booking should exist in database");
		log.info("JDBC is successfully connected");
		DatabaseUtils.closeConnection();
	}
}
