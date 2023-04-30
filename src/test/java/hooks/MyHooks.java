package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {
WebDriver driver;
	
	@Before
	public void setup() {
		Driverfactory.initializeBrowser("chrome");
		driver = Driverfactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
