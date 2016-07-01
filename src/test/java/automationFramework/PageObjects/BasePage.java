package automationFramework.PageObjects;


import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;

import automationFramework.Utilities.Global;

public class BasePage {
	
	// Element Locators
	    private static final String LAUNCH_PAD = "//*[@class='fa fa-rocket fa-lg cmc-main-icon']"; 
		
		
	public static WebDriver driver;

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
	}
	
	public void getLandingPage(String url) throws WebDriverException {
		  
		try{
			driver.get(url);

		} catch (Exception e) {
			Reporter.log("landing page not Found");
		}
	}



}
