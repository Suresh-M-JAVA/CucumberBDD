package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ConfigReader {

	public Properties initializeProperties() throws IOException {
		
		Properties prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		return prop;
	}
}
