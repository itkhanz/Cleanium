package com.nopcommerce.element.wait;

import com.nopcommerce.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class WaitFactory {
  private static Function<WaitDuration, WebDriverWait> WAIT_MANAGER = (waitDuration) -> new WebDriverWait(
    DriverManager.getDriver(),
    Duration.ofSeconds(waitDuration.getDurationSeconds())
  );

  private static final Map<WaitStrategy, BiFunction<WaitDuration, By, WebElement>> WAIT_MAPPER =
    new EnumMap<>(WaitStrategy.class);

  static {
    WAIT_MAPPER.put(WaitStrategy.PRESENCE, (waitDuration, byLocator) -> WAIT_MANAGER.apply(waitDuration).until(ExpectedConditions.presenceOfElementLocated(byLocator)));
    WAIT_MAPPER.put(WaitStrategy.VISIBLE, (waitDuration, byLocator) -> WAIT_MANAGER.apply(waitDuration).until(ExpectedConditions.visibilityOfElementLocated(byLocator)));
    WAIT_MAPPER.put(WaitStrategy.CLICKABLE, (waitDuration, byLocator) -> WAIT_MANAGER.apply(waitDuration).until(ExpectedConditions.elementToBeClickable(byLocator)));
    WAIT_MAPPER.put(WaitStrategy.NONE, (waitDuration, byLocator) -> DriverManager.getDriver().findElement(byLocator));
    WAIT_MAPPER.put(WaitStrategy.HANDLE_STALE_ELEMENT, (waitDuration, byLocator) ->  {
      System.out.println("Searching to find the element");
      DriverManager.getDriver().navigate().refresh();
      return DriverManager.getDriver().findElement(byLocator);
    });
  }

  public static WebElement performExplicitWait(WaitStrategy waitstrategy, WaitDuration waitDuration, By byLocator) {
    return WAIT_MAPPER
      .get(waitstrategy)
      .apply(
        waitDuration,
        byLocator
      );
  }

  public static boolean waitForElementTobeInteractable(WaitDuration waitDuration, By byLocator) {
    return WAIT_MANAGER.apply(waitDuration).until(
      ExpectedConditions.and(
        ExpectedConditions.visibilityOfElementLocated(byLocator),
        ExpectedConditions.elementToBeClickable(byLocator)
      )
    );
  }
}
