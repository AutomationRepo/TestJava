import org.openqa.selenium.WebDriver;

import hotel.driver.SeleniumDriver;
import hotel.pages.HomePage;
import hotel.utilty.ReadExcel;

public class MyTest {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//HomePage hm = new HomePage();
		ReadExcel objRS = new ReadExcel();		
		String user = objRS.getCellData("TestCases", "TC_1", "UserName");
		String pwd = objRS.getCellData("TestCases", "TC_1", "Password");
		System.out.println(user);
		//hm.userLogin("foouser02", "test");
		//SeleniumDriver.closeDriver();
	}

	
}
