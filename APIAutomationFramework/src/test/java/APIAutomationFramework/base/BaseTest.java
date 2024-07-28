package APIAutomationFramework.base;

import APIAutomationFramework.actions.AssertActions;
import APIAutomationFramework.endPoints.APIConstants;
import APIAutomationFramework.modules.PayLoadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

//Common functions for all Test cases

public class BaseTest {
	
	public RequestSpecification requestSpecification;
	public AssertActions assertAction;
	public PayLoadManager payLoadManager;
	public JsonPath jsonPath;
	public Response response;
	public ValidatableResponse validatableResponse;
	
	@BeforeTest
	public void setUp() {
		System.out.println("Before Test");
		payLoadManager = new PayLoadManager();
		assertAction = new AssertActions();
		requestSpecification = new RequestSpecBuilder()
				.setRelaxedHTTPSValidation()
				.setBaseUri(APIConstants.BASE_URL)		
				.addHeader("content-Type","application/json")
				.build().log().all();
		
	}
	
	public String getToken() {
		requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL)
								.basePath(APIConstants.AUTH_URL);
		
		// Setting the up the Payload
		String payLoad = payLoadManager.setAuthPayload();
		
		   // Getting the Response
		response = requestSpecification
					.relaxedHTTPSValidation()
					.contentType(ContentType.JSON)
					.body(payLoad)
					.when().post();
		
		// Extracting of the Token via Deserialization
		String token = payLoadManager.getTokenFromJSON(response.asString());
		
		//verify
		 return token;
		
	}

}
