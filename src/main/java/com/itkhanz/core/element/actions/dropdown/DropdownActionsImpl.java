package com.itkhanz.core.element.actions.dropdown;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropdownActionsImpl implements IDropdownActions{

  public static Logger logger = LogManager.getLogger(DropdownActionsImpl.class);

  private final By locator;

  public DropdownActionsImpl(By elementLocator) {
    this.locator = elementLocator;
  }

  @Override
  public List<WebElement> getOptions() {
    logger.info("Getting all options in the select element {}", locator);
    return getNativeSelect(locator).getOptions();
  }

  @Override
  public List<WebElement> getAllSelectedOptions() {
    logger.info("Getting all selected options in the select element {}", locator);
    return getNativeSelect(locator).getAllSelectedOptions();
  }

  @Override
  public WebElement getFirstSelectedOption() {
    logger.info("Getting first selected option in the select element {}", locator);
    return getNativeSelect(locator).getFirstSelectedOption();
  }

  @Override
  public void selectByText(String text) {
    logger.info("Selecting the option {} by text on select element {}", text, locator);
    getNativeSelect(locator).selectByVisibleText(text);
  }

  @Override
  public void selectByValue(String value) {
    logger.info("Selecting the option {} by value on select element {}", value, locator);
    getNativeSelect(locator).selectByValue(value);
  }

  @Override
  public void selectByIndex(int index) {
    logger.info("Selecting the option {} by index on select element {}", index, locator);
    getNativeSelect(locator).selectByIndex(index);
  }

  @Override
  public void deselectByText(String text) {
    logger.info("Deselecting the option {} by text on select element {}", text, locator);
    getNativeSelect(locator).deselectByVisibleText(text);
  }

  @Override
  public void deselectByValue(String value) {
    logger.info("Deselecting the option {} by value on select element {}", value, locator);
    getNativeSelect(locator).deselectByValue(value);
  }

  @Override
  public void deselectByIndex(int index) {
    logger.info("Deselecting the option {} by index on select element {}", index, locator);
    getNativeSelect(locator).deselectByIndex(index);
  }
}
