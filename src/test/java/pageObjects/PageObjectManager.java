package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public LandingPage landingpage;
	public OffersPage offerspage;
	public WebDriver driver;
	public CheckoutPage checkoutpage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	

	public LandingPage getLandingPage()
	{
		landingpage  = new LandingPage(driver);
		return landingpage;
	}
	
	public OffersPage offerspage()
	{
		offerspage = new OffersPage(driver);
		return offerspage;
	}
	
	public CheckoutPage CheckoutPage()
	{
		checkoutpage = new CheckoutPage(driver);
		return checkoutpage;
	}
}
