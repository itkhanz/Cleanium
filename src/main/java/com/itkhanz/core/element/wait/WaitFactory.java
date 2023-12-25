package com.itkhanz.core.element.wait;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WaitFactory extends AbstractWaitProvider {

  public static WebElement performExplicitWait(ElementWaitStrategy waitstrategy, WaitDuration waitDuration, By byLocator) {
    return ELEMENT_WAIT_MAPPER
      .get(waitstrategy)
      .apply(
        waitDuration,
        byLocator
      );
  }

  public static List<WebElement> performExplicitWait(ElementsWaitStrategy waitStrategy, WaitDuration waitDuration, By byLocator) {
    return ELEMENTS_WAIT_MAPPER
      .get(waitStrategy)
      .apply(
        waitDuration,
        byLocator
      );
  }

  public static boolean waitForElementTobeInteractable(WaitDuration waitDuration, By byLocator) {
    return WEBDRIVER_WAIT.apply(waitDuration).until(
      ExpectedConditions.and(
        ExpectedConditions.visibilityOfElementLocated(byLocator),
        ExpectedConditions.elementToBeClickable(byLocator)
      )
    );
  }

  public static Alert waitForAlert(WaitDuration waitDuration) {
    return WEBDRIVER_WAIT.apply(waitDuration).until(ExpectedConditions.alertIsPresent());
  }
}
