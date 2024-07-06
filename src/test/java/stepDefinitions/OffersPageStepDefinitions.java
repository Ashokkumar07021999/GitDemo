package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {

	public String offerpageproductname;

	TestContextSetup tc;
	PageObjectManager pom;
	
	public OffersPageStepDefinitions(TestContextSetup tc)
	{
		this.tc=tc;
	}
	
	@Then("^user searched for (.+) same shortname in offers page to check if product exists$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exists(String string) throws InterruptedException {
	  switchtoofferspage();
	  OffersPage op = tc.pom.offerspage();
	  //OffersPage op = new OffersPage(tc.driver);
	  
	  op.searchItem(string);
	  //tc.driver.findElement(By.xpath("//input[@id=\"search-field\"]")).sendKeys(string);
	  offerpageproductname = op.getproductname();
	  //offerpageproductname = tc.driver.findElement(By.tagName("td")).getText();
	  Thread.sleep(1000);
	  System.out.println(offerpageproductname);
	  //tc.driver.quit();
	}
	
	public void switchtoofferspage()
	{
//	LandingPage lp = tc.pom.getLandingPage(); //eliminating object creation
//	//LandingPage lp=new LandingPage(tc.driver);
//	lp.selecttopdeals();
//	//tc.driver.findElement(By.xpath("//a[@class=\"cart-header-navlink\"]")).click();
//	//Method -1 : To switch to child window
//	Object[] s1=tc.driver.getWindowHandles().toArray();
//	tc.driver.switchTo().window((String) s1[1]);
	
	//Method - 2 : To switch to child window
//	LandingPage lp = tc.pom.getLandingPage(); //eliminating object creation
//	lp.selecttopdeals();
//	Set<String> s1 = tc.driver.getWindowHandles();
//	Iterator<String> i1=s1.iterator();
//	String parentwindow = i1.next();
//	String childwindow = i1.next();
//	tc.driver.switchTo().window(childwindow);
	
	//Method - 3 : To switch to child window using generic utils
	LandingPage lp = tc.pom.getLandingPage(); //eliminating object creation
	lp.selecttopdeals();
	tc.genericutils.switchwindowtochild();
	}
	
	
	@Then("validate product name matches in offers page")
	public void validate_product_name_matches_in_offers_page(){
	   Assert.assertEquals(offerpageproductname, tc.landingpageproductname);
	}
	
}
