package hotel.utilty;


import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;


public class Utilities {
	
	
	public static String getPropertyValue(String configFilePath, String key) 
	{
		Properties prop = new Properties();
		try {
			//InputStream ipStream = Utilities.class.getClassLoader().getResourceAsStream(configFilePath);	
			//prop.load(ipStream);
			prop.load(new FileInputStream(configFilePath));
		} catch (Exception e) {
			e.printStackTrace();
		}			
		return prop.getProperty(key);		
	}	

	public static By createSelector(String configFilePath,String key)
	{
		String s;
		
		if(key.endsWith("ID"))
		{
			 s = getPropertyValue(configFilePath,key);
			return By.id(s);
		}
		else if (key.endsWith("NAME")) 
			return By.name(getPropertyValue(configFilePath,key));
		else if (key.endsWith("XPATH")) 
			return By.xpath(getPropertyValue(configFilePath,key));
		else if (key.endsWith("CSS")) 
			return By.cssSelector(getPropertyValue(configFilePath,key));
		else
			return By.linkText(getPropertyValue(configFilePath,key));
	}
}
