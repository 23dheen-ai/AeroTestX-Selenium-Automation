package com.aerotestx.database;

public class BookingQueries {

	public BookingQueries() {
		
	}

	public static String getBookingById(
            int bookingId) {

        return "SELECT * FROM bookings "
                + "WHERE booking_id = "
                + bookingId;
    }
}
