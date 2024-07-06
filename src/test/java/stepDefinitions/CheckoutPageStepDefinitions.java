package stepDefinitions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {
	public WebDriver driver;
	public CheckoutPage checkoutpage; 
	TestContextSetup tc;
	
	public CheckoutPageStepDefinitions(TestContextSetup tc)
	{
		this.tc=tc;
		this.checkoutpage = tc.pom.CheckoutPage();
	}
	
	@Then("verify user has ability to enter the promo code and place the order")
	public void verify_user_has_ability_to_enter_the_promo_code_and_place_the_order()
	{
		
		Assert.assertTrue(checkoutpage.verifypromobutton());
		Assert.assertTrue(checkoutpage.verifyplaceorderbutton());
	}
	
	@Then("^user proceeds to cehckout and validate the (.+) items in the checkout page$")
	public void user_proceeds_to_checkout(String vege) throws InterruptedException
	{
		checkoutpage.checkoutitems();
		CheckoutPage cp = tc.pom.CheckoutPage();
		String cartvege=cp.cartitem().split("-")[0].trim();
		Assert.assertEquals(cartvege, vege);	
	}
	
	
	
	
}
