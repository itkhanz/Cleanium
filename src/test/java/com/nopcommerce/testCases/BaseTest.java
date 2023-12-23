package com.nopcommerce.testCases;

import com.nopcommerce.config.reader.PropertyReaderImpl;
import com.nopcommerce.driver.DriverFactory;
import com.nopcommerce.utilities.ReadConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

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

		System.out.println(new PropertyReaderImpl().getConfiguration().getUseremail());
	}

	@AfterMethod(alwaysRun = true)
	void tearDownDriver() {
		if (driver!=null) {
			driver.quit();
		}
	}
}
