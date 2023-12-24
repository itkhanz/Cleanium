package com.itkhanz.nopcommerce.testCases;

import com.itkhanz.nopcommerce.pageObjects.LoginPage;
import com.itkhanz.nopcommerce.utils.properties.ConfigService;
import com.itkhanz.core.utils.screenshot.ScreenshotService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

	public class TC_LoginTest_001 extends BaseTest
	{

	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(ConfigService.getBaseUrl());
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(ConfigService.getUserEmail());
		logger.info("User provided......"); //logger msg
		
		lp.setPassword(ConfigService.getPassword());
		logger.info("Password provided......");//logger msg
		
		
		lp.clickLogin();
		logger.info("Login in Clicked......");//logger msg
		
		//verification
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Thread.sleep(5000);
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login Passed.....");//logger msg
		}
		else
		{
			ScreenshotService.getScreenShotAsBase64();
			Assert.assertTrue(false);
			logger.info("Login Failed.....");//logger msg
		}
	}
	
	
}


