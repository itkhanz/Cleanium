package com.itkhanz.core.driver;

import com.itkhanz.core.browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
  private DriverFactory() {}

  public static void initDriver(Browser browser) {
    WebDriver driver;
    switch (browser) {
      case EDGE -> driver = new EdgeDriver();
      case CHROME -> driver = new ChromeDriver();
      case FIREFOX -> driver = new FirefoxDriver();
      case SAFARI -> driver = new SafariDriver();
      default -> throw new RuntimeException(String.format("Invalid Browser %s provided", browser));
    }
    DriverManager.setDriver(driver);
  }
}
