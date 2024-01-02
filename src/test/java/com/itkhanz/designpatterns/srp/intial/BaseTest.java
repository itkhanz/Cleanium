package com.itkhanz.designpatterns.srp.intial;

import com.itkhanz.designpatterns.srp.initial.base.BrowserType;
import com.itkhanz.designpatterns.srp.initial.base.DriverFactory;
import com.itkhanz.designpatterns.srp.initial.base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

class BaseTest {
  protected static WebDriver driver;

  @BeforeMethod
  public void setup() {
    DriverFactory.initDriver(BrowserType.CHROME);
    driver = DriverManager.getDriver();
    driver.manage().window().maximize();
  }

  @AfterMethod(alwaysRun = true)
  public void teardown() {
    DriverManager.terminateDriver();
  }
}
