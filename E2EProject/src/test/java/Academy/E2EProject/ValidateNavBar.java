package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;

public class ValidateNavBar extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializedriver();
		driver.get(prop.getProperty("url"));
	}
	@Test()

	public void navigationbar() throws IOException {
		
		LandingPage l = new LandingPage(driver);
		
		Assert.assertTrue(l.getNavigationbar().isDisplayed());
	
	log.info("Navigation bar is displayed");
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
		driver=null;
	}

}
