package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {

	WebDriver driver;
	HomePage homepage;
	SearchResultsPage searchresultspage;
	
	@Given("User opens the Application")
	public void user_opens_the_application() {
	    driver = Driverfactory.getDriver();
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {
		homepage = new HomePage(driver);
	 homepage.enterProductintoSearchBox(validProductText);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
	 homepage.clickOnSearchButton();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		searchresultspage = new SearchResultsPage(driver);
	    Assert.assertTrue(searchresultspage.displayStatusOfValidProduct());
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
		homepage = new HomePage(driver);
		homepage.enterProductintoSearchBox(invalidProductText);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		searchresultspage = new SearchResultsPage(driver);
	  Assert.assertEquals("There is no product that matches the search criteria.", searchresultspage.getInValidProductMessage());
	}

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		homepage = new HomePage(driver);
		homepage.enterProductintoSearchBox("");
	}
}
