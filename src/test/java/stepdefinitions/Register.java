package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccounSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	WebDriver driver;
	private HomePage homepage; 
	private RegisterPage registerpage;
	private AccounSuccessPage accountsuccesspage; 
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		driver = Driverfactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage = homepage.selectRegisterOption();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	   
		Map<String,String> dataMap = dataTable.asMap(String.class, String.class);
		
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPasssword(dataMap.get("password"));
		registerpage.enterConfirmPasssword(dataMap.get("password"));
	
	}

	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
	   
		Map<String,String> dataMap = dataTable.asMap(String.class, String.class);
		
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enterEmailAddress(dataMap.get("email"));
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPasssword(dataMap.get("password"));
		registerpage.enterConfirmPasssword(dataMap.get("password"));
	}
	
	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
	registerpage.selectPrivacyPolicy();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
	accountsuccesspage = registerpage.clicksContinueButton();
	}

	@Then("User account should created successfully")
	public void user_account_should_created_successfully() {
	   Assert.assertEquals("Your Account Has Been Created!", accountsuccesspage.getPageHeading());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerpage.selectYesNewsLetterOption(); 
	}

	@Then("User should get proper warning message about duplicate email")
	public void user_should_get_proper_warning_message_about_duplicate_email() {
		Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));	
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		registerpage.enterFirstName("");
		registerpage.enterLastName("");
		registerpage.enterEmailAddress("");
		registerpage.enterTelephone("");
		registerpage.enterPasssword("");
		registerpage.enterConfirmPasssword("");
	}

	@Then("User should get proper warning messages for every mandatory fields")
	public void user_should_get_proper_warning_messages_for_every_mandatory_fields() {
		
	   Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
	   Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.getfirstNameWarning());
	   Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getlastNameWarning());
	   Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.getemailWarning());
	   Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.gettelephoneWarning());
	   Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.getpasswordWarning());
	}
	
	private String getEmailWithTimeStamp() {
		Date date = new Date();
		return "sureshm"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}
