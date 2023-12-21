package com.itkhanz.demos.part10;

import com.itkhanz.demos.part09.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class DriverFactory {
  private DriverFactory() {}

  public static void initializeDriver(Browser browser) {
    if (DriverManager.getDriver()== null) {
      WebDriver driver;
      switch (browser) {
        case EDGE -> driver = new EdgeDriver();
        case CHROME -> driver = new ChromeDriver();
        case FIREFOX -> driver = new FirefoxDriver();
        default -> throw new RuntimeException(String.format("Invalid Browser %s provided", browser.name()));
      }
      DriverManager.setDriver(driver);
    }
  }
}
