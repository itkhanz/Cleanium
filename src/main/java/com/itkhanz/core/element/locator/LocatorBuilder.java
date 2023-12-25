package com.itkhanz.core.element.locator;

public final class LocatorBuilder {
  private LocatorBuilder() {}

  public static String buildLocatorString(String locatorStr, String dynamicValue) {
    return String.format(locatorStr, dynamicValue);
  }
}
