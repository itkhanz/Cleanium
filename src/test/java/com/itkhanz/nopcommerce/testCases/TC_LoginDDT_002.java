package com.itkhanz.nopcommerce.testCases;

import com.itkhanz.nopcommerce.pageObjects.LoginPage;
import com.itkhanz.nopcommerce.utilities.XLUtils;
import com.itkhanz.nopcommerce.utils.properties.ConfigService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseTest
{

	@Test(dataProvider="LoginData")
	
	public void loginTest(String user, String pwd) throws InterruptedException{
		
		driver.get(ConfigService.getBaseUrl());
		driver.manage().window().maximize(); 
		
		LoginPage lp = new LoginPage(driver);
				
		lp.setUserName(user);
		logger.info("User provided"); //logger msg
		
		lp.setPassword(pwd);
		logger.info("Password provided");//logger msg
		
		lp.clickLogin();
		logger.info("Login in Clicked");//logger msg
		
		Thread.sleep(2000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			lp.clickLogout();
			Assert.assertTrue(true);
					
		} else {
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}

	}
	
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		
		int rownum= XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j); //1 0
			}
		}
		
		return logindata;
	}
	
	
	
}
