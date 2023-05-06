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
private ConfigReader ConfigReader;
private Driverfactory Driverfactory; 
	
	@Before
	public void setup() throws IOException {
		ConfigReader = new ConfigReader();
		Properties prop = ConfigReader.initializeProperties();
		Driverfactory = new Driverfactory();
		driver = Driverfactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
