package hotel.pages;

import org.openqa.selenium.By;
import hotel.driver.Page;

import hotel.utilty.Utilities;

public class HomePage extends Page{
	
	
	private static final String URL = Utilities.getPropertyValue("config\\config.properties", "BASEURL");	
	
	By username = Utilities.createSelector("config\\objects.properties", "EDT_USERNAME_ID");
	By password = Utilities.createSelector("config\\objects.properties", "EDT_PASSWORD_ID");
	By login = Utilities.createSelector("config\\objects.properties", "BTN_LOGIN_ID");
	
	public void navigateToPage(String url)
	{
		navigate(url);
	}
	
	public void userLogin(String user,String pwd)
	{
		navigateToPage(URL);
		enterTextbox(username, user);
		enterTextbox(password, pwd);
		clickButton(login);
		
	}
	
	public void close()
	{
		closeBrowser();
	}
	
}
