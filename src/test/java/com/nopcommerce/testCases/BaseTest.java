package com.nopcommerce.testCases;

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
	public void setupDriver(String browser)
	{
		driver = DriverFactory.getDriver(browser);
	}
	
	@AfterMethod
	void tearDownDriver()
	{
		if (driver!=null) {
			driver.quit();
		}
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
}
