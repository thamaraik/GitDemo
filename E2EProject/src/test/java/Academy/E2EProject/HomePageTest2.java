package Academy.E2EProject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePageTest2 extends base {
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializedriver();
	
	}
	
	
	@Test(dataProvider="getLoginDetail")
//count of the arguement should be equal to column count
	public void landingHomepage(String Uname, String pw) throws IOException
	{
		 driver.get(prop.getProperty("url"));
	 //create an object to that class to invoke methods in it or we can use inheritance also
	 LandingPage log = new LandingPage(driver);
	 log.getLogin().click();
	 LoginPage sign = new LoginPage(driver);
	 sign.getUsername().sendKeys(Uname);
	 sign.getPassword().sendKeys(pw);
	 sign.getSubmit().click();
	 
	 	 
	}
	@AfterTest
	public void quit()
	{
		driver.quit();
		driver=null;
	}
	@DataProvider
	public Object[][] getLoginDetail()
	{
		//1.1 set username and password= sales manager
		//2.1 set username and paswword=admin
		//3.1 set of username and pasword= marketing manager
		//row stands for how many different set of data shuould run(3 users)
		//column stands for how many values needed for each set of data(2 values=username and password)
		Object[][] data = new Object[3][2];//3 means 3 set of users 2 means 2 kind of values
		data[0][0] ="abc@gmail.com";
		data[0][1]= "1234";
		//firstset
		data[1][0] ="def@gmail.com";
		data[1][1]= "4586";
		//second set
		data[2][0] ="ghi@gmail.com";
		data[2][1]= "5896"; 
		//third set
		return data;
	}

}
