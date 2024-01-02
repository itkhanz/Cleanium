package com.itkhanz.designpatterns;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
  protected WebDriver driver;

  @BeforeMethod
  public void setupDriver() {
    this.driver = new ChromeDriver();
    this.driver.manage().window().maximize();
  }


  @AfterMethod
  public void quitDriver() {
    Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    if (this.driver != null) {
      this.driver.quit();
    }
  }
}
