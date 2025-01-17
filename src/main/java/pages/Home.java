package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.base;

public class Home extends base {
	@FindBy(name = "q")
	private WebElement searchBar;
	
	@FindBy(xpath = "//span[normalize-space()='Top rated']")
	private WebElement topRatedBtn;
	
	public Home(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterSearchQuery(String searchQuery)
	{
		searchBar.sendKeys(searchQuery); 
	}
	
	public void SubmitSearch() {
		searchBar.submit();
	}
	
	public void clickOnTopRated()
	{
		topRatedBtn.submit();
	}

}
