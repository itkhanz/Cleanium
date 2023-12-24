package com.nopcommerce.element.actions;

import com.nopcommerce.driver.DriverManager;
import com.nopcommerce.element.wait.WaitDuration;
import com.nopcommerce.element.wait.WaitFactory;
import com.nopcommerce.element.wait.WaitStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ElementActions {
  public static Logger logger = LogManager.getLogger(ElementActions.class);

  public static void click(By locator) {
    if (WaitFactory.waitForElementTobeInteractable(WaitDuration.WAIT_MEDIUM, locator)) {
      DriverManager.getDriver().findElement(locator).click();
    }

    logger.info("performed click action on: {}", locator.toString());
  }

  public static void type(By locator, String text) {
    WaitFactory.performExplicitWait(WaitStrategy.VISIBLE, WaitDuration.WAIT_MEDIUM, locator)
      .sendKeys(text);

    logger.info("performed sendKeys action on: {}", locator.toString());
  }

  public static void clear(By locator) {
    WaitFactory.performExplicitWait(WaitStrategy.VISIBLE, WaitDuration.WAIT_MEDIUM, locator)
      .clear();

    logger.info("performed sendKeys action on: {}", locator.toString());
  }

  public static String getAttribute(By locator, String attr) {
    logger.info("Getting the attribute {} of {}", attr, locator.toString());

    return WaitFactory.performExplicitWait(WaitStrategy.PRESENCE, WaitDuration.WAIT_MEDIUM, locator)
      .getAttribute(attr);
  }

  public static String getText(By locator) {
    logger.info("Getting the text of {}", locator.toString());

    return WaitFactory.performExplicitWait(WaitStrategy.PRESENCE, WaitDuration.WAIT_MEDIUM, locator)
      .getText();
  }
}
