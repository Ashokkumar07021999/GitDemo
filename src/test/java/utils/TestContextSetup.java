package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public String landingpageproductname;
	public PageObjectManager pom;
	public TestBase testbase;
	public GenericUtils genericutils;
	
	
	
	public TestContextSetup() throws IOException
	{
		testbase = new TestBase();
		pom = new PageObjectManager(testbase.WebDriverManager());
		genericutils = new GenericUtils(testbase.WebDriverManager());
	}
}
