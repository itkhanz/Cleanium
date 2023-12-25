package com.itkhanz.core.element.locator.finder;

import com.itkhanz.core.element.locator.finder.webelement.ElementFinderImpl;
import org.openqa.selenium.By;

public interface Find {
  static ElementFinderImpl withLocator(By elementLocator) {
    return new ElementFinderImpl(elementLocator);
  }
}
