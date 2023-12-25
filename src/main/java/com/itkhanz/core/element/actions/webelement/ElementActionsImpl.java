package com.itkhanz.core.element.actions.webelement;

import com.itkhanz.core.driver.DriverManager;
import com.itkhanz.core.element.wait.ElementWaitStrategy;
import com.itkhanz.core.element.wait.WaitDuration;
import com.itkhanz.core.element.wait.WaitFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class ElementActionsImpl implements IElementActions {
  public static Logger logger = LogManager.getLogger(ElementActionsImpl.class);

  private final By locator;

  public ElementActionsImpl(By elementLocator) {
    this.locator = elementLocator;
  }

  @Override
  public void click() {
    if (WaitFactory.waitForElementTobeInteractable(WaitDuration.MEDIUM, locator)) {
      DriverManager.getDriver().findElement(locator).click();
    }

    logger.info("performed click action on: {}", locator.toString());
  }

  @Override
  public void type(String text) {
    WaitFactory
      .performExplicitWait(ElementWaitStrategy.VISIBLE, WaitDuration.MEDIUM, locator)
      .sendKeys(text);

    logger.info("performed sendKeys action on: {}", locator.toString());
  }

  @Override
  public void clickAndType(String text) {
    this.click();
    this.type(text);
  }

  @Override
  public void clear() {
    WaitFactory
      .performExplicitWait(ElementWaitStrategy.VISIBLE, WaitDuration.MEDIUM, locator)
      .clear();

    logger.info("performed clear action on: {}", locator.toString());
  }

  @Override
  public String getAttribute(String attr) {
    logger.info("Getting the attribute {} of {}", attr, locator.toString());

    return WaitFactory
          .performExplicitWait(ElementWaitStrategy.PRESENCE, WaitDuration.MEDIUM, locator)
          .getAttribute(attr);
  }

  @Override
  public String getText() {
    logger.info("Getting the text of {}", locator.toString());

    return WaitFactory
          .performExplicitWait(ElementWaitStrategy.PRESENCE, WaitDuration.MEDIUM, locator)
          .getText();
  }

  @Override
  public boolean isDisplayed() {
    logger.info("Checking if the element {} is displayed", locator.toString());
    try {
      return WaitFactory
        .performExplicitWait(ElementWaitStrategy.VISIBLE, WaitDuration.MEDIUM, locator)
        .isDisplayed();
    } catch (TimeoutException e) {
      e.printStackTrace();
      logger.info("Element not visible within timeout of {} seconds", WaitDuration.MEDIUM.getDurationSeconds());
      return false;
    }

  }

  @Override
  public boolean isEnabled() {
    logger.info("Checking if the element {} is enabled", locator.toString());

    return WaitFactory
          .performExplicitWait(ElementWaitStrategy.VISIBLE, WaitDuration.MEDIUM, locator)
          .isEnabled();
  }

  @Override
  public boolean isSelected() {
    logger.info("Checking if the element {} is selected", locator.toString());

    return WaitFactory
      .performExplicitWait(ElementWaitStrategy.VISIBLE, WaitDuration.MEDIUM, locator)
      .isSelected();
  }

}
