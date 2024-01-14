package com.itkhanz.tests.assignment;

import com.google.common.util.concurrent.Uninterruptibles;
import com.itkhanz.chap03.functionalinterface.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PriceTableTest {
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

  @Test
  public void verify_selection_of_minimum_price_test() {
    driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");

    //get all product rows
    List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='prods']//tr"));

    //click on the radio box for row with lowest price
    allRows.stream()
      .skip(1)
      .min(Comparator.comparing(
        row -> {
          WebElement priceCol = row.findElement(By.xpath(".//td[@class='price']"));
          return Integer.parseInt(priceCol.getText());
        }))
      .ifPresent(rowWithMinPrice -> {
        WebElement checkbox = rowWithMinPrice.findElement(By.xpath(".//input[@type='radio']"));
        checkbox.click();
      });

    //click on Verify
    WebElement verifyBtn = driver.findElement(By.id("result"));
    verifyBtn.click();

    //verify status
    WebElement status = driver.findElement(By.id("status"));
    Assert.assertEquals(status.getText(), "PASS");

    Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
  }


}
