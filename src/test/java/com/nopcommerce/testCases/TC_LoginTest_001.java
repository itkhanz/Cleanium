package com.nopcommerce.testCases;

import java.io.IOException;

import com.nopcommerce.utils.properties.ConfigService;
import com.nopcommerce.utils.screenshot.ScreenshotService;
import com.nopcommerce.utils.screenshot.ScreenshotUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

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


