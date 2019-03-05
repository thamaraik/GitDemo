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

public class ValidateTitle2 extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializedriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}

	@Test()

	public void featuredcourses() throws IOException {
		
	// create an object to that class to invoke methods in it or we can use
		// inheritance also
		LandingPage l = new LandingPage(driver);

		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text present");
		

	}

	@AfterTest
	public void close()
	{
		driver.close();
		driver=null;
	}

}
