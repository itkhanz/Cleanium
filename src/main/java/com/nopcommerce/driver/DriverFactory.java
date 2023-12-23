package com.nopcommerce.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
  private DriverFactory() {}

  public static WebDriver getDriver(String browser) {
    WebDriver driver;
    switch (browser.toUpperCase()) {
      case "EDGE" -> driver = new EdgeDriver();
      case "CHROME" -> driver = new ChromeDriver();
      case "FIREFOX" -> driver = new FirefoxDriver();
      default -> throw new RuntimeException(String.format("Invalid Browser %s provided", browser));
    }
    return driver;
  }
}
