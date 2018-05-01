package hotel.pages;


import org.openqa.selenium.By;


import hotel.driver.Page;

import hotel.utilty.Utilities;

public class SearchHotelPage extends Page{
	
	
	By profileName = Utilities.createSelector("objects.properties", "EDT_LOGGEDINUSER_CSS");
	By location = Utilities.createSelector("objects.properties", "EDT_LOCATION_CSS");
	By hotels = Utilities.createSelector("objects.properties", "EDT_HOTEL_ID");
	By roomType = Utilities.createSelector("objects.properties", "EDT_ROOMTYPES_NAME");
	By noOfRooms = Utilities.createSelector("objects.properties", "EDT_NOOFROOMS_NAME");
	By checkInDate = Utilities.createSelector("objects.properties", "EDT_CHECKINDATE_ID");
	By checkOutDate = Utilities.createSelector("objects.properties", "EDT_CHECKOUTDATE_ID");
	By AdultsPerRoom = Utilities.createSelector("objects.properties", "EDT_ADULTS_CSS");
	By childrenPerRoom = Utilities.createSelector("objects.properties", "EDT_CHILDREN_ID");
	By search = Utilities.createSelector("objects.properties", "BTN_SEARCH_NAME");
	By reset = Utilities.createSelector("objects.properties", "BTN_RESET_ID");
	
	public String getProfileName()
	{
		return getValue(profileName);
	}	
	
	public void searchHotel(String[] data)
	{
		selectFromDropdown(location, data[0]);
		selectFromDropdown(hotels, data[1]);
		selectFromDropdown(roomType, data[2]);
		selectFromDropdown(noOfRooms, data[3]);
		enterTextbox(checkInDate, data[4]);
		enterTextbox(checkOutDate, data[5]);
		selectFromDropdown(AdultsPerRoom, data[6]);
		selectFromDropdown(childrenPerRoom, data[7]);	
		clickButton(search);
	}
	
	
	public void laterCheckInDate(String[] data)
	{
		selectFromDropdown(location, data[0]);
		selectFromDropdown(hotels, data[1]);
		selectFromDropdown(roomType, data[2]);
		selectFromDropdown(noOfRooms, data[3]);
		enterTextbox(checkInDate, data[4]);
		enterTextbox(checkOutDate, data[5]);	
		clickButton(search);
	}
	
	/*
	private void selectFromDropDown(By locator, String selection)
	{
		WebElement Dropdown = this._driver.findElement(locator);
		Select  location = new Select(Dropdown);
		location.selectByValue(selection);
	}
	
	private void selectLocation(String strLoc)
	{
		WebElement locDropdown = this._driver.findElement(location);
		Select location = new Select(locDropdown);
		location.selectByValue(strLoc);
	}
	
	private void selectHotel(String strHotel)
	{
		WebElement hotelDropdown = this._driver.findElement(hotels);
		Select hotel = new Select(hotelDropdown);
		hotel.selectByValue(strHotel);
	}
	
	private void selectRoomType(String strRoomType)
	{
		WebElement roomTypeDropdown = this._driver.findElement(roomType);
		Select roomType = new Select(roomTypeDropdown);
		roomType.selectByValue(strRoomType);
	}
	
	private void selectNoOfRooms(String strNoOfRooms)
	{
		WebElement noOfRoomsDropdown = this._driver.findElement(noOfRooms);
		Select noOfRooms = new Select(noOfRoomsDropdown);
		noOfRooms.selectByValue(strNoOfRooms);
	}
	
	private void enterCheckInDate(String chekInDate)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		//Calendar cal = Calendar.getInstance();
		//cal.add(Calendar.DATE, 7); cal.getTime();
		this._driver.findElement(checkInDate).sendKeys(dateFormat.format(chekInDate));		
	}
	
	private void enterCheckOutDate(String chekOutDate)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		//Calendar cal = Calendar.getInstance();
		//cal.add(Calendar.DATE, 5);
		this._driver.findElement(checkOutDate).sendKeys(dateFormat.format(chekOutDate));		
	}
	
	private void selectAdults(String strAdults)
	{
		WebElement adultsDropdown = this._driver.findElement(AdultsPerRoom);
		Select adults = new Select(adultsDropdown);
		adults.selectByVisibleText(strAdults);;
	}
	
	private void selectChildren(String strChilds)
	{
		WebElement childrenDropdown = this._driver.findElement(childrenPerRoom);
		Select children = new Select(childrenDropdown);
		children.selectByVisibleText(strChilds);
	}
	
	private void clickSearch()
	{
		this._driver.findElement(search).click();
	}
	
	private void clickReset()
	{
		this._driver.findElement(reset).click();
	}
	
	public void searchHotel(searchHotel objSH)
	{		
		this.selectLocation(objSH.getLocation());
		this.selectHotel(objSH.getHotel());
		this.selectRoomType(objSH.getRoomType());
		this.selectNoOfRooms(objSH.getNoOfRooms());
		this.enterCheckInDate(objSH.getCheckInDate());
		this.enterCheckOutDate(objSH.getCheckOutDate());
		this.selectAdults(objSH.getAdults());
		this.selectChildren(objSH.getChildren());
		this.clickSearch();
	}

	public void laterCheckInDate(searchHotel objSH)
	{
		this.selectLocation(objSH.getLocation());
		this.selectHotel(objSH.getHotel());
		this.selectRoomType(objSH.getRoomType());
		this.selectNoOfRooms(objSH.getNoOfRooms());
		this.enterCheckInDate(objSH.getCheckInDate());
		this.enterCheckOutDate(objSH.getCheckOutDate());
		this.clickSearch();
	}
	*/
}
