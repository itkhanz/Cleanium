package com.itkhanz.core.element.locator.finder.webelement;

import com.itkhanz.core.element.wait.ElementsWaitStrategy;
import com.itkhanz.core.element.wait.WaitDuration;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface IElementsFinder {
  List<WebElement> getAllElements();
  List<WebElement> getAllElements(WaitDuration waitDuration);
  List<WebElement> getAllElements(ElementsWaitStrategy waitStrategy);
  List<WebElement> getAllElements(ElementsWaitStrategy waitStrategy, WaitDuration waitDuration);
}
