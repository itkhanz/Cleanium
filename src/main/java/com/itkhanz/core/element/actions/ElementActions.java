package com.itkhanz.core.element.actions;

import com.itkhanz.core.driver.DriverManager;
import com.itkhanz.core.element.wait.WaitDuration;
import com.itkhanz.core.element.wait.WaitFactory;
import com.itkhanz.core.element.wait.WaitStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class ElementActions {
  public static Logger logger = LogManager.getLogger(ElementActions.class);

  public static void click(By locator) {
    if (WaitFactory.waitForElementTobeInteractable(WaitDuration.WAIT_MEDIUM, locator)) {
      DriverManager.getDriver().findElement(locator).click();
    }

    logger.info("performed click action on: {}", locator.toString());
  }

  public static void type(By locator, String text) {
    WaitFactory
      .performExplicitWait(WaitStrategy.VISIBLE, WaitDuration.WAIT_MEDIUM, locator)
      .sendKeys(text);

    logger.info("performed sendKeys action on: {}", locator.toString());
  }

  public static void clear(By locator) {
    WaitFactory
      .performExplicitWait(WaitStrategy.VISIBLE, WaitDuration.WAIT_MEDIUM, locator)
      .clear();

    logger.info("performed clear action on: {}", locator.toString());
  }

  public static String getAttribute(By locator, String attr) {
    logger.info("Getting the attribute {} of {}", attr, locator.toString());

    return WaitFactory
          .performExplicitWait(WaitStrategy.PRESENCE, WaitDuration.WAIT_MEDIUM, locator)
          .getAttribute(attr);
  }

  public static String getText(By locator) {
    logger.info("Getting the text of {}", locator.toString());

    return WaitFactory
          .performExplicitWait(WaitStrategy.PRESENCE, WaitDuration.WAIT_MEDIUM, locator)
          .getText();
  }

  public static boolean isDisplayed(By locator) {
    logger.info("Checking if the element {} is displayed", locator.toString());
    try {
      return WaitFactory
        .performExplicitWait(WaitStrategy.VISIBLE, WaitDuration.WAIT_MEDIUM, locator)
        .isDisplayed();
    } catch (TimeoutException e) {
      e.printStackTrace();
      logger.info("Element not visible within timeout of {} seconds", WaitDuration.WAIT_MEDIUM.getDurationSeconds());
      return false;
    }

  }

  public static boolean isEnabled(By locator) {
    logger.info("Checking if the element {} is enabled", locator.toString());

    return WaitFactory
          .performExplicitWait(WaitStrategy.VISIBLE, WaitDuration.WAIT_MEDIUM, locator)
          .isEnabled();
  }

  public static boolean isSelected(By locator) {
    logger.info("Checking if the element {} is selected", locator.toString());

    return WaitFactory
      .performExplicitWait(WaitStrategy.VISIBLE, WaitDuration.WAIT_MEDIUM, locator)
      .isSelected();
  }

}
