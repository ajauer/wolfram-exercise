package Tests;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.CloudApp;
import pageobjects.Home;
import pageobjects.Login;
import pageobjects.Notebook;

/**
 * Tests the ability to Navigate to www.wolframcloud.com,
 * Make a new Notebook,
 * and check the file extension on the new Notebook
 * @author Alex
 *
 */
public class TestSignInAndNotebook {
	
	// The current WebDriver
	private WebDriver driver;
	// The Login Page Object
	private Login login;
	// The Home Page Object
	private Home home;
	// The Cloud App Page Object
	private CloudApp cloudApp;
	// The Notebook Page Object
	private Notebook notebook;
	
	
	
	
	/**
	 * Initializes the WebDriver object
	 */
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
	}
	
	
	
	
	/**
	 * Attempts to access www.wolframcloud.com
	 */
	@Test (priority = 1)
	public void goToWolframCloudDotCom() {
		driver.get("http://www.wolframcloud.com");
	}
	
	/**
	 * Attempts to click the "Wolfram Development Platform" tile
	 */
	@Test (priority = 2) 
	public void clickWdpBtn() {
		home = new Home(driver);
		home.clickWDPTile();
	}
	
	/**
	 * Attempts to sign into the platform
	 */
	@Test (priority = 3)
	public void signIn() {
		login = new Login(driver);
		login.with("cubs2230@gmail.com", "fakePass123Word");
	}
	
	/**
	 * Attempts to make a new Notebook by using the dropdown arrow button,
	 * then clicking "Notebook"
	 */
	@Test(priority=4)
	public void makeNewNotebook() {
		cloudApp = new CloudApp(driver);
		cloudApp.makeNewNotebook();
	}
	
	/**
	 * Verifies that the file extension of the notebook is '.nb'
	 */
	@Test(priority=5)
	public void checkFileFormat() {
		String parentWindowHandle = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}
		notebook = new Notebook(driver);
		assertTrue("File does not show .nb extension", notebook.checkFileExtension(".nb"));
	}
	
	
	
	/**
	 * Quits the driver
	 */
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
