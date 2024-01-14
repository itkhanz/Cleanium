package com.itkhanz.tests;

import com.itkhanz.chap03.functionalinterface.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Function;

public class FunctionTest {
  private WebDriver driver;

  @BeforeMethod
  @Parameters("browser")
  public void setDriver(@Optional("chrome") String browser){
    this.driver = DriverFactory.getDriver(browser.toLowerCase());
  }

  @Test
  public void printElementsTextTest(){
    driver.get("https://the-internet.herokuapp.com/");

    List<WebElement> allLinks = driver.findElements(By.tagName("a"));
    Function<WebElement, String> getElementText = WebElement::getText;

    for (WebElement element: allLinks) {
      System.out.println(getElementText.apply(element));
    }
  }



  @AfterMethod
  public void quitDriver(){
    this.driver.quit();
  }
}
