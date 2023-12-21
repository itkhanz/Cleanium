package com.itkhanz.demos.part10;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Function;

@Slf4j
public class WebElementActions {

  public static void click(Locator locator) {
    //wait for element to be visible and clickable, and then perform click
    if (WaitFactory.waitForElementTobeInteractable(WaitDuration.WAIT_MEDIUM, locator)) {
      DriverManager.getDriver().findElement(LocatorFactory.getBy(locator)).click();
    }

    //log action
    //System.out.println(String.format("performed click action on: %s", locator.toString()));
    log.info("performed click action on: {}", locator.toString());
  }

  public static void type(Locator locator, String text) {
    //wait for element to be visible and sendKeys
    WaitFactory.performExplicitWait(WaitStrategy.VISIBLE, WaitDuration.WAIT_MEDIUM, locator)
      .sendKeys(text);

    //log action
    //System.out.println(String.format("performed sendKeys action on: %s", locator.toString()));
    log.info("performed sendKeys action on: {}", locator.toString());
  }

  public static void clear(Locator locator) {
    WaitFactory.performExplicitWait(WaitStrategy.VISIBLE, WaitDuration.WAIT_MEDIUM, locator)
      .clear();

    log.info("performed sendKeys action on: {}", locator.toString());
  }

  public static String getAttribute(Locator locator, String attr) {
    log.info("Getting the attribute {} of {}", attr, locator.toString());

    return WaitFactory.performExplicitWait(WaitStrategy.PRESENCE, WaitDuration.WAIT_MEDIUM, locator)
      .getAttribute(attr);
  }

  public static String getText(Locator locator) {
    log.info("Getting the text of {}", locator.toString());

    return WaitFactory.performExplicitWait(WaitStrategy.PRESENCE, WaitDuration.WAIT_MEDIUM, locator)
      .getText();
  }
}
