package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * A Page Object for the Home screen at www.wolframcloud.com
 * @author Alex
 *
 */
public class Home {

	// The page's WebDriver
	private WebDriver driver;
	// A Locator for the Wolfram Development Platform button
	private By wdpBtnLocator = By.cssSelector("#wdp-tile a.product-link");
	
	/**
	 * Constructor
	 * 
	 * Creates a Home page object
	 * @param driver The page's WebDriver
	 */
	public Home(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to("http://www.wolframcloud.com");
	}
	
	/**
	 * Clicks the Wolfram Developer Platform button
	 */
	public void clickWDPTile() {
		driver.switchTo().frame(0);
		driver.findElement(wdpBtnLocator).click();
	}
}
