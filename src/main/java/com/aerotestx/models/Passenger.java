package com.aerotestx.models;

public class Passenger {

	private String name;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String cardType;
	private String cardNumber;
	private String cardMonth;
	private String cardYear;
	private String nameOnCard;
	
	
	public Passenger(String name, String address, String city, String state, String zipCode, String cardType,
			String cardNumber, String cardMonth, String cardYear, String nameOnCard) {
		
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.cardMonth = cardMonth;
		this.cardYear = cardYear;
		this.nameOnCard = nameOnCard;
	}
	public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardMonth() {
        return cardMonth;
    }

    public String getCardYear() {
        return cardYear;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }
}
