package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public base(WebDriver driver)
	{
		this.driver = driver;		
	}
	
	public base() {
        // Default initialization
    }
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //explicit
	}
	
	public void teardown() {
		if(driver != null)
		{
			driver.quit();
		}
	}
}
