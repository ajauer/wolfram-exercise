/**
 * 
 */
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * A Page Object class for the Login page
 * 
 * @author Alex
 *
 */
public class Login {
	
	// The page's WebDriver
	private WebDriver driver;
	// A Locator for the Email field
	private By emailLocator = By.id("email");
	// A Locator for the Password field
	private By passwordLocator = By.id("password");
	// A Locator for the Sign In Button
	private By signInBtnLocator = By.id("signIn");
	
	/**
	 * Constructor
	 * 
	 * Creates a Page Object for the Login page
	 * @param driver The page's WebDriver
	 */
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Logs into the app with user-specified credentials 
	 * @param email		User's email address
	 * @param password	User's password
	 */
	public void with(String email, String password) {
		driver.findElement(emailLocator).sendKeys(email);
		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(signInBtnLocator).submit();
	}

}
