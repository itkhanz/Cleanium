package com.itkhanz.demos.part10;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Slf4j
public class LocatorFactory {

  public static By getBy(Locator locator) {
    String locatorValue = locator.getValue();
    return switch (locator.getStrategy()) {
      case ID -> By.id(locatorValue);
      case NAME -> By.name(locatorValue);
      case CLASS_NAME -> By.className(locatorValue);
      case TAG_NAME -> By.tagName(locatorValue);
      case LINK_TEXT -> By.linkText(locatorValue);
      case PARTIAL_LINK_TEXT -> By.partialLinkText(locatorValue);
      case CSS_SELECTOR -> By.cssSelector(locatorValue);
      case XPATH -> By.xpath(locatorValue);
    };
  }

  public static WebElement getWebElement(Locator locator) {
    log.info("Getting WebElement for {}", locator.toString());
    return WaitFactory.performExplicitWait(WaitStrategy.VISIBLE, WaitDuration.WAIT_MEDIUM, locator);
  }

  public static List<WebElement> getWebelementsList(Locator locator) {
    log.info("Getting list of WebElements for {}", locator.toString());
    WaitFactory.performExplicitWait(WaitStrategy.PRESENCE, WaitDuration.WAIT_MEDIUM, locator);
    List<WebElement> elementList = DriverManager.getDriver().findElements(LocatorFactory.getBy(locator));
    if (elementList.isEmpty()) {
      log.error("No elements found for the {}", locator.toString());
      throw new RuntimeException(String.format("No elements found for the %s", locator.toString()));
    }
    log.info("Found {} WebElements for the {}", elementList.size(), locator.toString());
    return elementList;
  }

}
