package com.aerotestx.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aerotestx.api.ApiClient;
import com.aerotestx.base.BaseTest;
import com.aerotestx.data.ApiTestData;
import com.aerotestx.database.DatabaseUtils;
import com.aerotestx.listeners.TestListener;
import com.aerotestx.models.Flight;
import com.aerotestx.models.Passenger;
import com.aerotestx.pages.ConfirmationPage;
import com.aerotestx.pages.FlightResultPage;
import com.aerotestx.pages.FlightSearchPage;
import com.aerotestx.pages.PurchasePage;
import com.aerotestx.utils.TestDataFactory;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
@Listeners(TestListener.class)
public class BookingTest extends BaseTest{

	@Test( description = "Verify passenger can complete airline booking",
	        groups = {"ui", "airline", "booking"})
	public void CompleteBooking() throws Exception {

        // 1. Search flight
		

        FlightSearchPage searchPage =
                new FlightSearchPage(getDriver());

        searchPage.selectDepatureCity("Boston");

        searchPage.selectDestiantionCity("New York");

        searchPage.FindFlights();


        // 2. Select cheapest flight

        FlightResultPage resultPage =
                new FlightResultPage(getDriver());

        Assert.assertTrue(
                resultPage.isFlightResultsDisplayed(),
                "Flight results were not displayed"
        );

        Flight cheapestFlight =
                resultPage.getCheapestFlight();

        System.out.println(
                "Selected cheapest flight: "
                + cheapestFlight
        );

        resultPage.selectFlight(
                cheapestFlight
        );


        // 3. Passenger data

        Passenger passenger =
                TestDataFactory.getDefaultPassenger();


        // 4. Fill purchase form

        PurchasePage purchasePage =
                new PurchasePage(getDriver());

        purchasePage.fillPassengerDetails(
                passenger
        );

        purchasePage.purchaseButton();


        // 5. Validate confirmation

        ConfirmationPage confirmationPage =
                new ConfirmationPage(getDriver());

        Assert.assertTrue(
                confirmationPage
                        .isConfirmationDisplayed(),
                "Confirmation page was not displayed"
        );

        String bookingId =
                confirmationPage.getBookingId();

        String status =
                confirmationPage.getStatus();

        String amount =
                confirmationPage.getAmount();

        System.out.println(
                "Booking ID: " + bookingId
        );

        System.out.println(
                "Booking Status: " + status
        );

        System.out.println(
                "Booking Amount: " + amount
        );

        Assert.assertNotNull(
                bookingId,
                "Booking ID should not be null"
        );

        Assert.assertFalse(
                bookingId.isBlank(),
                "Booking ID should not be blank"
        );

        Assert.assertEquals(
                status,
                "PendingCapture"
        );
	
        // 6. Get the json data for API test
        WebElement jsonBlock = confirmationPage.getJsonForm();
        String jsonText = jsonBlock.getText();
        
        JSONObject jsonObj = new JSONObject(jsonText);
        String id = jsonObj.getString("id");
        String status2 = jsonObj.getString("status");
       
        
        Assert.assertEquals(status, status2, "Status was matched and test passed");
        
}
	
    }

        
            
            
        


