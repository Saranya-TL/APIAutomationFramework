package APIAutomationFramework.CRUD.Sample;

import APIAutomationFramework.actions.AssertActions;
import APIAutomationFramework.base.BaseTest;
import APIAutomationFramework.endPoints.APIConstants;
import APIAutomationFramework.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
//import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class testCreateBookingPOST extends BaseTest{
	
	@Test(groups = "smoke")
	@Owner("Saranya")
	@Severity(SeverityLevel.NORMAL)
	@Description("#TC1 - verify that the Booking can be created")
	public void testCreateBooking() {
		requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
		response = RestAssured
				.given(requestSpecification)
				.when().body(payLoadManager.createPayLoadBookingAsString()).post();
				System.out.println("response is" + response.getBody());

	validatableResponse = response.then().log().all();
				System.out.println("validatable response is " + validatableResponse);
				validatableResponse.statusCode(200);
		
		//Deserialization
		BookingResponse bookingResponse = payLoadManager.bookingResponseJava(response.asString());
		System.out.println("booking response" +bookingResponse);
		//Verify
		
		assertThat(bookingResponse.getBookingId()).isNotNull();
		assertThat(bookingResponse.getBooking().getFirstName()).isNotBlank();
		assertThat(bookingResponse.getBooking().getFirstName()).isEqualTo("Saranya");
		
		//TestNg assertion
		assertAction.verifyStatusCode(response,200);
			
	}
	
	@Test(groups="smoke")
	@Owner("Saranya")
	@Severity(SeverityLevel.NORMAL)
	@Description("TC#2 Verify that the negative scenario works fine")
	public void testCreateBookingNegative() {
		requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
		response = RestAssured.given(requestSpecification).when().body(payLoadManager.createInvalidPayloadBookingAsString()).post();
		
		validatableResponse = response.then().log().all();
		
		//Assertion
		validatableResponse.statusCode(500);
	}

}
