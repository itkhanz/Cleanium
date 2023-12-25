package com.itkhanz.core.element.wait;

import com.itkhanz.core.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class AbstractWaitProvider {
  protected static Function<WaitDuration, WebDriverWait> WEBDRIVER_WAIT = (waitDuration) -> new WebDriverWait(
    DriverManager.getDriver(),
    Duration.ofSeconds(waitDuration.getDurationSeconds())
  );

  protected static final Map<ElementWaitStrategy, BiFunction<WaitDuration, By, WebElement>> ELEMENT_WAIT_MAPPER =
    new EnumMap<>(ElementWaitStrategy.class);

  static {
    ELEMENT_WAIT_MAPPER.put(ElementWaitStrategy.PRESENCE, (waitDuration, byLocator) -> WEBDRIVER_WAIT.apply(waitDuration).until(
      ExpectedConditions.presenceOfElementLocated(byLocator)));
    ELEMENT_WAIT_MAPPER.put(ElementWaitStrategy.VISIBLE, (waitDuration, byLocator) -> WEBDRIVER_WAIT.apply(waitDuration).until(ExpectedConditions.visibilityOfElementLocated(byLocator)));
    ELEMENT_WAIT_MAPPER.put(ElementWaitStrategy.CLICKABLE, (waitDuration, byLocator) -> WEBDRIVER_WAIT.apply(waitDuration).until(ExpectedConditions.elementToBeClickable(byLocator)));
    ELEMENT_WAIT_MAPPER.put(ElementWaitStrategy.NONE, (waitDuration, byLocator) -> DriverManager.getDriver().findElement(byLocator));
    ELEMENT_WAIT_MAPPER.put(ElementWaitStrategy.HANDLE_STALE_ELEMENT, (waitDuration, byLocator) ->  {
      System.out.println("Searching to find the element");
      DriverManager.getDriver().navigate().refresh();
      return DriverManager.getDriver().findElement(byLocator);
    });
  }

  protected static final Map<ElementsWaitStrategy, BiFunction<WaitDuration, By, List<WebElement>>> ELEMENTS_WAIT_MAPPER =
    new EnumMap<>(ElementsWaitStrategy.class);

  static {
    ELEMENTS_WAIT_MAPPER.put(ElementsWaitStrategy.PRESENCE, (waitDuration, byLocator) -> WEBDRIVER_WAIT.apply(waitDuration).until(ExpectedConditions.presenceOfAllElementsLocatedBy(byLocator)));
    ELEMENTS_WAIT_MAPPER.put(ElementsWaitStrategy.VISIBLE, (waitDuration, byLocator) -> WEBDRIVER_WAIT.apply(waitDuration).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator)));
    ELEMENTS_WAIT_MAPPER.put(ElementsWaitStrategy.NONE, (waitDuration, byLocator) -> DriverManager.getDriver().findElements(byLocator));
  }

}
