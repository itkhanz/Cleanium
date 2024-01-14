package com.itkhanz.tests;

import com.itkhanz.chap03.functionalinterface.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.function.Predicate;

public class LinksTest {
  private WebDriver driver;

  @BeforeMethod
  @Parameters("browser")
  public void setDriver(@Optional("chrome") String browser){
    this.driver = DriverFactory.getDriver(browser.toLowerCase());
  }

  @AfterMethod
  public void quitDriver(){
    this.driver.quit();
  }

  /*
  do not allow blank links
  do not allow links containing letter D
  convert link text to upper case
  print on the console
   */
  @Test
  public void filterLinksTest(){
    driver.get("https://the-internet.herokuapp.com/");

    List<WebElement> allLinks = driver.findElements(By.tagName("a"));

    Predicate<String> isBlank = String::isBlank;
    Predicate<String> containsLetterD = str -> str.contains("D");

    allLinks.stream()
      .map(WebElement::getText)
      .filter(isBlank.or(containsLetterD).negate())
      .map(String::toUpperCase)
      .limit(3)
      .forEach(System.out::println);

  }


}
