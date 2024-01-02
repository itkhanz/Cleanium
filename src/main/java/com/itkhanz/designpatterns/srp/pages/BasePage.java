package com.itkhanz.designpatterns.srp.pages;

import com.itkhanz.designpatterns.srp.base.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public abstract class BasePage {
  protected static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

  protected Function<By, WebElement> waitForElementToBeVisible = (locator) -> wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

  protected void load(String url) {
    DriverManager.getDriver().get(url);
  }

  protected void click(By locator) {
    waitForElementToBeVisible.apply(locator).click();
  }

  protected void type(By locator, String text) {
    waitForElementToBeVisible.apply(locator).sendKeys(text);
  }

  protected void clearAndType(By locator, String text) {
    waitForElementToBeVisible.apply(locator).clear();
    waitForElementToBeVisible.apply(locator).sendKeys(text);
  }

  protected String getText(By locator) {
    return waitForElementToBeVisible.apply(locator).getText();
  }

}
