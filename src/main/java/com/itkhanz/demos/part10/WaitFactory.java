package com.itkhanz.demos.part10;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.itkhanz.demos.part10.WaitStrategy.*;

@Slf4j
class WaitFactory {

  private static Function<WaitDuration, WebDriverWait> WAIT_MANAGER = (waitDuration) -> new WebDriverWait(
    DriverManager.getDriver(),
    Duration.ofSeconds(waitDuration.getDurationSeconds())
  );

  private static final Map<WaitStrategy, BiFunction<WaitDuration, By, WebElement>> WAIT_MAPPER =
    new EnumMap<>(WaitStrategy.class);

  static {
    WAIT_MAPPER.put(PRESENCE, (waitDuration, byLocator) -> WAIT_MANAGER.apply(waitDuration).until(ExpectedConditions.presenceOfElementLocated(byLocator)));
    WAIT_MAPPER.put(VISIBLE, (waitDuration, byLocator) -> WAIT_MANAGER.apply(waitDuration).until(ExpectedConditions.visibilityOfElementLocated(byLocator)));
    WAIT_MAPPER.put(CLICKABLE, (waitDuration, byLocator) -> WAIT_MANAGER.apply(waitDuration).until(ExpectedConditions.elementToBeClickable(byLocator)));
    WAIT_MAPPER.put(NONE, (waitDuration, byLocator) -> DriverManager.getDriver().findElement(byLocator));
    WAIT_MAPPER.put(HANDLE_STALE_ELEMENT, (waitDuration, byLocator) ->  {
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

  public static WebElement performExplicitWait(WaitStrategy waitstrategy, WaitDuration waitDuration, Locator locator) {
    //System.out.println(String.format("Waiting on %s for %d seconds to be %s", locator.toString(), waitDuration.getDurationSeconds(), waitstrategy.name()));
    log.info("Waiting on {} for {} seconds to be {}", locator.toString(), waitDuration.getDurationSeconds(), waitstrategy.name());
    return WAIT_MAPPER
      .get(waitstrategy)
      .apply(
        waitDuration,
        LocatorFactory.getBy(locator)
      );
  }

  public static boolean waitForElementTobeInteractable(WaitDuration waitDuration, Locator locator) {
    //System.out.println(String.format("Waiting on %s for %d seconds to be Clickable and Visible", locator.toString(), waitDuration.getDurationSeconds()));
    log.info("Waiting on {} for {} seconds to be Clickable and Visible", locator.toString(), waitDuration.getDurationSeconds());
    By elementlocator = LocatorFactory.getBy(locator);
    return WAIT_MANAGER.apply(waitDuration).until(
      ExpectedConditions.and(
        ExpectedConditions.visibilityOfElementLocated(elementlocator),
        ExpectedConditions.elementToBeClickable(elementlocator)
      )
    );
  }
}
