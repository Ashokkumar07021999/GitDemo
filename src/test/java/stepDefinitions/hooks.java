package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;


public class hooks {
	TestContextSetup tc; 
	public  hooks(TestContextSetup tc)
	{
		this.tc=tc;
	}
	@After //executes after scenarios
	public void AfterScenario() throws IOException
	{
		tc.testbase.WebDriverManager().quit();
	}
	
	@AfterStep //executes after each and every step of the scenario
	public void addscreenshot(Scenario scenario) throws IOException
	{
		//WebDriver driver = tc.testbase.WebDriverManager();
		TakesScreenshot ts = (TakesScreenshot)tc.testbase.WebDriverManager();
		if(scenario.isFailed())
		{
		File src = ts.getScreenshotAs(OutputType.FILE);
		byte[] filecontent = FileUtils.readFileToByteArray(src);
		scenario.attach(filecontent, "image/png", "image");
		}
	}
	
	
}
