package automationFramework.TestCases;


import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import automationFramework.PageObjects.EmailPage;
import automationFramework.Utilities.Global;
import automationFramework.Utilities.Logging;
import automationFramework.Utilities.Utils;


public class EmailTestDemo{
	
private static Logger Log = Logger.getLogger(Logger.class.getName());
	
	static WebDriver driver;
	static String browser;
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) throws InterruptedException {

		// create console and file logging
		Logging.setLogConsole();
		Logging.setLogFile();
		Log.info("Setup Started");
		Log.info("Current OS: " + WindowsUtils.readStringRegistryValue(Global.OS));
		Log.info("Current Browser: " + browser);
		driver = Utils.openBrowser(browser);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Log.info("Setup Completed");
	}
	
	@Test
	public void checkEmail() throws Exception{
		
		EmailPage ePage = new EmailPage(driver);
		ePage.getLandingPage(Global.URL1);
		ePage.enterEmail(driver, Global.EMAIL);
		ePage.clickNext(driver);
		Utils.waitTime(3000);
		ePage.enterPassword(driver, Global.PASSWD);
		ePage.clickSignIn(driver);
		Utils.waitTime(10000);
		ePage.findEmail(driver);
		Assert.assertTrue(driver.getPageSource().contains("OneAccount customer"));
		Log.info("checkEmail Test Completed");
		
	}
	
	@AfterMethod
	public void tearDown() {
		Log.info("TearDown Complete");
		driver.close();
		driver.quit();

	}
       
    }
		


