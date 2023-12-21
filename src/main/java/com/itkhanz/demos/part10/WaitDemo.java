package com.itkhanz.demos.part10;

import com.itkhanz.demos.part09.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WaitDemo {

  @BeforeTest
  private void setup() {
    DriverFactory.initializeDriver(Browser.CHROME);
    DriverManager.getDriver().get("https://the-internet.herokuapp.com/");
  }

  @AfterTest
  private void teardown() {
    DriverManager.terminateDriver();
  }

  @Test
  public void test_for_wait() {
    WebElement checkBox = WaitFactory.performExplicitWait(WaitStrategy.VISIBLE, WaitDuration.WAIT_SHORT, By.linkText("Checkboxes"));
    checkBox.click();
  }
}
