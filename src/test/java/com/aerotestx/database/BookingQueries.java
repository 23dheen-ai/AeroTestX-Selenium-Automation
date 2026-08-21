package com.aerotestx.database;

public class BookingQueries {

	public BookingQueries() {
    }

    public static String getBookingById(
            String bookingId) {

        return "SELECT * FROM bookings " +
               "WHERE booking_id = '" +
               bookingId + "'";
    }

    // NEW
    public static String getUserById(
            String userId) {

        return "SELECT * FROM users " +
               "WHERE id = " +
               userId;
    }
}
