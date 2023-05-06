package factory;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.ConfigReader;

public class Driverfactory {

	static WebDriver driver=null;
	
	public static WebDriver initializeBrowser(String BrowserName) throws IOException {
		
		
		if(BrowserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BrowserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BrowserName.equals("edge")) {
			driver = new EdgeDriver();
		}else if(BrowserName.equals("safari")) {
			driver = new SafariDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
