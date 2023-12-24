package com.nopcommerce.testCases;

import com.nopcommerce.driver.DriverFactory;
import com.nopcommerce.driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(BaseTest.class);

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		DriverFactory.initDriver(browser);
		driver = DriverManager.getDriver();
	}

	@AfterMethod(alwaysRun = true)
	void tearDown() {
		DriverManager.terminateDriver();
	}
}
