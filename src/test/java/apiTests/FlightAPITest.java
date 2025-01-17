package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FlightAPITest {
	
	@Test
	public void testFlightDetails()
	{
	
	String apiURL = "https://srv.wego.com/metasearch/bookings/flights/v2/fare-rules";
    String msFareId = "7d2471c14905798msr:handoff_wego_com:2ddbc0958a4dd66c:ss";
    String brandedFareIds = "90931e22-1bc9-3d02-8b07-a40fe7c16907";
    
    String cookies = "wego_analytics_client_id=904a9fa5-c884-474b-82ae-021ecd68c0d4; " +
            "wego_analytics_client_session_id=2666eedb-7053-4e8b-8271-b2e60cf1ff59; " +
            "_gcl_au=1.1.135368354.1737138910; " +
            "_ga=GA1.1.1727588394.1737138910; " +
            "_clck=1xc9npr|2|fsn|0|1843; " +
            "_tt_enable_cookie=1; " +
            "_ttp=dqsCGdsqdBp9OEvNaJRR18p0YNK.tt.1; " +
            "__cf_bm=GCyUdCvU5jYqKIGvR5UOu3BRSCzW6jxnDkFVgrh.V0A-1737140732-1.0.1.1-TuceyWH2cDs7fOGhsR9Akb3MNFVsUVkbJngxN9uUKm92ufoPATNMawzSVCKerKoWKcSGYk.LpbkR6nbrXP6P_g; " +
            "wego_ts_code=5aa90; " +
            "_hjSession_2024233=eyJpZCI6ImRmOTY5ZTU1LTRiODYtNDQ0NS1hNjQ4LWI2YmJkMjU4MTc5NyIsImMiOjE3MzcxNDA3MzgwNDMsInMiOjAsInIiOjAsInNiIjowLCJzciI6MCwic2UiOjAsImZzIjoxLCJzcCI6MH0=; " +
            "wego_visits_cnt=4; " +
            "forterToken=5dbcd050a8554a4ba118610b26606b53_1737140746942__UDF43-m4_24ck_; " +
            "wego_genzo_identifier_id=BAhJIkY5NTE4OGUwNy03Y2M2LTRmNzQtYjYzZC03YzFjMzVmZjk0ZmYtejVmRG5ibFp0Ry0xNzM3MTQwNzQ4LjY4ODIxOAY6BkVU--81f44aead70148cc71943e5d6e2f22ca8792f83b; " +
            "_hjSessionUser_2024233=eyJpZCI6ImY4MTRlMTdkLTdjNTUtNTMwYy05MGI3LWEzYTU2ZmIzZmRhNiIsImNyZWF0ZWQiOjE3MzcxNDA3MzgwNDIsImV4aXN0aW5nIjp0cnVlfQ==; " +
            "_clsk=wds5g5|1737140751369|2|1|n.clarity.ms/collect; " +
            "_uetsid=c8587eb0d50111efb68d1b3bfc3a4e25; " +
            "_uetvid=c858be60d50111efa46f938bd4903dc7; " +
            "_ga_VG6EGRH8EN=GS1.1.1737138910.1.1.1737140929.58.0.942160125";
    
    //Send a Get Request
    Response response = RestAssured.given()
    		.header("Content-Type", "application/json") 
            .header("X-Requested-By", "Landmark") 
            .header("Accept", "application/json, text/plain, */*") // 
            .header("Origin", "https://eg.wego.com") 
            .header("Referer", "https://eg.wego.com/") 
            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36") // Add User-Agent header
            .cookie(cookies) 
    		.queryParam("msFareId", msFareId)
    		.queryParam("brandedFareIds", brandedFareIds)
    		.get(apiURL);
	
     // Print the response for debugging
    //System.out.println("Status Code: " + response.getStatusCode());
    //System.out.println("Response Body: " + response.getBody().asString());
    //System.out.println("Headers: " + response.getHeaders());
	
	Assert.assertEquals(response.getStatusCode(), 200, "API request failed");
    
    // Validate the response body
    String DepartureCityName = response.jsonPath().getString("[0][0].departureCityName");
    Assert.assertEquals(DepartureCityName, "Cairo", "Departure city is incorrect");
    
    String ArrivalCityName = response.jsonPath().getString("[0][0].arrivalCityName");
    Assert.assertEquals(ArrivalCityName, "Marsa Alam City", "Arrival city is not Marsa Alam");
    
    System.out.println("API Response " + response.asPrettyString());

	}
}
