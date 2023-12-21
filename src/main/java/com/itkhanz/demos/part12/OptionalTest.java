package com.itkhanz.demos.part12;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Optional;

public class OptionalTest {

  @Test
  public void test_optional_demo() {
    String browser = System.getenv("browser");
    /*if (browser ==null) {
      browser = "chrome";
    }*/

    String browser1 = Optional.ofNullable(browser).orElse("chrome");

    Optional.ofNullable(browser).orElseGet(() -> "chrome");

    Optional.ofNullable(browser).orElseThrow(IllegalAccessError::new);

    Optional.ofNullable(browser).ifPresentOrElse(System.out::println, () -> System.out.println("not found"));

  }

  @Test
  public void test_alert_handling() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/");

    //JS Popup
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("alert('I am a demo alert')");

    //Approach 01
    /*try {
      driver.switchTo().alert().accept();
    } catch (Exception e) {
      System.out.println("Alert not present and ignored");
    }*/

    //Approach 02
    /*Optional.ofNullable(ExpectedConditions.alertIsPresent().apply(driver))
      .ifPresent(Alert::accept);*/

    //Approach 03
    Optional.ofNullable(ExpectedConditions.alertIsPresent().apply(driver))
      .ifPresentOrElse(Alert::accept, () -> System.out.println("Alert not present and ignored"));

    if (driver!= null) {
      driver.quit();
    }
  }

  @Test
  public void test_random_click() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/");

    driver.findElements(By.xpath("//li//a"))
      .stream()
      .findAny()
      .ifPresent(WebElement::click);

    if (driver!= null) {
      driver.quit();
    }
  }
}
