package com.itkhanz.tests;

import com.itkhanz.chap03.functionalinterface.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateTest {
  private WebDriver driver;

  @BeforeMethod
  @Parameters("browser")
  public void setDriver(@Optional("chrome") String browser){
    this.driver = DriverFactory.getDriver(browser.toLowerCase());
  }

  @Test
  public void removeEmptyTest(){
    driver.get("https://the-internet.herokuapp.com/");

    List<WebElement> allLinks = driver.findElements(By.tagName("a"));

    Predicate<WebElement> isBlank = element -> element.getText().isBlank();
    Predicate<WebElement> containsLetterD = element -> element.getText().contains("D");
    List<Predicate<WebElement>> removalRules = List.of(isBlank, containsLetterD);


    System.out.println("Before: " + allLinks.size());

    //Approach 01
    //allLinks.removeIf(isBlank.or(containsLetterD));

    //Approach 02 (suitable if you have many rules)
    //removalRules.forEach(rule -> allLinks.removeIf(rule));
    removalRules.forEach(allLinks::removeIf);

    System.out.println("After: " + allLinks.size());
  }



  @AfterMethod
  public void quitDriver(){
    this.driver.quit();
  }
}
