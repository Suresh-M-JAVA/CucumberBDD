package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driverfactory {

	static WebDriver driver=null;
	
	public static WebDriver initializeBrowser(String BrowserName) {
		
		if(BrowserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BrowserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BrowserName.equals("edge")) {
			driver = new EdgeDriver();
		}else if(BrowserName.equals("safari")) {
			driver = new SafariDriver();
		}
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
