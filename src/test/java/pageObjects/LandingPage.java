package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
By search = By.xpath("//input[@type='search']");
By productName = By.xpath("//h4[@class='product-name']");
By topdeals = By.xpath("//a[@class=\"cart-header-navlink\"]");
By increment = By.cssSelector("a.increment");
By addtocart = By.cssSelector(".product-action button");


public void searchItem(String name)
{
	driver.findElement(search).sendKeys(name);
}

public String getproductname()
{
	return driver.findElement(productName).getText();
}

public void selecttopdeals() 
{
	driver.findElement(topdeals).click();
}

public String gettitleoflandingpage()
{
	return driver.getTitle();
}

public void incrementquantity(int quantity)
{
	int i = quantity-1 ;
	while(i>0)
	{
		driver.findElement(increment).click();
		i--;		
	}
}

public void addtocartbutton()
{
	driver.findElement(addtocart).click();
}



}
