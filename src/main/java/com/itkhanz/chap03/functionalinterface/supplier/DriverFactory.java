package com.itkhanz.chap03.functionalinterface.supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/*
Refer to DriverTest to see the example usage of DriverFactory
 */
public class DriverFactory {
  private static final Supplier<WebDriver> chromeSupplier = () -> {
    return new ChromeDriver();
  };

  private static final Supplier<WebDriver> firefoxSupplier = () -> {
    return new FirefoxDriver();
  };

  /*private static final Map<String, Supplier<WebDriver>> DRIVER_MAP = new HashMap<>();

  static {
    DRIVER_MAP.put("chrome", chromeSupplier);
    DRIVER_MAP.put("firefox", firefoxSupplier);
  }*/

  //Java 09 Immutable map
  private static final Map<String, Supplier<WebDriver>> DRIVER_MAP = Map.ofEntries(
    Map.entry("chrome", chromeSupplier),
    Map.entry("firefox", firefoxSupplier)
  );


  public static WebDriver getDriver(String browser){
    return DRIVER_MAP.get(browser).get();
  }
}
