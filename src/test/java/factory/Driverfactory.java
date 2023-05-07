package factory;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.CommonUtils;
import utils.ConfigReader;

public class Driverfactory {

	static WebDriver driver=null;
	
	public WebDriver initializeBrowser(String BrowserName) throws IOException {
		
		
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
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(CommonUtils.IMPLICI_WAIT_TIME));
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
