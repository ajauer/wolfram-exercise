package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * A Page Object for the Cloud App page
 * @author Alex
 *
 */
public class CloudApp {

	// The page's WebDriver
	private WebDriver driver;
	// A Locator for the Dropdown Menu Button
	private By dropdownMenuBtnLocator = By.cssSelector(".newNotebookBtn-dropdown");
	// A Locator for the New Notebook Button
	private By newNotebookBtnLocator = By.id("nb");
	
	/**
	 * Constructor
	 * 
	 * Creates a Page Object for the Cloud App landing page
	 * @param driver The page's WebDriver
	 */
	public CloudApp (WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Creates a new Notebook by clicking the Dropdown arrow, then clicking the New Notebook Button
	 */
	public void makeNewNotebook() {
		driver.findElement(dropdownMenuBtnLocator).click();
		driver.findElement(newNotebookBtnLocator).click();
	}
}
