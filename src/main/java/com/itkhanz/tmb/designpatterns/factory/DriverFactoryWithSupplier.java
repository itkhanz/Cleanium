package com.itkhanz.tmb.designpatterns.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactoryWithSupplier {
  private DriverFactoryWithSupplier() {}

  private static final Map<String, Supplier<WebDriver>> driverProvider = new HashMap<>();

  /*private static final Supplier<WebDriver> chromeSupplier = () -> {
    return new ChromeDriver();
  };*/

  static {
    //You can also define as supplier separately and then put it in a map if there is a multi line declaration and other things to do
    driverProvider.put("CHROME", ChromeDriver::new);
    driverProvider.put("FIREFOX", FirefoxDriver::new);
    driverProvider.put("EDGE", EdgeDriver::new);
  }

  public static WebDriver getDriver(String browser) {
    return driverProvider.get(browser.toUpperCase()).get();
  }
}
