package utils;

import java.util.Date;

public class CommonUtils {

	public static String getEmailWithTimeStamp() {
		Date date = new Date();
		return "sureshm"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}
