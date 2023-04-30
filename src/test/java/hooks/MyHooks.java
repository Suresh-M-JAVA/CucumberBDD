package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class MyHooks {
WebDriver driver;
	
	@Before
	public void setup() throws IOException {
		
		Properties prop = ConfigReader.initializeProperties();
		Driverfactory.initializeBrowser(prop.getProperty("browser"));
		driver = Driverfactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
