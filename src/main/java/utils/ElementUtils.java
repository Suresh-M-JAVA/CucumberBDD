package utils;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnElement(WebElement element, long durationInSeconds) {
		WebElement we = waitForElement(element, durationInSeconds);
		we.click();
	}
	
	public void typeTextIntoElement(WebElement element,String textToBeTyped, long durationInSeconds) {
		WebElement we = waitForElement(element, durationInSeconds); 
		we.click();
		we.clear();
		we.sendKeys(textToBeTyped);
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		
		WebElement we=null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			we = wait.until(ExpectedConditions.elementToBeClickable(element));	
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return we;
	}
	
	public void selectOptionInDropdown(WebElement element,String dropDownOption, long durationInSeconds) {
		WebElement we = waitForElement(element, durationInSeconds); 
		Select select = new Select(element);
		select.selectByVisibleText(dropDownOption);
	}
	
	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
		}
	
	public Alert waitForAlert(long durationInSeconds) {
		Alert alert=null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public WebElement waitForVisibilityOfWebElement(WebElement element, long durationInSeconds) {
		WebElement we=null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			we = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return we;
	}
	
	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		WebElement we = waitForVisibilityOfWebElement(element, durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(we).click().build().perform();
	}
	
	public void javaScriptClick(WebElement element, long durationInSeconds) {
		WebElement we = waitForVisibilityOfWebElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", we);
	}
	
	public void javaScriptType(WebElement element,String textToBeTyped, long durationInSeconds) {
		WebElement we = waitForVisibilityOfWebElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeTyped+"'", we);
	}
	
	public String getTextFromElement(WebElement element, long durationInSeconds) {
		WebElement we = waitForElement(element, durationInSeconds);
		return we.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
		try {
		WebElement we = waitForVisibilityOfWebElement(element, durationInSeconds);
		return we.isDisplayed();
		}catch(Throwable e) {
			return false;
		}
	}
	
}
