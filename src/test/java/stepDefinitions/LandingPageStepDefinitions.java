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
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {
	public WebDriver driver;
	public String offerpageproductname;
	public String landingpageproductname;
	TestContextSetup tc;
	LandingPage lp;
	
	public LandingPageStepDefinitions(TestContextSetup tc)
	{
		this.tc=tc;
		this.lp = tc.pom.getLandingPage();
	}
	
	@Given("user is on greencart landing page")
	public void user_is_on_greencart_landing_page() {
//	    tc.driver=new ChromeDriver();
//	    tc.driver.manage().window().maximize();
//	    tc.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
   Assert.assertTrue(lp.gettitleoflandingpage().contains("GreenKart"));
	}
	@When("^user saerched with shortname (.+) and extracted actual name of the product$")
	public void user_saerched_with_shortname_and_extracted_actual_name_of_the_product(String string) throws InterruptedException {
	
		
		//LandingPage lp=new LandingPage(tc.driver);
	lp.searchItem(string);
	//tc.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string) ;
	 Thread.sleep(2000);
	 tc.landingpageproductname=lp.getproductname().split("-")[0].trim();
	// tc.landingpageproductname=tc.driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
	System.out.println(tc.landingpageproductname +" extacted from products page");
	}
	
	@When("added {string} items to the selected product to the cart")
	public void added_items(String quantity)
	{
		lp.incrementquantity(Integer.parseInt(quantity));
		lp.addtocartbutton();
	}
	
	
	
}
