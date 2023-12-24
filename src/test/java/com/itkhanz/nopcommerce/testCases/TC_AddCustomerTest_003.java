package com.itkhanz.nopcommerce.testCases;

import com.itkhanz.nopcommerce.pageObjects.AddcustomerPage;
import com.itkhanz.nopcommerce.pageObjects.LoginPage;
import com.itkhanz.nopcommerce.utils.properties.ConfigService;
import com.itkhanz.nopcommerce.utils.random.RandomService;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomerTest_003 extends BaseTest
{
	
	@Test
	public void addNewCustomer() throws IOException, InterruptedException
	{
		driver.get(ConfigService.getBaseUrl());

		LoginPage lp=new LoginPage(driver);
		lp.setUserName(ConfigService.getUserEmail());
		logger.info("User name is provided");
		
		lp.setPassword(ConfigService.getPassword());
		logger.info("password is provided");
		
		lp.clickLogin();
				
		logger.info("providing customer details....");
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		Thread.sleep(3000);
		
		addcust.clickOnAddnew();
				
		String email= RandomService.getRandomEmail();
		
		logger.info("Providing email");
		addcust.setEmail(email);
		
		logger.info("Providing password");
		addcust.setPassword("test123");
		
		logger.info("Providing Customer roles");
		addcust.setCustomerRoles("Guest");
		//addcust.setCustomerRoles("Administrators");
		
		logger.info("Selecting vendor");
		addcust.setManagerOfVendor("Vendor 2");
		
		logger.info("Selecting gender");
		addcust.setGender("Male");
		
		logger.info("Providing first name and last name");
		addcust.setFirstName("Pavan");
		addcust.setLastName("Kumar");
		
		logger.info("Providing dob");
		addcust.setDob("7/05/1985"); // Format: D/MM/YYY
		
		logger.info("Providing company name and admin content");
		addcust.setCompanyName("busyQA");
		addcust.setAdminContent("This is for testing.........");
	
		logger.info("clicking on save");
		addcust.clickOnSave();
		
		logger.info("validation started....");
		
		String actualMsg=driver.findElement(By.tagName("body")).getText();

		Assert.assertEquals(actualMsg, "The new customer has been added successfully");
		logger.info("test case passed....");

	}
	
	

}
