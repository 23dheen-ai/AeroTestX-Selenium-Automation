package com.aerotestx.utils;

import com.aerotestx.models.Passenger;

public class TestDataFactory {

	public static  Passenger getDefaultPassenger() {
		return new Passenger("Dheena G", "No.32, chrompet", "Chennai", "Tamil Nadu",
				"6000060", "Visa", "123456789121", "10", "2060", "Dheena G");
	}
}
