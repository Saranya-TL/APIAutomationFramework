package APIAutomationFramework.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

import APIAutomationFramework.pojos.Auth;
import APIAutomationFramework.pojos.Booking;
import APIAutomationFramework.pojos.BookingDates;
import APIAutomationFramework.pojos.BookingResponse;
import APIAutomationFramework.pojos.TokenResponse;

/**
 * 
 */
public class PayLoadManager {
	
	Gson gson;
	public String createPayLoadBookingAsString() {
		Booking booking = new Booking();
		Faker faker = new Faker();
		booking.setFirstName("Saranya");
		booking.setLastName(faker.name().lastName());
		booking.setTotalPrice(faker.random().nextInt(1000));
		booking.setDepositPaid(true);
		
		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2024-04-01");
		bookingdates.setCheckout("2024-05-04");
		booking.setBookingDates(bookingdates);
		booking.setAdditionalNeeds("Breakfast"); 
		
		gson = new Gson();
		String jsonPayload = gson.toJson(booking);
		System.out.println("pay load is" +jsonPayload);
		return jsonPayload;
		
		
	}
	
	public String createInvalidPayloadBookingAsString() {
		return "{}";
	}
	
	public String fullUpdatePayloadAsString () {
		Booking booking = new Booking();
		booking.setFirstName("Saranya");
		booking.setLastName("Devi");
		booking.setTotalPrice(112);
		booking.setDepositPaid(true);
		
		BookingDates bookingDates = new BookingDates();
		bookingDates.setCheckin("2024-04-01");
		bookingDates.setCheckout("2024-05-02");
		booking.setBookingDates(bookingDates);
		booking.setAdditionalNeeds("Breakfast");
		return gson.toJson(booking);
	}

	public BookingResponse bookingResponseJava(String responseString) {
		gson = new Gson();
		BookingResponse bookingResponse = gson.fromJson(responseString,BookingResponse.class);
		return bookingResponse;
	}
	
	public String setAuthPayload() {
		Auth auth = new Auth();
		auth.setUsername("admin");
		auth.setPassword("password123");
		gson = new Gson();
		String jsonPayLoadString = gson.toJson(auth);
		System.out.println("Payload set to: " +jsonPayLoadString );
		return jsonPayLoadString;
	}
	
	public String getTokenFromJSON(String tokenResponse) {
		gson = new Gson();
		//Response (JSON) -> object Token response
		//Deserialization
		TokenResponse tokenResponse1 = gson.fromJson(tokenResponse,TokenResponse.class);
		return tokenResponse1.getToken();
	}
	
	public Booking getResponseFromJSON(String getResponse) {
		gson = new Gson();
		//Reponse (Json) -> object token response
		//Deserialization
		Booking booking = gson.fromJson(getResponse,Booking.class);
		return booking;
			
	}
	
}
