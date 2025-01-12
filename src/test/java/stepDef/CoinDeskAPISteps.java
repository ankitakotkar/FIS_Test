package stepDef;


import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.json.JSONObject;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class CoinDeskAPISteps {
		

	    private RequestSpecification requestSpec;
	    private Response response;
	   
	    
	    String baseURI = "https://api.coindesk.com";
	    String endpoint = "/v1/bpi/currentprice.json";

	    @Given("User calls specified coin desk API")
	    public void user_calls_specified_coin_desk_API() {
	    	requestSpec = given().baseUri(baseURI);
	        response = requestSpec.when().get(endpoint);
	    }

	    @Then("The response status code should be {int}")
	    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
	        response.then().statusCode(expectedStatusCode);
	    }

	    @And("The response should contain {int} BPI keys")
	    public void theResponseShouldContainWithValue(int expectedKeyCount) {
	        
	    	String responseBody = response.getBody().asString();
	        JSONObject jsonResponse = new JSONObject(responseBody);
	        JSONObject bpiObject = jsonResponse.getJSONObject("bpi");
	        
	    	
	        Set<String> keys = bpiObject.keySet();
	        // Checking size
	        assertEquals(keys.size(),expectedKeyCount, "bpi object key size should be "+expectedKeyCount);

	        // Checking exact match for keys
	        assertEquals(Set.of("USD", "GBP", "EUR"), keys, "One of the BPI keys out of USD, GBP or EUR is missing in response!");
	             
	    }

	    @And("The {string} key description in response should be {string}")
	    public void theResponseKeyShouldContainExpectedDescription(String key, String value) {
	    	
	    	 String gbpDescription = response.jsonPath().getString("bpi."+key+".description");
	    	 assertEquals(gbpDescription,value,"Expected description for "+key+" is incorrect in API response!");

	    }
	    
	    
	}