package com.itkhanz.tests.assignment;

import com.google.common.util.concurrent.Uninterruptibles;
import com.itkhanz.chap03.functionalinterface.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class HoverableDropdownTest {
  private WebDriver driver;
  private Actions actions;

  @BeforeMethod
  @Parameters("browser")
  public void setDriver(@Optional("chrome") String browser){
    this.driver = DriverFactory.getDriver(browser.toLowerCase());
    this.actions = new Actions(driver);
  }

  @AfterMethod
  public void quitDriver(){
    this.driver.quit();
  }

  @Test(dataProvider = "linkProvider")
  public void hover_multi_dropdown_test(String links) {
    driver.get("https://vins-udemy.s3.amazonaws.com/java/html/drop-down.html");

    Arrays.stream(links.split(" => "))
      .map(String::trim)
      .map(By::linkText)
      .map(by -> driver.findElement(by))
      .map(element -> actions.moveToElement(element))
      .forEach(Actions::perform);

    Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
  }

  @DataProvider(name = "linkProvider")
  public Object[] dropdownLinks(){
    return new Object[] {
      "Dropdown => Dropdown Link 2",
      "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.1",
      "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.4 => Dropdown Submenu Link 5.4.2",
    };
  }


}
