package com.itkhanz.demos.part09;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class DriverFactory {
  private DriverFactory() {}

  public static WebDriver getDriver(Browser browser) {
    WebDriver driver;
    switch (browser) {
      case EDGE -> driver = new EdgeDriver();
      case CHROME -> driver = new ChromeDriver();
      case FIREFOX -> driver = new FirefoxDriver();
      default -> throw new RuntimeException(String.format("Invalid Browser %s provided", browser.name()));
    }
    return driver;
  }
}
