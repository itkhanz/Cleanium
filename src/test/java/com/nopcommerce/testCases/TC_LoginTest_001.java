package com.nopcommerce.testCases;

import java.io.IOException;

import com.nopcommerce.utils.ScreenshotUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

	public class TC_LoginTest_001 extends BaseTest
	{

	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User provided......"); //logger msg
		
		lp.setPassword(password);
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
			ScreenshotUtils.captureScreenshotAsPNG("loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed.....");//logger msg
		}
	}
	
	
}


