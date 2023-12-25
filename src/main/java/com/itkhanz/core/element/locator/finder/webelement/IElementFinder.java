package com.itkhanz.core.element.locator.finder.webelement;

import com.itkhanz.core.element.wait.ElementWaitStrategy;
import com.itkhanz.core.element.wait.WaitDuration;
import org.openqa.selenium.WebElement;

public interface IElementFinder {
  WebElement getElement();
  WebElement getElement(WaitDuration waitDuration);
  WebElement getElement(ElementWaitStrategy waitStrategy);
  WebElement getElement(ElementWaitStrategy waitStrategy, WaitDuration waitDuration);

}
