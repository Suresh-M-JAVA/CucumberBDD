package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmpasswordField;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value=1]")
	private WebElement yesNewsLetterOption;
	
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")
	private WebElement warningMessage;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNamewarning;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNamewarning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailwarning;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephonewarning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordwarning;
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		lastNameField.sendKeys(emailText);
	}
	
	public void enterTelephone(String telephoneText) {
		lastNameField.sendKeys(telephoneText);
	}
	
	public void enterPasssword(String passwordText) {
		lastNameField.sendKeys(passwordText);
	}
	
	public void enterConfirmPasssword(String confirmpasswordText) {
		lastNameField.sendKeys(confirmpasswordText);
	}
	
	public void selectPrivacyPolicy() {
		privacyPolicyOption.click();
	}
	
	public void clicksContinueButton() {
		continueButton.click();
	}
	
	public void selectYesNewsLetterOption() {
		yesNewsLetterOption.click();
	}
	
	public String getWarningMessageText() {
		return warningMessage.getText();
	}
	
	public String getfirstNameWarning() {
		return firstNamewarning.getText();
	}
	
	public String getlastNameWarning() {
		return lastNamewarning.getText();
	}
	
	public String getemailWarning() {
		return emailwarning.getText();
	}
	
	public String gettelephoneWarning() {
		return telephonewarning.getText();
	}
	
	public String getpasswordWarning() {
		return passwordwarning.getText();
	}
}
