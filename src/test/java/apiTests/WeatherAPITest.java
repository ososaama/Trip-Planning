package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeatherAPITest {
	
	@Test
	public void testWeatherDetails()
	{
		String apiURL = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/aggregated/352736";
		
		 Response response = RestAssured.given()
	                .header("Accept", "application/json") // Specify JSON response
	                .header("Referer", "https://www.bbc.com/") // Add Referer header
	                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36") // Add User-Agent header
	                .get(apiURL);
		 
		    Assert.assertEquals(response.getStatusCode(), 200, "API request failed");
		    
		    String locationName = response.jsonPath().getString("location.name");
		    String locationId = response.jsonPath().getString("location.id");
		    
		    Assert.assertEquals(locationName, "Marsa Alam", "Location name is incorrect");
	        Assert.assertEquals(locationId, "352736", "Location ID is incorrect");
	}

}
