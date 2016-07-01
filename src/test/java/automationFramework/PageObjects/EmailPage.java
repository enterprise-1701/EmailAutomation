package automationFramework.PageObjects;


import java.awt.AWTException;
import java.io.IOException;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.gargoylesoftware.htmlunit.WebClient;
import automationFramework.Utilities.Global;
import automationFramework.Utilities.Global;
import automationFramework.Utilities.Utils;

public class EmailPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 90);

	// Element Locators
	private static final String EMAIL = "//*[@id='Email']";	
	private static final String EMAILID = "Email";	
	private static final String NEXT = "//*[@id='next']";
	private static final String PASSWD = "//*[@id='Passwd']";
	private static final String SIGNIN = "//*[@id='signIn']";
	private static final String SUBJECT = "//div [@class='y6']/span[contains(.,'Welcome New Customer')]";
	
	public EmailPage(WebDriver driver) {
		super(driver);
	}


	public void enterEmail(WebDriver driver, String email) throws InterruptedException, AWTException{
		//driver.findElement(By.xpath(EMAIL)).click();
		driver.findElement(By.id(EMAILID)).click();
		driver.findElement(By.xpath(EMAIL)).sendKeys(email);
	}
	
	public void clickNext(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(NEXT)).click();
	}
	
	public void enterPassword(WebDriver driver, String password) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(PASSWD)).click();
		driver.findElement(By.xpath(PASSWD)).sendKeys(password);
	}
	
	public void clickSignIn(WebDriver driver) throws InterruptedException, AWTException{
		driver.findElement(By.xpath(SIGNIN)).click();
	}
	
	public void findEmail(WebDriver driver) throws InterruptedException, AWTException{
	driver.findElement(By.xpath(SUBJECT)).click();
	}

	public String getCookie(String cookie) {
		driver.get(Global.URL1);
		Set<Cookie> cookies = driver.manage().getCookies();
		Cookie UID = driver.manage().getCookieNamed(cookie);
		return UID.getValue();
	}

}