package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
By cartbag = By.cssSelector("[alt='Cart']");
By checkoutbutton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
By promobutton = By.cssSelector(".promoBtn");
By placeorder = By.xpath("//button[contains(text(),'Place Order')]");
By itemincart = By.xpath("//p[@class='product-name']");
public void checkoutitems()
{
	driver.findElement(cartbag).click();
	driver.findElement(checkoutbutton).click();
}

public boolean verifypromobutton()
{
	return driver.findElement(promobutton).isDisplayed();
}

public boolean verifyplaceorderbutton()
{
	return driver.findElement(placeorder).isDisplayed();
}

public String cartitem()
{
	return driver.findElement(itemincart).getText();
}





}
