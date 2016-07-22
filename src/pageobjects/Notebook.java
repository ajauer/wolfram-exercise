package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * A Page Object for a user's Notebook page
 * @author Alex
 *
 */
public class Notebook {

	// The page's WebDriver
	private WebDriver driver;
	// A Locator for the Notebook Name
	private By notebookNameLocator = By.xpath("//div[contains(@class, 'rename-title button-image button-end')]");
	// A Locator for the Toolbar Rename Input Field
	private By toolbarRenameInputFieldLocator = By.id("toolbarRenameInputField");
	
	/**
	 * Constructor
	 * 
	 * Creates a Page Object for the user's Notebook page.
	 * @param driver The WebDriver object that holds the current page
	 */
	public Notebook(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Checks the file format of the Notebook to see that it is a certain, user-specified extension
	 * @param expectedExtension The desired file extension
	 * @return True is the extension matches, otherwise False
	 */
	public boolean checkFileExtension(String expectedExtension) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(notebookNameLocator));
		
		driver.findElement(notebookNameLocator).click();
		element = driver.findElement(toolbarRenameInputFieldLocator);
		return element.getAttribute("value").equals(".nb");
	}
}
