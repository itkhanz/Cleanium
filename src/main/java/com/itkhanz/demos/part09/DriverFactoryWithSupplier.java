package com.itkhanz.demos.part09;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

class DriverFactoryWithSupplier {
  private DriverFactoryWithSupplier() {}

  private static final Map<Browser, Supplier<WebDriver>> driverProvider = new EnumMap<>(Browser.class);

  static {
    //You can also define as supplier separately and then put it in a map if there is a multi line declaration and other things to do
    driverProvider.put(Browser.CHROME, ChromeDriver::new);
    driverProvider.put(Browser.FIREFOX, FirefoxDriver::new);
    driverProvider.put(Browser.EDGE, EdgeDriver::new);
  }

  public static WebDriver getDriver(Browser browser) {
    return driverProvider.get(browser).get();
  }

}
