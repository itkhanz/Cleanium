package com.nopcommerce.testCases;

import com.nopcommerce.config.PropertyFileReaderImpl;
import com.nopcommerce.driver.DriverFactory;
import com.nopcommerce.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {

	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(BaseTest.class);


	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUseremail();
	public String password=readconfig.getPassword();

	@BeforeMethod
	@Parameters("browser")
	public void setupDriver(String browser) {
		//TODO create a threadsafe DriverManager and use it to get driver
		driver = DriverFactory.getDriver(browser);

		System.out.println(new PropertyFileReaderImpl().getConfiguration().getUseremail());
	}

	@AfterMethod(alwaysRun = true)
	void tearDownDriver() {
		if (driver!=null) {
			driver.quit();
		}
	}
}
