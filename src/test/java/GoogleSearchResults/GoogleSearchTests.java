package GoogleSearchResults;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pages.Home;
import utils.base;
import utils.testDataReader;

public class GoogleSearchTests extends base {
	
	private Home home;
	
	@BeforeMethod
	public void setupTest()
	{
		setup();
		home = new Home(driver);
	}
	
	@Test
	public void testSearchForFlights()
	{
		String flightSearchQuery = testDataReader.getProperty("flight.search.query");
		home.enterSearchQuery(flightSearchQuery);
		home.SubmitSearch();
		Assert.assertTrue("Flight options not displayed", driver.getPageSource().contains("Flights"));		
	}
	
	
	@Test
	public void testSearchForWeather()
	{
		String weatherSearchQuery = testDataReader.getProperty("weather.search.query");
		home.enterSearchQuery(weatherSearchQuery);
		home.SubmitSearch();
		Assert.assertTrue("Weather data is not displayed", driver.getPageSource().contains("Marsa al `Alam, Red Sea, Egypt Weather Forecast"));
	}
	
	@Test
	public void testSearchForRestaurants()
	{
		String resturantSearchQuery = testDataReader.getProperty("restaurant.search.query");
		home.enterSearchQuery(resturantSearchQuery);
		home.SubmitSearch();
		Assert.assertTrue("Resturants data are not displayed", driver.getPageSource().contains("Restaurants in Marsa Alam"));
		home.clickOnTopRated();
	}
	
	@AfterMethod
    public void tearDown() {
        teardown();
    }

	
}
