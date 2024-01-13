package com.itkhanz.tests;

import com.itkhanz.chap03.functionalinterface.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SupplierTest {
  private WebDriver driver;

  @BeforeTest
  @Parameters("browser")
  public void setDriver(@Optional("chrome") String browser){
    this.driver = DriverFactory.getDriver(browser.toLowerCase());
  }

  @Test
  public void googleTest(){
    this.driver.get("https://the-internet.herokuapp.com/");
    Assert.assertEquals(this.driver.getTitle(), "The Internet");
  }

  @AfterTest
  public void quitDriver(){
    this.driver.quit();
  }
}
