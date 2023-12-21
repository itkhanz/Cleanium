package com.itkhanz.demos.part09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SupplierDemoLazyEvaluation {
  WebDriver driver;

  @Test
  public void wait_with_custom_error() {
    //driver = DriverFactory.getDriver(Browser.CHROME);
    driver = DriverFactoryWithSupplier.getDriver(Browser.CHROME);

    driver.get("https://the-internet.herokuapp.com/");


    //withMessage() accepts a supplier that will only be evaluated if the wait conditions fails -> lazy initialization

    new WebDriverWait(driver, Duration.ofSeconds(5))
      .withMessage(() -> "Failed to find the element to be clickable within 05 seconds")
      .until(ExpectedConditions.elementToBeClickable(By.linkText("Checkboxes")))
      .click();

  }

  @AfterTest
  private void teardown() {
    if (driver!= null) {
      driver.quit();
    }
  }
}
