package com.itkhanz.nopcommerce.tests;

import com.itkhanz.core.browser.BrowserManager;
import com.itkhanz.core.driver.DriverFactory;
import com.itkhanz.core.driver.DriverManager;
import com.itkhanz.core.interactions.Interactions;
import com.itkhanz.nopcommerce.utils.properties.ConfigService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(BaseTest.class);

	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) {
		//TODO Add the capability to pass the browser via terminal
		DriverFactory.initDriver(BrowserManager.getMatchingBrowser(browser));
		driver = DriverManager.getDriver();
		Interactions.navigation().loadUrl(ConfigService.getBaseUrl());
		Interactions.windows().maximize();
	}

	@AfterMethod(alwaysRun = true)
	void tearDown() {
		DriverManager.terminateDriver();
	}
}
