package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
public WebDriver driver;
	
	public OffersPage(WebDriver driver)
	{
		this.driver = driver;
	}

	By search = By.xpath("//input[@id=\"search-field\"]");
	By productname = By.tagName("td");
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String getproductname()
	{
		return driver.findElement(productname).getText();
	}
}
