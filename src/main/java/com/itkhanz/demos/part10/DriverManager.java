package com.itkhanz.demos.part10;

import com.itkhanz.demos.part09.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class DriverManager {
  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  public static void setDriver(WebDriver dr) {
    driver.set(dr);
  }

  public static WebDriver getDriver() {
    return driver.get();
  }

  public static void terminateDriver() {
    if (getDriver() != null) {
      getDriver().quit();
      driver.remove();
    }
  }

}
