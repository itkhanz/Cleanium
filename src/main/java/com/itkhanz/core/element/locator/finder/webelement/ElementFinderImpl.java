package com.itkhanz.core.element.locator.finder.webelement;

import com.itkhanz.core.element.wait.ElementWaitStrategy;
import com.itkhanz.core.element.wait.ElementsWaitStrategy;
import com.itkhanz.core.element.wait.WaitDuration;
import com.itkhanz.core.element.wait.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFinderImpl implements IElementFinder, IElementsFinder {
  private final By locator;

  public ElementFinderImpl(By elementLocator) {
    this.locator = elementLocator;
  }


  @Override
  public WebElement getElement() {
    return WaitFactory.performExplicitWait(ElementWaitStrategy.VISIBLE, WaitDuration.MEDIUM, locator);
  }

  @Override
  public WebElement getElement(WaitDuration waitDuration) {
    return WaitFactory.performExplicitWait(ElementWaitStrategy.VISIBLE, waitDuration, locator);
  }

  @Override
  public WebElement getElement(ElementWaitStrategy waitStrategy) {
    return WaitFactory.performExplicitWait(waitStrategy, WaitDuration.MEDIUM, locator);
  }

  @Override
  public WebElement getElement(ElementWaitStrategy waitStrategy, WaitDuration waitDuration) {
    return WaitFactory.performExplicitWait(waitStrategy, waitDuration, locator);
  }

  @Override
  public List<WebElement> getAllElements() {
    return WaitFactory.performExplicitWait(ElementsWaitStrategy.VISIBLE, WaitDuration.MEDIUM, locator);
  }

  @Override
  public List<WebElement> getAllElements(WaitDuration waitDuration) {
    return WaitFactory.performExplicitWait(ElementsWaitStrategy.VISIBLE, WaitDuration.MEDIUM, locator);
  }

  @Override
  public List<WebElement> getAllElements(ElementsWaitStrategy waitStrategy) {
    return WaitFactory.performExplicitWait(ElementsWaitStrategy.VISIBLE, WaitDuration.MEDIUM, locator);
  }

  @Override
  public List<WebElement> getAllElements(ElementsWaitStrategy waitStrategy, WaitDuration waitDuration) {
    return WaitFactory.performExplicitWait(waitStrategy, waitDuration, locator);
  }
}
