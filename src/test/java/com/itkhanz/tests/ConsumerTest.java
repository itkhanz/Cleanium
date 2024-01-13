package com.itkhanz.tests;

import com.itkhanz.chap03.functionalinterface.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {
  private WebDriver driver;

  @BeforeMethod
  @Parameters("browser")
  public void setDriver(@Optional("chrome") String browser){
    this.driver = DriverFactory.getDriver(browser.toLowerCase());
  }

  @Test
  public void getAllLinksTest(){
    driver.get("https://the-internet.herokuapp.com/");

    Consumer<WebElement> printElementText = element -> System.out.println(element.getText());
    Consumer<WebElement> printElementLink = element -> System.out.println(element.getAttribute("href"));

    driver.findElements(By.tagName("a"))
        .forEach(printElementText.andThen(printElementLink));

  }

  @Test
  public void pageInfoTest() {
    driver.get("https://the-internet.herokuapp.com/");

    BiConsumer<String, String> printPageInfo = (title, url) -> {
      System.out.println("Title: " + title);
      System.out.println("Url: " + url);
    };

    printPageInfo.accept(driver.getTitle(), driver.getCurrentUrl());

  }

  @AfterMethod
  public void quitDriver(){
    this.driver.quit();
  }
}
