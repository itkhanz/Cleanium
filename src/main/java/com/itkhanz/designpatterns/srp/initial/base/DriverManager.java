package com.itkhanz.designpatterns.srp.initial.base;

import org.openqa.selenium.WebDriver;

public class DriverManager {
  private DriverManager() {}

  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  static void setDriver(WebDriver dr) {
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
