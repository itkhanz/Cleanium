package com.itkhanz.tests.factory;

import com.itkhanz.tmb.designpatterns.factory.DriverFactoryWithSupplier;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DriverFactoryTest {
  @Test
  public void test_driver_factory() {
    //Approach 01 using conditional
    //WebDriver driver = DriverFactory.getDriver("chrome");

    //Approach 02 using Supplier Interface
    WebDriver driver = DriverFactoryWithSupplier.getDriver("chrome");
    driver.get("https://the-internet.herokuapp.com/");

    driver.quit();
  }
}
