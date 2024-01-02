package com.itkhanz.designpatterns.srp;

import com.itkhanz.designpatterns.srp.base.BrowserType;
import com.itkhanz.designpatterns.srp.base.DriverFactory;
import com.itkhanz.designpatterns.srp.base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
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
