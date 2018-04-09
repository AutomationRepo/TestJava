package hotel.driver;

import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public abstract class Page {
	
	protected void selectFromDropdown(By locator,String item) 
	{
		WebElement Dropdown = SeleniumDriver.get_driver().findElement(locator);
		Select  target = new Select(Dropdown);
		target.selectByValue(item);	
		
	}
	
	protected String getValue(By locator) 
	{
		return SeleniumDriver.get_driver().findElement(locator).getAttribute("value");
		
	}
	
	protected void clickButton(By locator) 
	{
		SeleniumDriver.get_driver().findElement(locator).click();
		
	}
	protected void enterTextbox(By locator,String value) 
	{
		SeleniumDriver.get_driver().findElement(locator).sendKeys(value);
		
	}
	
	protected void navigate(String url)
	{
		SeleniumDriver.get_driver().get(url);		
	}
	
	protected void getPageTitle() 
	{
		throw new NotImplementedException("Method not implemented yet");
	}
	
	protected void getCurrentUrl() 
	{
		throw new NotImplementedException("Method not implemented yet");
	}
	
	protected void closeBrowser()
	{
		SeleniumDriver.closeDriver();
		
	}


}
