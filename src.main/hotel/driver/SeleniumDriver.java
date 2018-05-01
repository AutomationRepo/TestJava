/**
 * 
 */
package hotel.driver;

import java.io.File;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import hotel.utilty.Utilities;
//import hotel.logging.Log;

/**
 * @author Shweta
 *
 * Creates webdriver object 
 */
public class SeleniumDriver {
	
	
	private static WebDriver _driver = null;
	private static final String chromeExePath = "chromedriver.exe";
	private static final String ieExePath = "lib\\MicrosoftWebDriver.exe";
	private static final String browserName = Utilities.getPropertyValue("config.properties", "BROWSER");		
	
	public SeleniumDriver(){
		
		
	}
	
	public static WebDriver get_driver()
	{
		
		if(_driver == null)
		{
			switch (browserName.toLowerCase())
			{	
				case "chrome" :
					System.setProperty("webdriver.chrome.driver", new File(chromeExePath).getAbsolutePath());
					_driver = new ChromeDriver();
					break;
				case "ie" :
					System.setProperty("webdriver.ie.driver", new File(ieExePath).getAbsolutePath());
					_driver = new InternetExplorerDriver();
					break;
				default:
					_driver = new FirefoxDriver();					
			}			
		}	
		_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		_driver.manage().window().maximize();		
		return _driver;
	}
	
	public static void closeDriver()
	{
		_driver.quit();
	}

}
