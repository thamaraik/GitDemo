package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
By email= By.xpath("//input[@id='user_email']");
By pw=By.xpath("//input[@id='user_password']");
By submit=By.xpath("//input[@value='Log In']");

public WebElement getUsername()
{
return driver.findElement(email);
}

public WebElement getPassword()
{
return driver.findElement(pw);
}

public WebElement getSubmit()
{
return driver.findElement(submit);
}

}