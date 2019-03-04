package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializedriver() throws IOException
	{
		prop= new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\mahi\\eclipselearning\\E2EProject\\src\\main\\java\\Resources\\driverdata.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			//execute in chrome
			System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//execute in firefox
			System.setProperty("webdriver.gecko.driver","C:\\Gecko\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			//execute in IE
			System.setProperty("webdriver.ie.driver","C:\\work\\MicrosoftWebDriver.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
		
	}
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\mahi\\test"+ result+"screenshot.png"));
		
	}

}
